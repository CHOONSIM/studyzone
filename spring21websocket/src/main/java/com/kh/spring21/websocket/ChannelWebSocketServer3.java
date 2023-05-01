package com.kh.spring21.websocket;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring21.vo.ChannelVO;
import com.kh.spring21.vo.MemberMessageVO;
import com.kh.spring21.vo.RoomVO;
import com.kh.spring21.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

// 목표 : 방이 여러개 존재하는 채널 형태의 채팅을 구현 ( 편의상 1번 채널만 사용)
@Slf4j
@Service
public class ChannelWebSocketServer3 extends TextWebSocketHandler {

	// 사용자 저장소
	// private Map<String, RoomVO> channel =Collections.synchronizedMap(new HashMap<>());
	private ChannelVO channel = new ChannelVO();
	
	// 메세지 해석기
	private ObjectMapper mapper = new ObjectMapper();
	
	
	// 사용자가 들어왔을 때 실행 되는 기능
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 사용자 정보를 객체로 변환하여 저장
		// -> 세션을 조사하여 회원 정보까지 추가로 설정하도록 구현
		UserVO user = new UserVO(session);
		String roomName = "1";
		channel.join(user, roomName);
	}
	
	// 사용자가 퇴장했을 때 실행 되는 기능
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 삭제 조건
		// [1] 자료형이 일치해야함(UserVO)
		// [2] 비교기준이 설정되어 있어야함(hashCode, equals)
		UserVO user = new UserVO(session);
		String roomName = "1";
		channel.exit(user, roomName);
	}
	
	/*
	  웹소켓 세션은 HTTP세션과는 다른 저장소이며 생성되고 관리되는 시점이 다름
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// 회원 정보를 생성
		UserVO user = new UserVO(session);

		// 회원이 아니면 차단(VO 객체안에 판단)
		if(user.isMember() == false)return;
		
		// 사용자가 존재하는 방을 찾는 방법 - 탐색 or DB조회 or...
		String roomName = "1";
		if(channel.containsRoom(roomName) == false) return;
		
		//메세지 해석 및 신규 메세지 생성 & 전송(사용자에게)
		MemberMessageVO msg = mapper.readValue(message.getPayload(), MemberMessageVO.class);
		msg.setTime(System.currentTimeMillis());
		msg.setMemberId(user.getMemberId());
		msg.setMemberLevel(user.getMemberLevel());
		
		//메세지 만들어서
		String json = mapper.writeValueAsString(msg);
		TextMessage jsonMessage =new TextMessage(json);
		
		// 채팅방 전체 사용자에게 broadcast(전체전송)
		channel.broadcastRoom(jsonMessage,roomName);
	}
	
}

package com.kh.spring21.websocket;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring21.vo.MemberMessageVO;
import com.kh.spring21.vo.UserVO;

import lombok.extern.slf4j.Slf4j;

// 목표 : 회원을 클래스로 구현하여 회원 채팅을 처리하는 서버
@Slf4j
@Service
public class ChannelWebSocketServer1 extends TextWebSocketHandler {

	// 사용자 저장소
	private Set<UserVO>users = new CopyOnWriteArraySet<>();
	
	// 메세지 해석기
	private ObjectMapper mapper = new ObjectMapper();
	
	
	// 사용자가 들어왔을 때 실행 되는 기능
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 사용자 정보를 객체로 변환하여 저장
		// -> 세션을 조사하여 회원 정보까지 추가로 설정하도록 구현
		UserVO vo = new UserVO(session);
		users.add(vo);
		log.debug("사용자 입장 현재{}명",users.size());
	}
	
	// 사용자가 퇴장했을 때 실행 되는 기능
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// 삭제 조건
		// [1] 자료형이 일치해야함(UserVO)
		// [2] 비교기준이 설정되어 있어야함(hashCode, equals)
		UserVO vo = new UserVO(session);
		users.remove(vo);
		log.debug("사용자 퇴장 현재{}명", users.size());
	}
	
	/*
	  웹소켓 세션은 HTTP세션과는 다른 저장소이며 생성되고 관리되는 시점이 다름
	 */
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		// 회원 정보를 생성
		UserVO vo = new UserVO(session);

		// 회원이 아니면 차단(VO 객체안에 판단)
		if(vo.isMember() == false)return;
		
		//메세지 해석 및 신규 메세지 생성 & 전송(사용자에게)
		MemberMessageVO msg = mapper.readValue(message.getPayload(), MemberMessageVO.class);
		msg.setTime(System.currentTimeMillis());
		msg.setMemberId(vo.getMemberId());
		msg.setMemberLevel(vo.getMemberLevel());
		
		//메세지 만들어서
		String json = mapper.writeValueAsString(msg);
		TextMessage jsonMessage =new TextMessage(json);
		
		// broadcast(전체전송)
		for(UserVO user : users) {
			//user.getSession().sendMessage(jsonMessage);
			user.send(jsonMessage);
		}
	}
	
}

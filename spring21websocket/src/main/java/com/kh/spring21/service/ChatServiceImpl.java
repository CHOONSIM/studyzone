package com.kh.spring21.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh.spring21.dto.ChatRoomDto;
import com.kh.spring21.dto.ChatUserDto;
import com.kh.spring21.repo.ChatRoomRepo;
import com.kh.spring21.repo.ChatUserRepo;
import com.kh.spring21.vo.ChannelReceiveVO;
import com.kh.spring21.vo.MemberMessageVO;
import com.kh.spring21.vo.RoomVO;
import com.kh.spring21.vo.UserVO;
import com.kh.spring21.websocket.WebSocketConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ChatServiceImpl implements ChatService{
	
	//ChannelVO와 WebSocketServer5 합침
	
	// 여러 개의 방을 관리할 저장소
	private Map<String, RoomVO> rooms = Collections.synchronizedMap(new HashMap<>());
	
	// 메세지 해석기
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private ChatRoomRepo chatRoomRepo;
	
	@Autowired
	private ChatUserRepo chatUserRepo;
	
	
	//channelVO에서 구현했던 모든 메소드
	
	//채널에 필요한 기능
	// - 방 생성 / 제거 / 확인
	public void createRoom(String roomName) {
		if(containsRoom(roomName)) return;		//있으면 중단, 없으면 만들기
		rooms.put(roomName, new RoomVO());
		
		// DB등록
		boolean isWaitingRoom = roomName.equals(WebSocketConstant.WAITING_ROOM);
		if(!isWaitingRoom && chatRoomRepo.find(roomName) == null) {
		ChatRoomDto dto = new ChatRoomDto();
		dto.setRoomName(roomName);
		chatRoomRepo.create(dto);
		}
	}
	
	public void deleteRoom(String roomName) {
		rooms.remove(roomName);
		
		// 방 제거 코드 DB등록
	}
	
	public boolean containsRoom(String roomName) {
		return rooms.containsKey(roomName);
	}
	
	// - 사용자를 방에 입장 / 퇴장
	public void join(UserVO user, String roomName) {		//public void join(누구를 어느방에?)
		createRoom(roomName);		// 방 생성(있으면 안만들어짐)	
		RoomVO room = rooms.get(roomName);		//rooms.get(roomName) 맵에서 이름에 해당하는 room을 찾아내는 코드
		room.enter(user);
		
		// 참여자 등록(DB) - 기존에 참여중이 아닌 경우 실행
		boolean isWaitingRoom = roomName.equals(WebSocketConstant.WAITING_ROOM);
		ChatUserDto userDto = new ChatUserDto();
		userDto.setRoomName(roomName);
		userDto.setMemberId(user.getMemberId());
		boolean isJoin = chatUserRepo.check(userDto);
		if(!isWaitingRoom && !isJoin ) {		//if(대기실이 아니면 && 참여한적이 없으면)
		ChatUserDto dto = new ChatUserDto();
		dto.setRoomName(roomName);
		dto.setMemberId(user.getMemberId());
		chatUserRepo.add(dto);
		}

		log.debug("{}님이 {} 방에 참여하였습니다",user.getMemberId(), roomName);
	}
	
	public void exit(UserVO user, String roomName) {
		if(containsRoom(roomName) == false) return;
		RoomVO room = rooms.get(roomName);
		room.leave(user);
		
		// 참여자 제거(DB)
		
		
		log.debug("{}님이 {} 방을 퇴장하였습니다",user.getMemberId(), roomName);
		}
	
	// - 방에 메세지를 전송하는 기능(그룹채팅)
	public void broadcastRoom(TextMessage jsonMessage, String roomName) throws IOException {
		if(containsRoom(roomName) == false) return;
		
		RoomVO room = rooms.get(roomName);
		room.broadcast(jsonMessage);
	}
	
	// - 사용자가 존재하는 방의 이름을 찾는 기능
	public String findUser(UserVO user) {			//public 방이름 findUser(UserVO user)
		for(String roomName : rooms.keySet()){	//모든 방의 이름을 꺼내서
			RoomVO room = rooms.get(roomName);	// 방 객체를 추출하고
			if(room.contains(user)) {			//해당 방 객체에 사용자가 있다면
				return roomName;			//방 이름을 반환
			}
		}
		return null;		//없네?
	}
	
	// - 사용자를 방에서 방으로 이동시키는 기능
	public void moveUser(UserVO user, String roomName) {		//String beforeRoom, 사용자가 있는 방은 위에서 이미 찾아서 안써도됨
		String beforeRoomName = findUser(user);		// 사용자 위치를 찾아라
//		if(beforeRoomName != null) {		//이전 위치가 존재할 경우
//			RoomVO beforeRoom = rooms.get(beforeRoomName);		// 방을 찾아서
//			beforeRoom.leave(user);	//사용자를 제거
//		}
		exit(user, beforeRoomName);		// 나가
		join(user, roomName);		// 들어가
	}
	
	// - 방 개수 확인
	// - 전체 방에 메세지를 전송하는 기능(공지)

	
	@Override
	public void connectHandler(WebSocketSession session) {
		// 사용자 정보를 객체로 변환하여 저장
		// -> 세션을 조사하여 회원 정보까지 추가로 설정하도록 구현
		UserVO user = new UserVO(session);
		String roomName = WebSocketConstant.WAITING_ROOM;
		this.join(user, roomName);
	}

	@Override
	public void disconnectHandler(WebSocketSession session) {
		// 삭제 조건
		// [1] 자료형이 일치해야함(UserVO)
		// [2] 비교기준이 설정되어 있어야함(hashCode, equals)
		UserVO user = new UserVO(session);
		String roomName = this.findUser(user);
		this.exit(user, roomName);
		
	}

	@Override
	public void receiveHandler(WebSocketSession session, TextMessage message) throws IOException {
		// 회원 정보를 생성
				UserVO user = new UserVO(session);
				
				// 메세지를 수신(ChannelReceiveVO)
				// - 이 메세지의 type을 분석하여 작업에 맞는 처리를 수행
				ChannelReceiveVO receiveVO = mapper.readValue(message.getPayload(), ChannelReceiveVO.class);
				System.out.println(receiveVO);
				
				//채팅메세지인 경우
				if(receiveVO.getType() == WebSocketConstant.CHAT) {
					//receiveVO.content에 채팅 메세지가 있다
					
					//회원이 아니면 채팅 차단
					if(user.isMember() == false)return;
					
					String roomName = this.findUser(user);		//찾아
					if(roomName == null) return;		//없으면 하지마
					
					// (옵션) 대기실인 경우 메세지 전송이 불가
					if(roomName.equals(WebSocketConstant.WAITING_ROOM))return;
					
					//보낼 메세지 생성
					MemberMessageVO msg = new MemberMessageVO();
					msg.setContent(receiveVO.getContent());		//전송내용
					msg.setTime(System.currentTimeMillis());		//전송시각
					msg.setMemberId(user.getMemberId());		//아이디
					msg.setMemberLevel(user.getMemberLevel());		//등급
					
					//JSON 변환
					String jsonStr = mapper.writeValueAsString(msg);
					TextMessage jsonMessage = new TextMessage(jsonStr);
					
					this.broadcastRoom(jsonMessage, roomName); 	// 방에 메세지를 보내
				}
				//입장메세지인 경우
				else if(receiveVO.getType() == WebSocketConstant.JOIN) {
					//receiveVO.room에 방번호가 있다
					String roomName = receiveVO.getRoom();
					this.moveUser(user, roomName);
				}
	}

}

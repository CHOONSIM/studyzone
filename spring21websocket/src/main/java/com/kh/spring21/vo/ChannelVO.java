package com.kh.spring21.vo;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.TextMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
// 여러 개의 방이 모인 채널 클래스
public class ChannelVO {
	
	// 여러 개의 방을 관리할 저장소
	//List<RoomVO> rooms = new ArrayList<>();		// 번호로 채팅방 구분
	Map<String, RoomVO> rooms = Collections.synchronizedMap(new HashMap<>());

	//채널에 필요한 기능
	// - 방 생성 / 제거 / 확인
	public void createRoom(String roomName) {
		if(containsRoom(roomName)) return;		//있으면 중단, 없으면 만들기
		rooms.put(roomName, new RoomVO());
	}
	
	public void deleteRoom(String roomName) {
		rooms.remove(roomName);
	}
	
	public boolean containsRoom(String roomName) {
		return rooms.containsKey(roomName);
	}
	
	// - 사용자를 방에 입장 / 퇴장
	public void join(UserVO user, String roomName) {		//public void join(누구를 어느방에?)
		createRoom(roomName);		// 방 생성(있으면 안만들어짐)
		RoomVO room = rooms.get(roomName);		//rooms.get(roomName) 맵에서 이름에 해당하는 room을 찾아내는 코드
		room.enter(user);
		
		log.debug("{}님이 {} 방에 참여하였습니다",user.getMemberId(), roomName);
	}
	
	public void exit(UserVO user, String roomName) {
		if(containsRoom(roomName) == false) return;
		RoomVO room = rooms.get(roomName);
		room.leave(user);
		
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

}

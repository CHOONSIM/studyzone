package com.kh.spring21.websocket;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

/*
  스프링에서 웹소켓을 처리하는 서버 
  1 컨트롤러로 접속해서 HTTP연결이 이루어지고 난 뒤 WS 연결 생성
  2 만약 페이지를 이탈할 경우 자동으로 WS연결이 종료(수동종료도 가능)
  3 아무나 서버가 될 수 없음, 자격 획득을 위해 상속을 받음(상속받을때는 구체적일수록 좋음)
  	- interface WebsocketHandler
  	- class TextWebSocketHandler(텍스트), BinaryWebSocketHandler(파일)
  4 스프링에 등록한다(Configuration의 @Bean 또는 @Service)
  5 필요한 메소드를 재정의하여 원하는 코드를 작성
 	- afterConnectionEstablished : 연결 이루어진 경우 자동으로 실행
 		- WebSocketSession : 웹소켓 연결된 대상의 정보(HttpSession 아님)
 		
 	- afterConnectionClosed : 연결이 해제된 경우 자동으로 실행
 		- WebSocketSession : 웹소켓 해제된 대상의 정보(HttpSession 아님)
 		- CloseStatus : 연결이 해제된 이유에 대한 상태 코드
 */
@Slf4j
@Service
public class BasicWebsocketServer extends TextWebSocketHandler{

	// 사용자를 저장하기 위한 Collection 생성
//	private Set<WebSocketSession> set = new ConcurrentSkipListSet<>();
	private Set<WebSocketSession> set = new CopyOnWriteArraySet<>();
//	private Set<WebSocketSession> set = Collections.synchronizedSet(new HashSet<>());
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		// 사용자를 Collention에 추가
		set.add(session);
		
		log.debug("사용자 접속. 현재 ={}명", set.size());
		log.debug("session={}",session);
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		// 사용자를 Collention에 제거
		set.remove(session);
		
		log.debug("사용자 종료. 현재 ={}명",set.size());
		log.debug("session={}",session);
	}
	
	// 메세지를 보낼 때에는 메세지 객체를 만들고
	// WebSocketSession의 sendMessage() 를 사용한다
	@Scheduled(cron="*/10 * * * * *")
	public void macro() throws IOException {
		TextMessage message = new TextMessage("Hello Websocket");
		for(WebSocketSession session:set) {
			session.sendMessage(message);
		}
	}
}

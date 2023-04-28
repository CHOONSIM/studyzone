package com.kh.spring21.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//웹소켓 사용 설정 파일
@Configuration
@EnableWebSocket		//웹소켓 사용 설정 활성화
public class WebSocketServerConfiguration implements WebSocketConfigurer{

	@Autowired
	private BasicWebsocketServer basicWebsocketServer;
	
	@Autowired
	private ChatWebsocketServer chatWebsocketServer;
	
	@Autowired
	private SockJsWebSocketServer sockJsWebSocketServer;
	
	@Autowired
	private JsonWebSocketServer jsonWebSocketServer;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//		basicWebsocketServer 를 어딘가에 등록하겠다
//		만들어둔 웹소켓 서버를 등록하는 코드를 작성
//		-주의-
//		- 어떠한 주소와도 겹치면 안됨(HTTP도포함)(비어있는 페이지로 설정)
		
//		BasicWebsocketServer를 ws://localhost:8080/ws/basic 주소에서 사용하겠습니다.
		registry.addHandler(basicWebsocketServer, "/ws/basic");
		
		registry.addHandler(chatWebsocketServer, "/ws/chat");
		
		// SockJs를 사용하도록 웹소켓 서버를 등록
		registry.addHandler(sockJsWebSocketServer, "/ws/sockjs")	//등록하고
			.withSockJS();	// sockjs를 쓴다고 선언
		
		registry.addHandler(jsonWebSocketServer, "/ws/json")
			.withSockJS();
	}

}

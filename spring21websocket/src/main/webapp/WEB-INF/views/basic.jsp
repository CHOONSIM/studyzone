<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>기본 웹소켓 연결 예제</h1>

<!-- 연결/종료 버튼 -->
<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>
<hr>
<!-- 메세지 표시 공간 -->
<div class="message-wrapper"></div>

<!-- 
	jQuery를 이용하여 웹소켓 처리를 구현
	- javascript에 WebSocket API가 존재
	- 다음과 같이 연결이 가능
		const socket = new WebSocket(접속주소);
		window.socket = new WebSocket(접속주소);
	- 웹소켓 접속주소는 별도의 라이브러리가 없는 경우 ws(Http) 또는 wss(Https)로 시작됨
	- 다음과 같이 종료가 가능
		window.socket.close();
 -->
<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
	$(function(){
		// 처음에 시작하자마자 종료버튼을 disabled 구현
		changeToDisconnect();
		
		// [1] 연결 버튼을 누르면 연결 되도록 구현
		$(".btn-connect").click(function(){
			const url = "ws://localhost:8080/ws/basic";
			window.socket = new WebSocket(url);
			
			changeToConnect();
		});
		
		// [2] 종료 버튼을 누르면 연결이 해제되도록 구현
		$(".btn-disconnect").click(function(){
			window.socket.close();
			
			changeToDisconnect();
		});
		
		// 연결 상태일 때의 화면을 만드는 함수
		function changeToConnect(){
			$(".btn-connect").prop("disabled",true);
			$(".btn-disconnect").prop("disabled",false);
		}
		
		// 종료 상태일 때의 화면을 만드는 함수
		function changeToDisconnect(){
			$(".btn-connect").prop("disabled",false);
			$(".btn-disconnect").prop("disabled",true);
		}
		
	});
</script>
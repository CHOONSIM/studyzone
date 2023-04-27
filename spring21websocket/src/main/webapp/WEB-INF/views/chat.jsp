<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>웹소켓 전체 채팅 예제</h1>

<!-- 연결/종료 버튼 -->
<button class="btn-connect">연결</button>
<button class="btn-disconnect">종료</button>

<br>
<hr>
<br>

<!-- 메세지 입력창 + 전송버튼 -->
<input type="text" class="user-input">
<button class="btn-send">전송</button>

<br>
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
			const url = "ws://localhost:8080/ws/chat";
			window.socket = new WebSocket(url);
			
			// 실제로 연결이 됐는지, 끊어졌는지 알 방법이 없다
			// - 웹소켓에서 이벤트 형태로 제공한다(callback함수)
			//console.log(window.socket);
			window.socket.onopen = function(){
				changeToConnect();
			};
			window.socket.onclose = function(){
				changeToDisconnect();
			};
			window.socket.onerror = function(){
				changeToDisconnect();
			};
			// 메세지 수신하면 수신된 메세지로 태그를 만들어서 추가
			window.socket.onmessage = function(e){
				//console.log(arguments);
				//console.log(e.data);
				
				$("<p>").text(e.data).appendTo(".message-wrapper");
			};
		
		});
		
		// [2] 종료 버튼을 누르면 연결이 해제되도록 구현
		$(".btn-disconnect").click(function(){
			window.socket.close();
		});
		
		// [3] 전송 버튼을 누르면 서버에게 메세지를 전송하도록 구현
		$(".btn-send").click(function(){
			const text = $(".user-input").val();
			if(text.length == 0) return;
			
			window.socket.send(text);
			$(".user-input").val("");	//입력창 초기화
		});
		
		
		// 연결 상태일 때의 화면을 만드는 함수
		function changeToConnect(){
			$(".btn-connect").prop("disabled",true);
			$(".btn-disconnect").prop("disabled",false);
			$(".user-input").prop("disabled", false);
			$(".btn-send").prop("disabled",false);
		}
		
		// 종료 상태일 때의 화면을 만드는 함수
		function changeToDisconnect(){
			$(".btn-connect").prop("disabled",false);
			$(".btn-disconnect").prop("disabled",true);
			$(".user-input").prop("disabled", true);
			$(".btn-send").prop("disabled", true);
		}
		
	});
</script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1>채널2번 예제(단일 채널)</h1>
<h2>${sessionScope.memberId }, ${sessionScope.memberLevel }</h2>

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
 
 <!--
  sockjs를 사용하려면 sockjs-client 라이브러리의 의존성을 추가해야한다 
  [1] 주소를 http로 써도 된다(알아서 ws로 바꿔준다)
  [2] WebSocket을 지원하지 않는 브라우저는 풀링방식으로 자동 변환한다
  [3] 주기적으로 라이브핑으로 보내 생존여부를 체크해준다(heartbeat) 
  -->
<script type="text/template" id="message-template">
	<div class="message">
		<h2 class="memberId">보낸사람</h2>
		<p class="content">내용</p>
		<span class="time">HH:mm</span>
	</div>
</script>
  
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>

<!-- 모멘트(시간) -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<!-- 한국시간 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/locale/ko.min.js"></script>
<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
	$(function(){
		
		// 시작하자마자 연결
			
			//SockJS를 사용하여 달라지는 부분(주소, 연결생성)
			const url = "${pageContext.request.contextPath}/ws/channel3";
			
			window.socket = new SockJS(url);
			
			// 실제로 연결이 됐는지, 끊어졌는지 알 방법이 없다
			// - 웹소켓에서 이벤트 형태로 제공한다(callback함수)
			//console.log(window.socket);
			window.socket.onopen = function(){
				changeToConnect();
				$("<p>").text("서버에 연결되었습니다.").appendTo(".message-wrapper");
			};
			window.socket.onclose = function(){
				changeToDisconnect();
				$("<p>").text("서버와의 연결이 종료되었습니다.").appendTo(".message-wrapper");
			};
			window.socket.onerror = function(){
				changeToDisconnect();
				$("<p>").text("서버와의 연결 오류가 발생했습니다.").appendTo(".message-wrapper");
			};
			// 메세지 수신하면 수신된 메세지로 태그를 만들어서 추가
			window.socket.onmessage = function(e){
				// 수신한 데이터(e.data)가 JSON 문자열 형태이므로 해석 후 처리
				const data = JSON.parse(e.data);		//안에 content와 time이 있음
				const time = moment(data.time).format("HH:mm");
// 				const time = moment(data.time).fromNow();	// 몇초,분 전
				
				var template = $("#message-template").html();
				var html = $.parseHTML(template);
				$(html).find(".memberId").text(data.memberId);
				$(html).find(".content").text(data.content);
				$(html).find(".time").text(time);
				
				switch(data.memberLevel){
					case"우수회원": $(html).find(".memberId").css("color", "dodgeblue");
					break;
					case"관리자":  $(html).find(".memberId").css("color", "red");
				}
				$(".message-wrapper").append(html);
				}
		
		
		// [2] 페이지 나가면 종료이므로 처리 X

		
		// [3] 전송 버튼을 누르면 서버에게 메세지를 전송하도록 구현
		$(".btn-send").click(function(){
			const text = $(".user-input").val();
			if(text.length == 0) return;
			
			
			//window.socket.send(text);	// 일반 텍스트
			
			
			//<자바스크립트에서 JSON을 처리하는 명령>
			// JSON.stringify(객체) → 객체를 JSON 문자열로 변환
			// JSON.parse(JSON문자열) → JSON 문자열을 객체로 변환
			const data = {content:text};
			window.socket.send(JSON.stringify(data));
			$(".user-input").val("");	//입력창 초기화
		});
		
		
		// 연결 상태일 때의 화면을 만드는 함수
		function changeToConnect(){
			$(".user-input").prop("disabled", false);
			$(".btn-send").prop("disabled",false);
		}
		
		// 종료 상태일 때의 화면을 만드는 함수
		function changeToDisconnect(){
			$(".user-input").prop("disabled", true);
			$(".btn-send").prop("disabled", true);
		}
		
	});
</script>
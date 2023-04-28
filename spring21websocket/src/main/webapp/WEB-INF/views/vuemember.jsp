<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <meta name='viewport' content='width=device-width, initial-scale=1.0'>
    
    <title>VueJS</title>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.2.3/cosmo/bootstrap.min.css">

	<script src="https://unpkg.com/vue@3.2.36"></script>
    <script src="http://code.jquery.com/jquery-3.6.1.min.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.1/sockjs.min.js"></script>
	<!-- 모멘트(시간) -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
	<!-- 한국시간 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/locale/ko.min.js"></script>
    
</head>
<body>

    <div id="app" class="container-fluid mt-4">
		<div class="row">
		
			<div class="offset-md-1 col-md-9">
				<div class="row text-center">
                    <div class="col bg-dark text-light p-4 rounded">
                        <h1>Vue 채팅 클라이언트 예제</h1>
                        <p>(회원전용 채팅)</p>
                    </div>
                </div>
			</div>
			
			<div class="row">
				<input type="text" v-model="text" v-on:input="text = $event.target.value">
			</div>
			
			<div class="row">
				<button v-on:click="sendMessage">전송</button>
			</div>
			
			<div class="message-wrapper">
				<div class="message" v-for="(message, index) in messageList" :key="index">
					<div>{{message.memberId}}
						<div v-if="message.memberId == memberId">내계정</div>
					</div>
					<div>{{message.content}}</div>
<!-- 					<div>{{message.time}}</div> -->
					<div>{{timeFormat(message.time)}}</div>
				</div>
			</div>
			
		
			
		</div>
    </div>
 
        <script>
            Vue.createApp({
                // 데이터 설정 영역
                data(){
                    return{
                        // 화면에서 사용할 데이터 선언
                    	memberId:"${sessionScope.memberId}",	// 나의 아이디
                    	text:"",	//사용자가 입력하는 내용
                    	messageList:[],	//채팅기록
                    	socket:null,	//웹소켓 연결 객체
                    };
                },
                
                methods:{
                	connect(){
                		const url = "${pageContext.request.contextPath}/ws/vuemember";
                		this.socket = new SockJS(url);
                		
                		const app=this;
                		this.socket.onopen = function(){
                			app.openHandler();
                		};
                		this.socket.onclose = function(){
                			app.closeHandler();
                		};
                		this.socket.onerror = function(){
                			app.errorHandler();
                		};
                		this.socket.onmessage = function(){
                			app.messageHandler(e);
                		};
                	},
                	openHandler(){
                		
                	},
                	closeHandler(){
                		
                	},
                	errorHandler(){
                		
                	},
                	messageHandler(e){
                		this.messageList.push(JSON.parse(e.data));
                	},
                	sendMessage(){
                		if(this.text.length == 0)return;
                		this.socket.send(this.jsonText);
                		this.text="";
                	},
                	timeFormat(time){
                		return moment(time).format("A h:mm");
                	}
                },
                
                computed:{
                	jsonText(){
                		return JSON.stringify({content:this.text});
                	}
                },
                
                created(){
                	// 웹소켓 연결 코드
                	this.connect();
                },
            }).mount("#app");
            
        </script>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    
    </body>
    </html>

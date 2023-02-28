<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>포켓몬 정보 변경</h1>
	
	<!-- 
	수정 입력 페이지에서는 전달받은 정보를 value로 표시해야한다 
	- 사실살 상세페이지를 입력창으로 표시한 형태와 같다
	- pk(primary key)는 변경이 불가하도록 처리
		1, 입력창 잠금(readonly 속성 추가)
		2. 입력창의 type을 hidden으로 설정하면 표시가 되지 않는다
	-->
	<form action="edit"method="post">
<%-- 		번호 : <input type ="text" name="no"value="${pocketmonDto.no }"readonly><br> --%>
		번호 : <input type ="hidden" name="no"value="${pocketmonDto.no }"><br>
		이름 : <input type ="text" name="name"value="${pocketmonDto.name }"><br>
		타입 : <input type ="text" name="type"value="${pocketmonDto.type }"><br>		
		<button>수정</button>
	</form>

	<hr>
	<h2>KH정보교육원</h2>
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<%-- EL의 좋은 점 중 하나는 null을 화면에 출력하지 않는다 --%>
	<h1>포켓몬 정보</h1>
	번호 : ${pocketmonDto.no }	<br>
	이름 : ${pocketmonDto.name }	<br>
	속성 : ${pocketmonDto.type }	<br>
	
	<h2>
	<a href="list">목록으로 이동</a>
	</h2>

	<hr>
	<h2>KH정보교육원</h2>
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
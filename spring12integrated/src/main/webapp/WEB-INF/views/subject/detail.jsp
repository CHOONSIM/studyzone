<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<h1>강의 상세 정보</h1>
	번호 : ${subjectDto.no } <br>
	강의명 : ${subjectDto.name }<br>
	강의기간 : ${subjectDto.period }<br>
	수강료 : ${subjectDto.price }<br>
	강의타입 : ${subjectDto.type }<br> 
	
	<hr>
	
	<h4>
	<a href="list">목록으로 이동</a>
	</h4>
	<br>
	<h4>
	<a href="#">수정</a>
	<br><br>
	<a href="delete?no=${subjectDto.no }">삭제</a>
	</h4>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
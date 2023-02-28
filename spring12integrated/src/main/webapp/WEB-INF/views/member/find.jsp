<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>아이디 찾기</h1>

<form action="find" method="post">
	닉네임 : <input type="text" name="memberNick" required> <br><br>
	전화번호 : <input type="tel" name="memberTel" required> <br><br>
	생년월일 : <input type="date" name="memberBirth" required> <br><br>
	<button>찾기</button>
</form>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
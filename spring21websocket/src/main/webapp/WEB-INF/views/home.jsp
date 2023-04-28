<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>웹소켓 예제 모음</h1>

<!-- 로그인 화면 : 로그아웃 상태일 때-->
<form action="login" method="post">
	<input type="text" name="memberId" required placeholder="아이디">
	<input type="password" name="memberPw" required placeholder="비밀번호">
	<button type="submit">로그인</button>
</form>

<!-- 사용자 정보 : 로그인 상태일 때 -->
<h2>
아이디 : ${sessionScope.memberId },
등급 : ${sessionScope.memberLevel }
<a href="logout">로그아웃</a>
</h2>
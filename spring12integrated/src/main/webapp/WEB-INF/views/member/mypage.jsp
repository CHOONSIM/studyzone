<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>내 정보</h2>

<table border ="1" width="400">
	<tbody>
		<tr>
			<th width="25%">아이디</th>
			<td>${memberDto.memberId }</td>
		</tr>
			<tr>
			<th width="25%">닉네임</th>
			<td>${memberDto.memberNick }</td>
		</tr>
			<tr>
			<th width="25%">전화번호</th>
			<td>${memberDto.memberTel }</td>
		</tr>
			<tr>
			<th width="25%">생년월일</th>
			<td>${memberDto.memberBirth }</td>
		</tr>
			<tr>
			<th width="25%">이메일</th>
			<td>${memberDto.memberEmail }</td>
		</tr>
			<tr>
			<th width="25%">주소</th>
			<td>
			${memberDto.memberPost } <br>
			${memberDto.memberBasicAddr } <br>
			${memberDto.memberDetailAddr }
			</td>
			</tr>
			<tr>
			<th width="25%">회원등급</th>
			<td>${memberDto.memberLevel }</td>
		</tr>
		<tr>
			<th width="25%">회원포인트</th>
			<td>${memberDto.memberPoint } point</td>
		</tr>
		<tr>
			<th width="25%">가입일</th>
			<td>${memberDto.memberJoin }</td>
		</tr>
		<tr>
			<th width="25%">마지막 로그인</th>
			<td>${memberDto.memberLogin }</td>
		</tr>

	</tbody>

</table>

<!-- 회원관리 메뉴 -->

<br><br>
<hr>
<h3><a href="/member/password">비밀번호 변경</a></h3> 
<h3><a href="/member/edit">개인정보 변경</a></h3> 
<h3><a href="/member/exit">회원 탈퇴</a></h3>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
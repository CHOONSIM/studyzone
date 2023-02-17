<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>내 정보</h2>

<!--  프로필 이미지 유무에 따라 이미지를 선택하여 표시 -->
<c:choose>
	<c:when test="${profile != null }">
		<img width="200" height="200" src="/attachment/download?attachmentNo=${profile.attachmentNo }">
	</c:when>
	<c:otherwise>
		<img width="200" height="200" src="/image/user.jpg">
	</c:otherwise>
</c:choose>

<table border ="1" width="400">
	<tbody>
		<tr>
			<th>아이디</th>
			<td>${memberDto.memberId }</td>
		</tr>
			<tr>
			<th>닉네임</th>
			<td>${memberDto.memberNick }</td>
		</tr>
			<tr>
			<th>전화번호</th>
			<td>${memberDto.memberTel }</td>
		</tr>
			<tr>
			<th>생년월일</th>
			<td>${memberDto.memberBirth }</td>
		</tr>
			<tr>
			<th>이메일</th>
			<td>${memberDto.memberEmail }</td>
		</tr>
			<tr>
			<th>주소</th>
			<td>
			${memberDto.memberPost } <br>
			${memberDto.memberBasicAddr } <br>
			${memberDto.memberDetailAddr }
			</td>
			</tr>
			<tr>
			<th>회원등급</th>
			<td>${memberDto.memberLevel }</td>
		</tr>
		<tr>
			<th>회원포인트</th>
			<td>${memberDto.memberPoint } point</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>
				<fmt:formatDate value="${memberDto.memberJoin }"
					pattern="y년M월d일 E a h시 m분 s초"/>
			</td>
		</tr>
		<tr>
			<th>마지막 로그인</th>
			<td>
				<fmt:formatDate value="${memberDto.memberLogin }"
					pattern="y년M월d일 E a h시 m분 s초"/>
			</td>
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
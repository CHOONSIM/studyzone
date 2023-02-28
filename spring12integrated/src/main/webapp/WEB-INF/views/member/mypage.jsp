<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container-900">
	<div class="row left">
		<h2>${memberDto.memberId } 님의 개인 프로필</h2>
	</div>

<div class="row flex-box">
	<div class="w-30">
		<div class="row center">
			<!--  프로필 이미지 유무에 따라 이미지를 선택하여 표시 -->
			<c:choose>
				<c:when test="${profile != null }">
					<img width="200" height="200" src="/attachment/download?attachmentNo=${profile.attachmentNo }">
				</c:when>
				<c:otherwise>
					<img width="200" height="200" src="/static/image/user.jpg">
				</c:otherwise>
			</c:choose>
		</div>
		<div class="row center">
			<h3><a href="/member/password">비밀번호 변경</a></h3> 
		</div>
		<div class="row center">
		<h3><a href="/member/edit">개인정보 변경</a></h3> 		
		</div>
		<div class="row center">
		<h3><a href="/member/exit">회원 탈퇴</a></h3>		
		</div>
		
		</div>
		
		<div class="w-70">
			<table class="table table-slit">
        		<tbody>
					<tr>
						<th class="w-30">아이디</th>
						<td>${memberDto.memberId }</td>
					</tr>
					<tr>
						<th class="w-30">닉네임</th>
						<td>${memberDto.memberNick }</td>
					</tr>
					<tr>
						<th class="w-30">전화번호</th>
						<td>${memberDto.memberTel }</td>
					</tr>
					<tr>
						<th class="w-30">생년월일</th>
						<td>${memberDto.memberBirth }</td>
					</tr>
					<tr>
						<th class="w-30">E-mail</th>
						<td>${memberDto.memberEmail }</td>
					</tr>
					<tr>
						<th class="w-30">주소</th>
						<td>
						${memberDto.memberPost }
						${memberDto.memberBasicAddr }
						${memberDto.memberDetailAddr }
						</td>
					</tr>
					<tr>
						<th class="w-30">등급</th>
						<td>${memberDto.memberLevel}</td>
					</tr>
					<tr>
						<th class="w-30">포인트</th>
						<td>${memberDto.memberPoint}</td>
					</tr>
					<tr>
						<th class="w-30">가입일</th>
						<td>
						<fmt:formatDate value="${memberDto.memberJoin }"
							pattern="y년M월d일 E a h시 m분 s초"/>
						</td>
					</tr>
					<tr>
						<th class="w-30">마지막 로그인</th>
						<td>
						<fmt:formatDate value="${memberDto.memberLogin }"
							pattern="y년M월d일 E a h시 m분 s초"/>
					</td>
					</tr>
			</tbody>
            </table>
		</div>
	</div>
</div>



<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
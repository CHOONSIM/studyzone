<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    <!-- 다음 우편 API 사용을 위한 CDN -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://cdn.jsdelivr.net/gh/CHOONSIM/find-address@latest/find-address.min.js"></script>
<!--  <script src="/static/js/find-address.min.js"></script> -->
    
<h1>개인정보 변경</h1>

<!-- (주의) table부터 th/td 사이에는 어떠한 태크도 적을 수 없다 -->
<form action="edit" method="post">
<table border="0" width="400">
	<tbody>
		<tr>
			<th width="25%">아이디</th>
			<td>${memberDto.memberId }</td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td>
			<input type="password" name="memberPw" required placeholder="확인을 위해 비밀번호 입력">
			</td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td>
			<input type="text" name="memberNick" required value="${memberDto.memberNick }">
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
			<input type="tel" name="memberTel" required value="${memberDto.memberTel }">
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>
			<input type="date" name="memberBirth" required value="${memberDto.memberBirth }">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
			<input type="email" name="memberEmail" value="${memberDto.memberEmail }">
			</td>
		</tr>
		<tr>
			<th rowspan="3">주소</th>
			<td>
			<input type="text" name="memberPost" value="${memberDto.memberPost }" placeholder="우편번호">
			<button type="button" class="form-btn neutral find-address-btn">우편번호 찾기</button>
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="memberBasicAddr" value="${memberDto.memberBasicAddr }" placeholder="기본주소">
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="memberDetailAddr" value="${memberDto.memberDetailAddr }" placeholder="상세주소">
			</td>
		</tr>
		<tr>
		<td colspan ="2" align="right">
			<button>수정하기</button>
		</td>
		</tr>
	</tbody>
</table>
</form>
    
    <c:if test="${param.mode=='error' }">
 	<h3>비밀번호가 일치하지 않습니다!</h3>
 </c:if>
    
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
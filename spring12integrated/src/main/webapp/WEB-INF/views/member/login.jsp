<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>로그인</h1>

<form action="login" method="post">
	<div class="row">
		<c:choose>
			<c:when test="${cookie.saveId == null}">
				아이디 : <input type="text"name="memberId"required> <br><br>			
			</c:when>
			<c:otherwise>
				아이디 : <input type="text"name="memberId"required value="${cookie.saveId.value}"> <br><br>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="row">
		비밀번호 : <input type="password"name="memberPw"required><br><br>
	</div>
	<div class="row">
		<label>
			<c:choose>
				<c:when test="${cookie.saveId == null}">
				<!-- 아이디 저장하기 하지 않은 경우 -->
					<input type="checkbox"  name="remember">	
				</c:when>
				<c:otherwise>
				<!-- 아이디 저장하기 한경우 -->
					<input type="checkbox" name="remember" checked>
				</c:otherwise>
			</c:choose>
			아이디 저장		
		</label>
	</div>
	<button>로그인</button>
</form>

<h4><a href="find">아이디 찾기</a></h4>

<%-- 
	이 페이지 접근 가능한 방법은 2가지가 있다
	1. 일반적인 접근 : 메인페이지 메뉴 또는 회원가입 완료 페이지의 링크를 타고 이동
	2. 로그인 실패 시 리다이렉트로 이동
	- 구분을 위해서 2번의 경우 파라미터에 mode=error를 추가했다
	- 파라미터를 검사하여 로그인 실패인경우 추가 메세지를 출력
	- JSP에서 파라미터를 직접 읽으려면 ${param.이름}과 같이 작성(컨트롤러 안거치고)
	- ${param.mode}는 파라미터 중 mode라는 항목의 값을 불러오라는 의미
	- EL은 equals 대신 ==로 문자열 비교가 가능 (EL은 출력 전용 언어)
	- EL은 문자열을 쌍따옴표 또는 외따옴표 구분하지 않음(밖은 "" 안은 '' 혹은 그 반대 구분을 위해서)
 	
 --%>
 <c:if test="${param.mode=='error' }">
 	<h3>로그인 정보가 일치하지 않습니다!</h3>
 </c:if>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
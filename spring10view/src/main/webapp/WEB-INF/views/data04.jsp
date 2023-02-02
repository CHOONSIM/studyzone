<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%--
    	JSTL 
    	- Jsp Standard Tag Library(JSP 표준 태크 라이브러리)
    	- JSP에서 자바코드 없이 프로그래밍 작업을 할 수 있도록 도와준다
    	- 태그 형식을 가짐
    	- 그냥 사용은 불가 설정(directive)으로 사용하겠다고 선언해야 함
    	- JSTL-1.2.jar 필요
    	- 필요한 페이지마다 설정을 작성해야함
     --%>
     <%@taglib prefix="c"" uri="http://java.sun.com/jsp/jstl/core" %>
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터가 있거나 없거나 잘 모르겠는 경우</title>
</head>
<body>
	<h1>message = ${message }</h1>
	<h1>message = ${message == null}</h1>
	
	
	<!-- 
		 JSTL의 if 태그를 이요해서 조건을 구현 
		(주의) c:else는 조재하지 않는다(c:choose로 해결)
	-->
     <c:if test="${message == null}">
     	<h2>메세지가 없습니다.</h2>
     	</c:if>
     <c:if test="${message != null}">
     	<h2>메세지 = ${message}</h2>
     	</c:if>
     	
     	
	<c:choose>
		<c:when test="${message == null}">
			<h2>메세지가 없습니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>메세지 = ${message}</h2>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>
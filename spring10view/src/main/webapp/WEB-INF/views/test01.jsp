<%--
	JSP주석 - 이 주석은 서버 실행시점에서 사라지므로 사용자는 볼 수 없습니다.
	
	JSP에서 사용할 수 있는 서버코드 문법
	1. Directive - 페이지의 기본 설정을 위한 코드
	- <%@%> 형태로 작성
	- language = "java"는 이 페이지에서 사용 가능한 언어를 설정
	- contentType은 사용자가 받게 될 완성품의 형태와 인코딩 방식을 설정
 		- text/html 을 MIME-TYPE이라고 부른다(대분류/세분류)
 		- charset은 사용자가 받게될 글자의 표현방식을 말한다
 	- pageEncoding은 서버에서 이 페이지를 제작할 때 사용할 글자 표현방식
 --%>


<%--<서버 실행 코드>-- --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
    
    <!-- HTML주석 - 이 주석은 클라이언트(사용자)에게 전달됩니다. -->
<%--< 클라이언트 실행코드> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
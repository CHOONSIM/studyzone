<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%-- 
    	컨트롤러에서 화면으로 전달된 데이터(Model)은
    	EL(Expression Language, 표현언어)이라는 문법으로 출력할 수 있다.
     
     	표현 언어는 서버에서 클라이언트에게 전송되기 전에 실행
     	출력 방법 ${이름}을 원하는 위치에 작성
     --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> a = ${a}</h1>
	<h2> b =${b}</h2>
<%-- 클라이언트, 서버 언어가 다름, 주석도 다름 --%>
<%-- 	<h1> monster = ${monster }</h1>	 --%>
	<h1>no=${monster.getNo() }</h1>
	<h1>name=${monster.getName() }</h1>
	<h1>type=${monster.getType()}</h1>	
	
<%-- 	EL에서는 객체의 필드를 추론식으로 깨낼 수 있다. 
			(주의) 규칙에 맞는 이름의 getter메소드가 없으면 에러발생
--%>
	<h1>no=${monster.no() }</h1>
	<h1>name=${monster.getName() }</h1>
	<h1>type=${monster.getType()}</h1>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 반복</title>
</head>
<body>
	<h1>lotto=${lotto }</h1>
	<h1>lotto=${lotto[0]}</h1>
	<h1>lotto=${lotto[1]}</h1>

<!-- 
	for(int n : lotto)와 동일한 코드를 JSTL로 구현
		- var : 변수명
		- items : 추출 대상
 -->
<c:forEach var="n" items=${lotto }>
		<h2>
		n=${n },
		<c:choose>
			<c:when test="${n%2 == 0 }">짝수</c:when>
			<c:otherwise>홀수</c:otherwise>
		</c:choose>
		</h2>
</c:forEach>

<hr>

<!-- 1부터 10까지 출력-for(int i = q; i<=10; i++) -->
<c:forEach var = "i" begin="1"end="10"step="1">
	<h2>i={i}</h2>

</c:forEach>

</body>
</html>
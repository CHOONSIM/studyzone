<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포켓몬 목록/검색</title>
</head>
<body>
	<h1>포켓몬 목록/검색</h1>
	
	<h2><a href="insertInput">신규등록</a></h2>
	
	<!-- 검색을 위한 검색창도 존재해야함 -->
	<form action="list" method="get">
		<select name = "column">
			<option value="name">이름</option>
			<option value="type">속성</option>
		</select>
		<input type="search" name="keyword"placeholder="검색어"required>
		<button>검색</button>
	</form>	
	<%-- 
		목록이든 검색이든 결과는 어차피 List<PocketmonDto>형태이므로
		JSTL을 사용하여 반복적으로 출력하도록 구현 %-->
	
	--%>
	<c:forEach var ="pocketmonDto" items="${list }">
		<h2>
		${pocketmonDto }
		<a href = "detail?no=${pocketmonDto.no }">상세보기</a>
		</h2>
	</c:forEach>
</body>
</html>
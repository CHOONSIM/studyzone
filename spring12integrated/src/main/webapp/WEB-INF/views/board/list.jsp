<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
 <h1>게시글 목록</h1>
<hr>

<form action="list" method="get">
		<select name = "column">
			<option value="board_no">번호</option>
			<option value="board_title">제목</option>
			<option value="board_writer">작성자</option>
		</select>
		<input type="search" name="keyword"placeholder="검색어"required>
		<button>검색</button>
	</form>	
	<hr>
    	
<table border ="1" width ="900">
	<thead>
		<tr>
			<th>번호</th>
			<th width="50%">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>좋아요</th>
		</tr>
	</thead>
	<tbody align="center">
	<c:forEach var = "boardDto" items="${list}">
		<tr>
			<td>${boardDto.boardNo }</td>
			<td>
				<a href="detail?boardTitle=${boardDto.boardTitle }">"${boardDto.boardTitle }"</a>
			</td>
			<td>${boardDto.boardWriter }</td>
			<td>${boardDto.boardTime }</td>
			<td>${boardDto.boardRead }</td>
			<td>${boardDto.boardLike }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

<br>
<hr>
<br>

<c:forEach var ="i" begin="1" end="${totalPage}" step ="1">
	<c:choose>
		<c:when test="${page==i }">					<!-- 현재 페이지 -->
			${i }
		</c:when>
		<c:otherwise>
			<a href="list?page=${i }">${i }</a>		<!-- 현재페이지가 아닌 경우 -->
		</c:otherwise>
	</c:choose>
</c:forEach>

    
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
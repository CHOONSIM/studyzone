<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>강의 ${mode }결과</title>
</head>
<body>
	<h1>강의 목록/검색</h1><br>
	<h2><a href="insertInput">신규 강의 등록</a></h2><br>
	<h2><a href="list">목록</a></h2><br><br>
		<form action="list"method="get">
			<select name ="column">
			 <option value="no">번호</option>
			 <option value="name">강의명</option>
			 <option value="peirod">강의 기간</option>
			 <option value="price">수강료</option>
			 <option value="type">강의타입</option>
			</select>
			<input type = "search"name="keyword"placeholder="검색어"value="${keyword }">
			<button>검색</button>
		</form>
		
		<hr>
		
		<c:choose>
			<c:when test="${list.isEmpty() }">
				<h2>데이터가 존재하지 않습니다.</h2>
			</c:when>
		<c:otherwise>
		
		<br><br>
		<table border="1" width="500">
			<thead>
				<tr>
					<th>번호</th>
					<th width="30%">강의명</th>
					<th>강의기간</th>
					<th>수강료</th>
					<th>강의타입</th>
					<th>관리</th>
				</tr>
			</thead>
			<tbody align="center">
			<c:forEach var = "subjectDto" items="${list }">
				<tr>
					<td>${subjectDto.no }</td>
					<td>
						<a href="detail?no=${subjectDto.no }">
					${subjectDto.name }
						</a>
					</td>
					<td>${subjectDto.period }</td>
					<td align ="right">${subjectDto.price }</td>
					<td>${subjectDto.type }</td>
					<td>
						<a href="#">수정</a>
						<a href="delete?no=${subjectDto.no}&keyword=${keyword}">삭제</a>
					</td>
				</tr>
				
			</c:forEach>
			
			</tbody>
			<tfoot>
				<tr>
					<!-- 5칸 만큼 차지하세요 -->
					<td colspan="6" align="right">
						<a href="insertInput">신규 강의 등록</a>
					</td>
				</tr>
			</tfoot>
			
		
		</table>
		</c:otherwise>
		</c:choose>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>학생 ${mode }결과</title>
</head>
<body>
	<h1>학생 성적 ${mode }</h1>
	<hr>
	<h3><a href="insertInput">신규 학생 성적 등록</a></h3>
	<h3><a href="list">학생 성적 목록</a></h3>
		<form action="list"method="get">
			<select name = "column">
				<option value ="no">번호</option>
				<option value ="name">이름</option>
			</select>
			<input type="search" name="keyword" placeholder="검색" value="${keyword }">
			<button>검색</button>
		</form>
		
		<hr>
		
		<c:choose>
			<c:when test="${list.isEmpty() }">
				<h2>데이터가 존재하지 않습니다.</h2>
			</c:when>
		<c:otherwise>
		<br>
		<table border ="1" width="600">
			<thead>
				<tr>
					<th>번호</th>
					<th width="20%">이름</th>
					<th>국어 점수</th>
					<th>영어 점수</th>
					<th>수학 점수</th>
					<th>총 점수</th>
					<th>평균 점수</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="studentDto" items="${list }">
					<tr>
					 <td>${studentDto.no }</td>
					 <td>
					 	<a href="detail?no=${studentDto.no }">
					 	${studentDto.name }
					 	</a>
					 	</td>
					 	<td>${studentDto.korean }</td>
					 	<td>${studentDto.english }</td>
					 	<td>${studentDto.math }</td>
					 	<td>${studentDto.total }</td>
					 	<td>${studentDto.average }</td>
					</tr>
				</c:forEach>
				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="7" align="right">
						<a href="insert">신규 학생 정보 등록</a>
					</td>
				</tr>
			</tfoot>
		</table>
		</c:otherwise>
		</c:choose>
</body>
</html>
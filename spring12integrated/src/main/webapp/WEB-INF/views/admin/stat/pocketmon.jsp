<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>포켓몬 현황</h1>

<table border="1" width="300">
	<thead>
		<tr>
			<th>속성</th>
			<th>마릿수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="pocketmonStatDto" items="${list }">
		<tr>
			<td>
				<a href="/pocketmon/list?column=type&keyword=${pocketmonStatDto.type}">${pocketmonStatDto.type }</a>
			</td>
			<td>${pocketmonStatDto.cnt }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
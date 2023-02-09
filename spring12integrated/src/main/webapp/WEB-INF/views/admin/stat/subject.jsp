<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>강의 현황</h1>
	<table border="1" width="300">
		<thead>
			<tr>
				<th>강의타입</th>
				<th>강의갯수</th>
				<th>평균수강료</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="subjectStatDto" items="${list }">
			<tr>
				<td>
					<a href="/subject/list?column=type&keyword=${subjectStatDto.type }">${subjectStatDto.type }</a>
				</td>
				<td align="center">${subjectStatDto.cnt }</td>
				<td align="right">${subjectStatDto.avg }</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
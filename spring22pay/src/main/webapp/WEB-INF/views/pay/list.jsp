<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>결제 내역</h1>

<table border="1" width="700">
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>금액</th>
			<th>상태</th>
			<th>일시</th>
			<th>더보기</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="paymentDto" items="${list}">
			<tr>
				<td>${paymentDto.paymentNo }</td>
				<td>${paymentDto.paymentName }</td>
				<td>${paymentDto.paymentTotal }</td>
				<td>${paymentDto.paymentStatus }</td>
				<td>${paymentDto.paymentTime }</td>
				<td>
					<a href="detail?paymentNo=${paymentDto.paymentNo }">
						더보기
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>

</table>
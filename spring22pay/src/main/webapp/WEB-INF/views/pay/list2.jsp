<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>결제 목록 계층형 출력</h1>

<!-- ul을 사용하여 목록을 출력 -->
<ul>
	<c:forEach var="paymentListVO" items="${list}">
		<li>${payementListVO.paymentDto.paymentName}

<!-- 상세내역이 있다면 출력 -->
<c:if test="${paymentListVO.paymentDetailList.size() > 0}">
	<ul>
		<c:forEach var="paymentDetailDto" items="${paymentListVO.paymentDetailList}">
			<li>${paymentSetail.Dto.itemName}</li>
		</c:forEach>
	</ul>
</c:if>
		</li>
	</c:forEach>
</ul>
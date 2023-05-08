<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>결제 목록 계층형 출력</h1>

<!-- ul을 사용하여 목록을 출력 -->
<ul>
	<c:forEach var="paymentListVO" items="${list}">
	<!-- 결제 대표 정보 -->
		<li>
		${payementListVO.paymentDto.paymentName}
		/
		${paymentListVO.paymentDto.paymentTotal}원
		/
		${paymentListVO.paymentDto.paymentStatus}
		/
		<a href="#">[더보기]</a>
		/
		<c:if test="${paymentListVO.paymentDto.paymentRemain>0}">
			<a href="refundAll?paymentNo=${paymentListVO.paymentDto.paymentNo }">[전체취소]</a>
		</c:if>

<!-- 상세내역이 있다면 출력 -->
<c:if test="${paymentListVO.paymentDetailList.size() > 0}">
<!-- 결제 상세내역이 있다면 출력 -->
	<ul>
		<c:forEach var="paymentDetailDto" items="${paymentListVO.paymentDetailList}">
			<li>
				${paymentSetail.Dto.itemName}
				/
				${paymentDetailDto.itemName}
				/
				${paymentDetailDto.itemPrice}원
				/
				${paymentDetailDto.itemQty}개
				/
				총 : ${paymentDetailDto.itemTotal}원
				/
				${paymentDetailDto.paymentDetailStatus}
				/
				<c:if test="${paymentDetailDto.paymentDetailStatus == '완료'}">
					<a href="#">[항목취소]</a>
				</c:if>
			</li> 
		</c:forEach>
	</ul>
</c:if>
		</li>
	</c:forEach>
</ul>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>결제 상세 정보</h1>
<hr>

<h3>상품명 : ${paymentDto.paymentName}</h3>
<%-- <h3>총금액 : ${paymentDto.paymentTotal}</h3> --%>
<h2>총금액 : 
<fmt:formatNumber value="${paymentDto.paymentTotal}" pattern="#,##0"></fmt:formatNumber>
원</h2>
<h3>잔여금액 : ${paymentDto.paymentRemain}</h3>
<h3>현재상태 : ${paymentDto.paymentStatus}</h3>

<%--결제 취소 버튼 : 잔여금액이 존재한다면 --%>
<c:if test = "${paymentDto.paymentRemain > 0}">
	<a href="cancel?paymentNo=${paymentDto.paymentNo}">결제취소</a>
</c:if>


<hr>

<h3>결제상태 : ${response.status}</h3>
<h3>주문번호 : ${response.partner_order_id}</h3>
<h3>주문자 : ${response.partner_user_id}</h3>
<h3>결제수단 : ${response.payment_method_type}</h3>

<h3>결제금액 : ${response.amount.total}원</h3>
<h3>취소금액 : ${response.canceled_amount.total}원</h3>
<h3>취소가능 : ${response.cancel_available_amount.total}원</h3>

<h3>상품명 : ${response.item_name}</h3>
<h3>상품코드 : ${response.item_code}</h3>
<h3>구매수량 : ${response.quantity}</h3>

<h3>준비시각 : <fmt:formatDate value="${response.created_at}" pattern="y년M월 d일 E a h시 m분 s초"/></h3>
<h3>승인시각 : <fmt:formatDate value="${response.approved_at}" pattern="y년M월 d일 E a h시 m분 s초"/></h3>
<h3>취소시각 : <fmt:formatDate value="${response.canceled_at}" pattern="y년M월 d일 E a h시 m분 s초"/></h3>

<%-- 카드정보는 카드결제일 때만 나옴 --%>
<c:if test="${response.payment_method_type == 'CARD'}"></c:if>
<c:if test="${response.selected_card_info != null}">
<hr>
	<h4>카드사 정보 : ${response.selected_card_info.card_corp_name}</h4>
	<h4>카드 BIN 정보 : ${response.selected_card_info.card_corp_name}</h4>
	<h4>할부 개월 수 : ${response.selected_card_info.card_bin}</h4>
	<h4>무이자할부 여부 : ${response.selected_card_info.interest_free_install}</h4>
<hr>
</c:if>


<%--결제 전체 순서에 따른 내역 --%>
<h2>결제 순서 및 상세 내역</h2>
<c:forEach var="paymentAction" items="${response.payment_action_details}">
<hr>
	<h4>요청번호 : ${paymentAction.aid}</h4>
	<h4>거래시각 : ${paymentAction.approved_at}</h4>
	<h4>총액 : ${paymentAction.amount}원</h4>
	<h4>포인트 : ${paymentAction.point_amount}포인트</h4>
	<h4>할인 : ${paymentAction.discount_amount}원</h4>
	<h4>유형 : ${paymentAction.payment_action_type}</h4>
</c:forEach>





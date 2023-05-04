<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>결제 테스트(얼추)</h1>

<form action="test2" method="post">
<button type="submit">구매하기</button>
<c:forEach var="itemDto"  items="${itemList}" >
	<div>
		<input type="checkbox" name="itemNo" value="${itemDto.itemNo }">
		${itemDto.itemName}
		(
		<strike>${itemDto.itemPrice}</strike>
		→
		<mark>${itemDto.itemDiscount}</mark>
		)
		<input type="number" name="qty" value="1">
	</div>
</c:forEach>
</form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="write" method="post" autocomplete="off">
<%-- 답글일 때는 정보가 한 개 더 전송되어야 한다(boardParent) --%>
<c:if test="${boardParent != null}">
<input type="hidden" name="boardParent" value="${boardParent}">
</c:if>

<div class="container-800">

	<!-- 제목 -->
	<div class="row center">
		<c:choose>
			<c:when test="${boardParent == null}">
				<h2>새글 작성</h2>
			</c:when>
			<c:otherwise>
				<h2>답글 작성</h2>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="row">
		<label class="form-label w-100">말머리</label>
		<select name="boardHead" class="form-input">
			<!-- 없음을 선택하면 값이 비어서 전송되므로 DB에 null로 들어감 -->
			<option value="">없음</option>
			<c:if test="${memberLevel == '관리자'}">
				<option>공지</option>
			</c:if>
			<option>유머</option>
			<option>정보</option>
		</select>
	</div>
	
	<div class="row">
		<label>제목<i class="fa-solid fa-asterisk"></i></label>
		<c:choose>
			<c:when test="${boardParent == null}">
				<input type="text" name="boardTitle" required class="form-input w-100">
			</c:when>
			<c:otherwise>
				<input type="text" name="boardTitle" required value="RE: " class="form-input w-100">
			</c:otherwise>
		</c:choose>
	</div>
	
	<div class="row">
		<label>내용<i class="fa-solid fa-asterisk"></i></label>
        <textarea name="content"></textarea>
	</div>
	
	<div class="row">
		<button type="submit" class="form-btn positive w-100">등록</button>
	</div>
</div>

</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
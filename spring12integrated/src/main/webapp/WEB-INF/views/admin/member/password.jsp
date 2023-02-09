<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>일회용 비밀번호 설정</h2>
<h2>${memberPw } 로 변경되었습니다.</h2>

<hr>
<h4><a href="detail?memberId=${memberDto.memberId} &page=${page}">상세조회</a></h4>
<h4><a href="list">목록으로</a></h4>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
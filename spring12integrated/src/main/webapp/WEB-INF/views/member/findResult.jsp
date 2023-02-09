<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
    
    <h2>아이디 찾기 결과</h2>
    
    <h3>찾으시는 아이디는  ${memberId } 입니다.</h3>
    <h3><a href ="login">로그인</a></h3>
    <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
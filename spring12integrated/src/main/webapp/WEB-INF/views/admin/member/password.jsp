<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h2>��ȸ�� ��й�ȣ ����</h2>
<h2>${memberPw } �� ����Ǿ����ϴ�.</h2>

<hr>
<h4><a href="detail?memberId=${memberDto.memberId} &page=${page}">����ȸ</a></h4>
<h4><a href="list">�������</a></h4>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
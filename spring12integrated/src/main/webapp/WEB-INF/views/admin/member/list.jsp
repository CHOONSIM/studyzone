<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>ȸ�� ���</h1>
<hr>

<table border ="1" width="700">
	<c:forEach var ="memberDto" items="${list }">
	<thead>
		<tr>
			<th>���̵�</th>
			<th>�г���</th>
			<th>��ȭ��ȣ</th>
			<th>�������</th>
			<th>���</th>
			<th>����</th>
		</tr>
	</thead>
	<tbody align="center">
		<tr>
			<td>${memberDto.memberId }</td>
			<td>${memberDto.memberNick }</td>
			<td>${memberDto.memberTel }</td>
			<td>${memberDto.memberBirth }</td>
			<td>${memberDto.memberLevel }</td>
			<td>
				<a href="#">��</a>
				<a href="#">����</a>
				<a href="#">Ż��</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<!-- 
	������ �׺������ ���� 
	for(int i = 1; i<=totalPage;i++){}
-->
<c:forEach var ="i" begin="1" end="${totalPage}" step ="1">
	<c:choose>
		<c:when test="${page==i }">					<!-- ���� ������ -->
			${i }
		</c:when>
		<c:otherwise>
			<a href="list?page=${i }">${i }</a>		<!-- ������������ �ƴ� ��� -->
		</c:otherwise>
	</c:choose>
</c:forEach>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
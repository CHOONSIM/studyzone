<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>강의 정보 삭제</title>
		<a href="http://localhost:8080/view/subject">과제 목록으로</a><br><br>
	</head>
	<body>
	<h1>강의 정보 삭제</h1>
	<a href="/subject/listandsearch">전체목록확인</a>
		<form action="/subject/delete">
			<h4>삭제 강의 번호</h4>
			<input type="number"name="no"><br><br>
			<button>삭제</button>
		</form>
	</body>
</html>
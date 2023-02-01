<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 정보 삭제</title>
	</head>
	<body>
	<h1>학생 정보 삭제</h1>
	<a href="/student/listandsearch">전체목록확인</a>
		<form action="/student/delete">
			<h4>삭제 학생의 번호</h4>
			<input type="number"name="no"><br><br>
			<button>삭제</button>
		</form>
	</body>
</html>
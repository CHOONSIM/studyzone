<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 성적 등록</title>
		<a href="http://localhost:8080/view/student">과제 목록으로</a><br><br>
	</head>
	<body>
		<h1>학생 성적 정보 등록</h1>
		<form action="/student/insert">
		
			<h4>이름</h4>
			<input type="text"name="name"><br>
			<h4>국어점수	</h4>
			<input type="number"name="korean"><br>
			<h4>영어점수	</h4>
			<input type="number"name="english"><br>
			<h4>수학점수</h4>
			<input type="number"name="math"><br><br><br>
			<button>등록</button>
		</form>
	</body>
</html>
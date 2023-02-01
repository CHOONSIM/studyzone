<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 정보 수정</title>
	</head>
	<body>
	<h1>학생 정보 수정</h1>
	<a href="/student/listandsearch">전체목록확인</a>
		<form action="/student/edit">
			<h4>번호</h4>
			<input type="number"name="no"><br>
			<h4>이름</h4>
			<input type="text"name="name"><br>
			<h4>국어점수</h4>
			<input type="number"name="korean"><br>
			<h4>영어점수</h4>
			<input  type="number"name="english"><br>
			<h4>수학점수</h4>
			<input  type="number"name="math"><br><br>
			<button>수정</button>
		</form>
	</body>
</html>
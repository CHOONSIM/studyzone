<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>강의 정보 수정</title>
	</head>
	<body>
	<h1>강의 정보 수정</h1>
	<a href="/subject/listandsearch">전체목록확인</a>
		<form action="/subject/edit">
			<h4>번호</h4>
			<input type="number"name="no"><br>
			<h4>강의명</h4>
			<input type="text"name="name"><br>
			<h4>강의기간</h4>
			<input type="number"name="period"><br>
			<h4>수강료</h4>
			<input  type="number"name="price"><br>
			<h4>강의타입</h4>
			<input  type="text"name="type"><br><br>
			<button>수정</button>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<h1>강의 정보 등록</h1>
		<form action="/subject/insert">
		
			<h4>강의명</h4>
			<input type="text"name="name"><br>
			<h4>강의기간	</h4>
			<input type="number"name="period"><br>
			<h4>수강료</h4>
			<input type="number"name="price"><br>
			<h4>강의타입(온/오프라인,혼합)</h4>
			<input type="text"name="type"><br><br><br>
			<button>등록</button>
		</form>
	</body>
</html>
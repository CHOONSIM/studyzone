<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수업과목 등록</title>
</head>
<body>
<h1>수업 강의 등록</h1>
<h2><a href="list">목록보기</a></h2>
<form action="insert"method="post">
			강의 이름 : <input type="text"name="name"required placeholder="개설과정 이름"><br>
			강의 기간 : <input type="number"name="period"min="0" max="150" step="30"value="30" required><br>
			수강료 : <input type="number"name="price" requierd placeholder="과정 월 수강료"><br>
			강의 타입 : <select name="type">
				<option>온라인</option>
				<option>오프라인</option>
				<option>혼합</option>
			</select>
			<br><br><br>
			<button>등록</button>
			
</form>
</body>
</html>
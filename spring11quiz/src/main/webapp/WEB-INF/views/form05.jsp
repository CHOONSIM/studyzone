<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>강의 정보 등록</title>
		<a href="http://localhost:8080/view/subject">과제 목록으로</a><br><br>
	</head>
	<!-- 
		required="required"라는 속성을 입력창에 적으면 해당 입력창은 필수가 된다. 
		특별히 속성값이 같은 입력창들은 값을 생략할 수 있다.
		 - required, readonly, selected, checked, disable 등
	-->
	<body>
		<h1>강의 정보 등록</h1>
		<form action="/subject/insert">
		
			<h4>강의명</h4>
			<input type="text"name="name"required placeholder="개설과정 이름"><br>
			<h4>강의기간	</h4>
			<input type="number"name="period"min="0" max="150" step="30"value="30" required><br>
			<h4>수강료</h4>
			<input type="number"name="price" requierd placeholder="과정 월 수강료"><br>
			<h4>강의타입</h4>
			<select name="type">
				<option>온라인</option>
				<option>오프라인</option>
				<option>혼합</option>
			</select>
			<br><br><br>
			<button>등록</button>
		</form>
	</body>
</html>
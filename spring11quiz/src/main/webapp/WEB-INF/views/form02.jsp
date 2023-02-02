<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 성적 정보 검색</title>
		<a href="http://localhost:8080/view/student">과제 목록으로</a><br><br>
	</head>
	<body>
		<h1>학생 성적 정보 검색</h1>
		<a href="/student/listandsearch">전체목록확인</a>
		<br><br>
		<form action="/student/listandsearch">
			<select name="column">
				<option value="no">번호</option>
				<option value="name">이름</option>
				<option value="korean">국어과목</option>
				<option value="english">영어과목</option>
				<option value="math">수학과목</option>
			</select>
			<input name="keyword">
			<button>검색</button>
		</form>
		
		<h2>학생 상세정보</h2>
		<h5>학생번호 입력</h5>
		<form action="/student/detail">
			<input type="number"name="no">
			<button>상세정보</button>
		</form>	
	</body>
</html>
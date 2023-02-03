<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생 성적 등록</title>
	</head>
	<body>
		<h1>학생 성적 정보 등록</h1>
		<h3><a href="list">목록보기</a></h3>
		<form action="insert"method="post">
			이름 : <input type="text"name="name"required placeholder="학생 이름"><br>
			국어 점수 : <input type="number"name="korean"required placeholder="국어 점수"><br>
			영어 점수 : <input type="number"name="english"required placeholder="영어 점수"><br>
			수학 점수 : <input type="number"name="math"required placeholder="수학 점수"><br><br><br>
			<button>등록</button>
		</form>
	</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>강의 정보 검색</title>
	</head>
	<body>
		<h1>강의 정보 검색</h1>
		<a href="/subject/listandsearch">전체목록확인</a>
		<br><br>
		<form action="/subject/listandsearch">
			<select name="column">
				<option value="no">번호</option>
				<option value="name">강의명</option>
				<option value="period">강의기간</option>
				<option value="price">수강료</option>
				<option value="type">강의타입</option>
			</select>
			<input name="keyword">
			<button>검색</button>
		</form>
		
		<h2>강의 상세정보</h2>
		<h5>강의번호 입력</h5>
		<form action="/subject/detail">
			<input type="number"name="no">
			<button>상세정보</button>
		</form>	
	</body>
</html>
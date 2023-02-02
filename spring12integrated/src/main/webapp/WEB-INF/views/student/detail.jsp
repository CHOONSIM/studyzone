<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${studentDto.no }번 학생 상세 정보</title>
</head>
<body>
	<h1>학생 성적 상세 정보</h1>
	
	<!-- 
		ul : 순서 없는 리스트 태그
			- select 와 같은 주고로 배치하는 태크
			- 내부에 li(list item)태그를 사용하여 항목을 표시
	 -->
	 <ul>
	<li>번호 : ${studentDto.no }</li><br>
	<li>이름 : ${studentDto.name }</li><br>
	<li>국어 성적 : ${studentDto.korean }점</li><br>
	<li>영어 성적 : ${studentDto.english }점</li><br>
	<li>수학 성적 : ${studentDto.math }점</li><br>
	<li>총 성적 합 : ${studentDto.total }점</li><br>
	<li>평균 : ${studentDto.average }점</li><br>
	</ul>
</body>
</html>
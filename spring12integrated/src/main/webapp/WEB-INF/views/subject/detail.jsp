<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${subjectDto.no }번 강의 정보</title>
</head>
<body>
	<h1>강의 상세 정보</h1>
	번호 : ${subjectDto.no } <br>
	강의명 : ${subjectDto.name }<br>
	강의기간 : ${subjectDto.period }<br>
	수강료 : ${subjectDto.price }<br>
	강의타입 : ${subjectDto.type }<br> 
</body>
</html>
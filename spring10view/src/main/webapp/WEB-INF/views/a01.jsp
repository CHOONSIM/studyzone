<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>하이퍼링크 예제</title>
</head>
<body>
<!-- 
	a 태그(anchor 태그)
	- 클릭 시 다른 대상으로 이동하도록 하는 태크
	- 글자나 이미지 등 어떤 내용에 적용이 가능
	- href 속성으로 연결 대상을 지정
 -->
 <a href="https://iei.or.kr/main/main.kh">KH정보교육원으로 이동하기</a>

<br><br>
<!-- 
	내가 만든 페이지로의 링크
	- 절대경로(absolute path) - 절대로 변하지 않는 경로(전체주소)
	- 상대경로(relative path) - 현재 위치를 기반으로 계산한 경로
	
	(상대 경로 계산 원리)
	- 상대경로 계산을 위해서는 현재 위치와 목적지 위치가 필요하다
	- 현재 위치 - http://localhost:8080/a01
	- 목표 위치 - http://localhost:8080/test02
	- 현재 위치와 목표 위치의 엔드포인드(endpoint,마지막 슬래시) 가 같으므로 이름만 작성
	 -->
	 <a href="http://localhost:8080/test02">기본 구조 예제로 이동</a><br>
	 <a href="//localhost:8080/test02">기본 구조 예제로 이동</a><br>
	 <a href="/test02">기본 구조 예제로 이동</a><br>
	 <a href="test02">기본 구조 예제로 이동</a><br>
	 <a href="img01">이미지 예제1로 이동</a><br>
	 <a href="img02">이미지 예제2로 이동</a><br>
	 
	 <a href = "https://www.instagram.com/">
	 <img width="50" height= "50" src="logo/instagramicon.png" /></a>
	 </body>
</html>

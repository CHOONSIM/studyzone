<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
			<meta charset="UTF-8">
			<title>입력폼 예제</title>
	</head>
	<body>
		
		<!-- 
			폼(form)은 눈에 보이지는 않지만 내부에 입력창을 두고 전송할 수 있다.
			- action : 폼이 전송될 목적지 주소
			
			입력창(input)은 사용자가 글자를 작성할 수 있다 (여러개 가능)
			- name : 전송할 때 입력값에 붙을 이름을 지정
			
			버튼(button)은 form안에 있을 경우 해당 폼을 전송시킨다 (보통 한개)
			- 
		 -->
		 <form action="https://www.genie.co.kr/search/searchMain">
		 	<input name="query">
		 	<button>검색</button>
		 </form>

	</body>
</html>



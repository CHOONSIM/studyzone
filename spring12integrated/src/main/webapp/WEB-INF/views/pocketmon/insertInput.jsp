<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h1>포켓몬 등록</h1>
 <!-- 
 	form 전송방식은 크게 두 가지로 나뉜다
 	GET : 기본방식. 주소를 통해 데이터를 전달하는 방식
 		- 편지봉투에 할 말을 작서하는 것과 같음
 			- 간편하게 사용할 수 있는 장점
 			- 용량 제한의 단점(주소 포함 256byte)
 			- 모든 데이터 노출되는 단점
 			- a, img, form 주소를 직접 입력하는 등 다양한 형태로 가능하다.
 			
 	POST : 주소가 아니라 요청 내부에 숨겨서 데이터를 전달하는 방식(body에 첨부)
 		- 편지지에 할 말을 작성하는 것과 같음
 			- 용량 제한이 없음
 			- 데이터가 요청 바디(편지지)에 숨겨져서 전송
 			- form으로만 가능
  -->
 <!-- <form action="/pocketmon/insertProcess -->
	<form action="insertProcess"method="post" autocomplete="off">
		<div class="container-400">
            <!-- 2. 배치될 항목(컴포넌트)의 줄 수 만큼 .row를 생성-->
        <div class="row center">
            <h1>포켓몬 등록</h1>
        </div>
        <hr>
        <div class="row">
            <label>번호</label>
            <input type="text"name="no" required placeholder="숫자만 입력"
                        class="form-input w-100">
        </div>
        <div class="row">
            <label>이름</label>
            <input type="text"name="name" required placeholder="한글만 입력"
                        class="form-input w-100">
        </div>
        <div class="row">
            <label>속성</label>
            <input type="text"name="type" required  placeholder="한글만 입력"
                        class="form-input w-100">
        </div>
        <div class="row right">
            <!--
                form안에 있는 버튼은 전송용 버튼으로 기본 취급된다.
                문제를 해결하기 위해서는 다음과 같이 처리한다.

                1. 버튼에 type을 설정해서 용도를 지정할 수 있다.
                - type="submit" 이면 폼을 전송시키는 버튼
                - type="button" 이면 그냥 버튼

                2. 버튼 말고 다른 태그를 사용한다.
                - a태그, input[type=button] 등을 사용할 수 있다.
                - a태그의 display, text-align, text-decoration을 수정
            -->
            <button type="button" class="form-btn neutral">목록</button>
            <button type="submit" class="form-btn positive">등록</button>
        </div>
        <div class="row">
            <button class="form-btn positive w-100">등록</button>
        </div>
        <div class="row">
            <a class="form-btn neutral w-100" href="list">목록</a>
        </div>
    </div>
	</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
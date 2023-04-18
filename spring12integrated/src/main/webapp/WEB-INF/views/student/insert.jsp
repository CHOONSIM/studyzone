<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

		<h1>학생 성적 정보 등록</h1>
		<h3><a href="list">목록보기</a></h3>
		<form action="insert"method="post">
<div class="container-500 mt-50">
        <div class="row center">
            <h1>학생 성적 등록</h1>
        </div>
        <hr>
        <div class="row left">
            <a href="#">신규학생 성적 등록</a></div>
        <div class="row">
            <label>이름</label>
            <input type="text"name="name" required placeholder="학생이름"
                         class="form-input w-100"></div>
        <div class="row">
            <label>국어</label>
            <input type="number"name="korean" required placeholder="숫자만 입력"
                          class="form-input w-100"></div>
        <div class="row">
             <label>영어</label>
             <input type="number"name="english" required placeholder="숫자만 입력"
                          class="form-input w-100"></div>
         <div class="row">
            <label>수학</label>
            <input type="number"name="math" required placeholder="숫자만 입력"
                          class="form-input w-100"></div>
        <div class="row right">
            <a class="form-btn neutral">목록</a>
            <button class="form-btn positive">등록</button>
        </div>
        <div class="row">
            <button class="form-btn positive w-100">등록</button>
        </div>
        <div class="row">
            <a class="form-btn neutral w-100" href="list">목록</a>
        </div>
    </div>

		</form>
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
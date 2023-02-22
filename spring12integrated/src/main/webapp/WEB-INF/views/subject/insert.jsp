<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<h1>수업 강의 등록</h1>
<h2><a href="list">목록보기</a></h2>
<form action="insert"method="post">
		 <div class="container-500 mt-50">
            <div class="row center">
            <h1>과목 정보 등록</h1>
        </div>
        <div class="row">
            <label>과목명</label>
            <input type="text" name="name" required class="form-input w-100">
        </div>
        <div class="row">
            <label>과목 시간</label>
            <input type="number" name="period" required class="form-input w-100">
        </div>
        <div class="row">
            <label>수강료</label>
            <input type="number" name="price" required class="form-input w-100">
        </div>
        <div class="row">
            <label class="form-label w-25">강의 유형</label>
            <select name="type" required class="form-input">
                <option value="">선택</option>
                <option>오프라인</option>
                <option>온라인</option>
                <option>혼합</option>
            </select>
        </div>
        <div class="row right">
            <a class="form-btn neutral">목록</a>
            <button class="form-btn positive">등록</button>
        </div>
    </div>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
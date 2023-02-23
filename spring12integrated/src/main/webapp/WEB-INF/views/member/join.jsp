<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<form action="join" method="post" enctype="multipart/form-data">
        <div class="row center">
            <h1>회원가입 정보 입력</h1>
        </div>
        <hr>
        <div class="row">
            <input type="file" name="attach" enctype=".JPG, .GIF, .PNG" class="form-input w-100">
        </div>

        <div class="row">
            <label>아이디</label>
            <input type="text" name="memberId" required class="form-input w-100"placeholder="아이디 형식에 맞게 입력">
        </div>

        <div class="row">
            <label>비밀번호</label>
            <input type="text" name="memberPw" required class="form-input w-100" placeholder="비밀번호 형식에 맞게 입력">
        </div>

        <div class="row">
            <label>닉네임</label>
            <input type="text" name="memberNick" required class="form-input w-100" placeholder="닉네임 형식에 맞게 입력">
        </div>

        <div class="row">
            <label>전화번호</label>
            <input type="tel" name="memberTel" required class="form-input w-100" placeholder="숫자만 입력">
        </div>
        
        <div class="row">
            <label>이메일</label>
            <input type="email" name="memberEmail" class="form-input w-100" placeholder="이메일 형식에 맞게 입력">
        </div>

        <div class="row">
            <label>생년월일</label>
            <input type="date" name="memberBirth" required class="form-input w-100">
        </div>

        <div class="row">
            <label>우편번호</label>
            <input type="number" name="memberPost" class="form-input w-100" placeholder="숫자만 입력">
        </div>

        <div class="row">
            <label>기본주소</label>
            <input type="text" name="memberBasicAddr" class="form-input w-100" placeholder="기본주소 입력">
        </div>

        <div class="row">
            <label>상세주소</label>
            <input type="text" name="memberDetailAddr" class="form-input w-100" placeholder="상세주소 입력">

            <hr>

        <div class="row right">
            <button class="form-btn positive">게시</button>
        </div>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
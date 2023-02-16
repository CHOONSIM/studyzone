<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>회원 가입 정보 입력</h1>

<form action="join" method="post" enctype="multipart/form-data">
	프로필 이미지 : <input type="file" name="attach" accept=".png, .gif, .jpg"><br><br>
	아이디 : <input type="text" name="memberId"required><br><br>
	비밀번호 :  <input type="text" name="memberPw"required><br><br>
	닉네임 : <input type="text" name="memberNick"required><br><br>
	전화번호 : <input type="tel" name="memberTel"required><br><br>
	이메일 : <input type="email" name="memberEmail"><br><br>
	생년월일 : <input type="date" name="memberBirth"required><br><br>
	우편번호 : <input type="text" name="memberPost"><br><br>
	기본주소 : <input type="text" name="memberBasicAddr"><br><br>
	상세주소 : <input type="text" name="memberDetailAddr"><br><br>
	
		<button>가입</button>
</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
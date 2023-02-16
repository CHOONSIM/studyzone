<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<h1> 파일 관리 예제</h1>

<!-- 
	파일 전송은 input[type=file]로한다.
	GET방식은 용량제한 때문에 파일 전송이 불가능하며 이름만 전송
	POST방식은 용량제한은 없지만 전송이 불가능하며 이름만 전송
		- POST방식은 Encoding Type에 따라 두 가지로 나눠진다
		- application/x-www-form-urlencoded 은 기본 방식이며 key=value 형태로 전송
 		- key와 value가 1:1연결되므로 파일과 같이 정보가 많을때는 전송이 어렵다
 		- 파일을 전송하고 싶다면 반드시 enctype="multipart/form-data"로 변경해야한다
 -->
 
<h3>GET 예제</h3>
<form action="upload1" method="get" enctype="application/x-www-form-urlencoded">
	
	<input type="file" name="attach">
	<br><br>
	
	<button>첨부파일 업로드</button>
</form>

<hr>

<h3>POST 예제</h3>
<form action="upload2" method="post" >
	
	<input type="file" name="attach">
	<br><br>
	
	<button>첨부파일 업로드</button>
</form>

<hr>

<h3>POST (multipart방식)예제</h3>
<form action="upload3" method="post" enctype="multipart/form-data" >
	
	<input type="file" name="attach">
	<br><br>
	
	<button>첨부파일 업로드</button>
</form>

<hr>

<h2>포켓몬스터 등록</h2>
<form action="upload4" method="post" enctype="multipart/form-data" >

	번호 : <input type ="text" name = "no"><br><br>
	이름 : <input type ="text" name = "name"><br><br>
	속성 : <input type ="text" name = "type"><br><br>
	이미지 : <input type ="file" name = "attach"><br><br>
	<button>등록</button>
</form>






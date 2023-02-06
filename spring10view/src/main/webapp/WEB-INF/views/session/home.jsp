<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h1>세션 예제</h1>
    
    <%-- 
    JSP에서 세션의 값을 확인 
    	- sessionScop. 이름으로 확인
    	- sessionScope 생략 가능
    --%>
    <h2>academy=${sessionScope.academy }]</h2>
      <h2>academy=${academy }]</h2>
    
    <h2><a href="set">데이터 설정</h2>
    <h2><a href="remove">데이터 삭제</a></h2>
    
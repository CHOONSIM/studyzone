<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>홈패이지 레이아웃</title>
    <link rel="stylesheet" type="text/css" href="/static/css/load.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    
    <link rel="stylesheet" type="text/css" href="/static/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/static/css/commons.css">
    <link rel="stylesheet" type="text/css" href="/static/css/test.css">
    <style>
      
    </style>
</head>
<body>
    <!-- 홈페이지를 만들 때 시맨틱(sementic tag) 를 사용하여 의미있게 구현 -->

    <main>
        <header>
            <div class="flex-box">
                <div class="w-25">
                    <img src="https://via.placeholder.com/200x80?text=LOGO"alt="로고">
                </div>
                <div class="w-60">
                    <h3>테스트 홈페이지</h3>
                </div>
            </div>

        </header>
        <nav>
        	<!--  메뉴를 상태에 따라 다르게 나오도록 처리 -->
            <ul class="menu">
                <li><a href="/">홈</a></li>
                <li><a href="/pocketmon/list">포켓몬관리</a></li>
                <li><a href="/subject/list"">과목관리</a></li>
                <li><a href="/student/list">학생관리</a></li>
                <li><a href="/board/list">게시판</a></li>

                <li class="right-menu">
                    <a>회원메뉴</a>
                    <ul>
                    	<c:if test="${memberId == null }">
                        <li><a href="/member/login">로그인</a></li>
                        <li><a href="/member/join">회원가입</a></li>
                    	</c:if>
                    	<!--  로그인 상태 -->
                    	<c:if test="${memberId != null }">
                        <li><a href="/member/mypage">내정보</a></li>
                        <li><a href="/member/logout">로그아웃</a></li>
                    	</c:if>
                    	<!-- 관리자 -->
                    	<c:if test="${memberLevel == '관리자' }">
                        <li><a href="/admin/home">관리메뉴</a></li>
                    	</c:if>
                    </ul>
                </li>

            </ul>
        </nav>
        <section>
            <aside style="border-right:1px solid #B2BEC3">
                <!-- 관리메뉴는 수직으로 배치(List-Group 형태)-->
                <div class="flex-box flex-vertical">
                    <div class="p-10"><h3>관리자 메뉴</h3></div>
                    <div class="p-10"><a href="/admin.member/list" class="link">회원현황</a></div>
                    <div class="p-10"><a href="/admin.member/pocketmon" class="link">포켓몬 현황</a></div>
                    <div class="p-10"><a href="/admin.member/subject" class="link">강의 개설 현황</a></div>
                    <div class="p-10"><a href="/admin.member/student" class="link">학생 성적 현황</a></div>
                </div>
            </aside>
            <article>
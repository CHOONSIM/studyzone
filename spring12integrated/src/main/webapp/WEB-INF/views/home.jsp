<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
jsp가 제공하는 설정 중에 include라는 설정이 있음 
이를 사용하여 상단 ,하단 템플릿 페이지를 불러온다
--%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<!-- 중단 -->
	<h1>환영합니다.</h1>
	
<c:if test="${cookie.noad == null}">
	<!-- 광고 화면 모달 -->
	<style>
		.ad-modal{
			position: fixed;
			top:50%;
			left:50%;
			transform: transform(-50%,-50%);
			padding: 30px;
			border: 3px solid black;
			background-color: white;
		}
	</style>
	<div class="ad-modal">
		<img src="https://via.placeholder.com/400x400?text=AD">
		<br>
		<a class="close-no-ad" href="#">오늘 하루 안보기</a>
		<a class="close-no-action" href="#">닫기</a>
	</div>
	<script>
		$(function(){
			//닫기를 누르면 광고창을 숨김
			$(".close-no-action").click(function(){
				e.preventDefault();
				$(".ad-modal").hide();
			});
			//오늘 하루 안보기를 누르면 ~하고 광고창을 숨김
			$(".close-no-ad").click(function(){
				
				//서버에 쿠키 생성 요청
				$.ajax({
					async: false,//비동기 처리를 해제
					url:"${pageContext.request.contextPath}/noad",
				});
				$(".ad-modal").hide();
			});
		});
	</script>
</c:if>
			
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>

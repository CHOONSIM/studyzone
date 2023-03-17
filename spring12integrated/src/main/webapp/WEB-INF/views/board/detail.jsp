<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>    

<h1>${boardDto.boardNo}번 게시글</h1>

<script>
	// [1] 시작하자마자 이 글에 좋아요를 
	// - 글번호를 어떻게 알아내는지?
	// - 글번호는 boardDto에 있음.. boardDto는 EL로 접근가능
	// - EL로 접근 가능하다는 것은 서버에서 쓰는 데이터라는 뜻
	// - 필요한 곳은 자바스크립트(클라이언트 언어)
	// - 개발하다보면 자바스크립트와 EL/JSTL이 섞일 때가 있다
	// - 무조건 안하는 방향으로 선택하는 것이 좋음
	// - 어쩔 수 없는 경우(ex: 로그인 한 사용자 아이디) 제외
	
	// [2] 하트를 클릭하면 좋아요 설정/해지 페이지로 비동기 요청
	// [3] 하트에 마우스가 들어가거나 나오면 이벤트 처리로 애니메이션 부여
	// [4] 좋아요가 눌릴 경우에도 애니메이션 부여
	$(function(){
		
		//[1]
		var params = new URLSearchParams(location.search);		
		var boardNo = params.get("boardNo");

		$.ajax{{
			url:"/rest/board/check",
			method:"post",
			data:{
				boardNo:params.get("boardNo")
			},
			success:function(response){
// 				console.log(response);
// 				console.log(typeof response);
				if(response){
					$(".fa-heart").addClass("fa-solid");
				}
				else{
					$(".fa-heart").addClass("fa-regular");
				}
				
			},
			error:function(){
				$("fa-heart").remove;
			}
		}};
		
		// [2]
		$(".fa-heart").click(function(){
			$.ajax({
				url:"/rest/board/like",
				method:"post",
				data:{
					boardNo:boardNo
				},
				success:function(response){
					// response에는 result와 count가 들어있다
					if(response.result){	// 좋아요 된것
						$(".fa-heart").removeClass("fa-solid fa-regular")
											.addClass("fa-solid fa-shake");
					
					// 1초 뒤에 .fa-shake를 제거(setTimeout 함수 사용)
 					//	setTimeout(함수, 시간);		지정한 시간 이후에 함수 실행
 					// setInterval(함수,  시간);		지정한 시간 간격으로 함수 실행
					setTimeout(function(){
						$("fa-heart").removeClass(".fa-shake");
					},800);
					
						$(".heart-count").tex(response.count);
					}
					else{		// 좋아요 풀린 것
						$(".fa-heart").removeClass("fa-solid fa-regular")
											.addClass("fa-regular");
					}
				},
				error:function(){}
			});
		});
		
		// [3] mouseenter/mouseleave
		$(".fa-heart").mouseenter(function(){
			$(this).addClass("fa-beat");
		})
		.mouseleave(function(){
			$(this).removeClass("fa-beat");
		});
		
		// [4] 
	});
</script>

<table border="1" width="500">
	<tbody>
		<tr>
			<td>
				<h2>${boardDto.boardHead}</h2>
			</td>
		</tr>
		<tr>
			<td>
				<h2>${boardDto.boardTitle}</h2>
			</td>
		</tr>
		<tr>
			<td>
				${boardDto.boardWriter}
			</td>
		</tr>
		<tr>
			<td>
				<fmt:formatDate value="${boardDto.boardTime}" 
										pattern="y년 M월 d일 H시 m분 s초"/>
				조회 ${boardDto.boardRead}
			</td>
		</tr>
		<tr height="150" valign="top">
			<td>${boardDto.boardContent}</td>
		</tr>
		<tr>
			<td>
				좋아요 ${boardDto.boardLike}
				댓글 ${boardDto.boardReply}
			</td>
		</tr>
		<tr>
			<td>미래의 댓글목록</td>
		</tr>
		<tr>
			<td>미래의 댓글작성창</td>
		</tr>
		<tr>
			<td>
				<a href="/board/write">글쓰기</a>
				<a href="/board/write?boardParent=${boardDto.boardNo }">답글쓰기</a>
				
				<c:if test="${owner}">
				<!-- 내가 작성한 글이라면 수정과 삭제 메뉴를 출력 -->
				<a href="/board/edit?boardNo=${boardDto.boardNo}">수정</a>
				</c:if>
				
				<c:if test="${owner || admin}">
				<!-- 파라미터 방식일 경우의 링크 -->
				<a href="/board/delete?boardNo=${boardDto.boardNo}">삭제</a>
				<!-- 경로 변수 방식일 경우의 링크 -->
<%-- 				<a href="/board/delete/${boardDto.boardNo}">삭제</a> --%>
				</c:if>
				<a href="/board/list">목록보기</a>
			</td>
		</tr>
	</tbody>
</table>

<%-- (+추가) 오늘 읽은 글(memory) 목록을 출력 --%>
<c:forEach var="number" items="${sessionScope.memory}">
	${number}<br>
</c:forEach>

<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>de>
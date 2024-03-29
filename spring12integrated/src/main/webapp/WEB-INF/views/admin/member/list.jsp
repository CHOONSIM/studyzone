<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/adminHeader.jsp"></jsp:include>

 <div class="container-900">
        <div class="row center">
            <h1>회원 목록</h1>
        </div>
        
         <div class="row center">
            <!-- 검색창 -->
			<form action="list" method="get">
                <select name="column" class="form-input">
                	 <option value="">선택</option>
                    <option value="member_id">아이디</option>
                    <option value="member_nick">닉네임</option>
                    <option value="member_tel">전화번호</option>
                    <option value="member_birth">생년월일</option>
                    <option value="member_level">등급</option>
                </select>
                <input type="search" name="keyword" required
                        class="form-input" placeholder="검색어">
                <button type="submit" class="form-btn neutral">검색</button>
            </form>
        </div>
        
        <div class="row center">
            <table class="table table-slit table-hover">
        <thead>
			<tr>
				<th>아이디</th>
				<th>닉네임</th>
				<th>전화번호</th>
				<th>생년월일</th>
				<th>등급</th>
				<th>관리</th>
			</tr>
		</thead>
	<tbody class="center">
	<c:forEach var ="memberDto" items="${list }">
		<tr>
			<td>${memberDto.memberId }</td>
			<td>${memberDto.memberNick }</td>
			<td>${memberDto.memberTel }</td>
			<td>${memberDto.memberBirth }</td>
			<td>${memberDto.memberLevel }</td>
			<td>
				<a href="detail?memberId=${memberDto.memberId}" class="link">상세</a>
				<a href="edit?memberId=${memberDto.memberId }" class="link">변경</a>
				<a href="exit?memberId=${memberDto.memberId }&page=${page}" class="link">탈퇴</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
            </table>
        </div>
    </div>

<hr>
<br>
<div class="row">

<!-- 
	페이지 네비게이터 구현 
	for(int i = 1; i<=totalPage;i++){}
-->

<!-- 처음 -->
    	<c:choose>
			<c:when test="${vo.first}">
				<a class="disabled">&laquo;</a>
			</c:when>
			<c:otherwise>
				<a href="list?${vo.parameter}&page=1">&laquo;</a>
			</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${vo.preview}">
				<a href="list?${vo.parameter}&page=${vo.prevPage}">&lt;</a>
			</c:when>
			<c:otherwise>
				<a class="disabled">&lt;</a>
			</c:otherwise>
		</c:choose>
		
        <!-- 숫자 -->
       <c:forEach var="i" begin="1" end="${totalPage}" step="1">
			<c:choose>
				<c:when test="${page == i}"><!-- 현재페이지 -->
					${i}
				</c:when>
				<c:otherwise>
					<a href="list?page=${i}">${i}</a><!-- 현재페이지가 아닌 경우 -->
				</c:otherwise>
			</c:choose>
		</c:forEach>
	
		<!-- 다음 -->
		<c:choose>
			<c:when test="${vo.next}">
				<a href="list?${vo.parameter}&page=${vo.nextPage}">&gt;</a>
			</c:when>
			<c:otherwise>
				<a class="disabled">&gt;</a>
			</c:otherwise>
		</c:choose>
		
		<!-- 마지막 -->
		<c:choose>
			<c:when test="${vo.last}">
				<a class="disabled">&raquo;</a>
			</c:when>
			<c:otherwise>
				<a href="list?${vo.parameter}&page=${vo.totalPage}">&raquo;</a>
			</c:otherwise>
		</c:choose>

    
		
		
    </div>





    
    




<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
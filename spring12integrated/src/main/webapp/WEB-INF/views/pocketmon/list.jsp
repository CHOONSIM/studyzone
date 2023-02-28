    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

    <div class="container-500 mt-50">
        <div class="row center">
            <h1>포켓몬 ${mode }</h1>
        </div>
        <div class="row center">
            <form action="list" method="get">
            <select name="column" class="form-input">
                <option value="">선택</option>
                <option value="no">번호</option>
                <option value="name">이름</option>
                <option value="type">속성</option>
            </select>
            <input type="search" name="keyword" required
                    class="form-input" placeholder="검색어">
            <button type="submit" class="form-btn neutral">검색</button>
            </form>
        </div>
      
        <div class="row right">
        	<a href="insertInput" class="form-btn positive">신규등록</a>
        </div>
        

        	<div class="row center">
        	<c:choose>
        		<c:when test="${list.isEmpty() }">
        			<h2>데이터가 존재하지 않습니다.</h2>
        			<a href="insert" class="form-btn positive">등록하기</a>
        		</c:when>
        		<c:otherwise>
	            <table class="table table-border">
	                <thead>
	                    <tr>
	                        <th>번호</th>
	                        <th>이름</th>
	                        <th>속성</th>
	                        <th>관리</th>
	                    </tr>
	                </thead>
	                <tbody class="center">
	                <c:forEach var="pocketmonDto" items="${list}">
							<tr>
								<td>${pocketmonDto.no}</td>
								<td class="left">
									<a href="detail?no=${pocketmonDto.no}">
										${pocketmonDto.name}
									</a>
								</td>
								<td>${pocketmonDto.type}</td>
								<td>
									<a href="edit?no=${pocketmonDto.no }">수정</a>
									<a href="delete?no=${pocketmonDto.no }">삭제</a>
								</td>
							</tr>
							</c:forEach>
	                </tbody>
	             </table>
        	</c:otherwise>
        </c:choose>
      </div>
      
  		<div class="row left">
			<a href="/admin/home" class="form-btn positive">관리자 홈</a>
        </div>
        
    </div>
        	
<jsp:include page="/WEB-INF/views/template/adminFooter.jsp"></jsp:include>
        	

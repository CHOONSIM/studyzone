<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


   <div class="container-700">
        <div class="row center">
	<h1>학생 성적 ${mode }</h1>
	</div>
	
	<div class="row center">
		<form action="list"method="get">
			<select name = "column" class="form-input">
				<option value ="">선택</option>
				<option value ="no">번호</option>
				<option value ="name">이름</option>
			</select>
		          <input type="search" name="keyword" required
                            class="form-input" placeholder="검색어">
                <button type="submit" class="form-btn neutral">검색</button>
		</form>	
	</div>
	
	<div class="row right" >
        	<a href="insertInput" class="form-btn positive">신규등록</a>
        </div>
	
	<div class="row">
		<c:choose>
			<c:when test="${list.isEmpty() }">
				<h2>데이터가 존재하지 않습니다.</h2>
			</c:when>
		<c:otherwise>
            <table class="table table-border">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th width="20%">이름</th>
                        <th>국어점수</th>
                        <th>영어점수</th>
                        <th>수학점수</th>
                        <th>총 점수</th>
                        <th>평균 점수</th>
                    </tr>
                </thead>
                <tbody class="center">
                  <c:forEach var="studentDto" items="${list }">
					<tr>
					 <td>${studentDto.no }</td>
					 <td>
					 	<a href="detail?no=${studentDto.no }">
					 	${studentDto.name }
					 	</a>
					 	</td>
					 	<td>${studentDto.korean }</td>
					 	<td>${studentDto.english }</td>
					 	<td>${studentDto.math }</td>
					 	<td>${studentDto.total }</td>
					 	<td>${studentDto.average }</td>
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

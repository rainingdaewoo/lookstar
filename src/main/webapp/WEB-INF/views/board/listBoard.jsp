<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Lookstar</title>

<!-- 아이콘 -->
<script src="https://kit.fontawesome.com/51db22a717.js"
	crossorigin="anonymous"></script>
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 게시판 스타일 -->
<link rel="stylesheet" href="../../resources/css/board_css/board.css">

<script type="text/javascript">
	$(function() {
		// JOIN 버튼 누를시 로그인 모달창
		// JOIN 누를시 로그인 모달
		$('#joinBtn').click(function(e) {
			e.preventDefault();
			$('#joinModal').modal("show");
		});
	});
</script>
</head>
<body>
	
		<%@ include file=".././inc/header.jsp"%>
 	
	<br><br><br>
	<!-- Body Section -->
	<section class="py-5">
	<div class="container-aside">
		<ol class="category-list">
			<li class="category" id="자유게시판">
				<a href="/board/listBoard.do?pageNUM=1&board_category_no=0">자유게시판</a>
			</li>
			<li class="category" id="쇼핑후기">
				<a href="/board/listBoard.do?pageNUM=1&board_category_no=1">쇼핑후기</a>
			</li>
			<li class="category" id="발매및할인정보">
				<a href="/board/listBoard.do?pageNUM=1&board_category_no=2">발매 및 할인정보</a>
			</li>
			<li class="category" id="비밀글">
				<a href="/board/listBoard.do?pageNUM=1&board_category_no=3">비밀글</a>
			</li>
			<li class="category" id="공지사항">
				<a href="/board/listBoard.do?pageNUM=1&board_category_no=4">공지사항</a>
			</li>
		</ol>
		<input type="hidden" name="board_category_no" value="${board_category_no}">
	
	</div>
		<div class="container-sm" width=90%>
		<br>
			<c:if test="${board_category_no == 0}">
				<h2>자유게시판</h2>
			</c:if>
			<c:if test="${board_category_no == 1}">
				<h2>쇼핑후기</h2>
			</c:if>
			<c:if test="${board_category_no == 2}">
				<h2>발매 및 할인 정보</h2>
			</c:if>
			<c:if test="${board_category_no == 3}">
				<h2>비밀글</h2>
			</c:if>
			<c:if test="${board_category_no == 4}">
				<h2>공지사항</h2>
			</c:if>
		
			
	<hr>
	
	<div>
		<table class="table">
	  <thead>
	    <tr>
	      <th class="table-head" scope="col">글번호</th>
	      <th class="table-head" scope="col" width="600" >글제목</th>
	      <th class="table-head" scope="col" width="100">작성자</th>
	      <th class="table-head" scope="col" width="200">작성일</th>
	      <th class="table-head" scope="col" width="100">조회수</th>
	    </tr>
	  </thead>
	  <tbody>
	  	<c:forEach var="b" items="${list }">
			<c:choose>
				<c:when test="${b.board_show == 0 }">
					<tr>
						<td class="table-content">${b.board_no }</td>
						<td>
							<a href="detailBoard.do?board_no=${b.board_no }">${b.board_title }</a>
							<c:if test="${b.board_comments_count > 0 }">
							<a href="detailBoard.do?board_no=${b.board_no }" style="color: red;">(${b.board_comments_count })</a>
							</c:if>
						</td>
						<td class="table-content">${b.users_nickname }</td>
						<td class="table-content">
							<fmt:formatDate value="${b.board_date }" pattern="yyyy-MM-dd" />
						</td>
						<td class="table-content">${b.board_views }</td>
					</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5" align="left">
						<c:if test="${b.board_show == 1 }">
							삭제된 게시글입니다.
							<c:if test="${b.board_comments_count > 0 }">
							<a href="detailBoard.do?board_no=${b.board_no }" style="color: red;">(${b.board_comments_count })</a>
							</c:if>
						</c:if>
					</td>
				</tr>
			</c:otherwise>
			</c:choose>
		</c:forEach>
	  </tbody>
	</table>
				<div> 
					<c:if test="${board_category_no != 4}">
					<a href="board_write.do"
				class="btn btn-outline-dark pull-right" id="writeBtn">글쓰기</a>
				</c:if>
			</div>	
			<!-- 페이징처리 -->
			<div class="paging-center">
				<div class="paging">
					<c:if test="${prev}">
				 <span>[ <a href="listBoard.do?pageNUM=${startPageNum - 1}${searchTypeKeyword}">이전</a> ]</span>
					</c:if>
						<c:forEach begin="${startPageNum}" end="${endPageNum}" var="pageNUM">
						 <span>
						  <c:if test="${select != pageNUM}">
						 	  <a href="listBoard.do?pageNUM=${pageNUM}${searchTypeKeyword}">${pageNUM}</a>
						  </c:if>    
						  <c:if test="${select == pageNUM}">
						   	<b>${pageNUM}</b>
						  </c:if>
						 </span>
						</c:forEach>
						<c:if test="${next}">
					 <span>[ <a href="listBoard.do?pageNUM=${endPageNum + 1}${searchTypeKeyword}">다음</a> ]</span>
				</c:if>
			</div>
		</div>
	</div>
			<!-- 글쓰기 버튼 -->
			
			<br><br>
			<!-- 검색창 -->
			<div class="seach row">
				<select name="searchType" class="form-select" aria-label="Default select example">
						<option value="board_title"
							<c:if test="${searchType eq 'board_title'}">selected</c:if>>제목</option>
						<option value="board_content"
							<c:if test="${searchType eq 'board_content'}">selected</c:if>>내용</option>
						<option value="all"
							<c:if test="${searchType eq 'title_content'}">selected</c:if>>제목+내용</option> 
					<option value="users_nickname"
							<c:if test="${searchType eq 'users_nickname'}">selected</c:if>>작성자</option> 
					</select> 
			
				
					<div class="input-group-btn col-sm-8">
						<input type="text" value="${keyword }" name="keyword" id="ketwordInput" class="form-control"/>
					</div>
					<div>
						<span class="input-group-btn">
							<button id="searchBtn" class="btn btn-outline-dark pull-right" >검색</button>
						</span>
						</div>
				<script>
				 document.getElementById("searchBtn").onclick = function () {
				    
				  let searchType = document.getElementsByName("searchType")[0].value;
				  let keyword =  document.getElementsByName("keyword")[0].value;
				  
				  console.log(searchType)
				  console.log(keyword)
				  
				  location.href = "/board/listBoard.do?pageNUM=1" + "&searchType=" + searchType + "&keyword=" + keyword
						  	+ "&board_category_no=" + ${board_category_no};
				 };
				 
				 $('.category').click(function() {
						let board_category_no= $(this).value;
						console.log(board_category_no);
					});
				</script>
				
				
			</div>
				</div>
		
	</section>
		<%@ include file=".././inc/footer.jsp"%> 
	
</body>
</html>

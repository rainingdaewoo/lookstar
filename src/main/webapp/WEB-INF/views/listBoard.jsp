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
<!-- 룩북 스타일 -->
<link rel="stylesheet" href="../resources/css/lookbook.css">
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
<style type="text/css">
.board-category {
	float: left;
} 

.container {
	padding-top: 200px;
}
</style>
</head>
<body>
	<header>
		<%@ include file="./inc/header.jsp"%>
	</header>
	
	<!-- Body Section -->
	<section class="py-5">
		<div class="container">
			<h2>게시물 목록</h2>
	<hr>
	<div class="board-category">
	<ul>
		<li><a href="#">일상게시판</a></li>
		<li><a href="#">자유게시판</a></li>
		<li><a href="#">쇼핑후기</a></li>
	</ul>
	</div>
	<div>
	<table border="1" width="100%" class="table table-hover">
		<tr>
			<th width="70">글번호</th>
			<th>글제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="100">조회수</th>
		</tr>
		
		<c:forEach var="b" items="${list }">
			<c:choose>
				<c:when test="${b.board_show == 0 }">
					<tr>
						<td>${b.board_no }</td>
						<td>
							<a href="detailBoard.do?board_no=${b.board_no }">${b.board_title }</a>
						</td>
						<td>${b.users_nickname }</td>
						<td>
							<fmt:formatDate value="${b.board_date }" pattern="yyyy-MM-dd" />
						</td>
						<td>${b.board_views }</td>
					</tr>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5" align="left">
						<c:if test="${b.board_show == 1 }">
							삭제된 게시글입니다.
						</c:if>
					</td>
				</tr>
			</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	
	
			<!-- 페이징처리 -->
			<div class="col-md-offset-3">
				<c:if test="${prev}">
			 <span>[ <a href="listBoard.do?pageNUM=${startPageNum - 1}">이전</a> ]</span>
				</c:if>
					<c:forEach begin="${startPageNum}" end="${endPageNum}" var="pageNUM">
					 <span>
					  <c:if test="${select != pageNUM}">
					 	  <a href="listBoard.do?pageNUM=${pageNUM}">${pageNUM}</a>
					  </c:if>    
					  <c:if test="${select == pageNUM}">
					   	<b>${pageNUM}</b>
					  </c:if>
					 </span>
					</c:forEach>
					<c:if test="${next}">
				 <span>[ <a href="listBoard.do?pageNUM=${endPageNum + 1}">다음</a> ]</span>
			</c:if>
		</div>
	</div>
				
			<!-- 검색창 -->
			<div class="seach row">
				<div class="col-xs-2 col-sm-2">
				<select name="searchType" class="from-control">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="title_content">제목+내용</option>
					<option value="writer">작성자</option>
				</select> 
				</div>
				
				<div class="col-xs-10 col-sm-10">
					<div class="input-group-btn">
						<input type="text" name="keyword" id="ketwordInput" class="form-control"/>
						<span class="input-group-btn">
							<button id="searchBtn" class="btn btn-outline-dark pull-right" >검색</button>
						</span>
						<!-- 글쓰기 버튼 -->
			<a href="board_write.do"
				class="btn btn-outline-dark pull-right">글쓰기</a>
					</div>
				</div>
				
			</div>




			
				</div>
		<footer>
			<%@ include file="./inc/footer.jsp"%>
		</footer>
	</section>
	
	
</body>
</html>

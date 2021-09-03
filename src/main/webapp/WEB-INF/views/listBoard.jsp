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
<!-- 로그인 css -->
<link href="../resources/css/login.css" rel="stylesheet" />
<!-- 소셜 로그인 -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<!-- 룩북 스타일 -->
<link rel="stylesheet" href="../resources/css/lookbook.css">
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="../resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="../resources/css/styles.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 슬라이더 부트스트랩 -->
<script type="text/javascript"
	src="./jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>


<!-- 값슬라이더 -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
	float:left;
}
</style>
</head>
<body>
	<header>
		<%@ include file="inc/header.jsp" %>
	</header>
	
	<!-- Body Section -->
	<section class="py-5">
	<div class="board-category">
	<ul>
		<li><a href="#">일상게시판</a></li>
		<li><a href="#">자유게시판</a></li>
		<li><a href="#">쇼핑후기</a></li>
	</ul>
	</div>
		<div class="container">
			<h2>게시물 목록</h2>
	<hr>
	
	<div>
	<table border="1" width="100%">
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
				
			<!-- 검색창 -->
			<div>
				<select name="searchType">
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="title_content">제목+내용</option>
					<option value="writer">작성자</option>
				</select> <input type="text" name="keyword" />
				<button type="button">검색</button>
			</div>




			<!-- 글쓰기 버튼 -->
			<a href="insertBoard.do"
				class="btn btn-outline-dark pull-right">글쓰기</a>
			</div>
		<footer>
			<%@ include file="inc/footer.jsp" %>
		</footer>
	</section>
	
	
</body>
</html>

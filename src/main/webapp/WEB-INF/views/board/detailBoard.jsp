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

<!-- 게시판 스타일 -->
<link rel="stylesheet" href="../../resources/css/board_css/board.css">
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


<script type="text/javascript">
	$(function() {
		// JOIN 버튼 누를시 로그인 모달창
		// JOIN 누를시 로그인 모달
		$('#joinBtn').click(function(e) {
			e.preventDefault();
			$('#joinModal').modal("show");
		});
	});
	function confirmDeleteBoard(board_no) {
		if(confirm('정말로 삭제할까요')){
			location.href='/board/deleteBoard.do?board_no='+board_no;
		}
	}
	function confirmDeleteComments(comments_no) {
		console.log(comments_no);
		if(confirm('정말로 삭제할까요')){
			location.href='/board/deleteComments.do?comments_no='+comments_no;
		}
	}
	

</script>
<style type="text/css">
.board-category {
	float:left;
}
.comments {
}
#comments-btn {
	float: left;
}
</style>
</head>
<body>
	
		<%@ include file=".././inc/header.jsp" %>
	
	<br><br><br>
	<!-- Body Section -->
	<!-- 게시판 내용 -->
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
		<div class="container-sm">
		
		<c:choose>
			<c:when test="${b.board_show == 0 }">
				<div class="board-detail">
		
		
		<input type="hidden" name="board_no" value="${b.board_no }">
	<hr>
	<input type="hidden" name="users_no" value="${users.users_no}">
	<div class="article_header">
		<h3 class="title_text">${b.board_title }</h3>
		<div class="writerInfo">
					<img id="my_img" class="img-fluid rounded-circle mb-4"
			 src="../resources/profile/${users.users_fname}" width="30" onerror="this.src='/resources/images/user.png'"/>
			 ${b.users_nickname }<br>
			<div class="article_info">
				<fmt:formatDate value="${b.board_date }" pattern="yyyy-MM-dd HH:mm" />
				조회 ${b.board_views }
			</div>
			<div class="ArticleTool">
		댓글  <a style="color: red;">(${b.board_comments_count })</a>
		</div>
		</div> 
		
		<div>
		
		</div>
	</div>
	<div class="board-content">
			${b.board_content }
		
	</div>
	 </div>
			
			</c:when>
				<c:otherwise>
					<h2>삭제된 게시물입니다.</h2>
				</c:otherwise>
		</c:choose>
		
		
	<hr>
	<h3>댓글</h3>
	
	
	<!-- 댓글 목록 -->
	<div class="comments">
		 <c:forEach var="comments" items="${comments }">
			<c:choose>
				<c:when test="${comments.comments_show == 0 }">
					<li style="list-style:none;">
				<c:if test= "${comments.depth == 1}" >
					<li style="padding-left: 50px;  list-style:none;">
				</c:if>
							<div class="avc">
							<div class="comments-usersNickname">
							<img id="my_img" class="img-fluid rounded-circle mb-4"
			 src="../resources/profile/${users.users_fname}" width="30" onerror="this.src='/resources/images/user.png'"/>
								</div>
								<div class="comments-usersNickname">
									<p>${comments.users_nickname} 	</p>
								</div>
								<div class="extra-button">
									<i class="bi bi-plus"></i>
								</div>
								
								<div class="comments-extra">
								
								<c:if test="${comments.users_no == users.users_no }">
									<a class="btn btn-outline-dark pull-right" id="updateCommentsBtn">수정</a>
									<a onclick="confirmDeleteComments(${comments.comments_no})"
									class="btn btn-outline-dark pull-right" id="deleteBtn">삭제</a>	
								</c:if>	
								<a class="btn btn-outline-dark pull-right" id="reportCommentsBtn">신고</a>
								
								
								</div><br><br>
								<div class="comments-content">
								<p>${comments.comments_content }</p>
								<%-- 사진확인:<img class="card-img-top"
								src="resources/comments_img/${commets.comments_fname }"	style="height: 100%; width: 100%;" /> --%>
								</div>
								<div>
									<p><fmt:formatDate value="${comments.comments_date}" pattern="yyyy-MM-dd HH:ss" /></p>
									<p class="writeRecomments">답글쓰기</p>	
								</div>
							</div>
						</li>
						<!-- 답글 쓰기 생성 -->
						<div class="reComments">
						<hr>
							<form action="insertComments.do" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<div class="row col-md-6">
								<h1 class="display-5 fw-bolder"></h1>
								<br> 
							</div>
						<div class="col-md-6">
			 					<input type="hidden" name="users_no" value="${users.users_no}"> 
			 					<input type="hidden" name="board_no" value="${b.board_no }"> 
			 					<input type="hidden" name="depth" value="1">
			 					<input type="hidden" name="ori_comments_no" value="${comments.comments_no}">
								<div class="form-floating">
					  <textarea class="form-control" placeholder="댓글을 남겨보세요." name="comments_content"></textarea>
					  <label for="floatingTextarea">Comments</label>
					</div>
					<input type='file' class="comments_uploadFile" name="comments_uploadFile" accept="image/png, image/jpeg"/>
					
					
					<!-- 글쓰기 버튼 생성 -->
					<input type="submit" class="btn btn-outline-dark right" value="댓글 작성">
					<input type="reset" class="btn btn-outline-dark right" value="취소"> 
				</div>
			</form>
			</div>
			<!-- 댓글 수정 -->
					<div class="updateComments">
					<hr>
						<form action="updateComments.do" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<div class="row col-md-6">
								<h1 class="display-5 fw-bolder"></h1>
								<br> 
							</div>
						<div class="col-md-6">
			 					<input type="hidden" name="users_no" value="${users.users_no}"> 			 					<input type="hidden" name="board_no" value="${b.board_no }"> 
			 					<input type="hidden" name="depth" value="${comments.depth }">
			 					<input type="hidden" name="comments_no" value="${comments.comments_no }">
								<div class="inputArea">
					 <textarea rows="5" cols="50" class="inputText" name="comments_content">${comments.comments_content }</textarea>
					
					<input type='file' class="comments_uploadFile" name="comments_uploadFile" accept="image/png, image/jpeg"/>
					
					</div>
					
					<!-- 글쓰기 버튼 생성 -->
					<input type="submit" class="btn btn-outline-dark right" value="댓글 작성">
					<input type="reset" class="btn btn-outline-dark right" value="취소"> 
				</div>
			</form>
					</div>
					
						<hr>
			</c:when>
			<c:otherwise>
				<div>
						<c:if test="${comments.comments_show == 1 }">
							삭제된 댓글입니다.<br><hr>
							
						</c:if>
				</div>
			</c:otherwise>
			</c:choose>
		</c:forEach> 
			
			<!-- 댓글 작성 -->
		<form action="insertComments.do" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<div class="row col-md-6">
					<h1 class="display-5 fw-bolder"></h1>
					<br> 
				</div>
				<div class="col-md-6">
	 					<input type="hidden" name="users_no" value="${users.users_no}"> 
	 					<input type="hidden" name="board_no" value="${b.board_no }"> 
	 					<input type="hidden" name="depth" value="0"> 
	 					<input type="hidden" name="ori_comments_no" value="0"> 
						<div class="inputArea">
					<div class="form-floating">
					  <textarea class="form-control" placeholder="댓글을 남겨보세요." name="comments_content"></textarea>
					  <label for="floatingTextarea">Comments</label>
					</div>
					<input type='file' class="comments_uploadFile" name="comments_uploadFile" accept="image/png, image/jpeg"/>
					
					</div>

					<!-- 글쓰기 버튼 생성 -->
					<input type="submit" class="btn btn-outline-dark right" value="댓글 작성"> 
				</div>
			</form>
			</div>				
				<br><br>	
	<!-- 댓글 끝 -->
	<a href="/board/board_write.do"
		class="btn btn-outline-dark pull-right">글쓰기</a>
	<c:if test="${b.users_no == users.users_no }">
		<a href="/board/updateBoard.do?board_no=${b.board_no }"
		class="btn btn-outline-dark pull-right" id="updateBtn">수정</a>
		<a onclick="confirmDeleteBoard(${b.board_no})"
		class="btn btn-outline-dark pull-right" id="deleteBtn">삭제</a>
	</c:if>	
		
	
	<a href="/board/listBoard.do?pageNUM=${pageNUM}"
		class="btn btn-outline-dark pull-right">글목록</a>
	</div>	
		
			<br><br><br><br>
				
		
		
		
			<%@ include file=".././inc/footer.jsp" %>
		
	</section>
	<script type="text/javascript">
		$('.writeRecomments').click(function() {
			$(this).parent().parent().parent().next().toggle();
		});
		$('.extra-button').click(function() {
				$(this).next().toggle();
		});
		$('#updateCommentsBtn').click(function() {
			$(this).parent().parent().parent().next().next().toggle();
		});
		
			
	</script>
	
</body>
</html>
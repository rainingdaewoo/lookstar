<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 룩북 관리</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/mypage_css/manageMylook.css" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#upload_file").on('change', function() {
			readURL(this);
		});
	});
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
<style type="text/css">
</style>
</head>
<body>
	<!-- Main Content-->
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@ include file="../inc/header.jsp"%>
	<div id="container">
		<br>
		<div class="board_wrap1" width="80%">
			<div class="board_top" style="padding-left: 150px">
				<div class="board_title">
					<h2>
						<strong>${fusers_nickname}님의 룩북</strong>
					</h2>
				</div>
				<div class="text-center">
					<c:forEach var="l" items="${list}">
						<div class="card mb-4 shadow-sm text-center" style="width:303px;" id="imgBox">
				            <div class="image-box">
				         	<a href="/lookbook/lookbook_detail.do?lookbook_no=${l.lookbook_no}"><img
										src="/resources/look_img/${l.lookbook_fname}" height="600px"
										width="400px;" class="image-thumbnail"></a>
				         	</div>
				            <div class="card-body">
				              <p class="card-text">${l.lookbook_write}</p>	              
				            </div>
				         </div>
					</c:forEach>
				</div>
				
				
			</div>
			<!-- board_top -->
			<br> <br> <br> <br>
		</div>
		<!-- board_wrap1 -->

	</div>
	<!-- container -->
	
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
			<c:forEach var="i" begin="1" end="${totalPage}">
				<li class="page-item"><a class="page-link"
					href="/mypage/followingLookbook.do?pageNUM=${i}&users_no=${fusers_no}&users_nickname=${fusers_nickname}">${i}
					&nbsp;</a></li>
			</c:forEach>
		</ul> 
	</nav>	
	

	<%@ include file="../inc/footer.jsp"%>
</body>
</html>
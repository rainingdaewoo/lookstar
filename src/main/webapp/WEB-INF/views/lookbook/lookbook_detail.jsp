<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
.info_table {
	width: 400px;
	margin: auto;
	border-bottom: 1px solid gray;
}

.info_line {
	border-bottom: 1px solid gray;
}
</style>
<script type="text/javascript">
	$(function(){
		/*
		function confirmDeleteLookbook(lookbook_no) {
			if(confirm('정말로 삭제할까요')){
				location.href='/lookbook/deletelookbook.do?lookbook_no='+lookbook_no;
			}
		};
		*/
	});
</script>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 룩인포 Modal-->
	<div tabindex="-1" class="text-center" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div role="document">
			<div>
				<div>
					<h5>
						<img src="/resources/images/user.png" width=50 height=50>&nbsp;&nbsp;&nbsp;${write_u.users_nickname}<span></span>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button>+팔로우</button>
					</h5>
				</div>
			</div>
			<div>
				<b>${look.lookbook_height}cm ${look.lookbook_weight}kg</b>
			</div>
			<img src="/resources/look_img/${look.lookbook_fname}" width="30%">
			<br>
			<br>
			<div class="text-center">
				<div>
					<img src="/resources/images/heart.png" height=50 width=50>
				</div>
				<br>
				<br>
				<div class="text-center">
					<table class="info_table">
						<c:forEach var="i" items="${info}">
							<c:choose>
								<c:when test="${i.lookinfo_category == 1}">
									<tr class="info_line">
										<td><img src="/resources/images/cap.png" width=50
											height=50></td>
										<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
									</tr>
								</c:when>
								<c:when test="${i.lookinfo_category == 2}">
									<tr class="info_line">
										<td><img src="/resources/images/shirt.png" width=50
											height=50></td>
										<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
									</tr>
								</c:when>
								<c:when test="${i.lookinfo_category == 3}">
									<tr class="info_line">
										<td><img src="/resources/images/pants.png" width=50
											height=50></td>
										<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
									</tr>
								</c:when>
								<c:when test="${i.lookinfo_category == 4}">
									<tr class="info_line">
										<td><img src="/resources/images/shoe.png" width=50
											height=50></td>
										<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>


					</table>
					<c:choose>
						<c:when test="${look.users_no == u.users_no}">
							<a href="/lookbook/lookbookUpdate.do?lookbook_no=${look.lookbook_no}"><button type="button"
									class="btn btn-outline-dark a_not_blue">수정</button></a>

							<a href="/lookbook/deletelookbook.do?lookbook_no=${look.lookbook_no}" class="btn btn-outline-dark a_not_blue" id="deleteLookbook">삭제</a>
						</c:when>
					</c:choose>
				</div>

			</div>

		</div>
		<br> <br>
	</div>
	<!-- 룩인포 Modal끝-->
	<%@ include file="../inc/footer.jsp"%>
</body>
</html>
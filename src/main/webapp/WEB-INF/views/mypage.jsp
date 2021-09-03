<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>LOOKSTAGRAM-MYPAGE</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#my_img').click(function(e) {
			e.preventDefault();
			$('#testModal').modal("show");
		});
		
		$('#close_btn').click(function(){
			$('#testModal').modal("hide");
		})
	});
</script>
</head>
<body>
<br><br><br><br><br>
<%@ include file="inc/header.jsp" %>

	<div class="text-center my-5">
		<img id="my_img" class="img-fluid rounded-circle mb-4"
			src="https://dummyimage.com/150x150/6c757d/dee2e6.jpg" />

		<div class="modal fade" id="testModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">첨부파일</h5>
						<button aria-label="Close" onclick="myDialog.close()"
							id="close_btn">X</button>
					</div>

					<div class="modal-body">변경할 프로필 사진을 선택해주세요.</div>
					<div>
						<form action="updateProfile.do" method="post" enctype="multipart/form-data">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<input type="hidden" name="users_no" value="${u.users_no }">
							<input type="hidden" name="fname" value="${u.users_fname }">
							<input type="hidden" name="fsize" value="${u.users_fsize }">
							<input type="file" name="uploadFile">
							<input type="submit" value="변경">
							<input type="reset" value="취소">
						</form>
					</div>
					<div class="modal-footer">
						
					</div>

				</div>
			</div>
		</div>
		<h1>id</h1>
		<p>nickname</p>
	</div>
<!-- Main Content-->
	<div id="container">
		<main class="mb-4">
			<div class="container px-4 px-lg-5">
				<div class="row gx-4 gx-lg-5 justify-content-center">
					<div class="col-md-10 col-lg-8 col-xl-7">
						<div class="my-5">

							<form id="contactForm" data-sb-form-api-token="API_TOKEN">
								<div class="form-floating">
									<a href="changePWD.do">비밀번호 변경</a>
									<hr>
								</div>
								<div class="form-floating">
									<a href="myInform.do">개인정보관리</a>
									<hr>
								</div>
								<div class="form-floating">
									<a href="manageMyboard.do">내 글 관리</a>
									<hr>
								</div>
								<div class="form-floating">
									<a href="followList.do">팔로우 목록</a>
									<hr>
								</div>
								<div class="form-floating">
									<a href="likeList.do">좋아요 목록</a>
									<hr>
								</div>
								<div class="form-floating">
									<a href="termsOfService.do">서비스 약관</a>
									<hr>
								</div>
								<div class="form-floating">
									<a href="withdrawal.do">회원 탈퇴</a>
									<hr>
								</div>
								<br />
								
								
								<!-- Submit Button-->
								<button class="btn btn-primary text-uppercase disabled"
									id="submitButton" type="submit">log-out</button>
							</form>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>
	
	
			<%@ include file="inc/footer.jsp" %>
		
</body>
</html>
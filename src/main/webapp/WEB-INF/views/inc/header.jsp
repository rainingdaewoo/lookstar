<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HEADER</title>

<!-- 로그인 css -->
<link href="../../../resources/css/login.css" rel="stylesheet" />
<!-- 소셜 로그인 -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<!-- Favicon(인터넷창 아이콘) -->
<link rel="icon" type="image/x-icon"
	href="../../../resources/assets/favicon.ico" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- js -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>


</head>
<body>
	<nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
		<a class="navbar-brand" href="#"><img
			src="/resources/assets/top_logo.png" width="300px"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarsExampleDefault"
			aria-controls="navbarsExampleDefault" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarsExampleDefault">
			<ul class="navbar-nav mr-auto">
				<!-- 룩페이지 이동 -->
				<li class="nav-item"><a class="nav-link" href="../lookbook.do">Looks</a></li>
				<!-- 게시판 이동 -->
				<li class="nav-item"><a class="nav-link" href="#">Board</a></li>
				<!-- DM 이동 -->
				<li class="nav-item"><a class="nav-link" href="#"><img
						src="../../../resources/assets/chat.png" width="20px"></a></li>
				<li class="nav-item dropdown">
					<!-- 마이페이지 이동 -->
				<li class="nav-item"><a class="nav-link" href="#"><img
						src="../../../resources/assets/user.png" width="20px"></a></li>
				<li class="nav-item dropdown">
					<!-- 알림 드롭다운  --> <a class="nav-link dropdown-toggle" href="#"
					id="dropdown01" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><img src="../../../resources/assets/bell.png"
						width="20px"></a>
					<div class="dropdown-menu" aria-labelledby="dropdown01">
						<a class="dropdown-item" href="#">nilepa님이 내 게시판에 댓글을 달았습니다!</a> <a
							class="dropdown-item" href="#">호랑호랑님이 나를 팔로우합니다!</a> <a
							class="dropdown-item" href="#">누군가가 내 룩페이지를 좋아합니다!</a>
					</div>
				</li>
			</ul>
			<!-- JOIN 버튼(로그인) -->
			<form class="d-flex">
				<button type="button" class="btn btn-outline-dark"
					data-toggle="modal" data-target="#joinModal">JOIN</button>

			</form>
		</div>

	</nav>
	<!-- 회원가입 확인 Modal-->
	<div class="modal fade" id="joinModal" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Lookstargram</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="main-wrap">
						<section class="login-input-section-wrap">
							<div class="login-input-wrap">
								<input placeholder="이메일 또는 아이디 입력" type="text"></input>
							</div>
							<div class="login-input-wrap password-wrap">
								<input placeholder="비밀번호" type="password"></input>
							</div>
							<div class="login-button-wrap">
								<button>로그인</button>
							</div>
							<div>
								<p class="forget-msg">
									<a href="findPW.html">비밀번호 찾기</a> | <a href="newUsers.html">회원가입</a>
								</p>
							</div>
							<div class="login-stay-sign-in">
								<i class="far fa-check-circle"></i> <span>로그인 유지</span>
							</div>
						</section>

					</div>
					<div id="modal_footer">
						<div class="social_login_button">
							<h5>소셜로그인</h5>
							<button class="btn-social-login">
								<img src="../../../resources/assets/kakao_login.png" alt="">
							</button>
							<button class="btn-social-login">
								<img src="../../../resources/assets/naver_login.png" alt="">
							</button>
							<button class="btn-social-login">
								<img src="../../../resources/assets/google_login.png" alt="">
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 회원가입 확인 Modal끝-->
</html>

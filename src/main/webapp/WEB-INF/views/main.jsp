<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon(인터넷창 아이콘) -->
<link rel="icon" type="image/x-icon"
	href="../../resources/assets/favicon.ico" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- 룩북 스타일 -->
<link rel="stylesheet" href="../../resources/css/lookbook.css">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<%@ include file="./inc/header_home.jsp"%>

	<br> ${users.users_id}님 로그인 되었습니다.
	<section class="py-5">
		<div class="row align-items-center">

			<div class="offset-md-1 col-md-5">
				<h1 class="display-5 fw-bolder">
					<img src="../../resources/assets/top_logo.png">
				</h1>
				<br>
				<h3>&nbsp;&nbsp;당신의 스타일을 보여주세요!</h3>

			</div>
			<div class="col-md-4 offset-md-1">
				<!-- carousel를 구성할 영역 설정 -->
				<div class="container"></div>
				<div id="demo" class="carousel slide" data-ride="carousel">
					<div class="carousel-inner">
						<!-- 슬라이드 쇼 -->
						<div class="carousel-item active">
							<!--가로-->
							<img class="d-block w-100" src="../../resources/assets/Eom.png"
								alt="First slide">

						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="../../resources/assets/image1.webp" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block w-100"
								src="../../resources/assets/image2.jpg" alt="Third slide">
						</div>
						<!-- / 슬라이드 쇼 끝 -->
						<!-- 왼쪽 오른쪽 화살표 버튼 -->
						<a class="carousel-control-prev" href="#demo" data-slide="prev">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<!-- <span>Previous</span> -->
						</a> <a class="carousel-control-next" href="#demo" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<!-- <span>Next</span> -->
						</a>
						<!-- / 화살표 버튼 끝 -->
						<!-- 인디케이터 -->
						<ul class="carousel-indicators">
							<li data-target="#demo" data-slide-to="0" class="active"></li>
							<!--0번부터시작-->
							<li data-target="#demo" data-slide-to="1"></li>
							<li data-target="#demo" data-slide-to="2"></li>
						</ul>
						<!-- 인디케이터 끝 -->
					</div>

				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</section>
	<%@ include file="./inc/footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<!-- 값슬라이더 -->

<script type="text/javascript">
	$(function() {
		$(".unchosenF").click(function() {
			$(this).toggleClass("chosenF")
		});
		// 몸무게 범위 슬라이더
		$("#weight-range").slider({
			range : true,
			min : 40,
			max : 130,
			values : [ 40, 130 ],
			slide : function(event, ui) {
				$("#weight").val(ui.values[0] + " ~ " + ui.values[1] + " kg");
			}
		});
		$("#weight").val(
				$("#weight-range").slider("values", 0) + " ~ "
						+ $("#weight-range").slider("values", 1) + " kg");

		// 키 범위 슬라이더
		$("#height-range").slider({
			range : true,
			min : 140,
			max : 200,
			values : [ 140, 200 ],
			slide : function(event, ui) {
				$("#height").val(ui.values[0] + " ~ " + ui.values[1] + " cm");
			}
		});
		$("#height").val(
				$("#height-range").slider("values", 0) + " ~ "
						+ $("#height-range").slider("values", 1) + " cm");

	});
</script>
</head>
<body>
	<%@ include file="./inc/header.jsp"%>
	<!-- Body Section -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	<section id="content">
		<!-- 스타일필터와 검색 -->
		<div class="ftr" style="justify-content: center">
			<span class="unchosenF"><a
				href="lookbook.do?sortField=lookbook_no">NEW</a></span>&nbsp; <span
				class="unchosenF"><a
				href="lookbook.do?sortField=lookbook_views">HOT</a></span>&nbsp; <span
				class="unchosenF">미니멀</span>&nbsp; <span class="unchosenF">캐주얼</span>&nbsp;
			<span class="unchosenF">비즈니스</span>&nbsp; <span class="unchosenF">아메카지</span>&nbsp;
			<span class="unchosenF">스트릿</span>&nbsp; <span class="unchosenF">스포츠</span>&nbsp;
			<span class="unchosenF">레트로</span>&nbsp; <span class="unchosenF">캠퍼스</span>&nbsp;
			<span class="unchosenF">댄디</span>&nbsp; <span class="unchosenF">데일리</span>

		</div>
		<!-- 신체 필터/검색 -->
		<div class="FnS">
			<form class="navbar-form pull-left" style="float: right;">
				<button class="btn dropdown-toggle" data-toggle="dropdown">
					<span id="searchF">작성자</span>
				</button>
				<div class="dropdown-menu" id="dropdown-search">
					<a class="dropdown-item">작성자</a> <a class="dropdown-item">내용</a>
				</div>
				<input type="text" style="width: 200px;">
				<button type="submit" class="btn btn-outline-dark">검색</button>
			</form>
			<div style="float: left; padding-left: 50px">
				<p>
					&nbsp;&nbsp;&nbsp;<label for="weight"><b>몸무게 </b></label> <input
						type="range" class="slider" value="50" min="0" max="100" step="10">


				</p>
				<!-- 몸무게 슬라이더 -->
				<div id="weight-range" style='width: 180px;'></div>
			</div>
			<!-- 키 필터 -->
			<div style="float: left; padding-left: 50px">
				<p>
					<label for="height"><b>키 </b></label> <input type="text"
						id="height" readonly
						style="width: 250px; border: none; color: rgb(0, 0, 0); font-weight: bold;">

				</p>
				<!-- 키 슬라이더 -->
				<div id="height-range" style='width: 180px'></div>
			</div>

		</div>
		<!-- 몸무게 필터 -->

		<br> <br>
		<hr>
		<div class="center-block px-4 px-lg-5 mt-5 justify-content-center">
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

				<c:forEach var="l" items="${list}">
					<c:choose>
						<c:when test="${l.lookbook_show==0}">
							<div class="col mb-5">
								<div class="card h-100 justify-content-center">
									
										<!-- Product image-->
										<a href="lookbook_info.do?l.lookbook_no=${l.lookbook_no}">
											<!-- 이미지 경로 들어가게 해야함. --> <img class="card-img-top"
											src="resources/look_img/${l.lookbook_fname }"
											style="height: 100%; width: 100%;" />
										</a>
									
								</div>
							</div>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<!-- 글쓰기 버튼 -->
			<a href="lookbook_write.do" class="btn btn-outline-dark pull-right">글쓰기</a>
		</div><br><br><br>
	</section>


	<%@ include file="./inc/footer.jsp"%>
</body>
</html>

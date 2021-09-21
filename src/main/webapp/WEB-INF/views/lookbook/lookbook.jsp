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
	href="/resources/assets/favicon.ico" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- 룩북 스타일 -->
<link rel="stylesheet" href="/resources/css/lookbook.css">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 값슬라이더 -->

<script type="text/javascript">
	$(function() {
		
		// 스크롤 및 필터 작업
		
		let selected_style = [ '1', '2', '3', '4', '5', '6', '7', '8', '9',	'10' ];
		let sortField = "NEW";
		let weight_low = 0;
		let weight_high = 150;
		let height_low = 0;
		let height_high = 220;
		
		let pageNUM = 1;
		let start = (pageNUM-1)*8+1;
		let end = start+8-1;		
		
		
		function YesScroll () {
			const pagination = document.querySelector('.paginaiton'); // 페이지 정보획득
			const fullContent = document.querySelector('.infinite'); // 전체를 둘러싼 컨텐츠 정보획득
			const screenHeight = screen.height; // 화면 크기
			let oneTime = false; // 일회용 변수
			document.addEventListener('scroll',OnScroll,{passive:true}) // 스크롤 이벤트함수정의
			 function OnScroll () { //스크롤 이벤트 함수
			   const fullHeight = fullContent.clientHeight; // infinite 클래스의 높이   
			   const scrollPosition = pageYOffset; // 스크롤 위치
			   if (fullHeight-screenHeight/1.1 <= scrollPosition && !oneTime) { // 만약 전체높이-화면높이/1.2가 스크롤포지션보다 작아진다면, 그리고 oneTime 변수가 거짓이라면
			     oneTime = true; // oneTime 변수를 true로 변경해주고,
			     plusLookbook(); // 컨텐츠를 추가하는 함수를 불러온다.
			  }
			}
		}
		YesScroll();

		listLookbook();
		// 스타일, 키, 몸무게의 변수를 전역변수로.. 
		function listLookbook() {
			pageNUM=1;
			let data = {
				arr : selected_style,
				weight_low : weight_low,
				weight_high : weight_high,
				height_low : height_low,
				height_high : height_high,
				sortField : sortField,
				pageNUM:pageNUM
			};
			console.log("data값:" + data);
			$.each(data, function(i, item) {
				console.log(i + ":" + item);
			});

			$.ajax({
				url : "/lookbook/ListLookbook.do",
				data : data,
				success : function(list) {
					console.log(list);
					$("#lookbookimage").empty();
						$.each(list,function(index, item) {
							
								if (item.lookbook_show == 0) {
									let img = $("<div class='col mb-5'><div class='card h-100 justify-content-center'><a href='lookbook_detail.do?lookbook_no="	+ item.lookbook_no
											+ "'><img class='card-img-top' src='/resources/look_img/" + item.lookbook_fname
											+ "' style='height: 100%; width: 100%;' /></a></div></div>");
									$("#lookbookimage").append(img);
									}

								});
						}
				});
		}
		function plusLookbook() {
			pageNUM= pageNUM+1;
			let data = {
				arr : selected_style,
				weight_low : weight_low,
				weight_high : weight_high,
				height_low : height_low,
				height_high : height_high,
				sortField : sortField,
				pageNUM:pageNUM
			};
			console.log("data값:" + data);
			$.each(data, function(i, item) {
				console.log(i + ":" + item);
			});

			$.ajax({
				url : "/lookbook/ListLookbook.do",
				data : data,
				success : function(list) {
					console.log(list);
						$.each(list,function(index, item) {
								if (item.lookbook_show == 0) {
									let img = $("<div class='col mb-5'><div class='card h-100 justify-content-center'><a href='lookbook_detail.do?lookbook_no="	+ item.lookbook_no
											+ "'><img class='card-img-top' src='/resources/look_img/" + item.lookbook_fname
											+ "' style='height: 100%; width: 100%;' /></a></div></div>");
									$("#lookbookimage").append(	img);
									}

								});
						}
				});
			

		}
		

		// 분류기준(HOT/NEW) 선택
		$(".sortField").click(function() {
			sortField = $(this).text();
			
			console.log(sortField);
			listLookbook();
			YesScroll();
		})

		// 스타일 선택 
		$(".unchosenF").each(function(i) {
			$(this).attr("style_no", i + 1);
		});
		$(".unchosenF").click(function() {
			$(this).toggleClass("chosenF");
			let list = $(".chosenF");
			selected_style = [];

			$.each(list, function(index, item) {
				let style_no = $(item).attr("style_no");
				selected_style.push(style_no);
			});

			listLookbook();
			YesScroll();
		});

		$(".bodyspec").change(function() {
			let getWeight = $("#weight option:selected").val();
			let arrayWeight = getWeight.split("~");
			weight_low = arrayWeight[0];
			weight_high = arrayWeight[1];

			let getHeight = $("#height option:selected").val();
			let arrayHeight = getHeight.split("~");
			height_low = arrayHeight[0];
			height_high = arrayHeight[1];

			listLookbook();
			YesScroll();
		});

	});
</script>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<!-- Body Section -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<section id="content">
		<!-- 글쓰기 버튼 -->
			<a href="/lookbook/lookbook_write.do"
				class="btn btn-outline-dark pull-right">글쓰기</a>
		<!-- 신체 필터/검색 -->
		<div class="FnS">
			<div style="float: left; padding-left: 50px">
				키&nbsp; <select name="height" id="height" class="bodyspec form-select">
					<option value="0~230" selected>-선택-</option>
					<option value="140~150">140~150</option>
					<option value="151~160">151~160</option>
					<option value="161~170">161~170</option>
					<option value="171~180">171~180</option>
					<option value="181~190">181~190</option>
					<option value="191~230">190이상</option>
				</select>
			</div>
			<!-- 키 필터 -->
			<div style="float: left; padding-left: 50px" class="bodyspec form-select">
				몸무게&nbsp; <select name="weight" id="weight">
					<option value="0~150" selected>-선택-</option>
					<option value="41~50">41~50</option>
					<option value="51~60">51~60</option>
					<option value="61~70">61~70</option>
					<option value="71~80">71~80</option>
					<option value="81~90">81~90</option>
					<option value="91~100">91~100</option>
					<option value="101~150">100 이상</option>
				</select>
			</div>
			<!-- 몸무게 필터 -->
		</div>
		
		
		<!-- 스타일필터와 검색 -->
		<div class="ftr" style="justify-content: center">
			<span class="sortField">NEW</span>&nbsp; <span class="sortField">HOT</span>&nbsp;


			<span class="unchosenF" id="firstclick">미니멀</span>&nbsp; <span
				class="unchosenF">캐주얼</span>&nbsp; <span class="unchosenF">비즈니스</span>&nbsp;
			<span class="unchosenF">아메카지</span>&nbsp; <span class="unchosenF">스트릿</span>&nbsp;
			<span class="unchosenF">스포츠</span>&nbsp; <span class="unchosenF">레트로</span>&nbsp;
			<span class="unchosenF">캠퍼스</span>&nbsp; <span class="unchosenF">댄디</span>&nbsp;
			<span class="unchosenF">데일리</span>

		</div>
		
<br>
		<hr>
		<div class="center-block px-4 px-lg-5 mt-5 justify-content-center">
			<div
				class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center infinite"
				id="lookbookimage"></div>
			<!-- 
			<div class="paging pagination">
				<c:if test="${prev}">
					<span>[ <a href="ListLookbook.do?pageNUM=${startPageNum - 1}">이전</a>
						]
					</span>
				</c:if>
				<c:forEach begin="${startPageNum}" end="${endPageNum}" var="pageNUM">
					<span> <c:if test="${select != pageNUM}">
							<b class="page" href="lookbook.do?pageNUM=${pageNUM}">${pageNUM}</b>
						</c:if> <c:if test="${select == pageNUM}">
							<b class="page">${pageNUM}</b>
						</c:if>
					</span>
				</c:forEach>
				<c:if test="${next}">
					<span>[ <a href="/lookbook/lookbook?pageNUM=${endPageNum + 1}">다음</a>
						]
					</span>
				</c:if>
			</div>
			페이징처리 -->
			
		</div>
		<br>
		<br>
		<br>

	</section>


	<%@ include file="../inc/footer.jsp"%>
</body>
</html>
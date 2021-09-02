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
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 룩북 스타일 -->
<link rel="stylesheet" href="../../resources/css/lookbook.css">

<script type="text/javascript">
	$(function() {
		$(".unchosenF").click(function() {
			$(this).toggleClass("chosenF")
		});
	});
	
	
    $(function() {
        $("#upload_file").on('change', function(){
            readURL(this);
        });
    });
    function readURL(input) {
        if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }
          reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</head>
<body>
	<%@ include file="./inc/header.jsp"%>
	<!-- Section-->
	<br>
	<br>
	<section style="position: relative; text-align: center;">
		<br>
		<h3 class="mt-5">나의 룩 작성</h3><hr>
		<div class="align-items-center">
			<form action="insertLookbook.do" method="post"
				enctype="multipart/form-data">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<div class="row col-md-6">
					<h1 class="display-5 fw-bolder"></h1>
					<br> 
					<img id="blah" src="/YouSoSick/image/ready.png" height="400px" /><br>
					
					<input type='file' id="upload_file" name="uploadFile" accept="image/png, image/jpeg"/>
					
				</div>
				<div class="col-md-6">
					<input type="hidden" name="users_no" value="${u.users_no}">
					<input type="hidden" name="lookbook_height"
						value="${u.users_height}"> <input type="hidden"
						name="lookbook_weight" value="${u.users_weight}"> <input
						type="hidden" name="users_no" value="${u.users_no}"> <br>
					<input type="text" class="form-control" placeholder="간단하게 한마디 써주세요"
						name="lookbook_write" maxlength="50"><br>
					<table class="table"
						style="text-align: center; border: 1px solid #dddddd">
						<tr>
							<td valign="middle" rowspan="3" align="center" bgcolor="gray"
								width="200px"><b>룩정보</b></td>
							<td>+ 추가</td>
						</tr>
						<tr>
							<td>+ 추가</td>
						</tr>
						<tr>
							<td>+ 추가</td>
						</tr>
					</table>

					<div class="ftr" style="text-align: middle;">
						<span class="unchosenF">미니멀</span>&nbsp; <span class="unchosenF">캐주얼</span>&nbsp;
						<span class="unchosenF">비즈니스</span>&nbsp; <span class="unchosenF">아메카지</span>&nbsp;
						<span class="unchosenF">스트릿</span>&nbsp;
					</div>
					<div class="ftr" style="text-align: middle;">
						<span class="unchosenF">레트로</span>&nbsp; <span class="unchosenF">캠퍼스</span>&nbsp;
						<span class="unchosenF">댄디</span>&nbsp; <span class="unchosenF">데일리</span>&nbsp;
						<span class="unchosenF">스포츠</span>
					</div>
					<!-- 글쓰기 버튼 생성 -->
					<input type="reset"	class="btn btn-outline-dark pull-right" value="취소">
					<input type="submit" class="btn btn-outline-dark pull-right" value="작성"> 
				</div>
			</form>
			<br><br>
		</div>

	</section>
	<!-- Footer-->
	<%@ include file="./inc/footer.jsp"%>
</body>
</html>
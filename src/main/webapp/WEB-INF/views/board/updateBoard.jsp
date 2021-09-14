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
<!-- ck 에디터 -->
<script src="../../resources/ckeditor/ckeditor.js"></script>


<script type="text/javascript">
	
    $(function() {
        $("#board_uploadFile").on('change', function(){
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
	<%@ include file=".././inc/header.jsp"%>
	<!-- Section-->
	<br>
	<br>
	<section style="position: relative; text-align: center;">
		<br>
		<h3 class="mt-5">게시글 작성</h3><hr>
		<div class="align-items-center">
			<form action="updateBoard.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="users_no" value="21"> <br>	
			<input type="hidden" name="board_no" value="${b.board_no }"> <br>
				<div class="row col-md-6">
					<h1 class="display-5 fw-bolder"></h1>
					<br> 
					
				</div>
				<label>게시판 카테고리</label>
				<select class="board-category">
					 <option value="">자유게시판</option>
					 <option value="">쇼핑후기</option>
					 <option value="">발매정보</option>
					 <option value="">비밀글</option>
				 </select>
				 <label for="board_title">제목</label>
				  <input type="text" name="board_title" value="${b.board_title }"><br>
				  <div class="inputArea">
					<div class="col-md-6">
					<textarea rows="10" cols="80" name="board_content">${b.board_content }</textarea>
					
					<input type='file' id="board_uploadFile" name="board_uploadFile" accept="image/png, image/jpeg"/>
					
					</div>
					<br>

					<!-- 글쓰기 버튼 생성 -->
					<input type="submit" class="btn btn-outline-dark right" value="등록"> 
				</div>
			</form>
			<br><br>
		</div>

	</section>
	<!-- Footer-->
	<%@ include file=".././inc/footer.jsp"%>
</body>
</html>
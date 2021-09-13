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
	<%-- <%@ include file="./inc/header.jsp"%> --%>
	<!-- Section-->
	<br>
	<br>
	<section style="position: relative; text-align: center;">
		<br>
		<h2>게시물 등록</h2>
		<hr>
		
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="users_no" value="${b.users_no}">
	
	<div class="inputArea"> 
	 <label>게시판 카테고리</label>
	 <select class="board-category">
	  <option value="">자유게시판</option>
	  <option value="">쇼핑후기</option>
	  <option value="">발매정보</option>
	  <option value="">비밀글</option>
	 </select>
	
	</div>
	
	<div class="inputArea">
	 <label for="board_title">제목</label>
	 <input type="text" id="board_title" name="board_title" />
	</div>
	
	
	<div class="inputArea">
	 <textarea rows="5" cols="50" id="gdsDes" name="board_content"></textarea>
	</div>
	
	<img id="blah" src="/YouSoSick/image/ready.png" height="400px" /><br>
	<input type='file' id="upload_file" name="uploadFile" accept="image/png, image/jpeg"/>
		<!-- 글쓰기 버튼 생성 -->
					<input type="reset"	class="btn btn-outline-dark right" value="취소">
					<input type="submit" class="btn btn-outline-dark right" value="작성"> 
				</div>
			</form>
			<br><br>
		</div>

	</section>
	<!-- Footer-->
	<%-- <%@ include file="./inc/footer.jsp"%> --%>
</body>
</html>
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
<h2>게시물수정</h2>
<hr>
	<form action="updateBoard.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<input type="hidden" name="users_no" value="${b.users_no }">
		<input type="hidden" name="board_fname" value="${b.board_fname }">
		<input type="hidden" name="board_fsize" value="${b.board_fsize }">
		
		글제목: <input type="text" name="board_title" value="${b.board_title }"><br>
		글내용: <br>
		<textarea rows="10" cols="80" name="board_content">${b.board_content }</textarea>
		첨부파일: ${b.board_fname }(${b.board_fsize })<br>
		<input type="file" id="board_uploadFile" name="board_uploadFile" accept="image/png, image/jpeg"/>
		<input type="submit" value="등록">	
	</form>
</section>
	<!-- Footer-->
	<%@ include file=".././inc/footer.jsp"%>
</body>
</html>
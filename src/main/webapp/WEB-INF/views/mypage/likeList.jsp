<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="/resources/css/likeList.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#upload_file").on('change', function() {
		readURL(this);
	});
});
function readURL(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#blah').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
</script>
</head>
<body>
<br><br><br><br><br>
<%@ include file="../inc/header.jsp" %>
	<!-- 좋아요 목록 -->
	<div class="board_wrap">
        <div class="board_title">
            <h1><strong>좋아요 목록</strong></h1><hr>
        </div>
        <c:forEach var="l" items="${list}">
		  		<!-- 사진파일명 : ${l.lookbook_fname}<br> -->
		  		<div id="imgBox" style="float:left; width:250px; height:300px; margin:50px; padding:20px;">
					<a href="/lookbookInfo.do"><img src="/resources/look_img/${l.lookbook_fname}"  height="600px" width="400px;"></a>
				</div>	
		</c:forEach>
    </div>
    <span id="pageBox">
		<c:forEach var="i" begin="1" end="${totalPage}">
				<a href="/mypage/likeList.do?pageNUM=${i}&users_no=${users.users_no}">${i} &nbsp;</a>
		</c:forEach>
	</span>
    
     <%@ include file="../inc/footer.jsp" %>
</body>
</html>
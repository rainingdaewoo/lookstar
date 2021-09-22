<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="/resources/css/mypage_css/likeList.css"/>
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
<%@ include file="../inc/header.jsp" %>
<br><br><br><br><br>
	<!-- 좋아요 목록 -->
	<div class="board_wrap">
        <div class="board_title">
            <h1><strong>좋아요 목록</strong></h1><hr>
        </div>
        <c:forEach var="l" items="${list}">
		  		<!-- 사진파일명 : ${l.lookbook_fname}<br> -->
		  		<div class="text-center" style="width:303px;" id="imgBox">
				   <div class="image-box">
				      <a href="/lookbook/lookbook_detail.do?lookbook_no=${l.lookbook_no}">
				   		<img id="lookimg" src="/resources/look_img/${l.lookbook_fname}" height="600px" width="400px;" class="image-thumbnail">
			        	</a>
				   </div>
				</div>	
		</c:forEach>
    </div>
    <nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<c:forEach var="i" begin="1" end="${totalPage}">
			<li class="page-item">
				<a class="page-link" href="/mypage/likeList.do?pageNUM=${i}&users_no=${users.users_no}">${i} &nbsp;</a>
			</li>	
		</c:forEach>
	</ul> 
	</nav>	
    
     <%@ include file="../inc/footer.jsp" %>
</body>
</html>
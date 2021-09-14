<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 룩북 관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="/resources/css/manage.css"/>
<script type="text/javascript"src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
<!-- Main Content-->
<br><br><br><br><br>
<%@ include file="../inc/header.jsp" %>       
        <div id="container">
        		<br>
        		<div class="board_wrap1" width="80%">
			         <div class="board_top" style="padding-left: 150px">
				        <div class="board_title">
				            <h2><strong>내 룩북 관리</strong></h2>
				        </div>
			        <c:forEach var="l" items="${list}">
		  			<!-- 사진파일명 : ${l.lookbook_fname}<br> -->
		  			<div id="imgBox" style="float:left; width:250px; height:300px; margin:50px; padding:20px;">
						<a href="/lookbookInfo.do"><img src="/resources/look_img/${l.lookbook_fname}"  height="600px" width="400px;"></a>
					</div>	
				</c:forEach>
			  			
			  		</div> <!-- board_top -->	
	  			
		  			<br>
		  			<br>
		  			<br>
		  			<br>
	  			
				
				
	  			
			</div> <!-- board_wrap1 -->
			
	  	</div> <!-- container -->
		<span id="pageBox">
			<c:forEach var="i" begin="1" end="${totalPage}">
					<a href="/mypage/manageMylook.do?pageNUM=${i}&users_no=${users.users_no}">${i} &nbsp;</a>
			</c:forEach>
		</span>
		
<%@ include file="../inc/footer.jsp" %>
</body>
</html>
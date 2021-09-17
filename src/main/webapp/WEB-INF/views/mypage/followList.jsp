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
<link rel="stylesheet" href="css/css.css">
<link rel = "stylesheet" href="/resources/css/mypage_css/followList.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>     
<body>
<br><br><br><br><br>
<%@ include file="../inc/header.jsp" %>
<!-- 팔로우 목록 -->
	<div class="board_wrap">
        <div class="board_title">
            <h1><strong>팔로우 목록</strong></h1><hr>
        </div>
        
        <c:forEach var="f" items="${flist }">
        <div class="my-3 p-3 bg-white rounded shadow-sm" id="followBox">
        	
            <div class="media text-muted pt-3">
	            <img src="/resources/profile/${f.users_fname }" width=100 height=100 onerror="this.src='/resources/images/user.png'">&nbsp;&nbsp;
	            <div class="media-body pb-3 mb-0 lh-125 border-grey">
	            	<div class="d-flex justify-content-between align-items-center w-100">
	            		<h5><strong class="text-gray-dark">${f.users_id }</strong></h5>
	            		<a href="/mypage/followingLookbook.do?users_no=${f.users_no }&users_nickname=${f.users_nickname}">계정</a>
	            		<!-- ${f.users_no} -->
	            	</div>
	            	<span class="d-block">${f.users_nickname }</span>
	            </div>          
            </div>
        </div>
        </c:forEach>
    </div>
     <nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		<c:forEach var="i" begin="1" end="${totalPage}">
			<li class="page-item">
				<a class="page-link" href="/mypage/followList.do?pageNUM=${i}&users_id=${users.users_id}">${i} &nbsp;</a>
			</li>	
		</c:forEach>
	</ul> 
	</nav>	 

<%@ include file="../inc/footer.jsp" %>
</body>
</html>
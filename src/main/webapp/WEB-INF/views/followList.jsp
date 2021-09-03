<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="css/css.css">
<link rel = "stylesheet" href="resources/css/followList.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<br><br><br><br><br>
<%@ include file="inc/header.jsp" %>
<!-- 팔로우 목록 -->
	<div class="board_wrap">
        <div class="board_title">
            <h1><strong>팔로우 목록</strong></h1><hr>
        </div>
        
        
        <div class="my-3 p-3 bg-white rounded shadow-sm">
        	<h6 class="border-bottom border-gray pb-2 mb-0">follow</h6>
            <div class="media text-muted pt-3">
	            <img src="resources/assets/follower.png" width=50 height=50>
	            <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-grey">
	            	<div class="d-flex justify-content-between align-items-center w-100">
	            		<strong class="text-gray-dark">아이디</strong>
	            		<a href="#">계정</a>
	            	</div>
	            	<span class="d-block">@users_nickname</span>
	            </div>          
            </div>
        </div>
        
        <div class="my-3 p-3 bg-white rounded shadow-sm">
        	<h6 class="border-bottom border-gray pb-2 mb-0">follow</h6>
            <div class="media text-muted pt-3">
	            <img src="resources/assets/follower.png" width=50 height=50>
	            <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-grey">
	            	<div class="d-flex justify-content-between align-items-center w-100">
	            		<strong class="text-gray-dark">아이디</strong>
	            		<a href="#">계정</a>
	            	</div>
	            	<span class="d-block">@users_nickname</span>
	            </div>          
            </div>
        </div>
        
        <div class="my-3 p-3 bg-white rounded shadow-sm">
        	<h6 class="border-bottom border-gray pb-2 mb-0">follow</h6>
            <div class="media text-muted pt-3">
	            <img src="resources/assets/follower.png" width=50 height=50>
	            <div class="media-body pb-3 mb-0 small lh-125 border-bottom border-grey">
	            	<div class="d-flex justify-content-between align-items-center w-100">
	            		<strong class="text-gray-dark">아이디</strong>
	            		<a href="#">계정</a>
	            	</div>
	            	<span class="d-block">@users_nickname</span>
	            </div>          
            </div>
        </div>
        
    </div>
    


</body>
</html>
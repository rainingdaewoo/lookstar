<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 글 관리</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="css/manage.css"/>
</head>
<body>
 <!-- Main Content-->
        
        <div id="container">
        		<br>
        		<div class="board_wrap1">
			         <div class="board_top" style="padding-left: 150px">
				        <div class="board_title">
				             <strong>내 글 관리</strong>
				        </div>
			        
			  			<div class="btnlist">
			  				<button type ="button" onclick="location.href='manageMylook.do'" 
			  					class="btn btn-light" id="looksBtn">looks</button>
			  				<button type ="button" onclick="location.href='manageMyboard.do'" 
			  				class="btn btn-secondary" id="boardBtn">게시판</button>
			  			</div>
			  		</div> <!-- board_top -->	
	  			
		  			<br>
		  			<br>
		  			<br>
		  			<br>
		  			<br>
	  			
	  			<div id="iframe" class="horizontal">
	  				<div id="iframecontainer" class="horizontal" style="height: 70%; width: 100%;"> 
	  								
			  			 <table class="table table-hover" style="width: 80%; margin: auto;">
						    <thead class="thead-light">
						      <tr>
						        <th>no </th>
						        <th>제목</th>
						        <th>작성자</th>
						        <th>작성일</th>
						        <th>조회</th>
						      </tr>
						    </thead>
						    
						    <tbody>
							    <c:forEach var="b" items="${list }">
							    	<tr>
							    		<td>${b.board_no }</td>
							    		<td>${b.board_title }</td>
							    		<td>${b.users_nickname }</td>
							    		<td><fmt:formatDate value="${b.board_date }" pattern="yyyy-MM-dd" /></td>
							    		<td>${b.board_views }</td>
							    	</tr>
							    </c:forEach>
						    
						    </tbody>
						  </table>
						 </div>		<!-- iframconatiner-->					 
	  				
		  				</div>
				<div class="board_page">
					<a href="#" class="bt first"> << </a> <a href="#" class="bt prev">
						< </a> <a href="#" class="num on">1</a> <a href="#" class="num">2</a>
					<a href="#" class="num">3</a> <a href="#" class="num">4</a> <a
						href="#" class="num">5</a> <a href="#" class="bt next">></a> <a
						href="#" class="bt last">>></a>
				</div>
				<br>	<br>
	  				</div> <!-- iframe -->
	  					
	  			</div> <!-- board_wrap1 -->
	  			        
	        </div> 
</body>
</html>
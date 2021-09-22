<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chat with Writer</title>
	<meta http-equib="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Favicon(인터넷창 아이콘) -->
<link rel="icon" type="image/x-icon" href="../../resources/assets/favicon.ico" />
<!-- Bootstrap file --> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>	
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="../../resources/css/MyDM.css">


<link rel="stylesheet" 
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
		crossorigin="anonymous"/>


<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#msg_history").scrollTop($("#msg_history")[0].scrollHeight);
	$(function(){
		setTimeout(function(){
			location.reload();		
		},5000); // 3000밀리초 = 3초
		
	})
});
</script>
</head>

<body>
<!-- 룩북에서 DM view -->
<div class="container vsc-initialized">	
	<div class="messaging" width="100%">
		<h2 id="messaging" class="text-center">Messaging</h2>
		
		<iframe id="iframe1" name="iframe1" style="display:none"></iframe>
		<form id="write_form" name="write_form" action="insertDM.do" method="POST" target="iframe1">												
		
			<div id="from_to" style="width: 100%;">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
					${u.users_nickname } ->  ${dto_users_nickname }<br>
				<input type="hidden" name="from_id" id="from_id" value="${u.users_id }"><br>
				<input type="hidden" name="to_id" id="to_id" value="${dto_users_id }"><br>
															
			</div> <!-- from_to -->
			
			<div class="inbox_msg"> 
				<div class="mesgs" style="border: black 0.5px solid; width:100%; height:100%">
					<div class="msg_history" id="msg_history">					
						<c:forEach var="d" items="${dlist }">			
							<c:choose>	
								<c:when test= "${d.from_id==u.users_id }">
									<div class="outgoing_msg">						
										<div class="sent_msg">
		                					<p>${d.dm_content }</p>
											<span class="time_date"> 
											<fmt:parseDate value="${d.send_date}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="real_send_date" type="both"/>
											<fmt:formatDate value="${real_send_date}" pattern="　a hh:mm 　|　yy.MM.dd"/>
											</span>
										</div>
									</div>						
								</c:when>
								
								<c:otherwise>	
									<div class="incoming_msg_img" width="100%"> <img  src="/resources/profile/${dto_users_fname }" alt="profile"> 
									</div>
									<div class="received_msg">
										<div class="received_withd_msg">
											<p>${d.dm_content }</p>
											<span class="time_date"> 
											<fmt:parseDate value="${d.send_date}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="real_send_date" type="both"/>
											<fmt:formatDate value="${real_send_date}" pattern="　a hh:mm 　|　yy.MM.dd"/>
											</span>
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>						
					</div><!-- msg_histpry -->
			          
					<div class="type_msg">
						<div class="input_msg_write">
						    <input type="hidden" name="dm_no" id="dm_no" value="${dm.dm_no}" >	          		 
						   	<input type="hidden" name="room_no" id="room_no" value="${dm.room_no}" >	          		 
						    <input type="hidden" name="read_date" id="read_date" value="${dm.read_date}" >	          		 
						    <input type="hidden" name="send_date" id="send_date" value="${dm.send_date}" >	          		 						         		          		 
						    <input type="text" class="write_msg" name="dm_content" id="dm_content" placeholder="Type a message" />
						    <button id="sendMsg" class="msg_send_btn" type="submit"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
						 </div>
					</div>			         
		      	</div>  	<!-- megs -->
		     </div>  	 <!-- inbox msg --> 	
		</form>
	</div>
</div>				<!-- container -->
  
  
  
<div class="alert alert-success" id="successMessage" style="display:none;">
	<strong>메세지 전송에 성공했습니다.</strong>
</div>

<div class="alert alert-danger" id="dangerMessage" style="display:none;">
	<strong>이름과 내용을 모두 입력해주세요.</strong>
</div>

<div class="alert alert-warning" id="warningMessage" style="display:none;">
	<strong>데이터베이스 오류가 발생하였습니다..</strong>
</div>

	<br>
	<br>
	<br>
		<%@ include file="./inc/footer.jsp"%>

</body>
</html>
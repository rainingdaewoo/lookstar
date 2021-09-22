<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DM LIST</title>
	<meta http-equib="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Favicon(인터넷창 아이콘) -->
<link rel="icon" type="image/x-icon" href="../../resources/assets/favicon.ico" />
<!-- Bootstrap file --> 
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous"/>	
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
<!-- dm.css적용 -->
<link rel="stylesheet" href="../../resources/css/dmdm.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">

<link rel="stylesheet" 
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
		integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" 
		crossorigin="anonymous"/>

<style type="text/css">
	.chat_list:hover{
		background:#6482B9;		
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<!-- 날짜 format - moment 함수 사용 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script type="text/javascript">	
$(document).ready(function(){	
	setTimeout(function(){
		location.reload();		
	},30000); // 3000밀리초 = 3초
			
	$.ajax({
			url:"/listlist.do",
			dataType:"json",
			async:false,
			success:function(data){
				if(data.length>0){
					var row = "";
					var date = "";
					for(var i in data){
						var $dm_no=data[i].dm_no;
						var $room_no=data[i].room_no;
						var $from_id=data[i].from_id;
						var $to_id=data[i].to_id;
						var $dm_content=data[i].dm_content;
						var $read_date=data[i].read_date;
						var $send_date=data[i].dm_date;
						var $read_chk=data[i].read_chk;
						var $to_profile=data[i].to_profile;
						var $to_nickname=data[i].to_nickname;
						var $other_id=data[i].other_id;
							
						//$send_date는 내가 원하는 형식으로 바꿈
						var date = moment($send_date).format('MMM D');
						if(i==0){
							
							var row = row+"<div class='chat_list active_chat' style='cursor: pointer' onclick='location.href=\"/dmTest03.do?room_no="+$room_no+"&to_id="+$other_id+"&to_nickname="+$to_nickname+"&to_profile="+$to_profile+" \";'>";
							var row = row+"<div class='chat_people'>";
							var row = row+"<div class='chat_img'><img src='/resources/profile/"+$to_profile+"' alt='profile'>"+"</div>";
							var row = row+"<div class='chat_ib'>";
							var row = row+"<h5>"+$to_nickname;
							var row = row+"<span class='chat_date'>"+date+"</span>"+"</h5>";
							var row = row+"<p>"+$dm_content+"</p>"+"</div>"+"</div>"+"</div>";
						}
						else{
							var row = row+"<div class='chat_list' style='cursor: pointer' onclick='location.href=\"/dmTest03.do?room_no="+$room_no+"&to_id="+$other_id+"&to_nickname="+$to_nickname+"&to_profile="+$to_profile+" \";'>";
							var row = row+"<div class='chat_people'>";
							var row = row+"<div class='chat_img'><img src='/resources/profile/"+$to_profile+"' alt='profile'>"+"</div>";
							var row = row+"<div class='chat_ib'>";
							var row = row+"<h5>"+$to_nickname;
							var row = row+"<span class='chat_date'>"+date+"</span>"+"</h5>";
							var row = row+"<p>"+$dm_content+"</p>"+"</div>"+"</div>"+"</div>";
						}
				}//for문
				$(".inbox_chat").append(row);
			} //if문
		}//success문			
	});	 //ajax문		
});//document문
</script>
</head>

<body>
	<!-- DM아이콘 채팅리스트 View -->
	<div id="container">
		<h2 id="messaging" class="text-center">Messaging</h2>
			<iframe id="iframe1" name="iframe1" style="display:none"></iframe>
				<form id="write_form" action="insertDM2.do" method="POST" target="iframe1">								
					<div id="from_to">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							${u.users_nickname }의 목록<br>
						<input type="hidden" name="bbb" id="bbb" value="${u.users_nickname }"><br>					
					</div> <!-- from_to -->
					<div id="adad">
						<!-- inbox_people: 채팅목록 보여주는 부분 -->
						<div class="inbox_people">
							<div class="headind_srch">
								<div class="recent_heading">
	              					<h4>Recent</h4>
	           					 </div>
	           					 <div class="srch_bar">
	             					 <div class="stylish-input-group">
	                					<input type="text" class="search-bar"  placeholder="Search" >
	                					<span class="input-group-addon">
	                					<button type="button"> <i class="fa fa-search" aria-hidden="true"></i> </button>
	                					</span> </div>
	            				</div> <!-- srch_bar --> 
							</div> <!-- headind_srch -->
							
							<!-- 진짜 채팅목록 들어올 공간 -->
							<div class="inbox_chat">	
							</div><!-- inbox_chat -->
						</div><!-- inbox_people -->
					</div> 
				</form>			
		</div>
		
	<br>
	<br>
	<br>	
	<%@ include file="./inc/footer.jsp"%>	
</body>
</html>
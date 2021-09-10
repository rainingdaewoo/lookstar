<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<<<<<<< HEAD
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$("#send").click(function(){
		$("#dm_content").val("");
	});
	
	$(document).ready(function(){	
		setInterval(function(){
			$("#list").empty();
			$.ajax({
				url:"/listChat.do",
				dataType:"json",
				success:function(data){		
					if(data.length>0){
						var row = "";	
							var $dm_no=data[i].dm_no;
							var $from_id=data[i].from_id;
							var $to_id=data[i].to_id;
							var $dm_content=data[i].dm_content;
							var $dm_date=data[i].dm_date;
							
								
							var row = row+ "<tr>";
							var row = row+ "<td>"+$from_id+"</td>"
							var row = row+ "<td>"+$to_id+"</td>"
							var row = row+ "<td>"+$dm_content+"</td>"
							var row = row+ "<td>"+$dm_date+"</td>"
							var row = row+ "</tr>";

							
						$("#list").append(row);
					}
				}
			});
		},1000);
	});	
</script>
</head>
<body>
	<%@ include file="./inc/header.jsp"%>
	<br><br><br><br><br><br><br><br><br>
	<h2>채팅하기</h2>
	<iframe id="iframe1" name="iframe1" style="display:none"></iframe>
	<form id="write_form" action="insertDM.do" method="POST" target="iframe1">	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		작성자: ${u.users_nickname}<br>
		<input type="hidden" name="from_id" value="${u.users_id}"> <br>
		수신자: <input type="text" name="to_id"><br>
		<p>메세지</p> 
		<textarea name="dm_content" rows="10" cols="40"></textarea><br>
		<input type="submit" id="send" value="send">
		<input type="reset" id="reset" value="reset">
	</form>	
	<br>
	<h2>채팅목록</h2>
	<hr>
	<br>

	<div id="output">
		<table border="1" width="80%">
			<thead>
				<tr>
					<th>발신</th>
					<th>수신</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>
	</div>
	<%@ include file="./inc/footer.jsp"%>
=======
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


<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<!-- 날짜 format - moment 함수 사용 -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>


<script type="text/javascript">	
//닉네임 버전으로 수정
	$(document).ready(function(){			
		setInterval(function(){
			$(".msg_history").empty();
			$(".inbox_chat").empty();
			$.ajax({
				url:"/listChat.do",
				dataType:"json",
				async:false,
				success:function(data){						
					if(data.length>0){
						var div="";
						var date = "";					
						for(var i in data){
							var $dm_no=data[i].dm_no;
							var $from_nickname=data[i].from_nickname;
							var $to_nickname=data[i].to_nickname;
							var $dm_content=data[i].dm_content;
							var $dm_date=data[i].dm_date;
							
							//$dm_date는 내가 원하는 형식으로 바꿈
							var date = moment($dm_date).format('hh:mm A    |    MMM D YY');
							
							if($from_nickname == $('#to_nickname').val() && $to_nickname==$('#from_nickname').val()){
								var div = div+"<div class='incoming_msg'>";
								var div = div+"<div class='incoming_msg_img'>"+"<img src='https://ptetutorials.com/images/user-profile.png' alt='sunil'>"+"</div>";
								var div = div+"<div class='received_msg'>"+"<div class='received_withd_msg'>";
								var div = div+"<p>"+$dm_content+"</p>";
								var div = div+"<span class='time_date'>"+date+"</span>";
								var div = div+"</div>"+"</div>"+"</div>";
							}
							
							else if($from_nickname == $('#from_nickname').val() && $to_nickname==$('#to_nickname').val()){
								var div = div+"<div class='outgoing_msg'>";
								var div = div+"<div class='sent_msg'>";
								var div = div+"<p>"+$dm_content+"</p>";
								var div = div+"<span class='time_date'>"+date+"</span>";
								var div = div+"</div>"+"</div>";
							}
							
						}//for문
											
						//입력창의 내용을 채팅 db에 추가하면 지워주기
						$("#dm_content").val("");
						$(".msg_history").append(div);
						
						//setInterval할때마다 채팅창은 맨 하단으로 고정
						$("#msg_history").scrollTop($("#msg_history")[0].scrollHeight);
					} //if(data.length>0)문
					
				}//success문
				
			}); //ajax문


	/*		//채팅리스트 보여주는 ajax
			$.ajax({
				url:"/listPeople.do",
				dataType:"json",
				async:false,
				success:function(data){
					if(data.length>0){
						var row = "";
						var date = "";
						for(var i==0; i<data.length;i++){
							var $dm_no=data[i].dm_no;
							var $from_nickname=data[i].from_nickname;
							var $to_nickname=data[i].to_nickname;
							var $dm_content=data[i].dm_content;
							var $dm_date=data[i].dm_date;
								
							//$dm_date는 내가 원하는 형식으로 바꿈
							var date = moment($dm_date).format('MMM D');
							if(i==0){
								var row = row+"<div class='chat_list active_chat'>";
								var row = row+"<div class='chat_people'>";
								var row = row+"<div class='chat_img'>"+"<img src='https://ptetutorials.com/images/user-profile.png' alt='sunil'>"+"</div>";
								var row = row+"<div class='chat_ib'>";
								var row = row+"<h5>"+$from_nickname;
								var row = row+"<span class='chat_date'>"+date+"</span>"+"</h5>";
								var row = row+"<p>"+$dm_content+"</p>"+"</div>"+"</div>"+"</div>";
							}
							else{
								var row = row+"<div class='chat_list'>";
								var row = row+"<div class='chat_people'>";
								var row = row+"<div class='chat_img'>" + "<img src='https://ptetutorials.com/images/user-profile.png' alt='sunil'>"+"</div>";
								var row = row+"<div class='chat_ib'>";
								var row = row+"<h5>"+$from_nickname;
								var row = row+"<span class='chat_date'>"+date+"</span>"+"</h5>";
								var row = row+"<p>"+$dm_content+"</p>"+"</div>"+"</div>"+"</div>";
								}
							}//for문
						$(".inbox_chat").append(row);
						} //if문
					};//success문
				});	 //ajax문
			*/
			
		},10000); //setInterval문	
	});  //document문
	

</script>
</head>


<body>
	<div id="container">
		<h2 id="messaging" class="text-center">Messaging</h2>
		
		
			<iframe id="iframe1" name="iframe1" style="display:none"></iframe>
				<form id="write_form" action="insertDM.do" method="POST" target="iframe1">								
					<div id="from_to">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							${u.users_nickname } -> <input type="text" name="to_nickname" id="to_nickname"><br>
						<input type="hidden" name="from_nickname" id="from_nickname" value="${u.users_nickname }"><br>					
					</div> <!-- from_to -->
				<div class="inbox_msg">	
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
						<!-- <div class="chat_list active_chat">
				              <div class="chat_people">
				                <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
				                <div class="chat_ib">
				                  <h5 class="first_to"><span class="chat_date"></span></h5>
				                  <p class="fist_coment"></p>
				                </div>
				              </div>
				            </div>      --><!-- chat_list active_chat -->
				            
				        <!--    <div class="chat_list">
				              <div class="chat_people">
				                <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
				                <div class="chat_ib">
				                  <h5 class="other_to"><span class="chat_date"></span></h5>
				                  <p class="last_coment"></p> 
				                </div>
				              </div>
				            </div>      --><!-- chat_list --> 
						
						</div><!-- inbox_chat -->
						
					</div> <!-- inbox_people -->
						
						
					<div class="mesgs">			
						<div class="msg_history" id="msg_history">
								<!-- 여기서 기존 채팅 목록 불러오기 (발신 & 수신)-->
						</div><!-- msg_history -->	
							
							
						<div class="type_msg">
							<div class="input_msg_write">
								<input type="text" class="write_msg" name="dm_content" id="dm_content" placeholder="Type a message" />
								<button class="msg_send_btn" type="submit"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
							</div>
						</div> <!-- type_msg -->			
					</div><!-- mesgs -->
				</form>			
			</div><!-- inbox_msg -->		
		<br>
	</div>	
	<br>
	<br>
	<br>
		<%@ include file="./inc/footer.jsp"%>

>>>>>>> refs/heads/dm
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<link rel = "stylesheet" href="/resources/css/mypage_css/changepw.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<!-- 웹 페이지 크기 및 위치 자동 고정하기 -->
<script type="text/javascript">
	window.onfocus=function(){}
	window.onload=function(){
		window.focus(); // 현재 window 즉 익스플러러를 윈도우 최상단에 위치
		window.moveTo(0,0); // 웹 페이지의 창 위치를 0,0 (왼쪽 최상단) 으로 고정
		window.resizeTo(1280,800); // 웹페이지의 크기를 가로 1280 , 세로 800 으로 고정(확장 및 축소)
	}
$(function(){
	$("#form").submit(function(){
		 if (!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test($("#new_pw").val())) {
	            alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
	          $("#new_pw").focus();
	            return false;
	        };
	    
		if($("#new_pw").val() != $("#new_pw2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#new_pw2").focus();
			return false;
			
		}else if($("#new_pw").val() == ""){
			alert("비밀번호를 입력해주세요.")
			return false;
		}else{
			alert("비밀번호를 변경하였습니다. 로그인 페이지로 이동합니다.");
			return true;
		}
	})
})		
</script>
</head>
<body>
<br><br><br><br><br>
<%@ include file="../inc/header.jsp" %>
 <!-- Main Content-->
        
        <div id="container">
        		<br>
			        <div id="pw_content">
			        	<div class="section_pwconfirm" id="boxForm">			        		
					        <div class="pw_header">
					             <h2 class="h2_pw">비밀번호 변경</h2>
					             <p><h5>회원님의 계정 비밀번호를 재설정 해주세요.<br>
					             (영문, 숫자, 특수문자 포함 8자 이상 25자 이하)</h5></p>
					        </div> <!-- pw_header -->
	  			
	  			
	  			
	  				<div class="spc_content" id="pwdBox">
	  					<form  action="/updatePwd.do" class="form-inline-center" id="form" name="form" method="post">
		  					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<input type="hidden" name="users_no" value="${users.users_no }">
							<!-- 회원번호 : ${users.users_no } -->
		  						<fieldset>
		  							<p class="spc_row2">
		  								<input type="password" name="new_pw" id="new_pw" maxlength="20"
		  									style="width:440px" placeholder="새 비밀번호 입력">	
		  							</p>
		  							
		  							<p class="spc_row3">
		  								<input type="password" name="new_pw2" id="new_pw2" maxlength="20"
		  									style="width:440px" placeholder="새 비밀번호 확인 입력">	
		  							</p>	
		  							<br>
		  							<br>
		  							<p>
		  								<input type="submit" value="변경하기" class="btn btn-lg btn-primary btn-block" >
		  							</p>
		  								
		  						</fieldset>						
	  					</form>
	  				</div><!-- spc_content -->
	  			    </div> <!-- section_pwconfirm-->    
	    		</div>
	    	</div> 
<%@ include file="../inc/footer.jsp" %>	    	
</body>
</html>
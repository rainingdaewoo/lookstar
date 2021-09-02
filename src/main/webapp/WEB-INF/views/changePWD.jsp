<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="css/changepw.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- 웹 페이지 크기 및 위치 자동 고정하기 -->
		<script type="text/javascript">
			window.onfocus=function(){
			}
			window.onload=function(){
			 	window.focus(); // 현재 window 즉 익스플러러를 윈도우 최상단에 위치
				window.moveTo(0,0); // 웹 페이지의 창 위치를 0,0 (왼쪽 최상단) 으로 고정
				window.resizeTo(1280,800); // 웹페이지의 크기를 가로 1280 , 세로 800 으로 고정(확장 및 축소)
			}
			
			function alertDialogBox(){
				alert("비밀번호가 변경되었습니다.");
			}
		</script>
</head>
<body>
 <!-- Main Content-->
        
        <div id="container">
        		<br>
			        <div id="pw_content">
			        	<div class="section_pwconfirm">			        		
					        <div class="pw_header">
					             <h2 class="h2_pw">비밀번호 변경</h2>
					             <p class="pp">회원님의 계정 비밀번호를 재설정 해주세요.<br>
					             (영문, 숫자, 특수문자 포함 8자 이상 12자 이하)</p>
					        </div> <!-- pw_header -->
			  			
	  			
		  			
		  			
	  			
	  				<div class="spc_content">
	  					<form  action="./mainPage.jsp" class="form-inline-center" id="fm" name="fm" method="post">
	  						<fieldset>
	  							<p class="spc_row1">
	  								<input type="password" name="now_pw" id="now_pw" maxlength="20"
	  									style="width:440px" placeholder="현재 비밀번호 입력">			
	  							</p>
	  							
	  							<p class="spc_row2">
	  								<input type="password" name="new_pw" id="new_pw" maxlength="20"
	  									style="width:440px" placeholder="새 비밀번호 입력">	
	  							</p>
	  							
	  							<p class="spc_row3">
	  								<input type="password" name="conf_pw" id="conf_pw" maxlength="20"
	  									style="width:440px" placeholder="새 비밀번호 확인 입력">	
	  							</p>	
	  							<br>
	  							<br>
	  							<p class="btn_area_btm">
	  								<button type="submit" id="changepw" onclick="alertDialogBox()">확인</button>
	  							</p>
	  								
	  						</fieldset>						
	  					</form>
	  				</div><!-- spc_content -->
	  			    </div> <!-- section_pwconfirm-->    
	    		</div>
	    	</div> 
	    	
</body>
</html>
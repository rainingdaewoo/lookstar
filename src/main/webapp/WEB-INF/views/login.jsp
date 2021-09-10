<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Lookstar-loginUsers</title>
	<!-- 아이콘 -->
	<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script>
	<!-- 카카오 -->
	 <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="../resources/assets/favicon.ico" />
	<!-- Bootstrap icons-->
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5.3/examples/sign-in/">
    <!-- Custom styles for this template -->
    <link href="../resources/css/signin.css" rel="stylesheet">
    <script type="text/javascript">
    	window.Kakao.init("2e1f490b7eb0980dbf31d4d83821cf0d");
    	function kakaoLogin() {
    		window.Kakao.Auth.login({
    			scope:'profile_nickname,account_email,gender',
    			success: function(authObj){
    				console.log(authObj);
    				window.Kakao.API.request({
    					url:'/v2/user/me',
    					success: res =>{
 							const profile = res.properties.nickname;   						
    						const email = res.kakao_account.email;
    						const gender = res.kakao_account.gender;
    						
    						console.log(profile);
    						console.log(email);
    						console.log(gender);
    						
    						$("#kakaoprofile").val(profile);
    						$("#kakaoemail").val(email);
    						$("#kakaogender").val(gender);
    						location.href = 'join.do';
    					}
    				});
    			}
    		})
    	} 
    </script>
  </head>

  <%@ include file="./inc/header.jsp" %>

  <body class="text-center">
    <form class="form-signin" name="login_frm" action="login.do" method="post" >
    <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
  <h1 class="h3 mb-3 font-weight-normal">login</h1>
  <input type="text" id="inputId" name="username" class="form-control" placeholder="Id" required autofocus>
  <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
  <div class="checkbox mb-3">
    <label>
    <span>아직 회원이 아니신가요?</span>
      <a href="join.do" id="join">회원가입</a> 
    </label>
    <label>
    <span><a href="findID.do">findID</a></span><span>&nbsp;&nbsp;/&nbsp;&nbsp;</span>
    <span><a href="findPW.do">findPassword</a></span><br>
    </label>
  </div>
  <input type="submit" class="btn btn-lg btn-primary btn-block" value="login">
  <br>
  <div class="form-group row" id="kakaologin">
  	<div class="kakaobtn">
  		<input type="hidden" name="kakaoprofile" id="kakaoprofile"/>
  		<input type="hidden" name="kakaoemail" id="kakaoemail"/>
  		<input type="hidden" name="kakaogender" id="kakaogender"/>
  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  	<a href="javascript:kakaoLogin();">
  	<img src="https://www.gb.go.kr/Main/Images/ko/member/certi_kakao_login.png" style="height:50px;width:auto"/>
  	</a>
  	</div>
  </div>
  <br>
  <a href="#"><img src="https://static.nid.naver.com/oauth/big_g.PNG?version=js-2.0.0" style="height:50px;width:auto"/></a>
</form>
	
	<!-- Footer-->
	<%@ include file="./inc/footer.jsp" %>
</body>
</html>
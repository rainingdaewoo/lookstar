<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
	//2e1f490b7eb0980dbf31d4d83821cf0d
	window.Kakao.init("2e1f490b7eb0980dbf31d4d83821cf0d");
	
	function kakaoLogin() {
		window.Kakao.Auth.login({
			scope:'profile_nickname,account_email,gender',
			success: function(authObj){
				console.log(authObj);
				window.Kakao.API.request({
					url:'/v2/user/me',
					success: res =>{
						const kakao_account = res.kakao_account;
						console.log(kakao_account);
					}
				});
			}
		})
	} 
	</script>
<body>
<a href="javascript:kakaoLogin();">카카오 로그인</a>
</body>
</html>
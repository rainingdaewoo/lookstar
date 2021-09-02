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
	<!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="../resources/assets/favicon.ico" />
	<!-- Bootstrap icons-->
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/4.5.3/examples/sign-in/">
    <!-- Bootstrap core CSS -->
	<link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../resources/css/signin.css" rel="stylesheet">
  </head>

 <%@ include file="./inc/header.jsp" %>

  <body class="text-center">
  	<section class="container">
            <div class="page-header px-4 px-lg-5 my-5" id="text1">
                <div class="title">   
                <h1 class="h3 mb-3 font-weight-normal">메일 전송 완료</h1>
                </div>
            </div>
            <div>
            	<p class="field">
            	<!-- ${msg }-->
            	메일전송이 완료되었습니다. 확인 후 로그인 해주시기 바랍니다.
            	</p>
            </div>
            <div class="container px-4 px-lg-5 my-5" id="text2">
                <form class="form-find" action="#">
                    <div class="form-group text-center">
                        <input type="submit" class="btn btn-lg btn-primary btn-block" value="로그인하러 가기">
                    </div>
                </form>
            </div>
		</section>
    	<!-- Footer-->
	<%@ include file="./inc/footer.jsp" %>
</body>
</html>
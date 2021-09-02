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
    <form class="form-signin" action="login.do" method="post">
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
</form>

	<!-- Footer-->
	<%@ include file="./inc/footer.jsp" %>
</body>
</html>
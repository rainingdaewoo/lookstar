<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOOKSTAGRAM-MYINFO</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="/resources/css/myInfo.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<br><br><br><br><br>
<%@ include file="../inc/header.jsp" %>
 <!-- Main Content-->
        <main class="mb-4">
        <br><br><br><br><br>
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center" id="infoBox">
                <h2 align="center">개인정보 수정</h2>
                	<div id="inform">
                		<div class="container px-4 px-lg-5 my-5">
                		
                		
                <form action="/updateMyInfo.do" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<input type="hidden" name="users.users_no" value="${users.users_no }">
				
                    <div class="form-group">
                        <label for="inputNickname">닉네임</label>
                        <input type="text" class="form-control"  placeholder="${users.users_nickname}" name="users.users_nickname">
                    </div>
                    <div>
                    	<label for="inputBirthday">생년월일</label>
                        <input type="date" class="form-control" name="users.users_birth">
                    </div>
                    <div>
                    	<label for="inputSex">성별</label><br>
                        <label><input type="radio"  value="1" name="users.users_gender">남</label>
                        <label><input type="radio"  value="2" name="users.users_gender">여</label>
                    </div>
                    <div>
                    	<label for="inputHeight">키</label>
                        <input type="number" class="form-control" name="users.users_height" placeholder="${users.users_height}">
                    </div>
                    <div>
                    	<label for="inputWeight">몸무게</label>
                        <input type="number" class="form-control" name="users.users_weight" placeholder="${users.users_weight}">
                    </div>
                    <br><br>
                    <div class="ftr" style="text-align: middle;" id="styleBox">
						<h5>선호하는 스타일</h5>
						
						미니멀&nbsp; 	<input type="checkbox" name="style_no" value="1">&nbsp;
						캐주얼&nbsp; 	<input type="checkbox" name="style_no" value="2">&nbsp;
						비즈니스&nbsp; <input type="checkbox" name="style_no" value="3">&nbsp;
						아메카지&nbsp; <input type="checkbox" name="style_no" value="4">&nbsp;
						스트릿&nbsp; <input type="checkbox" name="style_no" value="5">&nbsp;
						스포츠&nbsp; <input type="checkbox" name="style_no" value="6">&nbsp;
						레트로&nbsp; <input type="checkbox" name="style_no" value="7">&nbsp;
						캠퍼스&nbsp; <input type="checkbox" name="style_no" value="8">&nbsp;
						댄디&nbsp; <input type="checkbox" name="style_no" value="9">&nbsp;
						데일리&nbsp;<input type="checkbox" name="style_no" value="10">
					</div>
					
                    <div>
                        <input type="submit" value="수정" style="margin-top: 30px">
                    </div>
              </form>
                    
                    	</div>
                	</div>
                </div>
            </div>
        </main>
        <%@ include file="../inc/footer.jsp" %>
</body>
</html>
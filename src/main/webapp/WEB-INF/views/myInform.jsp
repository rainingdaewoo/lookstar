<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOOKSTAGRAM-MYINFO</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="css/myInfo.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
 <!-- Main Content-->
        <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center" id="infoBox">
                <h2 align="center">개인정보 수정</h2>
                	<div id="inform">
                		<div class="container px-4 px-lg-5 my-5">
                		
                		
                <form role="form" action="updateMyInfo.do" method="post">
                
                    <div class="form-group">
                        <label for="inputNickname">닉네임</label>
                        <input type="text" class="form-control" id="inputNickname" placeholder="로그인 계정 닉네임" name="users_nickname">
                    </div>
                    <div>
                    	<label for="inputBirthday">생년월일</label>
                        <input type="date" class="form-control" id="inputBirthday" name="users_birth">
                    </div>
                    <div>
                    	<label for="inputSex">성별</label><br>
                        <label><input type="radio" id="inputSex"  value="1" name="users_gender">남</label>
                        <label><input type="radio" id="inputSex"  value="2" name="users_gender">여</label>
                    </div>
                    <div>
                    	<label for="inputHeight">키</label>
                        <input type="number" class="form-control" id="inputHeight" name="users_height">
                    </div>
                    <div>
                    	<label for="inputWeight">몸무게</label>
                        <input type="number" class="form-control" id="inputWeight" name="users_weight">
                    </div>
                    
                    <div>
                        <input type="submit" value="수정" style="margin-top: 30px">
                    </div>
              </form>
               <div>
                    	<label for="inputStyle">스타일</label><br>   
                       미니멀<input type="checkbox" name="looks" value="미니멀" style="margin-top: 15px" checked="checked">
                       이지캐주얼<input type="checkbox" name="looks" value="이지캐주얼" style="margin-left: 10px">
                       비즈니스<input type="checkbox" name="looks" value="비즈니스" style="margin-left: 10px"> 
                       아메카지<input type="checkbox" name="looks" value="아메카지" style="margin-left: 10px"> 
                       스트릿<input type="checkbox" name="looks" value="스트릿" style="margin-left: 10px">
                       스포츠<input type="checkbox" name="looks" value="스포츠" style="margin-left: 10px">
                       레트로<input type="checkbox" name="looks" value="레트로" style="margin-left: 10px"> 
                       댄디<input type="checkbox" name="looks" value="댄디" style="margin-left: 10px">
                       캠퍼스<input type="checkbox" name="looks" value="캠퍼스" style="margin-left: 10px">
                       데일리<input type="checkbox" name="looks" value="데일리" style="margin-left: 10px"> 
                    </div>     
                    
                    	</div>
                	</div>
                </div>
            </div>
        </main>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel = "stylesheet" href="resources/css/withdrawal.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<br><br><br><br><br>
<%@ include file="inc/header.jsp" %>
<!-- Main Content-->
        <main class="mb-4">
        <br><br><br><br><br>
            <div class="container" id="container">
                <div class="p-4 mb-3 bg-light rounded" align="center" id="box">
                <h1 align="center">회원탈퇴</h1>
	                <div id="container">
			                <div id="info">
			                <p align="center"><h5>회원을 탈퇴하면 좋아요,게시글,채팅,팔로우,룩북 등 모든 정보가 삭제 됩니다</h5></p>  
			                </div>     
			                
			                
			                <div id="checkPWD">
			                	<div id="pwd" class="input-group">
				                	<form action="deleteUsers.do" method="post" class="needs-validation">
				                	<div class="row">
				                		<div >
				                			<label for="checkPwd">비밀번호를 입력해주세요</label>
				                			<input type="hidden" name="users_no" value=4>
				                			<input type="password" name="users_pw" id="checkPwd" class="form-control">
				                			<div class="invalid-feedback">비밀번호가 불일치합니다.</div>
				                			
				                			
				                			<div id="reason" >
							                	<label for="why">탈퇴 사유를 선택해 주세요</label>
							                       <select name="reason" class="custom-select d-block w-100" id="why" required>
							                          <option value="many">너무 많이 이용해요</option>   
							                          <option value="no">보고싶은 룩이 없어요</option>   
							                          <option value="new">새 계정을 만들고 싶어요</option>   
							                          <option value="etc" id="etc">기타</option>   
							                       </select>
							                       <div class="invalid-feedback">탈퇴 사유를 선택해 주세요!</div> 
							                       <textarea rows="3" cols="40" id="txt" style="display: none;"></textarea>
							                </div>
				                			
				                			
				                		</div>
				                	</div>
				                			                	
					                	<input type="submit" value="탈퇴">
					                </form>	
			                	</div>
		                	</div>
		                
		                
	                  </div>   
                </div>
            </div>
        </main>
        <%@ include file="inc/footer.jsp" %>
</body>
</html>
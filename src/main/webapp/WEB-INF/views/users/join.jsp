<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v4.1.1">
<title>Lookstar-insertUsers</title>
<link rel="stylesheet" href="../resources/css/insertUsersPage.css">
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<!-- Favicon-->
<link rel="icon" type="image/x-icon" 
	href="../resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	

<!-- 아이콘 -->
<script src="https://kit.fontawesome.com/51db22a717.js" crossorigin="anonymous"></script> 
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	let code;
	let id_check = false;
	let nickname_check = false;

	
	//model.addAttribute("kakaoprofile",kakaoprofile);
	//model.addAttribute("kakaoemail",kakaoemail);
	//model.addAttribute("kakaogender",gender);
	//model.addAttribute("users_jointype",users_jointype);
	$("#f2").submit(function(){
		if($("#correct").val() == 2 ){
			nickname_check = true;
		}
		
		if ($("#users_id").val() == "") { 
	    	alert("아이디를 입력하세요.");
	    	$("#users_id").focus(); 
	    	return false;
	  	};
	  	
	  	if ( $("#users_pw").val() == "") {
	  	    alert("비밀번호를 입력하세요.");
	  	  	$("#users_pw").focus();
	  	    return false;
	  	};
	  	
	  	/*if ($("#users_pw").val() !=  !/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/) {
	  	    alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
	  	  $("#users_pw").focus();
	  	    return false;
	  	};*/
	  	
		if (!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test($("#users_pw").val())) {
	  	    alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
	  	  $("#users_pw").focus();
	  	    return false;
	  	};
	  	
	  	if ($("#users_pw").val() !== $("#pwdCheck").val()) {
	  	   alert("비밀번호가 일치하지 않습니다. 재확인 바랍니다.");
	  		$("#pwdCheck").focus();
	  	   return false;
	  	};
	  	
	  	if ( $("#users_email").val() == "") {
		    alert("이메일 주소를 입력하세요.");
		    $("#users_email").focus();
		    return false;
		 }
	  	
	  	if($("#emailCheck").val() !== code){
	  		if($("#correct").val() == 2 ){
	  			return true;
	  		}else{
	  		alert("인증번호를 확인해주세요.");
	  		$("#emailCheck").focus();
		    return false;	  			
	  		}
	  	}
	  	
		if (!$("#female").is(":checked") && !$("#male").is(":checked")) { //둘다 미체크시
		  alert("성별을 선택해 주세요.");
	  	  return false;
	  	}
		
		if (!$("#agree").is(":checked")) { //체크박스 미체크시
		    alert("약관 동의를 체크하세요.");
		    return false;
		 }
		
	  
		if(id_check !== true){
			alert("닉네임 중복확인을 확인하세요.")
		}
		
		if(nickname_check !== true){
			alert("닉네임 중복확인을 확인하세요.")
		}
		
	
		
		var mail1 = $('#users_email').val();
		var mail2 = $('#users_email2').val();
		mail1 += '@' + mail2;
		$("#users_email").val(mail1);
		
		alert("룩스타그램 회원가입을 축하합니다.");
		
	})
	
	$("#mailslc").change(function(){
		if($('#mailslc').val() == 'self'){
			$('#users_email2').attr("disabled", false);
			$('#users_email2').val("");
			$('#users_email2').focus();
		}else{
			$('#users_email2').val($('#mailslc').val());
		}
	});
	
	$("#compareID").click(function(event){
		event.preventDefault();
		var compare_id = $("#users_id").val();
		var users_id;
		data = {compare_id:compare_id};
		console.log(data)
		$.ajax({url:"/users/compareID.do",data:data,success:function(data){
			users_id = data;
			if(compare_id==users_id){
				alert("중복된 아이디입니다. 다른 아이디를 입력바랍니다.");
				return;
			}else{				
				alert("사용가능한 아이디 입니다!");
				id_check = true;
			}
		}});
	});
	
	
	
	$("#compareNickname").click(function(event){
		event.preventDefault();
		var compare_nickname = $("#users_nickname").val();
		var users_nickname;
		data = {compare_nickname:compare_nickname};
		console.log(data)
		$.ajax({url:"compareNickname.do",data:data,success:function(data){
			users_nickname = data;
			if(compare_nickname==users_nickname){
				alert("중복된 닉네임입니다. 다른 닉네임을 입력바랍니다.");
				return;
			}else{				
				alert("사용가능한 닉네임 입니다!");
				nickname_check = true;
			}
		}});
	});
	
	
	$("#sendCode").click(function(event){
		event.preventDefault();
		var sendEmail = $("#users_email").val();
		var sendEmail2 = $("#users_email2").val();
		sendEmail +="@"+ sendEmail2;
		console.log(sendEmail)
		data = {sendEmail:sendEmail};
		$.ajax({url:"sendCode.do",data:data,success:function(data){
			code = data;
			console.log(code)
			alert("인증코드를 발송하였습니다.\n코드를 입력해주세요!");
		}});
	});
	
	$("#checkCode").click(function(event){
		event.preventDefault();
		let emailCode = $("#emailCheck").val();
		if(emailCode == code){
			alert("인증되었습니다.");
		}else{
			alert("인증번호가 일치하지 않습니다. 다시확인해주시기 바랍니다.");
			return;
		}
	})

	
		
	   
	<!-- 뒤로가기 막기 -->   
	 window.history.forward();
	 function noBack(){window.history.forward();}
})
	

</script>
</head>
<!-- 뒤로가기 막기 -->
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="" class="bg-light">
	<%@ include file="../inc/header.jsp"%>
	<!-- 회원가입 섹션 -->
	<br><br><br><br>
	<hr>
	<input type="hidden" value="${correct }" id="correct">
	<div class="container">
	<h2 align="center">회원가입</h2>
	<form class="needs-validation" method="post" id="f2" name="join" action="/users/join.do" enctype="multipart/form-data" class="needs-validation" novalidate>
		<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"> 
		<input type="hidden" id="jointype" name="users.users_jointype" value="${users_jointype }"> 
		<input type="hidden" name="users.users_grant" value="client">
		<input type="hidden" name="users.users_del" value="0">
		<div class="container">
			<div>
				<br> <br>
				<div class="row">
					<div class="mb-3">
					<label for="ID">아이디</label>
						<input class="form-control" type="text" id="users_id" name="users.users_id" maxlength="20"style="width:300px;height:38px;font-size:15px;"> 
					</div>
					<div class="mb-3">
						<input class="btn btn-secondary" type="button" value="중복확인" id="compareID" style="margin-top: 28px; margin-left: 5px;">
					</div>
				</div>
				<div class="row">
					<div class="mb-3">
						<label for="PW">비밀번호</label>
							<input class="form-control" type="password" id="users_pw" name="users.users_pw" maxlength="20"style="width:300px;height:38px;font-size:15px;"> 
							<p>※비밀번호는 <span class="num">문자, 숫자, 특수문자(~!@#$%)의 조합 10 ~16자리</span>로 입력이 가능합니다.</p>				
					</div>
				</div>
				<div class="row">
					<div class="mb-3">
						<label for="PWC">비밀번호 확인</label>
							<input class="form-control" type="password" id="pwdCheck" name="pwdCheck" maxlength="20"style="width:300px;height:38px;font-size:15px;"> 
					</div>
				</div>
				<div class="row">
					<div class="mb-3">
						<label for="email">이메일</label>
							<input class="form-control" type="text" id="users_email" name="users.users_email" maxlength="20"style="width:150px;height:38px;font-size:15px;" value=${mail1 }>
					</div>	
					<div class="mb-3" id="mailspan">
					<br>
					<span class="a">@</span>
					</div>
					<div class="mb-3">
							<input class="form-control" type="text" id="users_email2" name="users_email2" maxlength="20"style="width:150px;height:38px;font-size:15px;" id="users_email2" value="${mail2 }" >
					 </div>	
							<div>  
							<select class="custom-select d-block w-100" name="mailslc" id="mailslc" class="mb-3"> 
								<option value="self" selected>직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.com	">daum.com</option>
							</select>
							</div>
							<div>
							<input class="btn btn-secondary" type="button" value="코드전송" id="sendCode" style="width: 90px;">
							</div> 
				</div>	
				<div class="row">	
					<div class="mb-3">
					<label for="Co">인증번호 확인</label>
						<input class="form-control" type="text" id="emailCheck" name="emailCheck" maxlength="20"style="width:300px;height:38px;font-size:15px;"> 
					</div>
					<div class="mb-3">
						<input class="btn btn-secondary" type="button" value="확인" id="checkCode" style="margin-top: 28px; margin-left: 5px;">
					</div>	
				</div>
				<div class="row">	
					<div class="mb-3">
					<label for="Nick">닉네임</label>
						<input class="form-control" type="text" id="users_nickname" name="users.users_nickname" maxlength="20"style="width:300px;height:38px;font-size:15px;" value="${kakaoprofile }"> 
					</div>
					<div class="mb-3">
						<input class="btn btn-secondary" type="button" value="중복 확인" id="compareNickname" style="margin-top: 28px; margin-left: 5px;">
					</div>	
				</div>	
				<div class="row">
					<div class="mb-3">
					<label for="birth">생년월일</label>
						<input class="form-control" type="date" id="users_birth" name="users.users_birth" style="width:300px;height:30px;font-size:15px;"> 
					</div>
				</div>
				<div class="row">	
					<div class="d-block my-3">
					<label for="gender">성별</label>
						<c:if test="${kakaogender == 'male' }">
						남 <input type="radio" name="users.users_gender" value="1" id="male" checked="checked" class="custom-control-input">
						여 <input type="radio" name="users.users_gender" value="0" id="female">
						</c:if>	
						<c:if test="${kakaogender == 'female' }">
						남 <input type="radio" name="users.users_gender" value="1" id="male">
						여 <input type="radio" name="users.users_gender" value="0" id="female" checked="checked">
						</c:if>	
						<c:if test="${kakaogender == null }">
						남 <input type="radio" name="users.users_gender" value="1" id="male">
						여 <input type="radio" name="users.users_gender" value="0" id="female">
						</c:if>	
					</div>
				</div>
				<div class="row">	
					<div class="mb-3">
					<label for="height">키</label>
						<input class="form-control" type="number" id="users_height" name="users.users_height" style="width:300px;height:30px;font-size:15px;" value="0"> 
					</div>
				</div>
				<div class="row">	
					<div class="mb-3">
					<label for="weight">몸무게</label>
						<input class="form-control" type="number" id="users_weight" name="users.users_weight" style="width:300px;height:30px;font-size:15px;" value="0"> 
					</div>
				</div>
				
				<div class="row">	
					<label for="like_style">선호스타일</label>
					<div class="mb-3" style="margin-top: 15px">
						미니멀<input type="checkbox" name="style_no" value="1" style="margin-top: 15px">&nbsp;&nbsp;&nbsp;
							캐주얼<input type="checkbox" name="style_no" value="2">&nbsp;&nbsp;&nbsp;
							비즈니스<input type="checkbox" name="style_no" value="3">&nbsp;&nbsp;&nbsp;
							아메카지<input type="checkbox" name="style_no" value="4">&nbsp;&nbsp;&nbsp;
							스트릿<input type="checkbox" name="style_no" value="5">&nbsp;&nbsp;&nbsp;
							스포츠<input type="checkbox" name="style_no" value="6"><br>
							레트로<input type="checkbox" name="style_no" value="7">&nbsp;&nbsp;&nbsp;
							캠퍼스<input type="checkbox" name="style_no" value="8">&nbsp;&nbsp;&nbsp;
							댄디<input type="checkbox" name="style_no" value="9">&nbsp;&nbsp;&nbsp;
							데일리<input type="checkbox" name="style_no" value="10">
					</div>
				</div>
				<div class="row">	
					<div class="mb-3">
					<label for="profile">프로필사진</label>
						<input type="file" id="uploadFile" name="users.uploadFile" style="width:300px;height:30px;font-size:15px;"> 
					</div>
				</div>	
				<br>
				<div class="form-group" style="text-align: center">
					<textarea rows="3" cols="80" name="content" readonly="readonly">1. lookstagram 서비스
lookstagram는 사용자가 좋아하는 것을 발견하고 직접 해볼 수 있도록 도우며 개인에게 맞춤화된 서비스를 제공합니다. 
lookstagram에서 사용자와 관련된 콘텐츠를 제공하기 위해 저희는 사용자가 무엇을 좋아하는지 알아야 합니다.
						
2. lookstagram 사용
lookstagram는 모든 연령이 이용할 수 있습니다.
						
3. 사용자 동의
① lookstagram에 게시한 콘텐츠의 소유권은 게시자에게 있습니다
② 회원님이 lookstagram에 콘텐츠를 게시하면 lookstagram는 이를 다른 사람들에게 공개할 수 있고 사람들은 해당 콘텐츠를 저장할 수 있습니다. 
   포르노를 게시하거나, 스팸을 보내거나, 다른 Pinterest 사용자에게 피해를 주지 마세요. 
③ 회원님이 콘텐츠를 게시하기로 하면 lookstagram 서비스를 제공하고 개선하기 위해 저희가 해당 콘텐츠를 사용할 수 있도록 허락한 것으로 간주됩니다. 
	다른 사람과 공유한 콘텐츠의 사본은 회원님이 본인의 계정에서 해당 콘텐츠를 삭제한 이후에도 계속 남아 있을 수 있습니다.
④ 저희는 여러분의 의견을 받아들여 lookstagram을 더욱 멋진 곳으로 만들기 위해 노력합니다.
						
4. 저작권 정책
lookstagram은 저작권을 존중합니다. 여러분도 존중해 주세요.
						
5. 보안
저희는 lookstagram 사용자의 보안을 중요하게 생각합니다. 
lookstagram는 회원님의 콘텐츠와 계정의 보안을 보호하기 위해 노력하고 있지만 어느 누구도 무단으로 lookstagram의 보안을 뚫을 수 없다는 것을 
보장하지는 못합니다. 항상 비밀번호 보안에 주의하시기 바랍니다. 계정이 도용되었거나 무단으로 사용되었다고 생각되는 때에는 지체 없이 알려주시기 바랍니다.
						
6. 해지
						
lookstagram은 어떠한 이유로든 적절한 공지를 통해서 회원님이 lookstagram을 사용할 수 있는 권리를 해지하거나 보류할 수 있습니다. 
저희는 커뮤니티 가이드라인 위반 등과 같이 합당한 이유가 있을 때에는 아무런 공지 없이 즉시 회원님의 사용 권한을 해지하거나 보류할 수 있습니다. 
					</textarea>
					<br>		
						<input type="checkbox" id="agree"> <a>이용약관에 동의합니다.</a>
				</div>

				<div class="create">
					<button class="btn btn-primary btn-lg" type="button" onclick="history.back();">이전페이지로</button>
					<input type="submit"class="btn btn-primary btn-lg" value="회원가입">
				</div>
			</div>
		</div>
	</form>
</div>
	<!-- Footer-->
	<%@ include file="../inc/footer.jsp"%>

	
</body>
</html>

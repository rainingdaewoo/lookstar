<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Lookstar-insertUsers</title>
<link rel="stylesheet" href="../resources/css/insertUsersPage.css">
<!-- 아이콘 -->
<script src="https://kit.fontawesome.com/51db22a717.js"
	crossorigin="anonymous"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon"
	href="../resources/assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


<script type="text/javascript">
$(function(){
	$("#mailslc").change(function(){
		if($('#mailslc').val() == 'self'){
			$('#users_email2').attr("disabled", false);
			$('#users_email2').val("");
			$('#users_email2').focus();
		}else{
			$('#users_email2').val($('#mailslc').val());
		}
	});
	
	$("#but4").click(function(){
		var mail1 = $('#users_email').val();
		var mail2 = $('#users_email2').val();
		mail1 += '@' + mail2;
		$("#users_email").val(mail1);
	})
})
</script>
</head>
<body>
	<%@ include file="./inc/header.jsp"%>
	<!-- 회원가입 섹션 -->
	<br><br><br><br>
	<form method="post" action="/join.do" enctype="multipart/form-data">
		<input type="hidden" name="${_csrf.parameterName }"
			value="${_csrf.token }"> <input type="hidden"
			name="users_jointype" value="1"> <input type="hidden"
			name="users_grant" value="client">
		<div class="container">
			<div class="insert">
				<br> <br>
				<table>
					<tr>
						<td class="col1">아이디</td>
						<td class="col2"><input type="text" id="users_id"
							name="users_id" maxlength="10"> <input class='but1'
							type="button" value="중복확인" onclick=""></td>
					</tr>

					<tr>
						<td class="col1">비밀번호</td>
						<td class="col2"><br> <input type="password"
							id="users_pw" name="users_pw" maxlength="16">
							<p>
								※비밀번호는 <span class="num">문자, 숫자, 특수문자(~!@#$%^&*)의 조합 10 ~
									16자리</span>로 입력이 가능합니다.
							</p></td>
					</tr>

					<tr>
						<td class="col1">비밀번호 확인</td>
						<td class="col2"><input type="password" id="pwdCheck"
							name="pwdCheck" maxlength="16"></td>
					</tr>

					<tr>
						<td class="col1">이메일</td>
						<td class="col2"><span class="input w1 mailId"><input
								type="text" id="users_email" name="users_email"></span> <span
							class="a">@</span> <input type="text" name="users_email2"
							id="users_email2"> <select name="mailslc" id="mailslc">
								<option value="self" selected>직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="gmail.com">gmail.com</option>
								<option value="daum.com	">daum.com</option>
						</select> <input class='but2' type="button" value="인증번호 발송" onclick="">
						</td>
					</tr>

					<tr id="cr_email">
						<td class="col1">인증번호 확인</td>
						<td class="col2"><input type="text" name="emailCheck"
							maxlength="16"> <input class='but2' type="button"
							value="확인" onclick=""></td>
					</tr>

					<tr>
						<td class="col1">닉네임</td>
						<td class="col2"><input type="text" id="users_nickname"
							name="users_nickname" maxlength="16"> <input class='but1'
							type="button" value="중복 확인" onclick=""></td>
					</tr>

					<tr>
						<td class="col1">생년월일</td>
						<td class="col2"><input type="date" id="users_birth"
							name="users_birth"></td>
					</tr>

					<tr>
						<td class="col1">성별</td>
						<td class="col2">남 <input type="radio" name="users_gender"
							value="1"> 여 <input type="radio" name="users_gender"
							value="0">
						</td>
					</tr>

					<tr>
						<td class="col1">키</td>
						<td class="col2"><input type="number" id="users_height"
							name="users_height"></td>
					</tr>

					<tr>
						<td class="col1">몸무게</td>
						<td class="col2"><input type="number" id="users_weight"
							name="users_weight"></td>
					</tr>

					<tr>
						<td class="col1">선호스타일</td>
						<td class="col2">미니멀<input type="checkbox" name="style_no"
							value="미니멀" style="margin-top: 15px">&nbsp;&nbsp;&nbsp;
							이지캐주얼<input type="checkbox" name="looks" value="이지캐주얼">&nbsp;&nbsp;&nbsp;
							비즈니스<input type="checkbox" name="looks" value="비즈니스">&nbsp;&nbsp;&nbsp;
							아메카지<input type="checkbox" name="looks" value="아메카지">&nbsp;&nbsp;&nbsp;
							스트릿<input type="checkbox" name="looks" value="스트릿">&nbsp;&nbsp;&nbsp;
							스포츠<input type="checkbox" name="looks" value="스포츠"><br>
							레트로<input type="checkbox" name="looks" value="레트로">&nbsp;&nbsp;&nbsp;
							댄디<input type="checkbox" name="looks" value="댄디">&nbsp;&nbsp;&nbsp;
							캠퍼스<input type="checkbox" name="looks" value="캠퍼스">&nbsp;&nbsp;&nbsp;
							데일리<input type="checkbox" name="looks" value="데일리"></td>
					</tr>
					<tr>
						<td class="col1">프로필사진</td>
						<td><input type="file" id="uploadFile" name="uploadFile"></td>
						<br>
					</tr>


				</table>
				<br>
				<div class="form-group" style="text-align: center">
					<textarea rows="3" cols="80" name="content" readonly="readonly"></textarea>
					<br>
					<div data-toggle="buttons">
						<input id="agree" type="checkbox" autocomplete="off"> <a>이용약관에
							동의합니다.</a>
					</div>

				</div>

				<div class="create">
					<input class="but4" type="submit" value="회원가입" id="but4">

				</div>
			</div>
		</div>
	</form>
	<!-- Footer-->
	<%@ include file="./inc/footer.jsp"%>

	
</body>
</html>

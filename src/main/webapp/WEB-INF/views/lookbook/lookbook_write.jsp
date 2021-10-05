<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon(인터넷창 아이콘) -->
<link rel="icon" type="image/x-icon"
	href="/resources/assets/favicon.ico" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 룩북 스타일 -->
<link rel="stylesheet" href="../../../resources/css/lookbook.css">

<script type="text/javascript">
	// 업로드한 파일을 바로 읽을수 있도록 하는 메소드
	$(function() {
		$("#upload_file").on('change', function() {
			readURL(this);
		});
	});
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#blah').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	// Lookinfo에 대한 행을 추가
	var arrInput = new Array(0);
	var arrInputValue = new Array(0);
	function addInput() {
		arrInput.push(arrInput.length);
		arrInputValue.push("");
		display();
	}
	function display() {
		document.getElementById('styleInput').innerHTML = "";
		for (intI = 0; intI < arrInput.length; intI++) {
			document.getElementById('styleInput').innerHTML += createInput(
					arrInput[intI], arrInputValue[intI]);
		}
	}
	function saveValue(intId, strValue) {
		arrInputValue[intId] = strValue;
	}
	function createInput(id, value) {
		return "<select id='list_info["+id+"].lookinfo_category' name='list_info["+id+"].lookinfo_category'><option value='0'>-선택-</option><option value='1'>모자</option><option value='2'>상의</option><option value='3'>하의</option><option value='4'>신발</option></select>"
				+ "<input type='text' style='width:80px' id='list_info["+id+"].lookinfo_name' name='list_info["+id+"].lookinfo_name' placeholder='제품명'>"
				+ "<input type='text' id='list_info["+id+"].lookinfo_url' name='list_info["+id+"].lookinfo_url' placeholder='구매처' ><br><br>";
	}
	function deleteInput() {
		if (arrInput.length > 0) {
			arrInput.pop();
			arrInputValue.pop();
		}
		display();
	}
	
</script>
</head>
<body>
	<%@ include file="../inc/header.jsp"%>
	<!-- Section-->
	<br>
	<br>
	<section style="position: relative; text-align: center;">
		<br><br>
		<h3 class="mt-5">나의 룩 작성</h3>
		<hr>
		<div class="mt-5" style="display: inline-block; text-align: center;" >
			<form action="/lookbook/insertLookbook.do" method="post" enctype="multipart/form-data" >
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
				<div class="row" style="text-align: center;">
					<h1 class="display-5 fw-bolder"></h1>
					<br> <img id="blah" src="" height="400px" /><br> <br>
					<div> 
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label for="upload_file" class="btn btn-outline-dark">사진 업로드</label>
					<input type='file' id="upload_file" name="lookbook.uploadFile" accept="image/png, image/jpeg" style="display: none;"/>
					</div>
				</div>
				<div style="text-align: center; ">
					<input type="hidden" name="lookbook.users_no" value="${u.users_no}"> <br>
					<input type="hidden" name="lookbook.lookbook_height"
						value="${u.users_height}"> 
						<input type="hidden"
						name="lookbook.lookbook_weight" value="${u.users_weight}"> 
					<input type="text" class="form-control" placeholder="간단하게 한마디 써주세요"
						name="lookbook.lookbook_write" maxlength="50"><br>
					
					
					
					<div id="styleInput"></div>
					<br> <input class="btn btn-outline-dark" type="button"
						value="+ 옷추가" onclick="addInput();" />&nbsp;&nbsp;&nbsp; <input
						class="btn btn-outline-dark" type="button" value="-"
						onclick="deleteInput();" /> <br>
					<br>



					<div class="ftr" style="text-align: middle;">
						
						<input type="checkbox" name="style_no" value="1">
						미니멀&nbsp; <input type="checkbox" name="style_no" value="2">
						캐주얼&nbsp; <input type="checkbox" name="style_no" value="3">
						비즈니스&nbsp; <input type="checkbox" name="style_no" value="4">
						아메카지&nbsp; <input type="checkbox" name="style_no" value="5">
						스트릿&nbsp; <input type="checkbox" name="style_no" value="6">
						스포츠&nbsp; <input type="checkbox" name="style_no" value="7">
						레트로&nbsp; <input type="checkbox" name="style_no" value="8">
						캠퍼스&nbsp; <input type="checkbox" name="style_no" value="9">
						댄디&nbsp; <input type="checkbox" name="style_no" value="10">
						데일리
					</div>
					<hr>

					<!-- 글쓰기 버튼 생성 -->
					<input type="submit" class="btn btn-outline-dark" value="작성">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" class="btn btn-outline-dark"	value="취소"> 
					
				</div>
			</form>
			<br> <br>
		</div>

	</section>
	<!-- Footer-->
	<%@ include file="../inc/footer.jsp"%>
</body>
</html>
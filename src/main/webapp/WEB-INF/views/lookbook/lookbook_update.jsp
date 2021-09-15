<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<style type="text/css">
.info_table {
	width: 400px;
	margin: auto;
	border-bottom: 1px solid gray;
}

.info_line {
	border-bottom: 1px solid gray;
}
</style>
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
				$('#img').attr('src', e.target.result);
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
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!-- 룩인포 Modal-->
	<div tabindex="-1" class="text-center" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<form action="/lookbook/insertLookbook.do" method="post"
			enctype="multipart/form-data">
			<div role="document">
				<div>
					<h5>수 정</h5>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}"> <img id="img"
					src="/resources/look_img/${look.lookbook_fname}" width="30%">
				<input type='file' id="upload_file" name="lookbook.uploadFile"
					accept="image/png, image/jpeg" /> <br> <br>
				<div class="text-center">

					<br> <br>
					<div class="text-center">
						<table class="info_table">
							<c:forEach var="i" items="${info}">
								<c:choose>
									<c:when test="${i.lookinfo_category == 1}">
										<tr class="info_line">
											<td><img src="/resources/images/cap.png" width=50
												height=50></td>
											<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
										</tr>
									</c:when>
									<c:when test="${i.lookinfo_category == 2}">
										<tr class="info_line">
											<td><img src="/resources/images/shirt.png" width=50
												height=50></td>
											<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
										</tr>
									</c:when>
									<c:when test="${i.lookinfo_category == 3}">
										<tr class="info_line">
											<td><img src="/resources/images/pants.png" width=50
												height=50></td>
											<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
										</tr>
									</c:when>
									<c:when test="${i.lookinfo_category == 4}">
										<tr class="info_line">
											<td><img src="/resources/images/shoe.png" width=50
												height=50></td>
											<td><b>${i.lookinfo_name}</b><br>${i.lookinfo_url}</td>
										</tr>
									</c:when>
								</c:choose>
							</c:forEach>
						</table>


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
					</div>

				</div>

			</div>
		</form>
	</div>
	<!-- 룩인포 Modal끝-->
	<%@ include file="../inc/footer.jsp"%>
</body>
</html>
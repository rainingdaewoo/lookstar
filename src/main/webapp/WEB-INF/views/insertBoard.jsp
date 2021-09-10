<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시물 등록</h2>
<hr>
	<form action="insertBoard.do" method="post"
	enctype="multipart/form-data"
	role="form" method="post" autocomplete="off">
	
	<div class="inputArea"> 
	 <label>게시판 카테고리</label>
	 <select class="board-category">
	  <option value="">자유게시판</option>
	  <option value="">쇼핑후기</option>
	  <option value="">발매정보</option>
	  <option value="">비밀글</option>
	 </select>
	
	</div>
	
	<div class="inputArea">
	 <label for="board_title">제목</label>
	 <input type="text" id="board_title" name="board_title" />
	</div>
	
	
	<div class="inputArea">
	 <textarea rows="5" cols="50" id="gdsDes" name="board_content"></textarea>
	</div>
	
	<div class="inputArea">
	 <button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
	</div>
	
	</form>
</body>
</html>
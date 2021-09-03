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
	enctype="multipart/form-data">

	<input type="hidden" name="board_no" value="${board_no }"> 
	글제목 : <input type="text" name="board_title"><br>
	글내용 : <br>
	<textarea rows="10" cols="80" name="board_content"></textarea><br>
	파일 : <input type="file" name="board_uploadFile"><br>
	<input type="submit" value="등록">
	<input type="reset" value="취소">
</form>
</body>
</html>
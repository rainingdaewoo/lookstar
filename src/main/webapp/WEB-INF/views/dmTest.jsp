<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$("#send").click(function(){
		$("#dm_content").val("");
	});
	
	$(document).ready(function(){	
		setInterval(function(){
			$("#list").empty();
			$.ajax({
				url:"/listChat.do",
				dataType:"json",
				success:function(data){		
					if(data.length>0){
						var row = "";	
						for(var i in data){
							var $dm_no=data[i].dm_no;
							var $from_id=data[i].from_id;
							var $to_id=data[i].to_id;
							var $dm_content=data[i].dm_content;
							var $dm_date=data[i].dm_date;
							var row = row+ "<tr>";
							var row = row+ "<td>"+$from_id+"</td>"
							var row = row+ "<td>"+$to_id+"</td>"
							var row = row+ "<td>"+$dm_content+"</td>"
							var row = row+ "<td>"+$dm_date+"</td>"
							var row = row+ "</tr>";
							
						}
						$("#list").append(row);
					}
				}
			});
		},1000);
	});
	
	/*
	$(window).on('load',function(){	
		setInterval(getDMList,1000);
		function getDmList(){
			$("#list").empty();
			$.ajax({
				url:"/listChat.do",
				dataType:"json",
				success:function(data){					
					if(data.length>0){
						
						for(var i in data){
							var $dm_no=data[i].dm_no;
							var $from_id=data[i].from_id;
							var $to_id=data[i].to_id;
							var $dm_content=data[i].dm_content;
							var $dm_date=data[i].dm_date;
								
							var row = $("<tr/>").append(
										$("<td/>").text($dm_no);
										$("<td/>").text($from_id);
										$("<td/>").text($to_id);
										$("<td/>").text($dm_content);
										$("<td/>").text($dm_date);
							);
							$("#list").append(row);
						}
						
					}
				}
			});
		}
	});
	*/
	
</script>
</head>
<body>

	<h2>채팅하기</h2>
	<iframe id="iframe1" name="iframe1" style="display:none"></iframe>
	<form id="write_form" action="insertDM.do" method="POST" target="iframe1">	
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		작성자: ${u.users_nickname}<br>
		수신자: <input type="text" name="to_id"><br>
		<p>메세지</p> 
		<textarea name="dm_content" rows="10" cols="40"></textarea><br>
		<input type="submit" id="send" value="send">
		<input type="reset" id="reset" value="reset">
	</form>	
	<br>
	<h2>채팅목록</h2>
	<hr>
	<br>

	<div id="output">
		<table border="1" width="80%">
			<thead>
				<tr>
					<th>발신</th>
					<th>수신</th>
					<th>내용</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>
	</div>
</body>
</html>


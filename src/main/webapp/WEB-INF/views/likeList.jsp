<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet" href="css/css.css">
<link rel = "stylesheet" href="css/followList.css"/>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<!-- Section-->
		<div class="board_wrap">
        <div class="board_title">
            <h1><strong>좋아요 목록</strong></h1><hr>
        </div>
        <div class="my-3 p-3 bg-white rounded shadow-sm">
        	<h6 class="border-bottom border-gray pb-2 mb-0">like</h6>
            <div class="media text-muted pt-3">
            	
                <div class="top"> 
                    <div class="like"><a href="likeList.do"><img src="./images/heart.png" width=50 height=50>좋아요</a></div>
                </div>
                <div>
                    <div class="lookbook"><a href="loobookInfo.do"><img src="./images/look1.jpg" width=200 ></a></div>
                    <div class="lookbook"><img src="./images/look2.jpg" width=200 ></div>
                    <div class="lookbook"><img src="./images/look3.jpg" width=200 ></div>
                    <div class="lookbook"><img src="./images/look4.jpg" width=200 ></div>
                    
                </div>
                
                <form class="d-flex">
					
					<!-- 룩인포 Modal-->
					<div class="modal fade" id="testModal" tabindex="-1" role="dialog"
						aria-labelledby="exampleModalLabel" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="exampleModalLabel"><img src="./images/user.png" width=50 height=50><span>@im_esunsin02</span></h5>
									<button aria-label="Close" onclick="myDialog.close()">X</button>

								</div>
								<div class="modal-body">168cm 53kg</div>
								<img src="./images/look1.jpg">
								<div class="modal-footer">
								
									<table class="info_table">
										<tr>
											<td><img src="./images/shirt.png" width=50 height=50></td>
											<td><b>musinsa standard</b><br>
												무지티(블랙)<br>
												25000</td>
										</tr>
										
										<tr>
											<td><img src="./images/pants.png" width=50 height=50></td>
											<td><b>MOOD IN BLUE</b><br>
												블랙진<br>
												45000</td>
										</tr>
										
										<tr>
											<td><img src="./images/shoe.png" width=50 height=50></td>
											<td><b>VANS</b><br>
												코어클래식 체커보드 어센틱<br>
												59000</td>
										</tr>
									</table>
								</div>
							</div>
						</div>
					</div><!-- 룩인포 Modal끝-->
				</form>
              
            </div>
           
        </div>
    </div>
</body>
</html>
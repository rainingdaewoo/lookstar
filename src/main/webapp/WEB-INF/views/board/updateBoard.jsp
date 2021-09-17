<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Favicon(인터넷창 아이콘) -->
<link rel="icon" type="image/x-icon"
	href="../../resources/assets/favicon.ico" />
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- 게시판 스타일 -->
<link rel="stylesheet" href="../../resources/css/board_css/board.css">
<!-- CK editor5 -->
<script src="https://cdn.ckeditor.com/ckeditor5/29.2.0/classic/ckeditor.js"></script>


<script type="text/javascript">
	
    $(function() {
        $("#board_uploadFile").on('change', function(){
            readURL(this);
        });
    });
    function readURL(input) {
        if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }
          reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</head>
<body>
	<%@ include file=".././inc/header.jsp"%>
	<!-- Section-->
	<br>
	<br>
	<section style="position: relative; text-align: center;">
		<br>
		<h3 class="mt-5">게시글 작성</h3><hr>
		<div class="align-items-center">
			<form action="updateBoard.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<input type="hidden" name="users_no" value="${users.users_no}"> <br>	
			<input type="hidden" name="board_no" value="${b.board_no }"> <br>
				<div class="container-sm">
		    <div class="content" style="width: 120%">
		    
		        <div class="row justify-content-md-center">
		            <div class="col-sm-4" id="inputCategory">
		                <div class="input-group mb-3">
		                    <select class="custom-select" id="inputGroupSelect03" name="board_category_no">
								 <option value="0">자유게시판</option>
								 <option value="1">쇼핑후기</option>
								 <option value="2">발매정보</option>
								 <option value="3">비밀글</option>
							 </select>
		                </div>
		            </div> 
		            <div class="col-sm-9">
		            <div class="input-group mb-3">
		                <div class="input-group-prepend">
		                    <label class="input-group-text">제목</label>
						 <input class="form-control" type="text" id="board_title" name="board_title" value="${b.board_title }"/>
		                  </div>            
		                </div>
		            </div>
		      </div>
		      
		      <hr>
		      
		      <div class="row justify-content-md-center">
		          <div class="col_c" style="margin-bottom: 30px">
		                <div class="input-group">                 
		                  <textarea id="input_board_content" name="board_content" > ${b.board_content }</textarea>
		                  <script>
		                  ClassicEditor
		                  .create( document.querySelector( '#input_board_content' ), {
		                      cloudServices: {
		                          tokenUrl: 'https://83434.cke-cs.com/token/dev/29019a7e76fb96313a55a0920566c2ef06dd305ef16a3efd387205aee0ba',
		                          uploadUrl: 'https://83434.cke-cs.com/easyimage/upload/'
		                      }
		                  } )
		                 .catch( error => {
				            console.error( error );
				        } );
							</script>
		                </div>
		            </div> 
		      </div>
		        <div class="uploadFile">
		            <div class="input-group mb-3">
		              <div class="input-group-prepend">
		                <span class="input-group-text" id="inputGroupFileAddon01">첨부파일</span>
		              </div>
		              <div class="custom-file">
		                  &nbsp; <input type='file' class="form-control-file" id="board_uploadFile" name="board_uploadFile" accept="image/png, image/jpeg"/>
		              </div>
		            </div>
		      </div>
		      <div class="row justify-content-md-center">
		        <button type="submit" class="btn btn-outline-secondary" style="width: 20%; font-weight: bold">
		             등   록          
		            </button>
		        </div>
		  </div>
		</div>
			</form>
			<br><br>
		</div>

	</section>
	<!-- Footer-->
	<%@ include file=".././inc/footer.jsp"%>
</body>
</html>
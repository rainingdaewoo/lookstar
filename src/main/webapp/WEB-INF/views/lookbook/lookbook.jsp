<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<!-- 룩북 스타일 -->
<link rel="stylesheet" href="/resources/css/lookbook.css">
<!-- 버튼 부트스트랩 -->
<script type="text/javascript"
   src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 값슬라이더 -->

<script type="text/javascript">
   $(function() {      
	
	  let selected_style= ['1','2','3','4','5','6','7','8','9','10'];
      let sortField="NEW";
      let weight_low=0;
      let weight_high=150;
      let height_low=0;
      let height_high=220;
      
      $("#firstclick").trigger("click");
      $("#firstclick").trigger("click");
	 
      listLookbook();
      // 스타일, 키, 몸무게의 변수를 전역변수로.. 
      function listLookbook() {
    	  let data ={arr:selected_style,weight_low:weight_low,weight_high:weight_high,height_low:height_low,height_high:height_high,sortField:sortField};
    	  console.log("data값:" + data);
    	  $.each(data,function(i,item){
    		  console.log(i+":"+item);
    	  });
    	  
    	  $.ajax({
              url:"/lookbook/ListLookbook.do",
              data:data,
              success:function(list){
                 console.log(list);
                 $("#lookbookimage").empty();
                 $.each(list, function(index,item){
                	if(item.lookbook_show == 0){
                		let img = $("<div class='col mb-5'><div class='card h-100 justify-content-center'><a href='lookbook_detail.do?lookbook_no="+item.lookbook_no + "'><img class='card-img-top' src='/resources/look_img/"+item.lookbook_fname+"' style='height: 100%; width: 100%;' /></a></div></div>");
                		$("#lookbookimage").append(img);
                	}                    
                    
                 });
              }
           });
    	  
		}
      
      // 분류기준(HOT/NEW) 선택
      $(".sortField").click(function(){
    	  sortField = $(this).text();
    	  console.log(sortField);
    	  listLookbook();
      })
      
      // 스타일 선택 
      $(".unchosenF").each(function(i){
         $(this).attr("style_no",i+1);
      });
      $(".unchosenF").click(function() {
         $(this).toggleClass("chosenF");
         let list = $(".chosenF");
         selected_style = [];
         
         $.each(list,function(index, item){
            let style_no = $(item).attr("style_no");
            selected_style.push(style_no);               
         });
         
         listLookbook();
         
      });
      
      
      $(".bodyspec").change(function() {
    	  let getWeight = $("#weight option:selected").val();
    	  let arrayWeight = getWeight.split("~");
    	  weight_low = arrayWeight[0];
    	  weight_high = arrayWeight[1];
          
    	  let getHeight = $("#height option:selected").val();
    	  let arrayHeight = getHeight.split("~");
    	  height_low = arrayHeight[0];
    	  height_high = arrayHeight[1];
       
         
          
          listLookbook();
    	 }
     );
     
   });
</script>
</head>
<body>
   <%@ include file="../inc/header.jsp"%>
   <!-- Body Section -->
   <br>
   <br>
   <br>
   <br>
   <br>
   <br>
   
   <section id="content">
      <!-- 스타일필터와 검색 -->
      <div class="ftr" style="justify-content: center">
         <span class="sortField">NEW</span>&nbsp; 
         <span class="sortField">HOT</span>&nbsp; 
            
            
         <span class="unchosenF" id="firstclick">미니멀</span>&nbsp; 
         <span class="unchosenF">캐주얼</span>&nbsp;
         <span class="unchosenF">비즈니스</span>&nbsp; 
         <span class="unchosenF">아메카지</span>&nbsp;
         <span class="unchosenF">스트릿</span>&nbsp; 
         <span class="unchosenF">스포츠</span>&nbsp;
         <span class="unchosenF">레트로</span>&nbsp; 
         <span class="unchosenF">캠퍼스</span>&nbsp;
         <span class="unchosenF">댄디</span>&nbsp; 
         <span class="unchosenF">데일리</span>

      </div>
      <!-- 신체 필터/검색 -->
      <div class="FnS">
      <!-- 
         <form class="navbar-form pull-left" style="float: right;">
            <button class="btn dropdown-toggle" data-toggle="dropdown">
               <span id="searchF">작성자</span>
            </button>
            <div class="dropdown-menu" id="dropdown-search">
               <a class="dropdown-item">작성자</a> <a class="dropdown-item">내용</a>
            </div>
            <input type="text" style="width: 200px;">
            <button type="submit" class="btn btn-outline-dark">검색</button>
         </form>*/
      -->
         <div style="float: left; padding-left: 50px">
            키: <select name="height" id="height" class="bodyspec">
                  <option value="0~230" selected>-선택-</option>
                  <option value="140~150">140~150</option>
                  <option value="151~160">151~160</option>
                  <option value="161~170">161~170</option>
                  <option value="171~180">171~180</option>
                  <option value="181~190">181~190</option>
                  <option value="191~230">190이상</option>
               </select>
         </div>
         <!-- 키 필터 -->
         <div style="float: left; padding-left: 50px" class="bodyspec">
            몸무게: <select name="weight" id="weight">
                  <option value="0~150" selected>-선택-</option>
                  <option value="41~50">41~50</option>
                  <option value="51~60">51~60</option>
                  <option value="61~70">61~70</option>
                  <option value="71~80">71~80</option>
                  <option value="81~90">81~90</option>
                  <option value="91~100">91~100</option>
                  <option value="101~150">100 이상</option>
               </select>
         </div>

      </div>
      <!-- 몸무게 필터 -->

      <br> <br>
      <hr>
      <div class="center-block px-4 px-lg-5 mt-5 justify-content-center">
         <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"  id="lookbookimage">

         </div>
         <!-- 글쓰기 버튼 -->
         <a href="/lookbook/lookbook_write.do" class="btn btn-outline-dark pull-right">글쓰기</a>
      </div><br><br><br>
   </section>


   <%@ include file="../inc/footer.jsp"%>
</body>
</html>
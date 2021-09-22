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
   $(function(){

      // 팔로우, 언팔로우 버튼
      
      let follower_id = $('#follower_id').val();
      let following_id = $('#following_id').val();   
      // 팔로우 클릭시
      $("#follow").click(function(){
         let data = {
               follower_id:follower_id,    //a
               following_id:following_id   //b            
         }
         
         console.log("팔로우 클릭:"+data.follower_id);
         console.log("팔로잉 아이디:"+data.following_id);

         $.ajax({
            url:'/insertFollow.do',
            data: data,
            success:function(data){
               console.log(data);
            }
         });
      });
      // 언팔로우 클릭시
      $("#unfollow").click(function(){
         let data = {
               follower_id:follower_id,    //a
               following_id:following_id   //b            
         }
         
         console.log("팔로우 클릭:"+data.follower_id);
         console.log("팔로잉 아이디:"+data.following_id);

         $.ajax({
            url:'/deleteFollow.do',
            data: data,
            success:function(data){
               console.log(data);
            }
         });
      });   
      
      
      
      let users_no=$('#users_no').val();
      let lookbook_no=$('#lookbook_no').val();
      
      $("#likelook").click(function(){
         let data = {
               users_no:users_no,
               lookbook_no:lookbook_no
         }
         console.log("좋아요 누른 회원:"+data.users_no);
         console.log("좋아요할 게시물번호:"+data.lookbook_no);

         $.ajax({
            url:'/insertLooklike.do',
            data: data,
            success:function(data){
               console.log(data);
            }
         });
      })
      
      
      $("#offlikelook").click(function(){
         let data = {
               users_no:users_no,
               lookbook_no:lookbook_no
         }
         console.log("좋아요 누른 회원:"+data.users_no);
         console.log("좋아요할 게시물번호:"+data.lookbook_no);

         $.ajax({
            url:'/deleteLooklike.do',
            data: data,
            success:function(data){
               console.log(data);
            }
         });
      })      
      
      
      
      
      $(".follow,.heartlook").click(function(){
         location.reload();
      })
      
      console.log()
   });
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
      
      <div role="document">
         <div>
            <div>
               <h5>
                  
                  <c:choose>
                     <c:when test="${write_u.users_fname==null && write_u.users_no!=u.users_no}">
                        <a href="/dmTest02.do?users_id=${write_u.users_id }&users_fname=${write_u.users_fname }&users_nickname=${write_u.users_nickname}&lookbook_no=${look.lookbook_no}"> 
                           <img src="/resources/images/user.png" width=50 height=50>
                        </a>
                     </c:when>
                     <c:when test="${write_u.users_fname==null && write_u.users_no==u.users_no}">
                         
                           <img src="/resources/images/user.png" width=50 height=50>
                        
                     </c:when>
                     
                     <c:when test="${write_u.users_fname!=null && write_u.users_no!=u.users_no}">
                        <a href="/dmTest02.do?users_id=${write_u.users_id }&users_fname=${write_u.users_fname }&users_nickname=${write_u.users_nickname}&lookbook_no=${look.lookbook_no}"> 
                           <img src="/resources/profile/${write_u.users_fname}" class="rounded-circle" width=50 height=50>
                        </a>
                     </c:when>
                     <c:when test="${write_u.users_fname!=null && write_u.users_no==u.users_no}"> 
                           <img src="/resources/profile/${write_u.users_fname}" class="rounded-circle" width=50 height=50>
                     </c:when>
                  </c:choose>
                  &nbsp;&nbsp;&nbsp;${write_u.users_nickname}<span></span>
                  &nbsp;&nbsp;&nbsp;&nbsp;
                     <input type="hidden" id="follower_id" name="follower_id" value="${u.users_id}">
                     <input type="hidden" id="following_id" name="following_id" value="${write_u.users_id}">
                     <input type="hidden" id="users_no" name="users_no" value="${u.users_no}">
                     <input type="hidden" id="lookbook_no" name="lookbook_no" value="${look.lookbook_no}">
                     
                              
               </h5>
               <div class="follow">
               </div>
                  <c:choose>
                     <c:when test="${look.users_no == u.users_no}">
                     </c:when>
                     <c:when test="${u.users_no==null}">
                     </c:when>
                     <c:when test="${followBtn!=1}">
                        <a class="btn btn-outline-dark follow" id="follow">팔로우</a>                        
                     </c:when>
                     <c:when test="${followBtn==1}">
                        <a class="btn btn-outline-dark follow" id="unfollow">언팔로우</a>
                     </c:when>
                  </c:choose>         
            </div>
         </div>
         <div>
            <b>${look.lookbook_height}cm ${look.lookbook_weight}kg</b>
         </div>
         
         <img src="/resources/look_img/${look.lookbook_fname}" width="30%">
         <br>
         <br>
         <div class="text-center">
            <div>
               <!-- 로그인 상태가 아니거나 좋아요 상태가 아닐시 빈 하트/ 좋아요 눌렀을 시 꽉찬하트 -->
               <c:choose>
                  <c:when test="${isLooklike==0}">
                     <img class="heartlook" id="likelook" src="/resources/images/heart_empty.png" height=50 width=50>
                  </c:when>
                  <c:when test="${isLooklike!=0}">
                     <img class="heartlook" id="offlikelook" src="/resources/images/heart.png" height=50 width=50>
                  </c:when>
               </c:choose>
               &nbsp;&nbsp;&nbsp;
               <b>${likelookCount}</b>
            </div>
            <br>
            <br>
            <div class="text-center">
               <h4>${look.lookbook_write}</h4>
               <br>
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
               <br><br><br>
               <c:choose>
                  <c:when test="${look.users_no == u.users_no}">
                     <a href="/lookbook/lookbook_update.do?lookbook_no=${look.lookbook_no}"><button type="button"
                           class="btn btn-outline-dark a_not_blue">수정</button></a>

                     <a href="/lookbook/deletelookbook.do?lookbook_no=${look.lookbook_no}" class="btn btn-outline-dark a_not_blue" id="deleteLookbook">삭제</a>
                  </c:when>
               </c:choose>
            </div>

         </div>

      </div>
      <br> <br>
   </div>
   <!-- 룩인포 Modal끝-->
   <%@ include file="../inc/footer.jsp"%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 네비게이션 바 -->
	<%@ include file="../common/menubar.jsp"%>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
			<div class="container">
			
			
			      <caption> <h2>얼마전에 신청했는데요</h2> </caption>
        </thead>
        <hr>
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
	 <table>
    <tr>
      <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
      <td align="center" width="76">작성자 : </td>     
      <td width="0">옆집드론</td>  
      
      <td align="center" width="76">조회수 : </td>      
      <td width="0"><b>231</b></td>	
      
      <td align="center" width="76">작성일 : </td>      
      <td width="0"><b>18.11.30 10:35</b></td>
     </tr>
     </table>
			   <div class="form-group">
			  <hr>
			  <div class="form-group" >
			  	<label ><h6>문의분류 : </h6></label>
				<input type="radio" name="문의" value="문의" checked="checked" disabled>문의.
			    <input type="radio" name="신고" value="신고" disabled>신고
			  </div>
			    <label ><h6>문의 내용</h6></label>
			   <textarea class="form-control" readonly rows="10"  id="comment" placeholder="내용을 입력해 주세요" readonly>
문의했었는데요 지금 같은 상황에는 어떻게 해야되는제 알려주세요		   </textarea>
			  </div>
			  <hr>
			<div style="margin:0px 0px 0px 900px; margin-right:20px; ">	
			<% if(loginUser !=null && loginUser.getMemberAdmin() == 1) {%>
				<button class="btn btn-default"  onclick="location.href='./QNA.jsp'">돌아가기</button>
			  	<button class="btn btn-default" onclick="location.href='./qnaUpdate.jsp'">적용</button>
			<% }else{ %>
			  	<button  class="btn btn-default"  onclick="location.href='./QNA.jsp'">목록</button>
			  	<button class="btn btn-default" onclick="location.href='./qnaUpdate.jsp'">수정</button>
			  	<button class="btn btn-default"  onclick="location.href='./QNA.jsp'">삭제</button>
			<% } %>
			 </div> 
			<form action="" method="post" name="">
			<font size="3" color="red">댓글 1</font>
			<br><br>
				<hr>
			</form>
			
			            <table style="width: 600px;">
               <tr>
                  <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;"><span>18.12.02
                        14:02</span> 
                  </span></td>
               </tr>
               <tr>
                  <td>
                     <div>
                        <b>관리자</b>
                     </div>
                     <div>문의해주신 내용은 잘 봤습니다. 해당 문의내용은 저희 운영진이 운영방침에 맞게 조치를 취하겠습니다. 그럼 오늘도 즐거운 하루 되세요
                     </div>
                  </td>
               </tr>
            </table>
			<hr>
			<br>
			<br>
				
	</div>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
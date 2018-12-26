<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.board.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>

</style>
</head>
<body>
 <!-- 네비게이션 바 -->
<%-- 		<%@ include file = "../common/navi.jsp" %> --%>
		<%@ include file = "../common/naviLogin.jsp" %>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
<div class="container">
			
			<form>
			      <caption> <h2><%= b.getBoardTitle() %></h2> </caption>
        </thead>
        <hr>
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
	 <table>
    <tr>
      <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
      <td align="center" width="76"  ><b><%= b.getBoardNo() %></b></td>     
      <td width="50"></td>  
      
      <td align="center" width="76" ">조회수 : </td>      
      <td width="50"><b><%= b.getBoardCount() %></b></td>	
      
      <td align="center" width="76">작성일 : </td>      
      <td width="150"><b><%= b.getBoardDate() %></b></td>
     </tr>
     </table>
     <hr>
            			 
			   <textarea class="form-control" readonly rows="10"  id="comment" >
			   		<p><%= b.getBoardContext() %></p>
			   </textarea>	
			                     
               </p>
            
   	<hr>
     <div class="form-group">
			  
			<form action="" method="post" name="">
			<font size="4" color="red">댓글 2</font>
      
			<div style="margin:0px 0px 0px 800px; margin-right:10px; ">	
			  <a href="<%=request.getContextPath()%>/selectList.bo" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">목록으로</a>
			  <a href=
			  "<% if(loginUser != null 
				&& loginUser.getUserId().equals(b.getbWriter())){ %>" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">수정</a>
				<% } %>
			  <a href="board.jsp" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">삭제</a>
			 </div> 
				<hr>
			</form>
			</div>	
			</table>
			<br><br>
			<!-- 댓글 란 -->
			  <table style="width: 300px;">			       
               <tr>
                  <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;"><span>18.11.29
                        17:02</span> 
                  </span></td>
               </tr>
               <tr>
                  <td>
                     <div>
                        <b>yes1231</b>
                     </div>
                     <div>긴 글 잘읽었습니다. 퍼가요
                     </div>
                  </td>
               </tr>
            </table> 
            	<hr>  
            	  <table style="width: 300px;">			       
               <tr>
                  <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;"><span>18.12.1
                        11:42</span> 
                  </span></td>
               </tr>
               <tr>
                  <td>
                     <div>
                        <b>아는사람</b>
                     </div>
                     <div>좋은글이네요 퍼갑니다
                     </div>
                  </td>
               </tr>               
            </table>                      
			<hr>
			<div class="input-group mb-3">
			  <input type="text" class="form-control" placeholder="댓글을 입력하세요" aria-label="Recipient's username" aria-describedby="button-addon2">
			  <div class="input-group-append">
			    <button class="btn btn-outline-secondary" type="button" id="button-addon2">댓글 등록</button>
			  </div>
			</div>			
			<br>
			<br>
		
		
		</table>
	</table>
		</form>
		</div>
		<br>
		<br><br>
		<br>
		<hr>
		<br>
		<br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
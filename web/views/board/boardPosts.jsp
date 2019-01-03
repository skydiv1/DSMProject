<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.board.model.vo.*" import="com.kh.w7.reply.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
	Member m = (Member)request.getAttribute("m");
	Reply r = (Reply)request.getAttribute("r");
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
	<%@ include file="../common/menubar.jsp"%>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
<div class="container">
		<caption><h2><span><b><%=b.getBoardTitle() %></b></span> </td></h2> </caption>
        <hr>
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
	 <table>
    <tr>
      <!-- <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td> -->
      <td align="center" width="76"  ><span><b><%=b.getMemberName() %></b></span> </td>     
      <td width="50"></td>  
      
      <td align="center" width="76" ">조회수 : </td>      
      <td width="50"><span><b><%=b.getBoardCount() %></b></span> </td>	
      
      <td align="center" width="76">작성일 : </td>      
      <td width="150"><span><b><%=b.getBoardDate() %></b></span> </td>
     </tr>
     </table>
     <hr>
     	<textarea class="form-control" readonly rows="10"  id="comment" ><%= b.getBoardContext() %></textarea>    	  
   	<hr>
     <div class="form-group">  
			<form action="" method="post" name="">      
			<div style="margin:0px 0px 0px 800px; margin-right:10px; ">	
			   <%-- <% if(loginUser != null && loginUser.getMemberCode() == b.getMemberCode()){ %> --%>
			  <a href="<%=request.getContextPath()%>/selectList.bo" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">목록으로</a>			  
			   <% if(loginUser != null && loginUser.getMemberName().equals(b.getMemberName())){ %> 			  	  
			  <a href="<%=request.getContextPath()%>/selectBoard.bo?num=<%=b.getBoardNo()%>"class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">수정</a>			  	
			   <% } %>
				
			 </div> 
				<hr>
			</form>
				
			</table>
			<br><br>
					
	<%-- 		<div>
			<div class="w7-border w7-padding">댓글</div>
			<div class="w7-border w7-padding">
				<c:if test="${ loginUser = null }">
					<textarea rows="5" cols="50" class="w7-input w7-border newLogin" readonly>로그인 후 댓글 달기</textarea>
				</c:if>
				<c:if test="${ loginUser != null }">
					<i class="fa fa-user w3-padding-16"></i> ${ content.id }
					<form>
						<input type="hidden" name="no" id="no" value="${ content.board_no }"> 
						<input type="hidden" name="id" id="id" value="${ id }">
						<textarea rows="5" cols="50" class="w3-input w3-border" placeholder="댓글 작성" name="reply_content" id="reply_content"></textarea>
						<input type="button" class="w3-button w3-border" id="reply_btn" value="댓글 등록">
					</form>
				</c:if>
			</div>
			<div>
				<div class="w3-border w3-padding">댓글목록(<i class="fa fa-commenting-o"></i> <span class="reply_count"></span>)</div>
				<div id="replyList"></div>
			</div>
		</div> --%>
	</div>
			
			
			
			
			
			
			
			
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
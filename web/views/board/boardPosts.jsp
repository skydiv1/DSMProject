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
			<div style="margin:0px 0px 0px 800px; margin-right:10px; ">	
			   <%-- <% if(loginUser != null && loginUser.getMemberCode() == b.getMemberCode()){ %> --%>
			  <a href="<%=request.getContextPath()%>/selectList.bo" class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">목록으로</a>			  
			   <% if(loginUser != null && loginUser.getMemberName().equals(b.getMemberName())){ %> 			  	  
			  <a href="<%=request.getContextPath()%>/selectBoard.bo?num=<%=b.getBoardNo()%>"class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">수정</a>			  	
			   <% } %>
			 </div> 
			 <hr>   	
			<%-- <div class="replyArea">
				<div class="replyWriterArea">
				<table align="center">
					<tr>
						<td><textarea rows="3" cols="80" id="replyContext"></textarea></td>
						<td><button class="btn btn-secondary btn-lg active" id="addReply">댓글 등록</button></td>
					</tr>
				</table>
				</div>
			<div id="replySelectArea">
				<table id="replySelectTable" border="1" align="center"></table>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			$("#addReply").click(function(){
				var BoardNo = <%= r.getBoardNo() %>;
				var MemberCode = <%= loginUser.getMemberCode() %>;
				var context = $("#replyContext").val();
				
				$.ajax({
					url:"/dsm/insertReply.re",
					data:{ BoardNo:BoardNo, MemberCode:MemberCode, Context:Context},
					type:"post",
					success:function(data){
						console.log(data);
							
						var $replySelectTable = $("#replySelectTable");
						$replySelectTable.html('');
						
						for(var key in data){
							var $tr = $("<tr>");
							var $MemberCodeTd = $("<td>").text(data[key].memberCode).css("width","100px");
							var $ContextTd = $("<td>").text(data[key].replyContext).css("width","400px");
							var $ReplyDateTd = $("<td>").text(data[key].replyDate).css("width", "200px");
							
							$tr.append($MemberCodeTd);
							$tr.append($ContextTd);
							$tr.append($ReplyDateTd);
							$replySelectTable.append($tr);
						}
						
						
					},
					error:function(){
						console.log(실패);
					}
				});
			});
		});
	</script> --%>
	<br><br>
	<br>
	<br>
	<br>
	<br>
				
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
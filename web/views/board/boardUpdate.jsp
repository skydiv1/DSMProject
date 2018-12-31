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
</head>
<body>
 <!-- 네비게이션 바 -->
	<%@ include file="../common/menubar.jsp"%>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
<div class="container">
			
        <div class="form-group">
			 <caption> <h1>게시글 수정</h1> </caption>
				<form action="<%= request.getContextPath() %>/updateBoard.bo" method="post">
	        	<hr>
	        	<thead>
			  <div class="form-group">
			    <label ><h3>제목 : &nbsp;</h3></label>
			    <h7><input type="text" style="width:300px" name="Boardtitle" placeholder="제목을 입력해 주세요" value="<%= b.getBoardTitle() %>"></h7>
			  	<input type="hidden" name="BoardNo" value="<%= b.getBoardNo() %>"> 
			  </div>
			  <hr>
   			 </thead>
			  <hr>
		 
			<td><h4><label>작성자 : &nbsp;</label><span><b><%=loginUser.getMemberName()%></b></span></h4>
				<input type="hidden" value="<%=loginUser.getMemberCode()%>" name="memberCode">
			</td>
			<hr>			
			    <label ><h3>내용 </h3></label>
			<hr>
			  <div class="form-group">
			    <textarea name="BoardContext" type="context" cols="60" rows="15" name="content" placeholder="내용을 입력해 주세요" value="<%= b.getBoardContext() %>"></textarea>
			  </div>
        
        
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
	
   	<hr>      
			<div style="margin:0px 0px 0px 870px; margin-right:10px; ">	
		
			  <button class="btn btn-default onclick="complet()">수정완료</button>

			  <button class="btn btn-default onclick="location.href='<%=request.getContextPath()%>/selectOne.bo?num=<%=b.getBoardNo() %>'">취소</button>
			  
			  <button class="btn btn-default onclick="deleteBoard()">삭제하기</button>			  
			 </div> 
			 <script>
			 	$(function complet(){
			 		$("#updateForm").attr("action", "<%=request.getContextPath()%>/updateBoard.bo");
			 	});
			 	
			 	$(function deleteBoard(){
			 		$("#updateForm").attr("action", "<%=request.getContextPath()%>/deleteBoard.bo");
			 	});
			 	
			 	
			 </script>
				<hr>
			
			 </form>
				</div>
</div>			
	
		<br>
		<br>
		<br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
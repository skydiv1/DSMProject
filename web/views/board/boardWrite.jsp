<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.board.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
	Member m = (Member)request.getAttribute("m");
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
	<% if(loginUser != null ){ %>
		<div class="outer">
			<form action="<%= request.getContextPath() %>/insert.bo" method="post">
			<div class="container">
	        <caption> <h1>게시글 작성</h1> </caption>
	        <hr>
			  <div class="form-group">
			    <label ><h3>제목 : &nbsp;</h3></label>
			    <h7><input type="text" name="title" placeholder="제목을 입력해 주세요"></h7>
			  </div>
			  <hr>
   			<td><h4><label>작성자 : &nbsp;</label><span><b><%=loginUser.getMemberName()%></b></span></h4></td>
				<input type="hidden" value="<%=loginUser.getMemberCode()%>" name="memberCode">			
			<hr>
			 <td align="center" width="76">작성일 : </td>
			<hr>			
			    <label ><h3>내용 </h3></label>
			<hr>
			  <div class="form-group">
			    <textarea name="context" type="context" cols="60" rows="15" name="content" placeholder="내용을 입력해 주세요"></textarea>
			  </div>
			  <hr>
			  <div style="margin:0px 0px 0px 900px; margin-right:10px; ">	
		  	    <button type="reset">취소하기</button>
				<button type="submit">등록하기</button>
			  </div>
			<br>
			<hr>
			<br>	
			</form>
		</div>
	</div>
	<% }else{
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
		
	} %>
	
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
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
	<% if(loginUser != null ){ %>
		<div class="outer">
			<form action="<%= request.getContextPath() %>/insert.bo" method="post">
			<div class="container">
			<thead>
        <caption> <h2>글쓰기</h2> </caption>
   			 </thead>
   			 <hr>
   			 <td id="title">작성자</td>
   			<td>
				<input type="text" value="<%=loginUser.getMemberName()%>" name="memberName" readonly>
				<input type="hidden" value="<%=loginUser.getMemberCode()%>" name="memberCode">
			</td>
			
			  <div class="form-group">
			    <label ><h3>제목 :</h3></label>
			    <input type="title" name="title" placeholder="제목을 입력해 주세요">
			  </div>
			  <hr>
			  
			  <hr>
			  <div class="form-group">
			    <label ><h3>내용 :</h3></label>
			    <textarea type="text" rows="10" name="content" placeholder="내용을 입력해 주세요"></textarea>
			  </div>
			  <hr>
			  <div style="margin:0px 0px 0px 980px; margin-right:10px; ">	
			  	<!-- <button onclick="location.href='./board.jsp'">취소</button>
			  	<button  onclick="location.href='./board.jsp'">수정</button> -->
		  	    <button type="reset">취소하기</button>
				<button type="submit">등록하기</button>
			  </div>
			</form>
			</div>
			<br>
			<hr>
			<br>	
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
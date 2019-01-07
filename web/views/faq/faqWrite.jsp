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
			<div class="container">
			
			<form id="updateForm" method="post">
			  <div class="form-group">
			    <label ><h2>문의하기</h2></label>
			    <input type="text" name="title" class="form-control"  placeholder="제목">
			  </div>
			  <td>
              <h4>
              <label>작성자 : &nbsp;</label>
              <span>
                 <b><%=loginUser.getMemberName()%></b>
	          </span>
		    </h4>
			</td>
			  <input type="hidden" value="<%=loginUser.getMemberCode()%>" name="memberCode">
			  <hr>
			  <div class="form-group">
			  	<label ><h6>문의분류 : </h6></label>
				<input type="radio" name="문의" value="문의" checked="checked">문의
			    <input type="radio" name="신고" value="신고">신고
			  </div>
			  <hr>
			  <div class="form-group">
			    <label ><h6>문의 내용</h6></label>
			    <textarea class="form-control" name="context" rows="15" id="context" placeholder="내용"></textarea>
			  </div>
			<div style="margin:0px 0px 0px 980px; margin-right:10px; ">	
			  <button class="btn btn-default" onclick="complet()">확인</button>
			  <button class="btn btn-default" onclick="cancel()">취소</button>
			 </div>
				</form> 
			  <script>
                function complet(){
					$("#updateForm").attr("action", "<%=request.getContextPath()%>/insert.faq");
				}
                function cancel(){
					$("#updateForm").attr("action", "<%=request.getContextPath()%>/selectFaqList.faq");
				}
                </script>
				<hr>
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
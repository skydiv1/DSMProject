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
<%-- 		<%@ include file = "../common/navi.jsp" %> --%>
		<%@ include file = "../common/naviLogin.jsp" %>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
			<div class="container">
			
			<form>
			  <div class="form-group">
			    <label ><h2>문의하기</h2></label>
			    <input type="text" class="form-control"  placeholder="제목">
			  </div>
			  <hr>
			  <div class="form-group">
			  	<label ><h6>문의분류 : </h6></label>
				<input type="radio" name="문의" value="문의" checked="checked">문의
			    <input type="radio" name="신고" value="신고">신고
			  </div>
			  <hr>
			  <div class="form-group">
			    <label ><h6>문의 내용</h6></label>
			    <textarea class="form-control" rows="15" id="comment" placeholder="내용"></textarea>
			  </div>
			</form>
			<div style="margin:0px 0px 0px 980px; margin-right:10px; ">	
			  <button class="btn btn-default"  onclick="location.href='./qnaPosts.jsp'">등록</button>
			  <button class="btn btn-default"  onclick="location.href='./QNA.jsp'">취소</button>
			 </div> 
				<hr>
			</div>	
	</div>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
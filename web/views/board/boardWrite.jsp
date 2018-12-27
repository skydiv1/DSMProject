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
			<thead>
        <caption> <h2>글쓰기</h2> </caption>
   			 </thead>
   			 <hr>
			<form>
			  <div class="form-group">
			    <label ><h3>제목 :</h3></label>
			    <input type="text" class="form-control"  placeholder="제목을 입력해 주세요">
			  </div>
			  <hr>
			  <div class="input-group">
			  <div class="custom-file">
			    <input type="file" class="custom-file-input" id="" >
			    <label class="custom-file-label" >파일을 선택해주세요</label>
			  </div>
			  </div>
			  <hr>
			  <div class="form-group">
			    <label ><h3>내용 :</h3></label>
			    <textarea class="form-control" rows="10" id="comment" placeholder="내용을 입력해 주세요"></textarea>
			  </div>
			  <hr>
			  <div style="margin:0px 0px 0px 980px; margin-right:10px; ">	
			   <button class="btn btn-default"  onclick="location.href='./board.jsp'">취소</button>
			  <button class="btn btn-default"  onclick="location.href='./board.jsp'">수정</button>
			  </div>
			</form>
			</div>
			<br>
			<hr>
			<br>	
	</div>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
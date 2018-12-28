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
		<div class="container">
			<div id="faq" data-obj-id="FAQ" data-obj-type="element" data-text-editable="true" style="position: relative;width:100px; float:left; margin:10px;";  width: 128px; height: 44px;>
                <a href="/dsm/views/faq/FAQ.jsp"><div style="font-size: 18px; color: rgb(0, 0, 0); text-align: center; line-height: 2.5em; background-color: rgb(255, 255, 255); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: bold;">FAQ</div>
                </a>
            </div>
            <div id="qna" data-obj-id="QNA" data-obj-type="element" data-text-editable="true" style="position: relative;width:100px; float:left; margin:10px;" width: 136px; height: 44px;>
                <a href="./QNA.jsp"><div style="font-size: 18px; color: rgb(255, 255, 255); text-align: center; line-height: 2.5em; background-color: rgb(127, 127, 127); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: normal;">Q&amp;A</div>
                </a>
            </div>
            <div><a href="qnaWrite.jsp" class="btn btn-primary" style="position: relative; margin:10px 10px 10px 10px; float:right; width: 136px; height: 44px; ">문의하기</a></div>
			
		<div>
		 	<table class="table table-striped" style="text-align:center; border:1px; solid #dddddd">
		 		
					<tr>
						<th style="width: 6%; background-color:#eeeeee; text-align: center;">분류</th>
						<th style="width: 30%; background-color:#eeeeee; text-align: center;">제목</th>
						<th style="width: 10%; background-color:#eeeeee; text-align: center;">작성자</th>
						<th style="width: 10%; background-color:#eeeeee; text-align: center;">작성일</th>
						<th style="width: 6%; background-color:#eeeeee; text-align: center;">조회수</th>
					</tr>		 		
		 		
		 	<%-- 			<% for(Board b : list){ %>
		 				<tr>		 				                      
                            <td><%= b.getBoardNo() %></td>
                            <td><%= b.getMemberCode() %></td>
                            <td><%= b.getBoardTitle() %></td>
                            <td><%= b.getBoardContext() %></td>
                            <td><%= b.getBoardDate() %></td>
                            <td><%= b.getBoardCategory() %></td>
                            <td><%= b.getBoardCount() %></td>
                            
                        </tr>
                <% } %> --%>
		 			 	
		 	</table>	
		 	 	<nav aria-label="page" style="margin:0px 0px 0px 400px">
 			 <ul class="pagination">
    			<li class="page-item">
    			  <a class="page-link" href="#" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
        			<span class="sr-only">Previous</span>
      	</a>
				    </li>
				    <li class="page-item"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next">
	      	  <span aria-hidden="true">&raquo;</span>
	        <span class="sr-only">Next</span>
	      </a>
	    </li>
	   <div class="input-group-prepend" id="searchText" style="margin:0px 0px 0px 200px">
    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">문의</button>
    <input type ="text"  placeholder="검색어 입력">
    <button>검색</button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">문의</a>
      <a class="dropdown-item" href="#">신고</a>    
    </div>
  </div>
	  </ul>
   
</nav>	 	
		</div>
	</div>
<br><br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
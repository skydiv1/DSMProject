<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.w7.board.model.vo.*"%>
 <%
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<style>
	td{
		text-align:center;
	}
</style>
</head>
<body>

<!-- 네비게이션 바 -->
< 		<%@ include file = "../common/navi.jsp" %> 
		<%-- <%@ include file = "../common/naviLogin.jsp" %> --%>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<section class="bg-light" id="portfolio">

	<h2 style="margin:-10px -20px -10px 70px; padding-left:5%">게시판</h2>	
		
		<div class="container">
			<!-- 로그인한 사용자만 게시글 작성할 수 있게 만드는거 2018-12-24 오후 3:05분 -->
		 		<div style="margin:10px 10px 10px 1050px">
		 			<a class="btn btn-primary pull-right " href="boardWrite.jsp">
		 			<%-- <% if(loginUser != null){ %> --%>
		 				<button>글쓰기</button>
		 			<%-- <% } %> --%>	
		 			</a>
		 		</div>
		 <div class="row" style="postion:static;">
		 	<table class="table table-striped"  border:1px; solid #dddddd">
		 		<thead>
		 			<tr>
						<th style="width: 3% background-color:#eeeeee; text-align: center;">번호</th>
						<th style="width: 20% background-color:#eeeeee; text-align: center;">제목</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">작성자</th>
						<th style="width: 5% background-color:#eeeeee; text-align: center;">작성일</th>
						<th style="width: 3% background-color:#eeeeee; text-align: center;">조회수</th>
					</tr>		 		
		 		</thead>
		 		<tbody>
		 		<% for(Board b : list){ %>
		 				<tr>		 				                      
                            <td><%= b.getBoardNo() %></td>
                            <td><%= b.getBoardTitle() %></td>
                            <td><%= b.getBoardDate() %></td>
                            <td><%= b.getMemberCode() %></td>
                            <td><%= b.getBoardCount() %></td>
                            
                        </tr>
                <% } %>
		 		</tbody>		 	
		 	</table>
		 			 	
		 	<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1){ %>
			<button disabled><</button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
			%>
					<button disabled><%= p %></button>
			<%      }else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
	
			<% } %>
			
			
			<% if(currentPage >= maxPage){ %>
			<button disabled>></button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
			
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo?currentPage=<%=maxPage%>'">>></button>
			
		</div>
	        	 <!-- 검색 드롭박스 부분 보류 -->
 <div class="searchArea" id="searchText" style="margin:0px 0px 0px 240px">
    <button class="dropdown" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">제목</button>
    <input type ="text"  placeholder="검색어 입력">
    <button>검색</button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">제목</a>
      <a class="dropdown-item" href="#">작성자</a>
      <a class="dropdown-item" href="#">제목+내용</a>    
    </div>
  </div>
  
</div>
	  </ul>
  
</nav>	
								
			 	
		 	</div>
		 	
		 </div>
		
	</div>
 </section>
</body>
<br><br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</html>
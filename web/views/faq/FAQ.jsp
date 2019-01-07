<%@page import="java.io.ObjectInputStream.GetField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.kh.w7.board.model.vo.*"%>
<%@ page import="com.kh.w7.common.*" %>
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

</head>
<body>
	<!-- 네비게이션 바 -->
	<%@ include file="../common/menubar.jsp"%>
	<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<div class="container">
		<div  data-obj-id="FAQ" data-obj-type="element"
			data-text-editable="true"
			style="position: relative; width: 100px; float: left; margin: 10px;";  width: 128px; height: 44px;">
			<a href="/dsm/selectFaqList.faq"><div
					style="font-size: 18px; color: rgb(255, 255, 255); text-align: center; line-height: 2.5em; background-color: rgb(127, 127, 127); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: normal;">Q&amp;A</div>
			</a>
		</div>
		<div  data-obj-id="QNA" data-obj-type="element"
			data-text-editable="true"
			style="position: relative; width: 100px; float: left; margin: 10px;"width: 136px; height: 44px;">
			<a href="/dsm/selectQnaList.qna"><div
					style="font-size: 18px; color: rgb(0, 0, 0); text-align: center; line-height: 2.5em; background-color: rgb(255, 255, 255); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: bold;">FAQ</div>
			</a>
		</div>
		<div><a href="views/faq/faqWrite.jsp" class="btn btn-primary" style="position: relative; margin:10px 10px 10px 10px; float:right; width: 136px; height: 44px; ">문의하기</a></div>
		<div>
			<table id="listArea" class="table table-striped"
				style="text-align: center; border: 1px;">
				<thead>
					<tr>
						<th
							style="width: 30%; background-color: #eeeeee; text-align: center;">제목</th>
						<th
							style="width: 10%; background-color: #eeeeee; text-align: center;">작성자</th>
						<th
							style="width: 10%; background-color: #eeeeee; text-align: center;">작성일</th>
						<th
							style="width: 6%; background-color: #eeeeee; text-align: center;">조회수</th>
					</tr>
				</thead>
				<tbody>
		 		<% for(Board b : list){ %>
		 				<tr>		 				                      
                            <input type="hidden" value="<%= b.getBoardNo() %>">
                            <td><%= b.getBoardTitle() %></td>
                            <%-- <input type="hidden" value="<%= b.getMemberCode() %>"> --%>
                            <td><%= b.getMemberName() %></td>
							 <input type="hidden" value="<%= b.getBoardContext() %>">
                            <td><%= b.getBoardDate() %></td>
                            <input type="hidden" value="<%= b.getBoardCategory() %>">
                            <td><%= b.getBoardCount() %></td>
                            
                        </tr>
                <% } %>
		 		</tbody>	
			</table>
				
				
			<div class="pagingArea" align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectFaqList.faq?currentPage=1'"><<</button>
			 
			 <% if(currentPage <= 1){ %>
			<button disabled><</button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/selectFaqList.faq?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
			%>
					<button disabled><%= p %></button>
			<%      }else{ %>
					<button onclick="location.href='<%=request.getContextPath()%>/selectFaqList.faq?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
	
			<% } %>
			
			
			<% if(currentPage >= maxPage){ %>
			<button disabled>></button>
			<% }else{ %>
			<button onclick="location.href='<%=request.getContextPath()%>/selectFaqList.faq?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
			
			<button onclick="location.href='<%=request.getContextPath()%>/selectFaqList.faq?currentPage=<%=maxPage%>'">>></button>
			
			</div> 
			<script>
			$(function(){
			$("#listArea td").mouseenter(function(){
				$(this).parent().css({ "cursor":"pointer"});
			}).click(function(){
				var num = $(this).parent().children("input").val();
				
				location.href="<%=request.getContextPath()%>/selectOne.faq?num=" + num;
				});
			});
			</script>
			 <!--  <div class="input-group-prepend" id="searchText" style="margin:0px 0px 0px 800px">
			    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">문의</button>
			    <input type ="text"  placeholder="검색어 입력">
			    <button>검색</button>
			    <div class="dropdown-menu">
			      <a class="dropdown-item" href="#">문의</a>
			      <a class="dropdown-item" href="#">신고</a>    
			    </div>
			  </div> -->
		</div>
		<br>
		<br>
	</div>
	<!-- Footer -->
	<%@ include file="../common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
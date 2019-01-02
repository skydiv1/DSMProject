<%@page import="com.kh.w7.product.model.service.ProductService"%>
<%@page import="com.kh.w7.common.*"%><%@page import="com.kh.w7.product.model.vo.*"%><%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	ArrayList<HashMap<String, Object>> searchArrayList = (ArrayList<HashMap<String, Object>>)request.getAttribute("searchArrayList");

	PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	// 미리 값을 꺼내서 저장해서 사용 (매번 꺼내서 사용하는 불편함을 줄이기 위함)
	int listCount = pageInfo.getListCount(); // 전체 개수
	int currentPage = pageInfo.getCurrentPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();

	String searchList = (String)request.getAttribute("searchList");
	//String searchList = (String)session.getAttribute("searchList");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<!-- 예전 버전아렁 현 버전이랑 호환문제?.. -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- ajax -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 시멘틱 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script> -->

<style>
</style>
</head>
<body>
	<!-- 네비게이션 바 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

	<%@ include file="../common/menubar.jsp"%>
	<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<section class="bg-light" id="portfolio" style="">

	<form id="formList" method="post">
	<div style="padding-left: 19%;">	
		'<span id="searchResult"><%= searchList %></span>' (으)로 검색된 결과는 <span id="searchResultCount"><%=listCount%></span>건 입니다.
	</div>
	
	<div class="input-group input-group-lg"
		style="width: 70%; padding-left: 19%;">
		<input type="text" class="form-control"
			aria-label="Sizing example input" id="searchList"
			aria-describedby="inputGroup-sizing-lg" name="searchList"
			style="width: 30%; font-size: 20px" placeholder=<%=searchList %>>
		<div class="input-group-prepend">
			<button class="input-group-text" id="inputGroup-sizing-lg" type="submit"
				style="color: black; cursor:pointer;"><b>검색</b></button>
		</div>
	</div>
	<div style="padding-left: 49%;">
<%-- 		'<span id="searchResult"><%= searchList %></span>' (으)로 검색된 결과는 <span id="searchResultCount"><%=listCount%></span>건 입니다. --%>
	</div>
	<div align="right" class="dropdown" style="padding-right: 19%;">
		<select class="btn btn-secondary">
			<option value="category" selected>카테고리</option>
			<option value="shooting">촬영</option>
			<option value="education">교육</option>
			<option value="edit">편집</option>
		</select>
	</div>
	</form>
	<br><br>
	<div class="dropdown" style="padding-left: 13%;">
		<button class="btn btn-secondary" id="goToMainList"><b>전체상품목록</b></button>
	</div>
	<br>

	<div class="container" id="searchListDiv">
		<div class="row">
		<% for(int i=0; i<searchArrayList.size(); i++){ 
			HashMap<String, Object> hmap = searchArrayList.get(i);	
		%>
			<input type="hidden" value="<%=hmap.get("productNo")%>"> 
			<div name="imageList" class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal" >
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<input type="hidden" value="<%=hmap.get("productNo")%>">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img style="width:400px; height:300px" class="img-fluid" src="/dsm/image_uploadFiles/<%=hmap.get("changeName")%>" alt="">
				</a>
				<div class="portfolio-caption">
					<h4><%=hmap.get("productName") %></h4>
					<p class="text-muted"><spna><%=hmap.get("productItemPrice") %></spna>원</p>
				</div>
			</div>
			<%} %>
		</div>
	</div>
	<br><br>
	
	<!-- 페이징 처리 시작 ////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		
		<div class="pagingArea" align="center" id="paging">
		<div>
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=1&searchList=<%=searchList%>'"><<</button>
			
			<% if(currentPage <= 1){ %>
			<button class="btn btn-warning" disabled><</button>
			<% }else{ %>
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=<%=currentPage - 1%>&searchList=<%=searchList%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
			%>
					<button class="btn btn-warning" disabled><%= p %></button>
			<%      }else{ %>
					<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=<%= p %>&searchList=<%=searchList%>'"><%= p %></button>
			<%      } %>
	
			<% } %>
						
			<% if(currentPage >= maxPage){ %>
			<button class="btn btn-warning" disable>></button>
			<% }else{ %>
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=<%=currentPage + 1%>&searchList=<%=searchList%>'">></button>
			<% } %>
			
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=<%=maxPage%>&searchList=<%=searchList%>'">>></button>
		</div>
		</div>
	<!-- 페이징 처리 끝 //////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	</section>
	
	<script>
		$(function () {
			$("[name=imageList]").click(function () {
				var num = $(this).children().children().children().children().eq(0).val(); // eq(0).val(); //eq 0번째의 value값
				console.log(num); // num 값 확인
				
				// num의 값이 num에 담겨 넘겨준다.
				location.href = "<%=request.getContextPath()%>/selectOne.pr?num=" + num; 
			});
		});
		
		/* 검색 버튼 클릭 시 */		
		$("#inputGroup-sizing-lg").click(function () {
			$("#formList").attr("action", "<%=request.getContextPath()%>/searchList.pr");
		});
	</script>
	
	<script>
		/*  */
		$(function () {
			$("#goToMainList").click(function () {
				$("#goToMainList").attr("onclick", "location.href='<%=request.getContextPath()%>/selectList.pr'")
			});
		});
	</script>

	<!-- Footer ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
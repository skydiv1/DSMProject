<%@page import="com.kh.w7.product.model.service.ProductService"%>
<%@page import="com.kh.w7.common.*"%><%@page import="com.kh.w7.product.model.vo.*"%><%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("list");
	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>)request.getAttribute("list");

	PageInfo pi = (PageInfo)request.getAttribute("pi");
	// 미리 값을 꺼내서 저장해서 사용 (매번 꺼내서 사용하는 불편함을 줄이기 위함)
	int listCount = pi.getListCount(); // 전체 개수
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

	<div style="padding-left: 19%;">
		<span>● 전체 상품 수는 ' <%=listCount%> ' </span>건 입니다.
	</div>
	
	<div class="input-group input-group-lg"
		style="width: 70%; padding-left: 19%;">
		<input type="text" class="form-control"
			aria-label="Sizing example input" id="searchList"
			aria-describedby="inputGroup-sizing-lg"
			style="width: 30%; font-size: 20px" placeholder="검색어를 입력해주세요">
		<div class="input-group-prepend">
			<button class="input-group-text" id="inputGroup-sizing-lg"
				style="color: black; cursor:pointer;"><b>검색</b></button>
		</div>
	</div>
	<div style="padding-left: 49%;">
		'<span id="searchResult"></span>' (으)로 검색된 결과는 <span id="searchResultCount"></span>건 입니다.
	</div>
	<div align="right" class="dropdown" style="padding-right: 19%;">
		<select class="btn btn-secondary">
			<option value="category" selected>카테고리</option>
			<option value="shooting">촬영</option>
			<option value="education">교육</option>
			<option value="edit">편집</option>
		</select>
	</div>
	<br><br>

	<div class="container" id="searchListDiv">
		<div class="row">
		<% for(int i=0; i<list.size(); i++){ 
			HashMap<String, Object> hmap = list.get(i);	
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
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/selectList.pr?currentPage=1'"><<</button>
			
			<% if(currentPage <= 1){ %>
			<button class="btn btn-warning" disabled><</button>
			<% }else{ %>
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/selectList.pr?currentPage=<%=currentPage - 1%>'"><</button>
			<% } %>
			
			<% for(int p = startPage; p <= endPage; p++){ 
					if(p == currentPage){
			%>
					<button class="btn btn-warning" disabled><%= p %></button>
			<%      }else{ %>
					<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/selectList.pr?currentPage=<%= p %>'"><%= p %></button>
			<%      } %>
	
			<% } %>
						
			<% if(currentPage >= maxPage){ %>
			<button class="btn btn-warning" disable>></button>
			<% }else{ %>
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/selectList.pr?currentPage=<%=currentPage + 1%>'">></button>
			<% } %>
			
			<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/selectList.pr?currentPage=<%=maxPage%>'">>></button>
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
// 		$(function () {
		function selectListPr(pg) {
			$("#inputGroup-sizing-lg").click(function () {
				var searchList = $("#searchList").val();
				
				$.ajax({
					url:"/dsm/searchList.pr",
					type:"get",
					data:{searchList:searchList, currentPage:pg},
					success:function(data){
						console.log(data);
						$("#searchResult").text(searchList);

						$select = $("#searchListDiv"); // 해당 div 영역을 찾아서 
						//$select.find('a').remove(); // a부터 하위에 있는 모든 태그를 찾아서 지운다.
						$select.find('div').remove(); // div부터 하위에 있는 모든 태그를 찾아서 지운다.

						console.log(decodeURIComponent(data.listCount));
						//$select.append('<div class="container">');
						$select.append('<div class="row">');
					 	for(var key in data){
							var productNo = decodeURIComponent(data[key].productNo);
							var changeName = decodeURIComponent(data[key].changeName); 
							var productName = decodeURIComponent(data[key].productName); 
							var productItemPrice = decodeURIComponent(data[key].productItemPrice); 
							var listCount = decodeURIComponent(data[key].listCount)
							var maxPage = decodeURIComponent(data[key].maxPage)
							var startPage = decodeURIComponent(data[key].startPage)
							var endPage = decodeURIComponent(data[key].endPage)
							console.log("검색한 게시글 수: "+listCount);
							console.log("maxPage: "+maxPage);
							console.log("startPage: "+startPage);
							console.log("endPage: "+endPage);
							
							 $select.append(
									 '<div name="imageList" class="col-md-4 col-sm-6 portfolio-item" id="">'
									+'<a class="portfolio-link" data-toggle="modal" >'
									+'<div class="portfolio-hover">'
									+'<div class="portfolio-hover-content">'
									+'<input type="hidden" value="'+productNo+'">'
									+'<i class="fas fa-plus fa-3x"></i>'
									+'</div>'
									+'</div> <img style="width:400px; height:300px" class="img-fluid" src="/dsm/image_uploadFiles/'+changeName+'" alt="">'
									+'</a>'
									+'<div class="portfolio-caption">'
									+'<h4>'+productName+'</h4>'
									+'<p class="text-muted"><spna>'+productItemPrice+'</spna>원</p>'
									+'</div>'
									+'</div>'
									+'</div>');							
						 }
						$select.append('</div>');  
						$("#searchResultCount").text(listCount); // 특정 검색어 게시글 수 

						//$select2 = $("#paging"); 
						//$select2.find('div').remove();
						
						<%-- 페이징처리 -->
		 				<%-- $select2.append(	'<div class="pagingArea" align="center" id="paging">');
						$select2.append(	'<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=1'"><<</button>');
								if(currentPage <= 1){
									$select2.append(	'<button class="btn btn-warning" disabled><</button>');
								}else{ 
									$select2.append(	'<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=currentPage - 1'"><</button>');
								}
								
								for(var p = startPage; p <= endPage; p++){ 
										if(p == currentPage){
											$select2.append(	'<button class="btn btn-warning" disabled>'+ p +'</button>');
										}else{
											$select2.append(	'<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=p'"> '+p+'</button>');
								      }
								} 
											
								if(currentPage >= maxPage){
									$select2.append(	'<button class="btn btn-warning" disable>></button>');
								}else{
									$select2.append(	'<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=currentPage + 1'">></button>');
								}
								
								$select2.append(	'<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/searchList.pr?currentPage=maxPage'">>></button>');
								$select2.append(	'</div>');  --%>
						var apPageHtml= [];
						apPageHtml.push('<button class="btn btn-warning" onclick="selectListPr(1)"><<</button>');
						if(pg <=1){
							apPageHtml.push('<button class="btn btn-warning" disabled><</button>');
						}else{
							apPageHtml.push('<button class="btn btn-warning" onclick="selectListPr(' + pg-1 + ')"><</button>');
						}
						for(var p = startPage; p<= endPage; p++) {
							if(p == pg){
							apPageHtml.push('<button class="btn btn-warning" disabled>'+p+'</button>');
							}else{
								apPageHtml.push('<button class="btn btn-warning" onclick="selectListPr('+p+')">'+p+'</button>');
								}
							}
						if(pg >= maxPage){ 
							apPageHtml.push('<button class="btn btn-warning" disabled>></button>');
						}else{
							apPageHtml.push('<button class="btn btn-warning" onclick="selectListPr('+pg+1+')">></button>');
						}
							apPageHtml.push('<button class="btn btn-warning" onclick="selectListPr('+maxPage +')">>></button>');
						
							$("#paging").html("");
							$("#paging").append(apPageHtml.join(""));
						
					},
					error:function(data){
						console.log("에러");
					}
				});				
			});
		}
		
	 	$(function () {
	 		selectListPr(1);
		}); 		
	</script>

	<!-- Footer ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
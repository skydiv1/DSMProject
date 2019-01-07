<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<HashMap<String, Object>> sessionList = (ArrayList<HashMap<String, Object>>)session.getAttribute("sessionList");

	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>)request.getAttribute("list");
	
	System.out.println("list(jsp) : "+list);
	
	/* Cookie ck = null;
	for(int i=0; i<sessionList.size(); i++){ 
		HashMap<String, Object> hmap = sessionList.get(i);
		String pNo = (String) hmap.get("productNo");
		String changeName = (String) hmap.get("changeName");
		String productName = (String) hmap.get("productName");
		String productItemPrice = (String) hmap.get("productItemPrice");		
		ck = new Cookie("pNo", pNo); 
		ck = new Cookie("changeName", changeName); 
		ck = new Cookie("productName", productName); 
		ck = new Cookie("productItemPrice", productItemPrice); 
		response.addCookie(ck);
	}
	
	Cookie[] cks = request.getCookies(); */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menubar.jsp"%>
	<!-- 로그인 안된화면  / 된 화면  -->

	<!-- //////////////////////////////////// -->

	<!-- 베스트판매자 -->
	<section class="bg-light" id="portfolio">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">베스트판매자</h2>
					<h3 class="section-subheading text-muted">
						<hr>
					</h3>
				</div>
			</div>
			<div class="row">
			<% for(int i=0; i<list.size(); i++){ 
				HashMap<String, Object> hmap = list.get(i);	
			%>
				<div name="imageList" class="col-md-4 col-sm-6 portfolio-item">
					<a class="portfolio-link" data-toggle="modal" href="#">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<input type="hidden" name="memberCode" value="<%=hmap.get("memberCode")%>">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" src="img/portfolio/bestSeller.jpg"
						alt="">
					</a>
					<div class="portfolio-caption">
						<h4><%=hmap.get("memberId") %></h4>
						<p class="text-muted">랭킹&nbsp;&nbsp;<%=(i+1) %>위</p>
					</div>
				</div>
				<%} %>				
			</div>
		</div>
	</section>
	<!-- 베스트판매자 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<!-- 최근 본 상품 -->
	<section class="bg-light" id="portfolio">
		<div class="container">
			<div class="row">	
				<div class="col-lg-12 text-center">
					<h2 class="section-heading text-uppercase">최근 본 상품</h2>
					<h3 class="section-subheading text-muted">
						<hr>
					</h3>
				</div>
			</div>
			<div class="row">		
				<div class="col-md-4 col-sm-6 portfolio-item">
					<a class="portfolio-link" data-toggle="modal" href="#"
						id="product1"> <!-- 링크 스크립트에서 처리 -->
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" src="img/portfolio/01-thumbnail.jpg"
						alt="">
					</a>
					<div class="portfolio-caption">
					<h4>상품 1의 제목</h4>
						<p class="text-muted">IDGraphic Design123</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 portfolio-item">
					<a class="portfolio-link" data-toggle="modal" href="#">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" src="img/portfolio/02-thumbnail.jpg"
						alt="">
					</a>
					<div class="portfolio-caption">
						<h4>상품 2의 제목</h4>
						<p class="text-muted">IDGraphic Design</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 portfolio-item">
					<a class="portfolio-link" data-toggle="modal" href="#">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" src="img/portfolio/03-thumbnail.jpg"
						alt="">
					</a>
					<div class="portfolio-caption">
						<h4>상품 3의 제목</h4>
						<p class="text-muted">IDIdentity</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 portfolio-item"
					style="margin-left: 180px;">
					<a class="portfolio-link" data-toggle="modal" href="#">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" src="img/portfolio/04-thumbnail.jpg"
						alt="">
					</a>
					<div class="portfolio-caption">
						<h4>상품 4의 제목</h4>
						<p class="text-muted">IDBranding</p>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 portfolio-item">
					<a class="portfolio-link" data-toggle="modal" href="#">
						<div class="portfolio-hover">
							<div class="portfolio-hover-content">
								<i class="fas fa-plus fa-3x"></i>
							</div>
						</div> <img class="img-fluid" src="img/portfolio/05-thumbnail.jpg"
						alt="">
					</a>
					<div class="portfolio-caption">
						<h4>상품 5의 제목</h4>
						<p class="text-muted">IDWebsite Design</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- 최근 본 상품 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<!-- 스크립트 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<script>
		$(function () {
			$("[name=imageList]").click(function () {
				var memberCode = $(this).children().children().children().children().eq(0).val(); // eq(0).val(); //eq 0번째의 value값

				location.href = "<%=request.getContextPath()%>/noticeResist.pr?memberCode=" + memberCode; 
			});
			
			/* 세션 스토리지 */
			var pNo1 = sessionStorage.getItem("productNo1");
			//alert(pNo1);
			var pNo2 = sessionStorage.getItem("productNo2");
			//alert(pNo2);
			
		});
	</script>
	
	<!-- Footer -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

</body>
</html>
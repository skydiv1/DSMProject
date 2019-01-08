<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<HashMap<String, Object>> list = (ArrayList<HashMap<String, Object>>)request.getAttribute("list");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
			<div class="row" id="recentListForm"></div>
	</section>

	<form>
		<input type="hidden" name="pNo1">
		<input type="hidden" name="pNo2">
		<input type="hidden" name="pNo3">
		<input type="hidden" name="pNo4">
		<input type="hidden" name="pNo5">
		<input type="hidden" name="pNo6">
	</form>
	<!-- 최근 본 상품 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<!-- 스크립트 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<script>
		/* 세션 스토리지 */
		sessionStorage.setItem("i",1);		

		$(function () {
			/* 베스트 판매자 */
			$("[name=imageList]").click(function () {
				var memberCode = $(this).children().children().children().children().eq(0).val(); // eq(0).val(); //eq 0번째의 value값

				location.href = "<%=request.getContextPath()%>/noticeResist.pr?memberCode=" + memberCode; 
			});
		});
	</script>
	<script>
		$(function () {
			$.ajax({
				url:"<%=request.getContextPath()%>/recentProduct.pr",
				type:"get", /* sessionStorage에 등록할 상품 수 최대 6개 */
				data:{pNo1:sessionStorage.getItem("pNo1")
						,pNo2:sessionStorage.getItem("pNo2")
						,pNo3:sessionStorage.getItem("pNo3")
						,pNo4:sessionStorage.getItem("pNo4")
						,pNo5:sessionStorage.getItem("pNo5")
						,pNo6:sessionStorage.getItem("pNo6")},
				success:function(data){

					$select = $("#recentListForm");
					$select.find("div").remove();
					
					for(var key in data){
						$select.append('<div name="recentList" class="col-md-4 col-sm-6 portfolio-item">'
						+'<a class="portfolio-link" data-toggle="modal" href="#">'
						+'<div class="portfolio-hover">'
						+'<div class="portfolio-hover-content">'
						+'<input type="hidden" value="'+data[key].productNo+'">'
						+'<i class="fas fa-plus fa-3x"></i>'
						+'</div>'
						+'</div> <img style="width:400px; height:300px" class="img-fluid" src="/dsm/image_uploadFiles/'+data[key].changeName+'"  alt="">'
						+'</a>'
						+'<div class="portfolio-caption">'
						+'<h4>'+data[key].productName+'</h4>'
						+'<p class="text-muted">'+data[key].memberId+'</p>'
						+'</div>'
						+'</div>');						
					}
					
					/* 최근 본 상품 상세 페이지로 이동 */
					$("[name=recentList]").click(function () {
		 				var num = $(this).children().children().children().children().eq(0).val();
						location.href = "<%=request.getContextPath()%>/selectOne.pr?num=" + num; 
					});
					
				},
				error:function(){
					console.log("실패");
				}
			});

		});
	</script>
	
	<!-- Footer -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

</body>
</html>
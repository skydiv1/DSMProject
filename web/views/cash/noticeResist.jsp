<%@page import="com.kh.w7.product.model.vo.Review"%>
<%@page import="com.kh.w7.common.PageInfo"%>
<%@page import="com.kh.w7.common.Attachment"%>
<%@page import="com.kh.w7.product.model.vo.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member member = (Member)request.getAttribute("member");
	ArrayList<Product> pList = (ArrayList<Product>)request.getAttribute("pList");
	ArrayList<Attachment> imgList = (ArrayList<Attachment>)request.getAttribute("imgList");
	ArrayList<Attachment> profileImgList = (ArrayList<Attachment>)request.getAttribute("profileImgList");

	PageInfo pi = (PageInfo)request.getAttribute("pi");
	// 미리 값을 꺼내서 저장해서 사용 (매번 꺼내서 사용하는 불편함을 줄이기 위함)
	int listCount = pi.getListCount(); // 전체 개수
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();
	
	int memberCode = (int)request.getAttribute("memberCode");

	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>DSM(payment Page)</title>

<!-- 
	Bootstrap core CSS
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
    Custom fonts for this template
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    Custom styles for this template
    <link href="../../css/agency.min.css" rel="stylesheet"> -->


   
   <meta name="format-detection" content="telephone=no" />
   <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<style>
input::placeholder {
	font-style: italic;
	font-size: 0.7em;
}


.tRow {
	background: lightgray;
	text-align: center;
}
 .wrapper {
           padding: 20px;
           margin: 100px auto;
           width: 400px;
           min-height: 200px;
           border-radius: 5px;
           box-shadow: 0 0 10px rgba(0,0,0,.1);
           background-color: #fff;
       }
       .rating{
           overflow: hidden;
           vertical-align: bottom;
           display: inline-block;
           width: auto;
           height: 30px;
       }
       .rating > input{
           opacity: 0;
           margin-right: -100%;
       }
       .rating > label{
           position: relative;
           display: block;
           float: right;
           background: url('../../img/star-off-big.png');
           background-size: 30px 30px;
       }
       .rating > label:before{
           display: block;
           opacity: 0;
           content: '';
           width: 30px;
           height: 30px;
           background: url('../../img/star-on-big.png');
           background-size: 30px 30px;
           transition: opacity 0.2s linear;
       }
       .rating > label:hover:before,
       .rating > label:hover ~ label:before,
       .rating:not(:hover) > :checked ~ label:before{
           opacity: 1;
       }
       
       td{
          padding:10px 10px 10px 10px;       
       }
       img{
          box-shadow:0px 0px 5px #000;        
       }     
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<!--/////////////////////////////////////////네비끝, 헤더시작//////////////////////////////////////////////////////////////////////////////////////////////  -->

	<!--/////////////////////////////////////////////헤더끝//////////////////////////////////////////////////////////////////////////////////////////  -->
<section class="bg-light" id="portfolio" style = "padding: 50px">


<div style="background : #323232; width:58%; height:250px; margin-top: 0px; margin-left:21%; background-position:center;">
	<div class="container">
		<div class="intro-text" style="padding-top: 35px;">
			
			<table style="width: 600px;" align = "center">
               <tr>
                  <td rowspan="3"><img class="mx-auto rounded-circle"
                     src="/dsm/image_uploadFiles/<%=profileImgList.get(0).getChangeName()%>" alt=""
                     style="width: 150px; height: 150px;"></td>
                     
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;">
                  <span style = "color : white; font-size:20px;">'<%=member.getMemberId() %>'님의 페이지에 오신 것을 환영합니다.</span></td>
               </tr>
               <tr>
                  <td>
                     <div style = "color : white;">소개 : <%=member.getSellerIntroduction() %></div>
                  </td>
               </tr>
               <tr>
                  <td>
<!-- 	                 <div style="background: lightgray; text-align: center; font-size: 1.3em; display : inline-block; width : 45%; height : 10%; vertical-align : center; border-radius : 3px;">★★★★☆(4.0)</div> -->
<!-- 					 <div style = "display : inline-block;">&nbsp;&nbsp;</div> -->
                     <button class="btn btn-light" disabled='disabled' style="text-align: center center; font-size: 1.3em; display : inline-block; width : 45%; height : 10%; vertical-align : center;border-radius : 3px;"><%=listCount %>개의 상품
                     </button>
                  </td>
               </tr>
            </table>
            <div>&nbsp;</div>
			<div>&nbsp;</div>
			<div>&nbsp;</div>
		</div>
	</div>
	</div>
    <br><br>
	<!--///////////////////////////////////판매자 프로필 끝///////////////////////////////////////////////////////////////////  -->
	<div class="container" align="center" style="width: 60%">
		<div style="font-size: 1.3em; font-weight: bold; text-align: left">'<%=member.getMemberId() %>'님의 개인정보</div>
		<table class="table">
			<thead class="thead-dark">
			</thead>
			<tbody>
				<tr>
					<th class="tRow">자기소개</th>
					<td><%=member.getSellerIntroduction() %></td>
				</tr>
				<tr>
					<th style = "vertical-align: middle;" class="tRow">자격증</th>
					<td>
						<img src = "/dsm/image_uploadFiles/<%=profileImgList.get(1).getChangeName()%>" alt = "드론 자격증" style="width:260px !important; height:170px !important;">
					</td>

				</tr>
				<tr>
					<th class="tRow">경력사항</th>
					<td><%=member.getSellerCareer() %></td>
				</tr>
			</tbody>
		</table>
	</div>
	</section>
	
	
	<!--////////////////////////////베스트 만매자 시작///////////////////////////////////////////////////  -->
	<section class="bg-light" id="portfolio" style = "padding: 50px">
	<div class="container" align="center" style="width: 60%">
		<div style="font-size: 1.3em; font-weight: bold; text-align: left">'<%=member.getMemberId() %>'님의 전체 상품</div><br>
		
		<%for(int i=0; i<pList.size(); i++){ %>
		<div name="imageList" class="col-md-4 col-sm-6 portfolio-item" style="display: inline-block; width: 33%; padding-top: 10px !important;">
			<a class="portfolio-link" data-toggle="modal" href="#">
				<div class="portfolio-hover">
					<div class="portfolio-hover-content">
						<input type="hidden" value="<%=pList.get(i).getProductNo()%>">
						<i class="fas fa-plus fa-3x"></i>
					</div>
				</div> <img class="img-fluid" style="width:300px !important; height:200px !important;" src="/dsm/image_uploadFiles/<%=imgList.get(i).getChangeName()%>" 
				alt="">
			</a>
			<div class="portfolio-caption" style="height:130px !important;" >
				<h4><%=pList.get(i).getProductName() %></h4>
			</div>
		</div>
		<%} %>
	
	<!-- 페이징 처리 시작 ----------------------------------------------------------------------------------------------------------->	
	<div class="pagingArea" align="center" id="paging">
	<div>
		<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/noticeResist.pr?currentPage=1&memberCode=<%=memberCode%>'"><<</button>
		
		<% if(currentPage <= 1){ %>
		<button class="btn btn-warning" disabled><</button>
		<% }else{ %>
		<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/noticeResist.pr?currentPage=<%=currentPage - 1%>&memberCode=<%=memberCode%>'"><</button>
		<% } %>
		
		<% for(int p = startPage; p <= endPage; p++){ 
				if(p == currentPage){
		%>
				<button class="btn btn-warning" disabled><%= p %></button>
		<%      }else{ %>
				<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/noticeResist.pr?currentPage=<%= p %>&memberCode=<%=memberCode%>'"><%= p %></button>
		<%      } %>

		<% } %>
					
		<% if(currentPage >= maxPage){ %>
		<button class="btn btn-warning" disable>></button>
		<% }else{ %>
		<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/noticeResist.pr?currentPage=<%=currentPage + 1%>&memberCode=<%=memberCode%>'">></button>
		<% } %>
		
		<button class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/noticeResist.pr?currentPage=<%=maxPage%>&memberCode=<%=memberCode%>'">>></button>
	</div>
	</div>
	
	</section>
	<!-- 페이징 처리 끝 ---------------------------------------------------------------------------------------------------------->

	
	<!--////////////////////////////서비스 평가 시작///////////////////////////////////////////////////  -->
	<section class="bg-light" id="portfolio" style = "padding: 50px">
	<div class="container" style="width: 60%">
		<div style="font-size: 1.3em; font-weight: bold; text-align: left;">'<%=member.getMemberId() %>'님의 상품을 이용한 <%=reviewList.size() %>개의 소비자 평가</div>
			<div style="background: lightgray; text-align: center; font-size: 1.7em;">&nbsp;
			</div>

         	<% for(int i=0; i<reviewList.size(); i++){ %>
			<table style="width: 600px;">
               <tr>
                  <td rowspan="2">
                  	<img class="mx-auto rounded-circle" src="/dsm/img/customerProfile1.jpg" alt="" style="width: 90px; height: 90px;">
                  </td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;">
                  	<span><%=reviewList.get(i).getReviewDate() %></span> <span class="rating" style="margin-left: 15px;"> 
	                  	<input id="rating5_2" type="radio" name="rating2" value="5" checked><label for="rating5_2">5</label> 
	                  	<input id="rating4_2" type="radio" name="rating2" value="4"> <label for="rating4_2">4</label> 
	                  	<input id="rating3_2" type="radio" name="rating2" value="3"> <label for="rating3_2">3</label>
	                    <input id="rating2_2" type="radio" name="rating2" value="2"> <label for="rating2_2">2</label> 
	                    <input id="rating1_2" type="radio" name="rating2" value="1"> <label for="rating1_2">1</label>
                  	</span>
                  </td>
               </tr>
               <tr>
                  <td>
                     <div><b><%=reviewList.get(i).getMemberId() %></b></div>
                     <div><%=reviewList.get(i).getReviewContext() %></div>
                  </td>
               </tr>
            </table>
            <%} %>

	</div>
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
	</script>
		
	<%@ include file="../common/footer.jsp"%>

	<!--//////////////////////////////////////////////////푸터시작/////////////////////////////////////////////////////////////////////////////////////  -->
	<!-- Bootstrap core JavaScript -->
	<!-- <script src="../../vendor/jquery/jquery.min.js"></script>
    <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    Plugin JavaScript
    <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

    Contact form JavaScript
    <script src="../../js/jqBootstrapValidation.js"></script>
    <script src="../../js/contact_me.js"></script>

    Custom scripts for this template
    <script src="../../js/agency.min.js"></script> -->
	<!--///////////////////////////////////////////푸터끝////////////////////////////////////////////////////////////////////////////////////////////  -->
</body>
</html>
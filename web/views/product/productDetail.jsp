<%@page import="com.kh.w7.product.model.vo.Review"%>
<%@page import="com.kh.w7.product.model.vo.PlusProduct"%>
<%@page import="com.kh.w7.member.model.vo.Member"%>
<%@page import="com.kh.w7.common.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.w7.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Product product = (Product)request.getAttribute("product");
	Member member = (Member)request.getAttribute("member");
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	Attachment detailImg1 = fileList.get(0);
	Attachment detailImg2 = fileList.get(1);
	Attachment detailImg3 = fileList.get(2);	
	Attachment detailImg4 = fileList.get(3);	
	Attachment detailImg5 = fileList.get(4);	
	Attachment detailImg6 = fileList.get(5);	 
	
	ArrayList<PlusProduct> pList = (ArrayList<PlusProduct>)request.getAttribute("pList");
	
	ArrayList<Review> reviewList = (ArrayList<Review>)request.getAttribute("reviewList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="format-detection" content="telephone=no" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>Insert title here</title>
<!-- 제이쿼리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<!-- 예전 버전아렁 현 버전이랑 호환문제?.. -->
<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>  -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> 

<!-- 시멘틱 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script> -->

<style>	
	<meta name="format-detection" content="telephone=no" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
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
	        background: url('/dsm/img/star/star-off-big.png');
	        background-size: 30px 30px;
	    }
	    .rating > label:before{
	        display: block;
	        opacity: 0;
	        content: '';
	        width: 30px;
	        height: 30px;
	        background: url('/dsm/img/star/star-on-big.png');
	        background-size: 30px 30px;
	        transition: opacity 0.2s linear;
	    }
	    .rating > label:hover:before,
	    .rating > label:hover ~ label:before,
	    .rating:not(:hover) > :checked ~ label:before{
	        opacity: 1;
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
</head>

<body>
<!-- 네비게이션 바 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

	<%@ include file="../common/menubar.jsp"%>
<%@ include file = "/views/common/AskPopUp.jsp" %> <!-- 팝업 띄우기 --> <!-- 팝업을 include하면 서비스 설명이 안뜨는 오류발생!!! -->
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<section class="bg-light" id="portfolio">

	<input type="hidden" name="productNo" value="<%=product.getProductNo()%>"> <!-- 상품 번호 sevlet으로 넘긴다. -->
	
	<table width="70%" style="margin-left: 17%;" border="0">
		<tr>
			<td>			
				<h2>상품 상세</h2><br>
			</td>	
			<td>
				<div style="font-size: 15px; margin-left: 5%;">작성자 : <span><%=member.getMemberId() %></span></div><hr>	
			</td>
		</tr>
		<tr>
			<td rowspan="4">
				<img class="img-fluid" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg1.getChangeName()%>" alt="" style="box-shadow: 0px 0px 10px #000; width:530px; height:420px;">
			</td>
			<td>
				<div style="font-size: 20px; font: bold; margin-left: 5%; margin-bottom: 5%;"><%=product.getProductName() %></div><hr> <!-- 상품 제목 -->
			</td>
		</tr>
		<tr>
			<td width="50%">
				<div style="font-size: 15px; font: bold; margin-left: 5%; margin-top: 15%;">
					<b><%= product.getProductItem() %></b> : <span style="font-size: 20px; margin-left: 60%;"><%= product.getProductItemPrice() %></span>원<hr>
				</div>
			</td>
		</tr>
		<tr>
			<td>
				<div align="left" class="dropdown"
					style="padding-right: 10%; margin-left: 5%;">
					<select class="btn btn-outline-secondary" id="additionalOption" >
						<option value="category" selected>추가옵션(선택)</option>
						<% for(PlusProduct p : pList){ %>
							<option value="<%=p.getPlusProductPrice()%>"><span><%=p.getPlusProductItem()%></span> : <span><%=p.getPlusProductPrice()%></span>원
							</option>						
						<% } %>
					</select>
				</div>
			</td>
		</tr>
		<tr>
			<td align="center">
				<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#askModal"
					style="width: 90%; height: 50px;">신청하기</button>
			</td>
		</tr>
		<tr>
			<td align="left">
				<div class="wrapper" style="font-size: 20px; margin-top: 2%;">
					평점 : <span class="rating"> 
							<input id="rating5" type="radio" name="rating" value="5" checked disabled><label for="rating5">5</label>
							<input id="rating4" type="radio" name="rating" value="4" disabled><label for="rating4">4</label> 
							<input id="rating3" type="radio" name="rating" value="3" disabled> <label for="rating3">3</label> 
							<input id="rating2" type="radio" name="rating" value="2" disabled> <label for="rating2">2</label> 
							<input id="rating1" type="radio" name="rating" value="1" disabled> <label for="rating1">1</label>
					</span> (<span><span>30</span>개의 평가</span>)
				</div>
			</td>
			<td align="center">
				<button type="button" class="btn btn-outline-secondary" style="width:90%; height:50px;" onclick="location.href='/dsm/noticeResist.pr'">판매자 프로필 보러가기</button>
			</td>
		</tr>
		<tr>
			<td>
			</td>
			<td width="50%">
				<div style="font-size: 15px; font: bold; margin-left: 5%; margin-top: 5%;">
					<b>전체 금액</b> : <span id="totalPrice" style="font-size: 20px; margin-left: 60%;"><%= product.getProductItemPrice() %></span>원
				</div>
			</td>
		</tr>
	</table>
	<br><br><br>

	<div style="margin-left: 17%; padding-right: 13%;">
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="a-tab"
				data-toggle="tab" href="#a" role="tab" aria-controls="a"
				aria-selected="true">상품 설명</a></li>
			<li class="nav-item"><a class="nav-link" id="b-tab"
				data-toggle="tab" href="#b" role="tab" aria-controls="b"
				aria-selected="false">취소 및 환불규정</a></li>
			<li class="nav-item"><a class="nav-link" id="c-tab"
				data-toggle="tab" href="#c" role="tab" aria-controls="c"
				aria-selected="false">상품 평가</a></li><button id="test1"></button>
		</ul>
		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="a" role="tabpanel"
				aria-labelledby="a-tab" style="margin-left: 3%; margin-top: 3%;">
				<h5>상품 설명</h5>
				<br><br>
				
				<div>
					<%= (product.getProductContext()).replace("\r\n", "<br>") %> <!-- 상품 설명 --> <!-- .replace("\r\n", "<br>") : 줄바꿈 처리 -->
				</div>
				<br><br>
				
				<table>
					<tr>
						<td style="padding: 2% 2% 2% 0%;"><img class="img-fluid" id="detailImg1"
							src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg1.getChangeName()%>"
							style="width: 420px; height: 300px;"></td>
						<td style="padding: 2% 2% 2% 2%;"><img class="img-fluid" id="detailImg2"
							src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg2.getChangeName()%>"
							style="width: 420px; height: 300px;"></td>
					</tr>
					<tr>
						<td style="padding: 2% 2% 2% 0%;"><img class="img-fluid" id="detailImg3"
							src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg3.getChangeName()%>"
							style="width: 420px; height: 300px;"></td>
						<td style="padding: 2% 2% 2% 2%;"><img class="img-fluid" id="detailImg4"
							src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg4.getChangeName()%>"
							style="width: 420px; height: 300px;"></td>
					</tr>
					<tr>
						<td style="padding: 2% 2% 2% 0%;"><img class="img-fluid" id="detailImg5"
							src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg5.getChangeName()%>"
							style="width: 420px; height: 300px;"></td>
						<td style="padding: 2% 2% 2% 2%;"><img class="img-fluid" id="detailImg6"
							src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg6.getChangeName()%>"
							style="width: 420px; height: 300px;"></td>
					</tr>
				</table>
			</div>
			<div class="tab-pane fade" id="b" role="tabpanel"
				aria-labelledby="b-tab" style="margin-left: 3%; margin-top: 3%;">
				<div>
					<h5>취소 및 환불 규정</h5>
					<br><br> 가. 기본 환불 규정 
					<br>1. 전문가와 의뢰인의 상호 협의하에 청약 철회 및 환불이 가능합니다. 
					<br>2. 섭외, 대여 등 사전 준비 도중 청약 철회 시, 해당 비용을 공제한 금액을 환불 가능합니다. 
					<br>3. 촬영 또는 편집 작업 착수 이후 청약 철회 시, 진행된 작업량 또는 작업 일수를 산정한 금액을 공제한 부분 환불이 가능합니다.
					<br><br> [환불 가이드라인] 
					<br>(1) 기획 단계에서 청약 철회: 총 결제 금액의 최대 80%까지 환불 가능 
					<br>(2) 촬영 완료 후 청약 철회: 총 결제 금액의 최대 20%까지 환불 가능 
					<br>(3) 편집 작업 50% 완료 후 청약 철회: 총 결제 금액의 최대 10%까지 환불 가능
					<br><br> 나. 전문가 책임 사유 
					<br>1. 소비자 피해 보상 규정에 의거하여 촬영 원본의 멸실 및 재해로 인한 피해 발생 시, 전액 환불합니다. 
					<br>2. 작업 기간 미준수, 작업 태만 및 이에 상응하는 전문가 책임으로 인한 청약 철회 시, 환불 및 촬영 원본 제공이 가능합니다. 
					<br><br> 다. 의뢰인 책임 사유 .
					<br>작업이 시작되면 단순 변심 또는 의뢰인 책임 사유로 인한 전액 환불이 불가능합니다.<br>
				</div>
			</div>
			<div class="tab-pane fade" id="c" role="tabpanel"
				aria-labelledby="c-tab" style="margin-left: 3%; margin-top: 3%;">
				<h5>서비스 평가</h5>
				<br>

				<div class="wrapper"
					style="font-size: 20px; width: 600px; height: 110px; background-color: #EAEAEA; padding: 4% 7%;">
					<span class="rating"> 
						<input id="rating5_1" type="radio" name="rating1" value="5" checked disabled><label for="rating5_1">5</label>
						<input id="rating4_1" type="radio" name="rating1" value="4" disabled><label for="rating4_1">4</label> 
						<input id="rating3_1" type="radio" name="rating1" value="3" disabled><label for="rating3_1">3</label> 
						<input id="rating2_1" type="radio" name="rating1" value="2" disabled><label for="rating2_1">2</label>
						<input id="rating1_1" type="radio" name="rating1" value="1" disabled><label for="rating1_1">1</label>
					</span><span style="margin-left: 3%;">30 </span>개의 평가
				</div>
				<br>

				<div id="reviewResult">
				<table style="width: 600px;">
					<tr>
						<td rowspan="2"><img class="mx-auto rounded-circle"
							src="/dsm/img/team/1.jpg" alt=""
							style="width: 90px; height: 90px;"></td>
						<td width="80%" style="border-bottom: 1px solid #EAEAEA;">
							<span>18.12.07 14:02</span>
							<span class="rating" style="margin-left: 15px;">
								<input id="rating5_2" type="radio" name="rating2" value="5" checked disabled><label for="rating5_2">5</label>
								<input id="rating4_2" type="radio" name="rating2" value="4" disabled><label for="rating4_2">4</label>
								<input id="rating3_2" type="radio" name="rating2" value="3" disabled><label for="rating3_2">3</label>
								<input id="rating2_2" type="radio" name="rating2" value="2" disabled><label for="rating2_2">2</label>
								<input id="rating1_2" type="radio" name="rating2" value="1" disabled><label for="rating1_2">1</label>
							</span>
						</td>
					</tr>
					<tr>
						<td>
							<div>
								<b>dsm***</b>
							</div>
							<div>감사합니다~~~</div>
						</td>
					</tr>
				</table>
				</div>
				
				<hr>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<% if(loginUser != null && loginUser.getMemberId().equals(member.getMemberId()) ){ %> <!-- 조건 추가 (작성자와 로그인 유저가 일치했을 경우 처리..) -->
	<button onclick="location.href='<%=request.getContextPath()%>/selectProduct.pr?num=<%=product.getProductNo()%>'" class="btn btn-warning" style="width:7%; height:40px; margin-left: 80%">수정하기</button>
	<% } %>
</section>

	<script>
		$(function () {
			/* 이미지가 없을 경우에는 공간을 숨긴다. */
			if($("#detailImg2").attr("src") == "/dsm/image_uploadFiles/null"){
				$("#detailImg2").hide();
			}
			if($("#detailImg3").attr("src") == "/dsm/image_uploadFiles/null"){
				$("#detailImg3").hide();
			}
			if($("#detailImg4").attr("src") == "/dsm/image_uploadFiles/null"){
				$("#detailImg4").hide();
			}
			if($("#detailImg5").attr("src") == "/dsm/image_uploadFiles/null"){
				$("#detailImg5").hide();
			}
			if($("#detailImg6").attr("src") == "/dsm/image_uploadFiles/null"){
				$("#detailImg6").hide();
			}
		})
	</script>
	
	<!-- Review Table Ajax 출력 -->
	<script>
		$(function () {
			$("#test1").click(function () {
				$.ajax({
					url:"/dsm/reviewList.pr",
					type:"get",
					success: function (data) {
						console.log(data);
						console.log("들어오는지 확인 ")
						
						$select = $("#reviewResult");
						$select.find("table").remove();
						
						for(var i in data){
							/* var $option = $("<option>");
							$option.val(data[index].userNo);
							$option.text(data[index].userName);
							$select.append($option); */
							var reviewDate = decodeURIComponent(data[i].reviewDate);
							var reviewGrade = decodeURIComponent(data[i].reviewGrade);
							var memberId = decodeURIComponent(data[i].memberId);
							var reviewContext = decodeURIComponent(data[i].reviewContext);
							
							$select.append(
									'<table style="width: 600px;">'
									+'<tr>'
									+'<td rowspan="2"><img class="mx-auto rounded-circle" src="/dsm/img/team/1.jpg" alt="" style="width: 90px; height: 90px;"></td>'
									+'<td width="80%" style="border-bottom: 1px solid #EAEAEA;">'
									+'<span>'+reviewDate+'</span>'
									+'<span class="rating" style="margin-left: 15px;">'
									+'<input id="rating5_2" type="radio" name="rating2" value="5" checked disabled><label for="rating5_2">5</label>'
									+'<input id="rating4_2" type="radio" name="rating2" value="4" disabled><label for="rating4_2">4</label>'
									+'<input id="rating3_2" type="radio" name="rating2" value="3" disabled><label for="rating3_2">3</label>'
									+'<input id="rating2_2" type="radio" name="rating2" value="2" disabled><label for="rating2_2">2</label>'
									+'<input id="rating1_2" type="radio" name="rating2" value="1" disabled><label for="rating1_2">1</label>'
									+'</span>'
									+'</td>'
									+'</tr>'
									+'<tr>'
									+'<td>'
									+'<div>'
									+'<b>'+memberId+'</b>'
									+'</div>'
									+'<div>'+reviewContext+'</div>'
									+'</td>'
									+'</tr>'
									+'</table>'							
							);
						}
					}					
				});
			});
		});
	</script>
	
	<script>
		$(function () {
			$("#additionalOption").change(function () {
				var totalPrice=0;
				if($("#additionalOption").val() == "<%=pList.get(0).getPlusProductPrice()%>"){
					totalPrice = <%=pList.get(0).getPlusProductPrice()%> + <%= product.getProductItemPrice() %>
					$("#totalPrice").text(totalPrice);
				}else if($("#additionalOption").val() == "<%=pList.get(1).getPlusProductPrice()%>"){
					totalPrice = <%=pList.get(1).getPlusProductPrice()%> + <%= product.getProductItemPrice() %>
					$("#totalPrice").text(totalPrice);
				}else if($("#additionalOption").val() == "<%=pList.get(2).getPlusProductPrice()%>"){
					totalPrice = <%=pList.get(2).getPlusProductPrice()%> + <%= product.getProductItemPrice() %>
					$("#totalPrice").text(totalPrice);
				}else{
					alert("해당 상품은 존재하지 않습니다.")
				}
			});
		});
	</script>

	<!-- Footer ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<%@ include file="/views/common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
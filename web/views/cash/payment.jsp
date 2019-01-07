<%@page import="com.kh.w7.deal.model.vo.Deal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	 	ArrayList<Deal> list = (ArrayList<Deal>)session.getAttribute("payList");
		int totalPrice = 0;
	%>
	<!-- ArrayList<Deal> list = (ArrayList<Deal>)session.getAttribute("payList"); -->
	
	
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
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

<style>
table, tr, td {
	padding: 10px;
}

table {
	width: 100%;
}
</style>

</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<!--/////////////////////////////////////////네비끝, 헤더시작//////////////////////////////////////////////////////////////////////////////////////////////  -->

	<!--/////////////////////////////////////////////헤더끝//////////////////////////////////////////////////////////////////////////////////////////  -->

	<!-- 고객코드, 상품코드로 어떤 상품을 가지고 올지 판단(CostomerMyPage에서 가지고옴)  -->


	<section class="bg-light" id="portfolio">
	<div class="container">
		<div class="row">
			<div class="col-lg-12 text-center">
				<h2 class="section-heading text-uppercase">주문확인</h2>
				<h3 class="section-subheading text-muted">
					<hr>
				</h3>
			</div>
		</div>

		<div style="border: 1px solid black; padding: 30px;">
			<table>
				<tr>
					<!--	(괄호)request.getContextPath()(괄호)/image_uploadFiles/(괄호)detailImg1.getChangeName()(괄호)  -->
					<%-- <td width = "20%" rowspan="3"><img src="<%= list.get(0).getImgFilePath() %>" alt="판매자 상품 이미지"></td> --%>
					<td width = "20%" rowspan="3"><img src="<%= request.getContextPath() %>/image_uploadFiles/<%= list.get(0).getChangedImgName() %>" alt="판매자 상품 이미지" width = "300px"></td>
					<td><h4><%= list.get(0).getProductTitle() %></h4></td>
					<td></td>
				</tr>
				<tr>
					<td rowspan="2"><%= list.get(0).getProductContext() %><br></td>
					<td></td>

				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr style="background: lightgray;">
					<td style="font-weight: bold;">기본항목</td>
					<td></td>
					<td>가격</td>
				</tr>
				<tr>
					<td><%= list.get(0).getMainProductName()%><!-- 기본항목 이름 --></td>
					<td></td>
					<td><%= list.get(0).getMainProductPrice()%><!-- 기본항목 가격 --></td>
				</tr>
				<tr style="background: lightgray;">
					<td style="font-weight: bold;">추가항목</td>
					<td></td>
					<td>가격</td>
				</tr>
				<%
				totalPrice = list.get(0).getMainProductPrice(); 
				
				for(int i = 0; i < list.size() ; i++){ %>
				<tr>
					<td><%= list.get(i).getSubProductName()%><!-- 추가항목 이름 --></td>
					<td>
						<!-- 예상소요일 -->
					</td>
					<td><%= list.get(i).getSubProductPrice() %><!-- 추가금액 --></td>
				</tr>
				<% 
				totalPrice += list.get(i).getSubProductPrice();
				} %>
			</table>

		</div>
		

		<div style="background: lightyellow; width: 100%;">
			<table style="margin: 30px 0 0 0; width: 104.7%;">
				<tr
					style="background: lightgray; margin: 30px 0px 30px 0px; height: 40px;">
					<th>&nbsp;&nbsp;&nbsp;결제금액</th>
					<th></th>
					<th></th>
				</tr>

				<tr>
					<td style="text-align: left; font-size: 1.3em; font-weight: bold;">총결제금액(VAT포함)</td>
					<td></td>
					<td rowspan="3" style="text-align: right;"><button
							type="button" class="btn btn-warning"
							style="width: 200px; height: 100px; font-size: 1.8em" id = "dealButton">결제하기</button></td>
				</tr>
				<tr>
					<td style="text-align: left; color: gray; font-weight: bold;">나의
						보유 캐시 : <%= list.get(0).getMemberNowCash()%><!-- 보유캐시 들어가는부분 -->
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td
						style="text-align: left; font-size: 1.8em; color: red; font-weight: bold;"><%= totalPrice%><!-- 결제금액 들어가는 부분 --></td>
					<td></td>
					<td></td>
				</tr>

			</table>
		</div>
		<!-- <img class="img-fluid" src="../../img/lockIcon.jpg" alt="결제보안아이콘"> -->
		<ul style="margin: 30px 0 0 0;">
			<li>DMS은 에스크로 결제 서비스를 이용하여 안전한 거래 환경을 제공합니다.</li>
			<li>DMS을 통해 결제 진행 시 관련 정책에 의해 보호 받을 수 있습니다.</li>
		</ul>



	</div>
	</section>

	<script>
		$(function(){
			/* 결제버튼 클릭시 금액 계산해서 돈 있으면 결제 진행, 부족하면 alert창 띄우면서 돌아가기  */
			$("#dealButton").click(function(){
				if(<%= totalPrice%> < <%= list.get(0).getMemberNowCash()%>){
					//가진금액이 더 많음
					console.log("가진금액이 더 많음");
					//거래 내용이 진행되며 저장되는 서블릿으로 이동
					/*필요한게 1.소비자 코드(해당 소비자 캐시 변경), 2. 거래번호(신청 상태인것을 진행상태로 변경), 3. 판매자코드(해당 판매자의 캐시 변경) , 4. 거래금액(거래금액만큼 맴버들의 캐시를 변화시킴) */
					$.ajax({
						url : "<%= request.getContextPath()%>/updateDealCash",
						data : {customerCode : <%= list.get(0).getCustomerCode()%>,
								sellerCode : <%= list.get(0).getSellerCode()%>,
								dealNo : <%= list.get(0).getDealNo()%>,
								totalPrice : <%= totalPrice%>,
								nowCash : <%= list.get(0).getMemberNowCash()%>},
						type : "post",
						success : function(data){
							if(data > 0){
								swal("결제가 성공했습니다!", "ok버튼 클릭시 메인페이지로 이동합니다", "success").then((value) =>{
									if(value = "ok"){
										
										location.href = "/dsm/index.jsp";
									}
								});
							}else{
								
								location.href = "/dsm/views/common/errorPage.jsp";
							}
						},
						error : function(data){
							console.log("실패!");
						}
					});
					<%-- //location.href = "<%= request.getContextPath()%>/updateDealCash"; --%>
					//인자로 전달해서 판매자, 소비자의 캐시가 업데이트 되도록하는 서블릿작성
					
				}else{
					//결제하려는 금액이 더 많을때
					console.log("결제하려는 금액이 더 많을때");
					swal("캐시가 부족합니다!", "버튼을 눌러 충전을 해주세요", "error").then((value) =>{
						if(value = "ok"){
							location.href = '/dsm/selectUser.pa?memberCode=' + <%= loginUser.getMemberCode()%>;
							
							
							
						}
						});
				}
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
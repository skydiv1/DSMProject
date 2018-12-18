<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%@ include file="../common/navi.jsp"%>
	<!--/////////////////////////////////////////네비끝, 헤더시작//////////////////////////////////////////////////////////////////////////////////////////////  -->

	<!--/////////////////////////////////////////////헤더끝//////////////////////////////////////////////////////////////////////////////////////////  -->



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
					<td rowspan="3"><img src="../../img/wedding.jpg" alt="결혼사진"></td>
					<td><h4>멋있는 드론 촬영과 영상에 맞는 보정</h4></td>
					<td></td>
				</tr>
				<tr>
					<td rowspan="2">지역 : 수도권 외 지방 촬영<br> 실내외 : 무관<br> 추가
						비용 : (교통비 포함, 항공비의 경우 별도) <br> 팬텀보유 장비 : 인스파이어,매빅,스파크 <br>
						예상 작업일 : 4일<br></td>
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
					<td>드론영상촬영<!-- 기본항목 이름 --></td>
					<td></td>
					<td>35000<!-- 기본항목 가격 --></td>
				</tr>
				<tr style="background: lightgray;">
					<td style="font-weight: bold;">추가항목</td>
					<td>소요시간</td>
					<td>가격</td>
				</tr>
				<tr>
					<td>영상편집<!-- 추가항목 이름 --></td>
					<td>+3일<!-- 예상소요일 --></td>
					<td>10000<!-- 추가금액 --></td>
				</tr>

			</table>

		</div>
		6
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
							style="width: 200px; height: 100px; font-size: 1.8em">결제하기</button></td>
				</tr>
				<tr>
					<td style="text-align: left; color: gray; font-weight: bold;">나의
						보유 캐시 : 580,000<!-- 보유캐시 들어가는부분 -->
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td
						style="text-align: left; font-size: 1.8em; color: red; font-weight: bold;">400,000<!-- 결제금액 들어가는 부분 --></td>
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
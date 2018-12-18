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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/navi.jsp"%>
	<!--/////////////////////////////////////////네비끝, 헤더시작//////////////////////////////////////////////////////////////////////////////////////////////  -->

	<!--/////////////////////////////////////////////헤더끝//////////////////////////////////////////////////////////////////////////////////////////  -->




	<section class="bg-light" id="portfolio">
	<div class="container">
		<div class="row" style="width: 70%; display: inline-block;">
			<div>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col" colspan="2">캐시충전</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>￦5,000</th>
							<td style="text-align: right;"><button onclick="minusBtn1()">-</button>
								<label>&nbsp;&nbsp;</label><label id="la1">0</label><label>&nbsp;&nbsp;</label>
							<button onclick="plusBtn1()">+</button></td>
						</tr>
						<!-- 버튼이 클릭될때마다 가운데 숫자가 바뀌게 스크립트 작성 -->
						<tr>
							<th>￦10,000</th>
							<td style="text-align: right;"><button onclick="minusBtn2()">-</button>
								<label>&nbsp;&nbsp;</label><label id="la2">0</label><label>&nbsp;&nbsp;</label>
							<button onclick="plusBtn2()">+</button></td>
						</tr>
						<tr>
							<th>￦30,000</th>
							<td style="text-align: right;"><button onclick="minusBtn3()">-</button>
								<label>&nbsp;&nbsp;</label><label id="la3">0</label><label>&nbsp;&nbsp;</label>
							<button onclick="plusBtn3()">+</button></td>
						</tr>
						<tr>
							<th>￦50,000</th>
							<td style="text-align: right;"><button onclick="minusBtn4()">-</button>
								<label>&nbsp;&nbsp;</label><label id="la4">0</label><label>&nbsp;&nbsp;</label>
							<button onclick="plusBtn4()">+</button></td>
						</tr>
					</tbody>
				</table>

				<script>
					function minusBtn1() {
						var num = Number($("#la1").text());
						if (num > 0)
							$("#la1").text(num - 1);
					}
					function plusBtn1() {
						var num = Number($("#la1").text());
						$("#la1").text(num + 1);
					}

					function minusBtn2() {
						var num = Number($("#la2").text());
						if (num > 0)
							$("#la2").text(num - 1);
					}
					function plusBtn2() {
						var num = Number($("#la2").text());
						$("#la2").text(num + 1);
					}

					function minusBtn3() {
						var num = Number($("#la3").text());
						if (num > 0)
							$("#la3").text(num - 1);
					}
					function plusBtn3() {
						var num = Number($("#la3").text());
						$("#la3").text(num + 1);
					}

					function minusBtn4() {
						var num = Number($("#la4").text());
						if (num > 0)
							$("#la4").text(num - 1);
					}
					function plusBtn4() {
						var num = Number($("#la4").text());
						$("#la4").text(num + 1);
					}
				</script>
				<br> <br> <br>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col" colspan="4">결제방법</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="radio" name="paymentMethod"
								value="creditCard">신용카드</td>
							<td><input type="radio" name="paymentMethod"
								value="checkCard">체크카드</td>
							<td><input type="radio" name="paymentMethod"
								value="depositless">무통장입금</td>
							<td><input type="radio" name="paymentMethod"
								value="giftCard">문화상품권</td>
						</tr>
					</tbody>
				</table>



				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col" colspan="4">필독!!!</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>▶충전한 캐시 환불 시 무상으로 지급받은 보너스 캐시는 자동으로 환수됩니다.<br> ▶캐시를
								충전하여 발급받은 신용카드 전표/현금영수증은 개인 소득공제용으로만 사용 가능합니다.<br> ▶매입세액공제용
								영수증이 필요한 의뢰인에게는, '기업 전문가'가 직접 세금계산서를 발행합니다.<br> ▶'DSM' 캐시는
								'통장'의 의미를 가지고 있으며, 사이트 내 거래를 위해 편의상 보관되는 금액이므로 세금 계산서 발행이
								불가능합니다.<br> &nbsp;&nbsp;&nbsp;&nbsp;(DSM 으로 세금계산서 발행요청을
								자제부탁드립니다.)<br>
							</td>
						</tr>
					</tbody>
				</table>

			</div>
		</div>

		<div
			style="float: right; background: lightyellow; width: 20%; height: 70%;">

			<table>
				<tr>
					<td colspan="2"
						style="text-align: right; font-size: 1.3em; font-weight: bold;">보유캐시</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"
						style="text-align: right; font-size: 1.3em; font-weight: bold; color: red;">50,000</td>
					<td></td>
				</tr>
				<tr>
					<td><br>
					<hr>
						<br></td>
					<td></td>
				</tr>
				<tr>
					<td style="text-align: left; font-size: 1.3em; font-weight: bold;">충전캐시</td>
					<td
						style="text-align: right; font-size: 1.3em; font-weight: bold; color: red;">65,000</td>
				</tr>
				<tr>
					<td style="text-align: left; font-size: 1.3em; font-weight: bold;">충전
						후 캐시</td>
					<td
						style="text-align: right; font-size: 1.3em; font-weight: bold; color: red;">565,000</td>
				</tr>
				<tr>
					<td colspan="2"
						style="text-align: left; font-size: 1.3em; font-weight: bold;">총
						결제 캐시</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"
						style="text-align: right; font-size: 1.7em; font-weight: bold; color: red;">65,000</td>
					<td></td>
				</tr>
				<tr>
					<td><br>
					<hr>
						<br></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><button type="button" class="btn btn-light"
							style="width: 108%;">취소하기</button></td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2"><button type="button" class="btn btn-danger"
							style="width: 108%; height: 100px" onclick = "location.href = '/dsm/views/common/impordPayment.jsp'">충전하기</button></td>
					<td></td>
				</tr>
			</table>

		</div>
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
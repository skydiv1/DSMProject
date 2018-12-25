<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
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
 		.ft01{
	        font-family: Open Sans Condensed;
	     }
		input::placeholder {
		  font-style: italic;
		  font-size : 0.7em;
		}
		table,tr,td{
			padding : 10px;
			
		}

		.tRow{
			background : lightgray;
			text-align : center;
			padding : auto 0; !important
		}
		th{
			width : 10%;
			
			
		}
		td{
			width : 50%;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  </head>
<body>
<%@ include file = "../common/navi.jsp" %>
<!--/////////////////////////////////////////네비끝, 헤더시작//////////////////////////////////////////////////////////////////////////////////////////////  -->

<!--/////////////////////////////////////////////헤더끝//////////////////////////////////////////////////////////////////////////////////////////  -->




<section class="bg-light" id="portfolio">
<div class="container" align = "center">
	<div align = "center">
		<div  style = "font-size : 1.3em; font-weight : bold;">user1님의 환급 신청 가능한 금액은</div>
		<div id = "refundMoney"  style = "font-size : 1.7em; font-weight : bold; color : red;">580000<div style = "display : inline; color : black; font-size : 0.8em; font-weight : bold;">원 입니다</div></div>
     	<div  style = "font-size : 1.3em; font-weight : bold;">아래 환급계좌 정보를 입력해 주세요.</div>
      	<div  style = "font-size : 1.0em; font-weight : bold; color : gray;">환급처리는 일반적으로 신청일로부터 2일 후(토,일, 공휴일제외)에 일괄 처리됩니다.</div>
	</div>
	
	<br><br><br><br>
	
	<div style = "font-size : 1.8em; font-weight : bold; color : gray;">환급 계좌 정보 입력 </div>
	<br>
	
	<table class="table"  style = "width : 60%">
	  <thead class="thead-dark">
	  </thead>
	  <tbody>
	    <tr>
	      <th class="tRow" >예금주</th>
	      <td ><input type = "text" name = "refundsName" placeholder = "성함을 입력하세요"></td>
	
	    </tr>
	    <tr>
	      <th class="tRow">생년월일</th>
	      <td><input type = "text" name = "refundsBirth" placeholder = "생년월일 6자리를 입력하세요">&nbsp;&nbsp;<div style = "color : gray;  display : inline; font-size : 0.8em;">예)831027</div></td>
	
	    </tr>
	    <tr>
	      <th class="tRow">은행선택</th>
	      <td><select name = "refundsBank">
	      	<option value = "">은행 선택</option>
	       	<option value = "국민은행">국민은행</option>
	        <option value = "신한은행">신한은행</option>
	        <option value = "기업은행">기업은행</option>
	        <option value = "우리은행">우리은행</option>
	        <option value = "하나은행">하나은행</option>
	        <option value = "농협">농협</option>
	        <option value = "지역농협">지역농협</option>
	      </select></td>
	
	    </tr>
	    <tr>
	      <th class="tRow">계좌번호</th>
	      <td><input type = "text" name = "refundsAccount" placeholder = "-를 포함하여 숫자를 입력해주세요" style = "width : 300px"></td>
	
	    </tr>
	    <tr>
	      <th style = "vertical-align: middle;" class="tRow">계좌인증</th>
	      <td id = "printEffectiveness"><button type="button" class="btn btn-danger" name = "refundsCertification" id = "accountCertBtn">계좌 인증하기</button></td>
	    </tr>
	    <tr>
	      <th style = "vertical-align: middle;" class="tRow">환급동의</th>
	      <td class="p-2 text-dark">본인은  환급급액에 대해 위 계좌를 환급되는 것에 동의합니다.  타인계좌로 환급 요청시, 이에 대한 모든 법적인 책임은 본인에게 있습니다.<br>
	      	<div style = "color : red;  display : inline">위 내용에 확인하였으며, 이에 동의합니다.</div><input type = "checkbox" name = "refundsAgree"></td>
	
	    </tr>
	  </tbody>
	</table>
	
	<br>
	
	<button type="button" class="btn btn-warning" style = "width : 200px;" id = "applyRefundBtn">신청하기</button>
</div>
</section>


<script>
	$(function(){
		$("#accountCertBtn").click(function(){
			var name = $("input[name = refundsName]").val();
			var birth = $("input[name = refundsBirth]").val();
			var bank = $("select[name = refundsBank]").val();
			var account = $("input[name = refundsAccount]").val();
			
			$.ajax({
				url : "/dsm/accountCert.re",
				data : {name : name,
						birth : birth,
						bank : bank,
						account : account},
				type : "post",
				success : function(data){
					//console.log(data);
					$("#printEffectiveness").append("&nbsp;&nbsp;&nbsp;"+data).css({"color" : "red"});
				},
				error : function(){
					console.log("실패!");
				}
			});
		});
	});
	
	$(function(){
		$("#applyRefundBtn").click(function(){
			var name = $("input[name = refundsName]").val();
			var birth = $("input[name = refundsBirth]").val();
			var bank = $("select[name = refundsBank]").val();
			var account = $("input[name = refundsAccount]").val();
			var refundMoney = $("#refundMoney").text();
			
			location.href = "/dsm/index.jsp"; //페이지 이동 후 값 삽입
			
			$.ajax({
				url : "/dsm/applyRefund.re",
				data : {name : name,
						birth : birth,
						bank : bank,
						account : account,
						refundMoney : refundMoney},
				type : "post",
				success : function(data){
					console.log(data);

				},
				error : function(){
					console.log("실패!");
					
				}
			});
		});
	});

</script>






<%@ include file = "../common/footer.jsp" %>

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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<script>
   var chargeMoney = <%= request.getParameter("chargeMoney")%>;
   var memberCode = <%= request.getParameter("memberCode")%>;

   
   var IMP = window.IMP; 
   IMP.init('imp11530773');
   
   IMP.request_pay({
	    pg : 'kakaopay',
	    pay_method : 'card',
	    merchant_uid : 'merchant_' + new Date().getTime(),
	    name : 'DSM_CashCharge',
	    amount : chargeMoney,
	    buyer_code : memberCode
	}, function(rsp) {
	    if ( rsp.success ) {

	    	jQuery.ajax({
	    		url: "/dsm/saveCharge.pa",
	    		type: 'POST',
	    		dataType: 'json',
	    		data: {
	    			buyer_code : memberCode, 
	    			amount : chargeMoney,
		    		imp_uid : rsp.imp_uid
	    		},
	    		success : function(data){
	    			if(data > 0) {
						page = "/dsm/index.jsp";
						swal("Charge is complete!", "when you click 'OK'button return to mainPage", "success").then((value) =>{
							if(value = "ok"){
								location.href = page;
							}
						});
						
						
					}else {
						page = "/dsm/views/common/errorPage.jsp";
						location.href = page;

					}
	    		}
	    	}).done(function(data) {
	    		if ( everythings_fine ) {
	    			var msg = '결제가 완료되었습니다.';
	    			msg += '\n고유ID : ' + rsp.imp_uid;
	    			msg += '\n상점 거래ID : ' + rsp.merchant_uid;
	    			msg += '\결제 금액 : ' + rsp.paid_amount;
	    			msg += '카드 승인번호 : ' + rsp.apply_num;
	    			
	    			alert(msg);
	    		} else {

	    		}
	    	});
	    } else {
	        var msg = '결제에 실패하였습니다.';
	        msg += '에러내용 : ' + rsp.error_msg;
	        
	        alert(msg);
	    }
	});
</script>

</body>
</html>
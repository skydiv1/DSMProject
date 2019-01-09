<%@page import="com.kh.w7.mypage.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>판매자 마이페이지</title>
<style type="text/css">
.bg-light{
	padding-top: 100px;
	padding-bottom: 50px;
}
 th{
 	background-color:#EAEAEA;
 }
  
 .td1{
	border-right:solid 1px black;
 }

</style>
<script type="text/javascript">
function addBtnEvent() {

	   //대기자 목록에서 거절하기버튼 누를때
	  $(".cBtn").click(function () {
		  var no = $(this).parent().parent().children().eq(1).text();
			$("#dealnum").val(no);
			
	  });
	 
	
	//취소 팝업에 있는 보내기 버튼 누를때
	  $("#cancelBtn").click(function () {
		  var textContent = $("#textContent").val();//신청취소사유
			var dealnum = $("#dealnum").val();
		  
			console.log("textContent:"+textContent);
			console.log("dealnum:"+dealnum);
			$.ajax({
				url:"${pageContext.request.contextPath}/cancelupdate.seller",
				type : "get",
				data : {dealnum:dealnum, textContent:textContent},
				success : function (data) {
					selectListWaiting(1);
					 selectListCencelseller(1);
				}
			});
	  });
	 
	  //대기자 목록에서 수락하기버튼 누를때
	  $(".agBtn").click(function () {
		  var no = $(this).parent().parent().children().eq(1).text();
			$("#agreedealnum").val(no);
	  });
	  
	  
	  //수락 팝업에 있는 보내기 버튼 누를때
	    $("#agreeBtn").click(function () {
		var agreeMsg = $("#agreeMsg").val();//수락 추가사유
		var agreedealnum = $("#agreedealnum").val();
		console.log("agreeMsg:"+agreeMsg);
		console.log("agreedealnum:"+agreedealnum);
		$.ajax({
			url:"${pageContext.request.contextPath}/agree.seller",
			type : "get",
			data : {agreedealnum:agreedealnum, agreeMsg:agreeMsg},
			success : function (data) {
				selectListWaiting(1);
				selectListDealprogress(1);
				
			}
		});
	}); 
	  
	
	  
	  //판매글 목록에서 게시글 수정하기 버튼 누를때
	  $(".productModify").click(function () {
		  
		  var num = $(this).parent().parent().children().eq(1).text();//제품번호
		  location.href="<%=request.getContextPath()%>/selectProduct.pr?num="+num;
	});
	  
	  
	  //취소 목록에서 삭제 버튼 눌렀을때
		 $(".cancelDelete").click(function () {
			 var dealnum = $(this).parent().parent().children().eq(1).text();
				$.ajax({
					url:"${pageContext.request.contextPath}/canceldelete.consumer",
					type : "get",
					data : {dealnum:dealnum},
					success : function (data) {
						selectListCencelseller(1);
					}
				});
		}); 
}




//내가쓴 판매글 목록 ajax
function selectListProduct(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.sellerProduct",
			type :"get",
			data : {currentPage : pg},
			success : function (data) {
				
				var productListHtml = [];
				var no =0;
				for(var i=0; i<data.prolist.length; i++){
					productListHtml.push('<tr>');
					productListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					productListHtml.push('	<td class="td1" style="display: none">' +data.prolist[i].productNo + '</td>');
					productListHtml.push('	<td class="td1">' +data.prolist[i].productName + '</td>');
					productListHtml.push('	<td>' +data.prolist[i].productContext+ '</td>');
					productListHtml.push('	<td style="width: 20px"><button type="button" class="btn btn-secondary productModify">게시글 수정하기</button></td>');
					productListHtml.push('</tr>');
					
				    
				}
				$("#productboard").html("");//이전틀 지우고
				$("#productboard").append(productListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				//페이징 처리
			 	var productPageHtml= [];
			 	productPageHtml.push('<button onclick="selectListProduct(1)"><<</button>');
				if(pg <=1){
					productPageHtml.push('<button disabled><</button>');
				}else{
					productPageHtml.push('<button onclick="selectListProduct(' + (pg-1) + ')"><</button>');
				}
				for(var p = data.startPage; p<= data.endPage; p++) {
					if(p == pg){
						productPageHtml.push('<button disabled>'+p+'</button>');
					}else{
						productPageHtml.push('<button onclick="selectListProduct('+p+')">'+p+'</button>');
						}
					}
				if(pg >= data.maxPage){ 
					productPageHtml.push('<button disabled>></button>');
				}else{
					productPageHtml.push('<button onclick="selectListProduct('+(pg+1)+')">></button>');
				}
				productPageHtml.push('<button onclick="selectListProduct('+data.maxPage +')">>></button>');
				
					$("#ProductPagingArea").html("");
					$("#ProductPagingArea").append(productPageHtml.join(""));
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}

//대기자 목록 ajax
function selectListWaiting(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.wait",
			type :"get",
			data : {currentPage : pg},
			success : function (data) {
				
				var waitListHtml = [];
				
				for(var i=0; i<data.wlist.length; i++){
					waitListHtml.push('<tr>');
					waitListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					waitListHtml.push('	<td class="td1" style="display: none">' +data.wlist[i].dealNo + '</td>');
					waitListHtml.push('	<td class="td1">' +data.wlist[i].member_id + '</td>');
					waitListHtml.push('	<td class="td1">' +data.wlist[i].productName+ '</td>');
					waitListHtml.push('	<td>' +data.wlist[i].dealListaddMsg1 + '</td>');
					waitListHtml.push('	<td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning agBtn"data-toggle="modal" data-target="#agreeModal">수락하기</button></td>');
					waitListHtml.push('	<td style="width: 5px"><button type="button" class="btn btn-secondary cBtn" data-toggle="modal" data-target="#cencelModal">거절</button></td>');
					waitListHtml.push('</tr>');
					
				}
				$("#waitingList").html("");//이전틀 지우고
				$("#waitingList").append(waitListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
				//페이징 처리
			 	var waitPageHtml= [];
			 	waitPageHtml.push('<button onclick="selectListWaiting(1)"><<</button>');
				if(pg <=1){
					waitPageHtml.push('<button disabled><</button>');
				}else{
					waitPageHtml.push('<button onclick="selectListWaiting(' + (pg-1) + ')"><</button>');
				}
				for(var p = data.startPage; p<= data.endPage; p++) {
					if(p == pg){
						waitPageHtml.push('<button disabled>'+p+'</button>');
					}else{
						waitPageHtml.push('<button onclick="selectListWaiting('+p+')">'+p+'</button>');
						}
					}
				if(pg >= data.maxPage){ 
					waitPageHtml.push('<button disabled>></button>');
				}else{
					waitPageHtml.push('<button onclick="selectListWaiting('+(pg+1)+')">></button>');
				}
				waitPageHtml.push('<button onclick="selectListWaiting('+data.maxPage +')">>></button>');
				
					$("#WaitingPagingArea").html("");
					$("#WaitingPagingArea").append(waitPageHtml.join(""));
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}
//구매진행 목록 ajax(수락이(0)랑 결제완료(3)보여줌)
function selectListDealprogress(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.progress",
			type :"get",
			data : {currentPage : pg},
			success : function (data) {
				
				var progressListHtml = [];
				var no =0;
				for(var i=0; i<data.progresslist.length; i++){
					progressListHtml.push('<tr>');
					progressListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					progressListHtml.push('	<td class="td1" style="display: none">' +data.progresslist[i].dealNo + '</td>');
					progressListHtml.push('	<td class="td1">' +data.progresslist[i].member_id + '</td>');
					progressListHtml.push('	<td class="td1">' +data.progresslist[i].productName+ '</td>');
					progressListHtml.push('	<td class="td1">' +data.progresslist[i].dealListaddMsg1 + '</td>');
					progressListHtml.push('	<td class="td1">' +data.progresslist[i].dealListaddMsg2 + '</td>');
				
					 if(data.progresslist[i].dealListCategory==1){
						progressListHtml.push('	<td>' + "구매 진행 중" +'</td>');
					}else{
						progressListHtml.push('	<td>' + "구매 완료 " +'</td>');	
					} 
					progressListHtml.push('</tr>'); 
					
				}
				$("#dealprogressList").html("");//이전틀 지우고
				$("#dealprogressList").append(progressListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
				//페이징 처리
			 	var progressPageHtml= [];
			 		progressPageHtml.push('<button onclick="selectListDealprogress(1)"><<</button>');
				if(pg <=1){
					progressPageHtml.push('<button disabled><</button>');
				}else{
					progressPageHtml.push('<button onclick="selectListDealprogress(' + (pg-1) + ')"><</button>');
				}
				for(var p = data.startPage; p<= data.endPage; p++) {
					if(p == pg){
						progressPageHtml.push('<button disabled>'+p+'</button>');
					}else{
						progressPageHtml.push('<button onclick="selectListDealprogress('+p+')">'+p+'</button>');
						}
					}
				if(pg >= data.maxPage){ 
					progressPageHtml.push('<button disabled>></button>');
				}else{
					progressPageHtml.push('<button onclick="selectListDealprogress('+(pg+1)+')">></button>');
				}
					progressPageHtml.push('<button onclick="selectListDealprogress('+data.maxPage +')">>></button>');
				
					$("#ProgressPagingArea").html("");
					$("#ProgressPagingArea").append(progressPageHtml.join(""));
					 
					 
				
				
				 
				 
				 
			}
		});
	}
	
//취소 목록 ajax
function selectListCencelseller(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.SellerCan",
			type :"get",
			data : {currentPage : pg},
			success : function (data) {
				console.log(data);
				
				var scListHtml = [];
				var no =0;
				for(var i=0; i<data.scclist.length; i++){
					scListHtml.push('<tr>');
					scListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					scListHtml.push('	<td class="td1" style="display: none">' +data.scclist[i].dealNo + '</td>');
					scListHtml.push('	<td class="td1">' +data.scclist[i].member_id + '</td>');
					scListHtml.push('	<td class="td1">' +data.scclist[i].productName+ '</td>');
					scListHtml.push('	<td class="td1">' +data.scclist[i].dealListaddMsg1 + '</td>');
					scListHtml.push('	<td>' +data.scclist[i].dealListaddMsg2 + '</td>');
					scListHtml.push('	<td style="width: 10px"><button type="button" class="btn btn-secondary cancelDelete">삭제</button></td>');
					scListHtml.push('</tr>');
					
					
				}
				$("#cancelSellerList").html("");//이전틀 지우고
				$("#cancelSellerList").append(scListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				//페이징 처리
			 	var ccPageHtml= [];
			 	ccPageHtml.push('<button onclick="selectListCencelseller(1)"><<</button>');
				if(pg <=1){
					ccPageHtml.push('<button disabled><</button>');
				}else{
					ccPageHtml.push('<button onclick="selectListCencelseller(' + (pg-1) + ')"><</button>');
				}
				for(var p = data.startPage; p<= data.endPage; p++) {
					if(p == pg){
						ccPageHtml.push('<button disabled>'+p+'</button>');
					}else{
						ccPageHtml.push('<button onclick="selectListCencelseller('+p+')">'+p+'</button>');
						}
					}
				if(pg >= data.maxPage){ 
					ccPageHtml.push('<button disabled>></button>');
				}else{
					ccPageHtml.push('<button onclick="selectListCencelseller('+(pg+1)+')">></button>');
				}
				ccPageHtml.push('<button onclick="selectListCencelseller('+data.maxPage +')">>></button>');
				
					$("#CancelSellerPagingArea").html("");
					$("#CancelSellerPagingArea").append(ccPageHtml.join(""));
					 
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}	
	
//판매완료 목록 ajax
function selectListEndseller(pg) {
		
	$.ajax({
		url : "${pageContext.request.contextPath}/selectList.endSeller",
		type :"get",
		data : {currentPage : pg},
		success : function (data) {
			
			var endListHtml = [];
			var no =0;
			console.log(typeof(data[0].dealListCategory));
			for(var i=0; i<data.endlist.length; i++){
				endListHtml.push('<tr>');
				endListHtml.push('	<th scope="row">' + (i+1) + '</th>');
				endListHtml.push('	<td class="td1">' +data.endlist[i].member_id + '</td>');
				endListHtml.push('	<td class="td1">' +data.endlist[i].productName+ '</td>');
				endListHtml.push('	<td class="td1">' +data.endlist[i].dealListaddMsg1 + '</td>');
			
				 if(data.endlist[i].dealListCategory==3){
					 endListHtml.push('	<td>' + "구매확정 전" +'</td>');
				}else{
					endListHtml.push('	<td>' + "구매확정 완료 " +'</td>');	
				} 
				 endListHtml.push('</tr>'); 
				
				
			}
			$("#endDealList").html("");//이전틀 지우고
			$("#endDealList").append(endListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
			
			//페이징 처리
		 	var endPageHtml= [];
		 		endPageHtml.push('<button onclick="selectListEndseller(1)"><<</button>');
			if(pg <=1){
				endPageHtml.push('<button disabled><</button>');
			}else{
				endPageHtml.push('<button onclick="selectListEndseller(' + (pg-1) + ')"><</button>');
			}
			for(var p = data.startPage; p<= data.endPage; p++) {
				if(p == pg){
					endPageHtml.push('<button disabled>'+p+'</button>');
				}else{
					endPageHtml.push('<button onclick="selectListEndseller('+p+')">'+p+'</button>');
					}
				}
			if(pg >= data.maxPage){ 
				endPageHtml.push('<button disabled>></button>');
			}else{
				endPageHtml.push('<button onclick="selectListEndseller('+(pg+1)+')">></button>');
			}
				endPageHtml.push('<button onclick="selectListEndseller('+data.maxPage +')">>></button>');
			
				$("#EnddealPagingArea").html("");
				$("#EnddealPagingArea").append(endPageHtml.join(""));
				 
			
				 
				 
				 
			}
		});
	}	
	
	
//환급 목록 ajax
function selectListCash(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.SellerCash",
			type :"get",
			data : {currentPage : pg},
			success : function (data) {
				console.log(data);
				
				var cashListHtml = [];
				var no =0;
				for(var i=0; i<data.length; i++){
					cashListHtml.push('<tr>');
					cashListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					cashListHtml.push('	<td class="td1">' +data[i].refund_applyDate + '</td>');
					cashListHtml.push('	<td class="td1">' +data[i].refund_bank+ '</td>');
					cashListHtml.push('	<td class="td1">' +data[i].refund_account + '</td>');
					cashListHtml.push('	<td class="td1">' +data[i].refund_money + '</td>');
					 
					if(data[i].refund_StatusYN==0){
						cashListHtml.push('	<td>' + "환급 진행 중" +'</td>');
					}else{
						cashListHtml.push('	<td>' + "환급 완료 " +'</td>');	
					} 
					cashListHtml.push('</tr>'); 
					 
					
				    
				}
				$("#CashList").html("");//이전틀 지우고
				$("#CashList").append(cashListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				 
				 
			}
		}); 
}

		
//마이페이지 실행시에 뷰페이지 만들고 데이터 뿌려주는 ajax 메인(함수 호출 여기서)
	$(function () {
		selectListProduct(1);
		selectListWaiting(1);
		selectListDealprogress(1);
		selectListCencelseller(1);
		selectListEndseller(1);
		selectListCash(1);
}); 
</script>
</head>
<body>
<!-- 네비게이션 바 -->
		<%@ include file = "../common/menubar.jsp" %>
		<%@ include file = "../common/CancelPopUp.jsp" %>
		<%@ include file = "../common/AgreePopUp.jsp" %>

<!-- 나의 판매글 -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">나의 판매글 </h2>
               <h3 class="section-subheading text-muted">
                  <hr style="border: solid 1px darkgray">
               </h3>
            </div>
         </div>
         <div class="row">
          <table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col" class="td1" style="display: none">판매글번호</th>
			      <th scope="col" class="td1">게시글 제목</th>
			      <th scope="col" >게시글 내용</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody id="productboard">
			  <!-- ajax도는 부분 -->
			  </tbody>
			</table>

         </div>
         
   			<div class="pagingArea" align="center" id="ProductPagingArea">
				<!-- ajax에서 도는부분 -->
			</div>
	
	
      </div>
   </section>
  <!-- 대기자 목록 -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">대기자 목록 </h2>
               <h3 class="section-subheading text-muted">
                  <hr style="border: solid 1px darkgray">
               </h3>
            </div>
         </div>
         <div class="row">
          <table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col" class="td1" style="display: none">거래번호</th>
			      <th scope="col" class="td1">소비자ID</th>
			      <th scope="col" class="td1">판매 상품명</th>
			      <th scope="col">추가신청 내용</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody id="waitingList">
				<!-- ajax도는부분 -->
			  </tbody>
			</table>
         </div>
         	<div class="pagingArea" align="center" id="WaitingPagingArea">
				<!-- ajax에서 도는부분 -->
			</div>
      </div>
   </section>
    <!-- 구매진행 목록 -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">구매진행 목록 </h2>
               <h3 class="section-subheading text-muted">
                  <hr style="border: solid 1px darkgray">
               </h3>
            </div>
         </div>
         <div class="row">
          <table class="table table-hover">
				  <thead>
				    <tr>
				     <th scope="col">No</th>
				     <th scope="col" class="td1" style="display: none">거래번호</th>
				      <th scope="col" class="td1">소비자ID</th>
				      <th scope="col" class="td1">판매 상품명</th>
				      <th scope="col" class="td1">추가신청 내용</th>
				      <th scope="col" class="td1">수락 내용</th>
				      <th scope="col">진행상황</th>
				    </tr>
				  </thead>
				  <tbody id="dealprogressList">
				   <!-- ajax도는 부분 -->
				  </tbody>
				</table>
         </div>
         <div class="pagingArea" align="center" id="ProgressPagingArea">
				<!-- ajax에서 도는부분 -->
				</div>
      </div>
   </section>
    <!-- 취소된 목록 -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">취소 목록 </h2>
               <h3 class="section-subheading text-muted">
                  <hr style="border: solid 1px darkgray">
               </h3>
            </div>
         </div>
         <div class="row">
          <table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col" class="td1" style="display: none">거래번호</th>
			      <th scope="col" class="td1">판매자ID</th>
			      <th scope="col" class="td1">구매상품명</th>
			      <th scope="col" class="td1" >신청 내용</th>
			      <th scope="col" >취소 사유</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody id="cancelSellerList">
			    <!-- ajax도는 부분 -->
			  </tbody>
			</table>
         </div>
         <div class="pagingArea" align="center" id="CancelSellerPagingArea">
				<!-- ajax에서 도는부분 -->
				</div>
         	

      </div>
   </section>
   <!-- 판매완료 목록(구매확정 후꺼) -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">판매완료 목록 </h2>
               <h3 class="section-subheading text-muted">
                  <hr style="border: solid 1px darkgray">
               </h3>
            </div>
         </div>
         <div class="row">
          <table class="table table-hover">
			  <thead>
			    <tr>
			     <th scope="col">No</th>
			      <th scope="col" class="td1">소비자ID</th>
			      <th scope="col" class="td1">판매 상품명</th>
			      <th scope="col" class="td1">추가신청 내용</th>
			      <th scope="col">진행상황</th>
			    </tr>
			  </thead>
			  <tbody id="endDealList">
			 <!-- ajax도는 부분 -->
			  </tbody>
			</table>
         </div>
         
         	<div class="pagingArea" align="center" id="EnddealPagingArea">
				<!-- ajax에서 도는부분 -->
				</div>


      </div>
   </section>
    <!-- 환급내역 -->
   <section class="bg-light" id="portfolio" >
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">환급 내역 </h2>
               <h3 class="section-subheading text-muted">
                  <hr style="border: solid 1px darkgray">
               </h3>
            </div>
         </div>
         <div class="row">
          <table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">No</th>
			      <th scope="col" class="td1">환급 신청 날짜</th>
			      <th scope="col" class="td1">환급 은행</th>
			      <th scope="col" class="td1">환급 계좌</th>
			      <th scope="col" class="td1">환급 금액</th>
			      <th scope="col">진행상황</th>
			    </tr>
			  </thead>
			  <tbody id="CashList">
			    <!--ajax도는 부분 -->
			  </tbody>
			</table>
         </div>
         
             <div class="pagingArea" align="center" id="CashPagingArea">
				<!-- ajax에서 도는부분 -->
				</div> 

      </div>

      
   </section>
   
   <!-- 밑 공백주기용 -->
    <section class="bg-light" id="portfolio" >
      <div style="height: 200px">
      </div>
   </section>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
	
</body>
</html>
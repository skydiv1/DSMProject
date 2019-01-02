<%@page import="com.kh.w7.mypage.model.vo.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>소비자 마이페이지</title>
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

	//취소 팝업에 있는 버튼 누를때
	  $("#cancelBtn").click(function () {
		var textContent = $("#textContent").val();//신청사유
		var dealnum = $("#dealnum").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/cancelupdate.consumer",
			type : "get",
			data : {dealnum:dealnum, textContent:textContent},
			success : function (data) {
				selectListAp();
				selectListCencel();
			}
		});
	}); 
	//목록에서 취소버튼 누를때
	 $("#cBtn").click(function () {
			var no = $(this).parent().parent().children().eq(1).text();
			$("#dealnum").val(no);
			
		
		});
   
	//취소 목록에서 삭제 버튼 눌렀을때
	 $("#cancelDelete").click(function () {
		 var dealnum = $(this).parent().parent().children().eq(1).text();
			$.ajax({
				url:"${pageContext.request.contextPath}/cancelupdate.consumer",
				type : "get",
				data : {dealnum:dealnum},
				success : function (data) {
					selectListCencel();
				}
			});
	});
	
	//수락 목록에서 결제 버튼 눌렀을때
	 $("#dealBtn").click(function () {
		 var dealnum = $(this).parent().parent().children().eq(1).text();
			$.ajax({
				url:"${pageContext.request.contextPath}/selectOneProduct.de",
				type : "get",
				data : {dealnum:dealnum},
				success : function (data) {
					selectListAccept();
					selectListdealcomplete();
				}
			});
	});
	
	//구매완료 목록에서 구매확정 버튼 눌렀을때
	$("#dealcomlete").click(function () {
		var no = $(this).parent().parent().children().eq(1).text();
		$("#reviewdealnum").val(no);
		$("#dealcomlete").attr('disabled',true);
		$("#dealreview").show();
		
	});
	
	//구매완료 목록에서 구매평작성 누를때
	$("#dealreview").click(function () {
		var dealnum = $("#reviewdealnum").val();
		$.ajax({
			url:"${pageContext.request.contextPath}/cancelupdate.consumer",
			type : "get",
			data : {dealnum:dealnum, textContent:textContent},
			success : function (data) {
				selectListAp();
				selectListCencel();
			}
		});
	});  
  }
		
	
	
 



//신청 리스트 ajax
function selectListAp(pg) {
	
	$.ajax({
		url : "${pageContext.request.contextPath}/selectList.ap",
		type :"get",
		data : {currentPage : pg},
		success : function (data) {
			console.log(data);
			
			var apListHtml = [];
			var no =0;
			for(var i=0; i<data.aplist.length; i++){
				apListHtml.push('<tr>');
				apListHtml.push('	<th scope="row">' + (i+1) + '</th>');
				apListHtml.push('	<td class="td1" style="display: none">' +data.aplist[i].dealNo + '</td>');
				apListHtml.push('	<td class="td1">' +data.aplist[i].member_id + '</td>');
				apListHtml.push('	<td class="td1">' +data.aplist[i].productName+ '</td>');
				apListHtml.push('	<td class="td1">' +data.aplist[i].dealListaddMsg + '</td>');
				apListHtml.push('	 <td style="width: 30px"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#cencelModal" id="cBtn" >취소</button></td>');
				apListHtml.push('</tr>');
				
				
			}
			$("#applylist").html("");//이전틀 지우고
			$("#applylist").append(apListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
			
			//페이징 처리
		 	var apPageHtml= [];
			apPageHtml.push('<button onclick="selectListAp(1)"><<</button>');
			if(pg <=1){
				apPageHtml.push('<button disabled><</button>');
			}else{
				apPageHtml.push('<button onclick="selectListAp(' + pg-1 + ')"><</button>');
			}
			for(var p = data.startPage; p<= data.endPage; p++) {
				if(p == pg){
				apPageHtml.push('<button disabled>'+p+'</button>');
				}else{
					apPageHtml.push('<button onclick="selectListAp('+p+')">'+p+'</button>');
					}
				}
			if(pg >= data.maxPage){ 
				apPageHtml.push('<button disabled>></button>');
			}else{
				apPageHtml.push('<button onclick="selectListAp('+pg+1+')">></button>');
			}
				apPageHtml.push('<button onclick="selectListAp('+data.maxPage +')">>></button>');
			
				$("#ApplyPagingArea").html("");
				$("#ApplyPagingArea").append(apPageHtml.join(""));
				 
			
			 addBtnEvent();//버튼 함수 불러오기
			 
			 
			 
		}
	});
}
 //취소 목록 ajax
 function selectListCencel(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.Can",
			type :"get",
			success : function (data) {
				console.log(data);
				
				var apListHtml = [];
				var no =0;
				for(var i=0; i<data.length; i++){
					apListHtml.push('<tr>');
					apListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					apListHtml.push('	<td class="td1" style="display: none">' +data[i].dealNo + '</td>');
					apListHtml.push('	<td class="td1">' +data[i].member_id + '</td>');
					apListHtml.push('	<td class="td1">' +data[i].productName+ '</td>');
					apListHtml.push('	<td class="td1">' +data[i].dealListaddMsg + '</td>');
					apListHtml.push('	<td style="width: 10px"><button type="button" class="btn btn-secondary" id="cancelDelete">삭제</button></td>');
					apListHtml.push('</tr>');
					
					
				}
				$("#cancelList").html("");//이전틀 지우고
				$("#cancelList").append(apListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
					 
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}
 //수락 목록 ajax
 function selectListAccept(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.Acc",
			type :"get",
			success : function (data) {
				
				var accListHtml = [];
				var no =0;
				for(var i=0; i<data.length; i++){
					accListHtml.push('<tr>');
					accListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					accListHtml.push('	<td class="td1" style="display: none">' +data[i].dealNo + '</td>');
					accListHtml.push('	<td class="td1">' +data[i].member_id + '</td>');
					accListHtml.push('	<td class="td1">' +data[i].productName+ '</td>');
					accListHtml.push('	<td class="td1">' +data[i].dealListaddMsg + '</td>');
					accListHtml.push('	<td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning" id="dealBtn">결제하기</button></td>');
					accListHtml.push('	<td style="width: 5px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal" id="cBtn">취소</button></td>');
					accListHtml.push('</tr>');
					
					
				}
				$("#acceptList").html("");//이전틀 지우고
				$("#acceptList").append(accListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
					 
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}
 //구메완료 목록 ajax
 function selectListdealcomplete(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.dc",
			type :"get",
			success : function (data) {
				
				var dcListHtml = [];
				var no =0;
				for(var i=0; i<data.length; i++){
					dcListHtml.push('<tr>');
					dcListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					dcListHtml.push('	<td class="td1" style="display: none">' +data[i].dealNo + '</td>');
					dcListHtml.push('	<td class="td1">' +data[i].member_id + '</td>');
					dcListHtml.push('	<td class="td1">' +data[i].productName+ '</td>');
					dcListHtml.push('	<td class="td1">' +data[i].dealListaddMsg + '</td>');
					dcListHtml.push('	<td style="width: 40px"><button type="button" class="btn btn-secondary" id="dealcomlete">구매확정</button></td>');
					dcListHtml.push('	<td style="width: 40px"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#reviewModal" id="dealreview" style="display: none">구매평 작성</button></td>');
					dcListHtml.push('</tr>');
					
					
				}
				$("#dealcomplete").html("");//이전틀 지우고
				$("#dealcomplete").append(dcListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
					 
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}

//마이페이지 실행시에 뷰페이지 만들고 데이터 뿌려주는 ajax 메인(함수 호출 여기서)
 	$(function () {
 		selectListAp(1);
 		selectListCencel(1);
 		selectListAccept(1);
 		selectListdealcomplete(1);
	}); 
</script>
</head>
<body>
<!-- 네비게이션 바 -->
		<%@ include file = "../common/menubar.jsp" %>
		<%@ include file = "../common/CancelPopUp.jsp" %>
		<%@ include file = "../common/ReviewPopUp.jsp" %>
		<%@ include file = "../common/AskPopUp.jsp" %>
<!-- 신청목록 -->
    <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">신청 목록 </h2>
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
			      <th scope="col" class="td1">신청 내용</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			 
			  <tbody id="applylist">
				<!-- ajax에서 도는부분 -->
			  </tbody>
				
			
			</table>
         </div>
				<div class="pagingArea" align="center" id="ApplyPagingArea">
				<!-- ajax에서 도는부분 -->
				</div>
      </div>
   </section>
  <!-- 수락 목록 -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">수락 목록 </h2>
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
			      <th scope="col" class="td1">구매 상품명</th>
			      <th scope="col" class="td1">신청 내용</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody id="acceptList">
					<!-- ajax도는 부분 -->			    
			  </tbody>
			</table>
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
			      <th scope="col" >취소 사유</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody id="cancelList">
			   <!-- ajax도는 부분 -->
			  </tbody>
			</table>
         </div>
      </div>
   </section>
   <!-- 구매완료 목록 -->
   <section class="bg-light" id="portfolio">
      <div class="container">
         <div class="row">
            <div class="col-lg-12 text-left">
               <h2 class="section-heading text-uppercase">구매완료 목록 </h2>
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
			      <th scope="col" class="td1">구매 상품명</th>
			      <th scope="col" class="td1">신청 내용</th>
			      <th scope="col">진행상황</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody id="dealcomplete">
			    <!-- ajax도는 부분 -->
			 </tbody>
			</table>
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
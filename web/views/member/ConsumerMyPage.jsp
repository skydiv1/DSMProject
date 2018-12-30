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
/*  function addBtnEvent() {
	$("#cancelBtn").click(function () {//취소 팝업에 있는 버튼 누를때
		var textContent = $("textContent").val();//신청사유
		
		.ajax({
			url:"${pageContext.request.contextPath}/cancelupdate.consumer",
			type : "get",
			data : {no:no, textContent:textContent}
			success : function (data) {
				selectListAp();
			}
			
		});
	});
		
	} 
  */
		
	/*
	$("#삭제").클릭(){
		ajax
	}
	
	$("#abc").클릭(){
		ajax
	}	
	
 */



//신청 리스트 ajax
function selectListAp(pg) {
	$.ajax({
		url : "${pageContext.request.contextPath}/selectList.ap",
		type :"get",
		success : function (data) {
			var apListHtml = [];
			var no =0;
			for(var i=0; i<data.length; i++){
				apListHtml.push('<tr>');
				apListHtml.push('	<th scope="row">' + (i+1) + '</th>');
				apListHtml.push('	<td class="td1" style="display: none">' +data[i].dealNo + '</td>');
				apListHtml.push('	<td class="td1">' +data[i].member_id + '</td>');
				apListHtml.push('	<td class="td1">' +data[i].productName+ '</td>');
				apListHtml.push('	<td class="td1">' +data[i].dealListaddMsg + '</td>');
				apListHtml.push('	 <td style="width: 30px"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#cencelModal" id="cBtn" >취소</button></td>');
				apListHtml.push('</tr>');
				
				
			}
			$("#applylist").html(apListHtml);
			
			/* addBtnEvent(
					$("#cBtn").click(function () {
						no = $("#applylist").children().eq(1).val();
					})
					
			);//버튼 함수 불러오기 */
		}
	});
}

//마이페이지 실행시에 뷰페이지 만들고 데이터 뿌려주는 ajax 메인(함수 호출 여기서)
 	$(function () {
 		selectListAp();
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
			    <tr>
			      <th scope="row"></th>
			      <td class="td1" style="display: none"></td>
			      <td class="td1"></td>
			      <td class="td1"></td>
			      <td class="td1"></td>
			      <td style="width: 30px"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#cencelModal" id="cBtn">취소</button></td>
			    </tr>

		

			  </tbody>
			
			</table>
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
			      <th scope="col" class="td1">판매자ID</th>
			      <th scope="col" class="td1">구매 상품명</th>
			      <th scope="col" class="td1">신청 내용</th>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning" onclick = "location.href = '<%= request.getContextPath()%>/selectOneProduct.de?memberCode=<%= 3%>&productNo=<%= 2%>'">결제하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal">취소</button></td>							<!-- 결제 페이지 전송용 샘플 데이터 -->
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning">결제하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal">취소</button></td>
			    </tr>
			    <tr>
			    
			      <th scope="row">3</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning">결제하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal">취소</button></td>
			    </tr>
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
			      <th scope="col" class="td1">판매자ID</th>
			      <th scope="col" class="td1">구매상품명</th>
			      <th scope="col" >취소 사유</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td>@mdo</td>
			      <td style="width: 10px"><button type="button" class="btn btn-secondary">삭제</button></td>
			    </tr>
			    
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td>@mdo</td>
			      <td style="width: 10px"><button type="button" class="btn btn-secondary">삭제</button></td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td>@mdo</td>
			      <td style="width: 10px"><button type="button" class="btn btn-secondary">삭제</button></td>
			    </tr>
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
			      <th scope="col" class="td1">판매자ID</th>
			      <th scope="col" class="td1">구매 상품명</th>
			      <th scope="col" class="td1">신청 내용</th>
			      <th scope="col">진행상황</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 40px"><button type="button" class="btn btn-secondary">구매확정</button></td>
			      <td style="width: 40px"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#reviewModal">구매평 작성</button></td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 40px"><button type="button" class="btn btn-secondary">구매확정</button></td>
			      <td style="width: 40px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#reviewModal">구매평 작성</button></td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 40px"><button type="button" class="btn btn-secondary">구매확정</button></td>
			      <td style="width: 40px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#reviewModal">구매평 작성</button></td>
			    </tr>
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
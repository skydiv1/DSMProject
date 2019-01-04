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

	//취소 팝업에 있는 보내기 버튼 누를때
	  $("#cancelBtn").click(function () {
		  var textContent = $("#textContent").val();//신청사유
			var dealnum = $("#dealnum").val();
			$.ajax({
				url:"${pageContext.request.contextPath}/cancelupdate.seller",
				type : "get",
				data : {dealnum:dealnum, textContent:textContent},
				success : function (data) {
					selectListWaiting();
				}
			});
	  });
	  $("#agreeBtn").click(function () {
		  
	  });
	 
	  //대기자 목록에서 거절버튼 누를때
	  $("#cBtn").click(function () {
		  var no = $(this).parent().parent().children().eq(1).text();
			$("#dealnum").val(no);
	  });
}






//대기자 목록 ajax
function selectListWaiting(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.wait",
			type :"get",
			success : function (data) {
				
				var waitListHtml = [];
				var no =0;
				for(var i=0; i<data.length; i++){
					waitListHtml.push('<tr>');
					waitListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					waitListHtml.push('	<td class="td1" style="display: none">' +data[i].dealNo + '</td>');
					waitListHtml.push('	<td class="td1">' +data[i].member_id + '</td>');
					waitListHtml.push('	<td class="td1">' +data[i].productName+ '</td>');
					waitListHtml.push('	<td>' +data[i].dealListaddMsg1 + '</td>');
					waitListHtml.push('	<td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning"data-toggle="modal" data-target="#agreeModal" id="agreeBtn">수락하기</button></td>');
					waitListHtml.push('	<td style="width: 5px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal" id="cBtn">거절</button></td>');
					waitListHtml.push('</tr>');
					
				}
				$("#waitingList").html("");//이전틀 지우고
				$("#waitingList").append(waitListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}
//구매진행 목록 ajax(수락이(0)랑 결제완료(3)보여줌)
function selectListDealprogress(pg) {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/selectList.progress",
			type :"get",
			success : function (data) {
				
				var progressListHtml = [];
				var no =0;
				console.log(typeof(data[0].dealListCategory));
				for(var i=0; i<data.length; i++){
					progressListHtml.push('<tr>');
					progressListHtml.push('	<th scope="row">' + (i+1) + '</th>');
					progressListHtml.push('	<td class="td1" style="display: none">' +data[i].dealNo + '</td>');
					progressListHtml.push('	<td class="td1">' +data[i].member_id + '</td>');
					progressListHtml.push('	<td class="td1">' +data[i].productName+ '</td>');
					progressListHtml.push('	<td class="td1">' +data[i].dealListaddMsg1 + '</td>');
					progressListHtml.push('	<td class="td1">' +data[i].dealListaddMsg2 + '</td>');
					/* var ct = data[i].dealListCategory;
					 if(ct==1){
						progressListHtml.push('	<td>' + 구매진행중 +'</td>');
					}else{
						progressListHtml.push('	<td>' + 구매완료  +'</td>');	
					} 
					progressListHtml.push('</tr>'); */
					
				}
				$("#dealprogressList").html("");//이전틀 지우고
				$("#dealprogressList").append(progressListHtml.join(""));//""를 기준으로 배열에 담긴 데이터 꺼내오기
				
				
				 addBtnEvent();//버튼 함수 불러오기
				 
				 
				 
			}
		});
	}
	
//마이페이지 실행시에 뷰페이지 만들고 데이터 뿌려주는 ajax 메인(함수 호출 여기서)
	$(function () {
		selectListWaiting(1);
		selectListDealprogress(1);
		
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
			      <th scope="col" class="td1">게시글 제목</th>
			      <th scope="col" >게시글 내용</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td>Otto</td>
			      <td style="width: 20px"><button type="button" class="btn btn-secondary">게시글 수정하기</button></td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Jacob</td>
			      <td>Thornton</td>
			      <td style="width: 20px"><button type="button" class="btn btn-secondary">게시글 수정하기</button></td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Jacob</td>
			      <td>Thornton</td>
			      <td style="width: 20px"><button type="button" class="btn btn-secondary">게시글 수정하기</button></td>
			    </tr>
			  </tbody>
			</table>

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
			      <th scope="col" class="td1">소비자ID</th>
			      <th scope="col" class="td1">판매상품명</th>
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
   <!-- 판매완료 목록 -->
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
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td>@mdo</td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td>@mdo</td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td>@mdo</td>
			    </tr>
			  </tbody>
			</table>
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
			      <th scope="col" class="td1">환급 날짜</th>
			      <th scope="col" class="td1">환급 은행</th>
			      <th scope="col" class="td1">환급 계좌</th>
			      <th scope="col" class="td1">환급 금액</th>
			      <th scope="col">진행상황</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td>Mark</td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td>Mark</td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td>Mark</td>
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
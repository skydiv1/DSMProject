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

</head>
<body>
<!-- 네비게이션 바 -->
		<%@ include file = "../common/naviLogin.jsp" %>
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
			      <th scope="col" class="td1">판매자ID</th>
			      <th scope="col" class="td1">구매상품명</th>
			      <th scope="col" class="td1">신청 내용</th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td style="width: 30px"><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#cencelModal">취소</button></td>
			    </tr>
			    
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td style="width: 30px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal">취소</button></td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td class="td1">Markㅇㄶㅇㄹㄴ</td>
			      <td class="td1">Mark</td>
			      <td class="td1">Mark</td>
			      <td style="width: 30px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal">취소</button></td>
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
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning">결제하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary"data-toggle="modal" data-target="#cencelModal">취소</button></td>
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
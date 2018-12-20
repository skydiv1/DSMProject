<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
</head>
<body>
<!-- 네비게이션 바 -->
		<%@ include file = "../common/naviLogin.jsp" %>

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
			      <th scope="col" class="td1">소비자ID</th>
			      <th scope="col" class="td1">판매 상품명</th>
			      <th scope="col" class="td1">추가신청 내용</th>
			      <th scope="col">진행상황</th>
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
			      <td class="td1">@mdo</td>
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning">수락하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary">거절</button></td>
			    </tr>
			    <tr>
			      <th scope="row">2</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning">수락하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary">거절</button></td>
			    </tr>
			    <tr>
			      <th scope="row">3</th>
			      <td class="td1">Mark</td>
			      <td class="td1">Otto</td>
			      <td class="td1">@mdo</td>
			      <td class="td1">@mdo</td>
			      <td style="width: 10px; padding-right: 0px"><button type="button" class="btn btn-warning">수락하기</button></td>
			      <td style="width: 5px"><button type="button" class="btn btn-secondary">거절</button></td>
			    </tr>
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
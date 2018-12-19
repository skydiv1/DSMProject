<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<!-- 네비게이션 바 -->
<%-- 		<%@ include file = "../common/navi.jsp" %> --%>
		<%@ include file = "../common/naviLogin.jsp" %>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<div class="container">
			<div id="faq" data-obj-id="FAQ" data-obj-type="element" data-text-editable="true" style="position: relative;width:100px; float:left; margin:10px;";  width: 128px; height: 44px;">
                <a href="FAQ.jsp"><div style="font-size: 18px; color: rgb(255, 255, 255); text-align: center; line-height: 2.5em; background-color: rgb(127, 127, 127); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: normal;">FAQ</div>
                </a>
            </div>
            <div id="qna" data-obj-id="QNA" data-obj-type="element" data-text-editable="true" style="position: relative;width:100px; float:left; margin:10px;" width: 136px; height: 44px;">
                <a href="../qna/QNA.jsp"><div style="font-size: 18px; color: rgb(0, 0, 0); text-align: center; line-height: 2.5em; background-color: rgb(255, 255, 255); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: bold;">Q&amp;A</div>
                </a>
            </div>
             
        <!--     <div><a href="qnaWrite.jsp" class="btn btn-primary" style="position: relative; width:100px; float:right" >문의하기</a></div> -->

		<div>
		 	<table class="table table-striped" style="text-align:center; border:1px; solid #dddddd">
		 		<thead>
					<tr>
						<th style="width: 6%; background-color:#eeeeee; text-align: center;">분류</th>
						<th style="width: 30%; background-color:#eeeeee; text-align: center;">제목</th>
						<th style="width: 10%; background-color:#eeeeee; text-align: center;">작성자</th>
						<th style="width: 10%; background-color:#eeeeee; text-align: center;">작성일</th>
						<th style="width: 6%; background-color:#eeeeee; text-align: center;">조회수</th>
					</tr>		 		
		 		</thead>
		 		<tbody>
		 				<tr>
                            <td>상품관련</td>
                            <td onclick="location.href='faqPosts.jsp'">상품 등록시키는 방법</td>
                            <td>관리자</td>
                            <td>18.11.29</td>
                            <td>213</td>
                        </tr>
                        <tr>
                            <td>결제관련</td>
                            <td>캐시 충전 안내</td>
                            <td>관리자</td>
                            <td>18.11.29</td>
                            <td>211</td>
                        </tr>
                        <tr>
                            <td>로그인</td>
                            <td>로그인 오류시</td>
                            <td>관리자</td>
                            <td>18.11.29</td>
                            <td>111</td>
                        </tr>
                        <tr>
                            <td>구매관련</td>
                            <td>구매 취소/환불 관련</td>
                            <td>관리자</td>
                            <td>18.11.29</td>
                            <td>162</td>
                        </tr>
                        <tr>
                            <td>신고관련</td>
                            <td>분쟁 조정시 해결 방법</td>
                            <td>관리자</td>
                            <td>18.11.28</td>
                            <td>130</td>
                        </tr>
                        <tr>
                            <td>상품관련</td>
                            <td>페널티 관련 공지</td>
                            <td>관리자</td>
                            <td>18.11.28</td>
                            <td>71</td>
                        </tr>
                        <tr>
                            <td>결제관련</td>
                            <td>결제 수단 관련 안내</td>
                            <td>관리자</td>
                            <td>18.11.28</td>
                            <td>182</td>
                        </tr>
                        <tr>
                            <td>결제관련</td>
                            <td>상품 추가 결제 안내</td>
                            <td>관리자</td>
                            <td>18.11.28</td>
                            <td>340</td>
                        </tr>
                        <tr>
                            <td>신고관련</td>
                            <td>댓글/게시글 신고기능 안내</td>
                            <td>관리자</td>
                            <td>18.11.28</td>
                            <td>254</td>
                        </tr>
                        <tr>
                            <td>신고관련</td>
                            <td>구매자 신고 기능 안내</td>
                            <td>관리자</td>
                            <td>18.11.28</td>
                            <td>154</td>
                        </tr>
                        <tr>
                            <td>로그인</td>
                            <td>본인인증 오류</td>
                            <td>관리자</td>
                            <td>18.11.27</td>
                            <td>37</td>
                        </tr>
                        <tr>
                            <td>상품관련</td>
                            <td>판매자 관련 안내</td>
                            <td>관리자</td>
                            <td>18.11.27</td>
                            <td>45</td>
                        </tr>
                        <tr>
                            <td>결제관련</td>
                            <td>캐시 환급 안내</td>
                            <td>관리자</td>
                            <td>18.11.27</td>
                            <td>32</td>
                        </tr>
		 		</tbody>		 	
		 	</table>
		 			 	 	<nav aria-label="page" style="margin:0px 0px 0px 400px">
 			 <ul class="pagination">
    			<li class="page-item">
    			  <a class="page-link" href="#" aria-label="Previous">
        			<span aria-hidden="true">&laquo;</span>
        			<span class="sr-only">Previous</span>
      	</a>
				    </li>
				    <li class="page-item"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#" aria-label="Next">
	      	  <span aria-hidden="true">&raquo;</span>
	        <span class="sr-only">Next</span>
	      </a>
	    </li>
	   <div class="input-group-prepend" id="searchText" style="margin:0px 0px 0px 200px">
    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">상품</button>
    <input type ="text"  placeholder="검색어 입력">
    <button>검색</button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">상품</a>
      <a class="dropdown-item" href="#">결제</a>
      <a class="dropdown-item" href="#">회원</a>
      <a class="dropdown-item" href="#">신고</a>    
    </div>
  </div>
  
	  </ul>
  
</nav>	 		 	
		 </div>

</body>
<br><br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</html>
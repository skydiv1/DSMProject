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
	<%@ include file="../common/menubar.jsp"%>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
		<div class="container">
			<div id="faq" data-obj-id="FAQ" data-obj-type="element" data-text-editable="true" style="position: relative;width:100px; float:left; margin:10px;";  width: 128px; height: 44px;>
                <a href="/dsm/views/faq/FAQ.jsp"><div style="font-size: 18px; color: rgb(0, 0, 0); text-align: center; line-height: 2.5em; background-color: rgb(255, 255, 255); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: bold;">FAQ</div>
                </a>
            </div>
            <div id="qna" data-obj-id="QNA" data-obj-type="element" data-text-editable="true" style="position: relative;width:100px; float:left; margin:10px;" width: 136px; height: 44px;>
                <a href="./QNA.jsp"><div style="font-size: 18px; color: rgb(255, 255, 255); text-align: center; line-height: 2.5em; background-color: rgb(127, 127, 127); border-width: 1px 1px 0px; border-style: solid; border-color: rgb(51, 51, 51); font-weight: normal;">Q&amp;A</div>
                </a>
            </div>
            <div><a href="qnaWrite.jsp" class="btn btn-primary" style="position: relative; margin:10px 10px 10px 10px; float:right; width: 136px; height: 44px; ">문의하기</a></div>
			
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
                            <td>문의</td>
                            <td onclick="location.href='qnaPosts.jsp'">얼마전에 신청했는데요</td>
                            <td>옆집드론</td>
                            <td>18.11.30</td>
                            <td>231</td>
                        </tr>
                        <tr>
                            <td>신고</td>
                            <td>여기 게시판 도배하는 사람이 있는데요</td>
                            <td>윤희맘</td>
                            <td>18.11.30</td>
                            <td>211</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>로그인/계정정보 관련 문의드립니다</td>
                            <td>옆집드론</td>
                            <td>18.11.29</td>
                            <td>131</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>구매 취소/환불 관련 문의드립니다</td>
                            <td>yes1231</td>
                            <td>18.11.29</td>
                            <td>162</td>
                        </tr>
                        <tr>
                            <td>신고</td>
                            <td>분쟁조정 관련 문의드립니다</td>
                            <td>철수아저씨</td>
                            <td>18.11.28</td>
                            <td>121</td>
                        </tr>
                        <tr>
                            <td>신고</td>
                            <td>불법 자금관련 문의드립니다</td>
                            <td>아무말대잔치</td>
                            <td>18.11.27</td>
                            <td>11</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>촬영 관련 금액에 대해 문의드립니다</td>
                            <td>닉네임어렵다</td>
                            <td>18.11.26</td>
                            <td>12</td>
                        </tr>
                        <tr>
                            <td>신고</td>
                            <td>웨딩쪽 판매자 신고합니다</td>
                            <td>너뒤에</td>
                            <td>18.11.25</td>
                            <td>34</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>조금 빠른 답변 부탁드립니다</td>
                            <td>금요일밤</td>
                            <td>18.11.24</td>
                            <td>54</td>
                        </tr>
                        <tr>
                            <td>신고</td>
                            <td>진상 소비자관해 신고합니다</td>
                            <td>으아아</td>
                            <td>18.11.24</td>
                            <td>45</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>촬영/편집 관련 문의</td>
                            <td>나에게맡겨요</td>
                            <td>18.11.22</td>
                            <td>34</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>판매자 관련 문의드립니다</td>
                            <td>yes1231</td>
                            <td>18.11.21</td>
                            <td>45</td>
                        </tr>
                        <tr>
                            <td>문의</td>
                            <td>결제 관련 문의 드립니다</td>
                            <td>옆집드론</td>
                            <td>18.11.18</td>
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
    <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">문의</button>
    <input type ="text"  placeholder="검색어 입력">
    <button>검색</button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">문의</a>
      <a class="dropdown-item" href="#">신고</a>    
    </div>
  </div>
	  </ul>
   
</nav>	 	
		</div>
	</div>
<br><br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
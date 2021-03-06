
<%@page import="com.kh.w7.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>DSM(Drone Service Market)</title>

<!-- Bootstrap core CSS -->
<link href="/dsm/vendor/bootstrap/css/bootstrap.min.css?after"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="/dsm/vendor/fontawesome-free/css/all.min.css?after"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">

<!-- 제이쿼리 CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body id="page-top">
	<!-- 네비게이션 바 -->
	<!-- //////////////////////////////////////////////////////////////// -->
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
		<div class="container">
			<a class="navbar-brand js-scroll-trigger" href="/dsm/index.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DSM</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav text-uppercase ml-auto">
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/dsm/selectList.pr"><b>상품 목록</b></a></li>
					<% if(loginUser != null  && loginUser.getSellerCertcheck()==1){ %>
					<li class="nav-item" id="productEnrollment"><a class="nav-link js-scroll-trigger"
						href="/dsm/views/product/productEnrollment.jsp"><b>상품 등록</b></a></li>
					<%} else if(loginUser != null  && loginUser.getSellerCertcheck()==0){ %>
					<li class="nav-item" id="productEnrollment"><a class="nav-link js-scroll-trigger"
						id="productEnrollment2"><b>상품 등록</b></a></li>
					<% } else if(loginUser == null){ %>
					<li class="nav-item" id="productEnrollment"><a class="nav-link js-scroll-trigger"
						id="productEnrollment1"><b>상품 등록</b></a></li>
					<% } %>
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/dsm/selectList.bo"><b>게시판</b></a></li>
						
						
						
					<%  if(loginUser!=null && loginUser.getMemberCategory() == 0){  %>	
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/dsm/selectList.consumer"><b>마이페이지</b></a></li>
					<%}else if(loginUser!=null && loginUser.getMemberCategory() == 1){  %>	
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/dsm/selectList.seller"><b>마이페이지</b></a></li>
					<%}else{ %>	
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/dsm/views/member/login.jsp"><b>마이페이지</b></a></li>
					<%} %>		
					
					
					<li class="nav-item"><a class="nav-link js-scroll-trigger"
						href="/dsm/selectFaqList.faq"><b>고객센터</b></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- //////////////////////////////////////////////////////////////// -->

	<script>
		$(function() {
			$("#productEnrollment").css("cursor", "pointer");
			
			$("#productEnrollment1").click(function() {
				alert("로그인이 필요한 서비스 입니다.");
				$("#memberId").focus();
			});
			$("#productEnrollment2").click(function() {
				alert("해당 페이지는 판매자만 이용할 수 있습니다.");
			});
		});
	</script>

	<%
		if (loginUser == null) {
	%>
	<header class="masthead"
		style="background-image: url('/dsm/img/drone_background.jpg'); background-size: 100% 500px; margin-top: 0px; background-position: center;">
		<form action="<%=request.getContextPath()%>/login.me" method="POST">
			<div class="container">
				<div class="intro-text" style="padding-top: 35px;">
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div>&nbsp;</div>
					<div style="margin-bottom: 20px;">
						<input type="text" id="memberId" name="memberId"
							placeholder="아이디를 입력하세요"
							style="width: 250px; height: 40px; font-size: 12px; box-shadow: 0px 0px 20px #000; border-radius: 6px;">

					</div>
					<div style="margin-bottom: 20px">
						<input type="password" id="memberPwd" name="memberPwd"
							placeholder="비밀번호를 입력하세요"
							style="width: 250px; height: 40px; font-size: 12px; box-shadow: 0px 0px 20px #000; border-radius: 6px;">
					</div>
					<div>
						<input type="submit" id="login" value="로그인"
							class="btn btn-primary btn-xl text-uppercase js-scroll-trigger"
							style="padding: 7px 100px; box-shadow: 0px 0px 10px #000; background-color: #fed136;">
					</div>
					<div style="margin-top: 10px;">
						<a href="/dsm/views/member/find_Id.jsp">아이디 찾기</a> / <a
							href="/dsm/views/member/find_pw.jsp">비밀번호 찾기</a> / <a
							href="/dsm/views/member/user_terms2.jsp">회원가입</a>
					</div>
				</div>
			</div>
		</form>
	</header>
	
	<%
		} else {
	%>
	<header class="masthead"
		style="background-image: url('/dsm/img/drone_background_login.png'); background-size: 100% 500px; margin-top: 0px; background-position: center;">
		<div class="container">
			<div class="intro-text" style="padding-top: 35px;">
				<div>&nbsp;</div>
				<div>&nbsp;</div>
				<div>&nbsp;</div>
				<table style="margin-left: 25%; width: 600px;">
					<tr>
						<td rowspan="2"><img class="mx-auto rounded-circle"
							src="/dsm/img/team/2.jpg" alt=""
							style="width: 120px; height: 120px;"></td>
						<td style="padding-left: 2%;">
							<h6>
								<label><%=loginUser.getMemberName()%>님 환영합니다.</label>
							</h6>
							<div>
								잔여 캐시: <b id = "refundMoney1">0</b>원
							</div>
						</td>
					</tr>
					<tr>
						<td>
						<% if(loginUser != null&& loginUser.getMemberCategory() == 0) {%>
							<a href="#"><button type="button"
									class="btn btn-warning"
									onclick="location.href = '/dsm/selectUser.pa?memberCode=<%= loginUser.getMemberCode()%>'">캐시충전</button></a>
						<%}else if(loginUser != null&& loginUser.getMemberCategory() == 1) {%>
						<a href="#"><button type="button"
									class="btn btn-warning"
									onclick="location.href = '/dsm/views/cash/refunds.jsp?memberCode=<%= loginUser.getMemberCode()%>'">캐시환급</button></a>
						<%}%>
						 <% if(loginUser != null&& loginUser.getMemberAdmin() == 1) {%>
		                     <a href="/dsm/refreshPage"><button type="button" class="btn btn-light">관리자 페이지로 이동</button></a>
		                  <% }else{ %>
		                            <% if(loginUser != null&& loginUser.getMemberCategory() == 0) {%>
		                          <a href="GetIdinfo.me"><button type="button"
		                              class="btn btn-light"
		                              onclick="location.href = '/dsm/views/member/con_info.jsp?memberCategory=<%= loginUser.getMemberCategory()%>'">개인정보수정</button></a>
		                        <%}else if(loginUser != null&& loginUser.getMemberCategory() == 1) {%>
		                        <a href="GetIdinfo.me"><button type="button"
		                              class="btn btn-light"
		                              onclick="location.href = '/dsm/views/member/Sel_info.jsp?memberCategory=<%= loginUser.getMemberCategory()%>'">개인정보수정</button></a>
		                        <%}%>
		                  <% } %>

							<!-- <a href="GetIdinfo.me"><button type="button" class="btn btn-light">내
									정보 수정</button></a> --> <a href="/dsm/logout.me"><button type="button" class="btn btn-light">로그아웃</button></a> <!--         			<a href="#"><button type="button" class="btn btn-light">관리자페이지</button></a> -->
					<% if(loginUser != null&& loginUser.getMemberAdmin() == 1) {%>
                     
                  <% }else{ %>

                     <button class="btn btn-light" style="cursor: default;">
                       		 신고횟수: <span><%= loginUser.getBlackCount() %></span>회
                     </button></td>
                  <% } %>

					</tr>
				</table>
			</div>
		</div>
	</header>
	 <script>
   $(function(){
      console.log("회원 코드 제대로 뽑아오나? "+<%= loginUser.getMemberCode()%>);
      $.ajax({
         url : "/dsm/selectNowCashRefund",
         data : {
            memberCode : <%= loginUser.getMemberCode()%>
         },
         type : "post",
         success : function(data){
            //var tag = $('<div style = "display : inline; color : black; font-size : 0.8em; font-weight : bold;">원 입니다</div>');
            $("#refundMoney1").text(data);
         },
         error : function(data){
            console.log(data);
         }
      });
   });
   </script>
	
	
	<%
		}
	%>
	<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- Header -->
	<!-- header 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

	<!-- 스크립트 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<!-- Bootstrap core JavaScript -->
	<script src="/dsm/vendor/jquery/jquery.min.js"></script>
	<script src="/dsm/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Plugin JavaScript -->
	<script src="/dsm/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Contact form JavaScript -->
	<script src="/dsm/js/jqBootstrapValidation.js"></script>
	<script src="/dsm/js/contact_me.js"></script>

	<!-- Custom scripts for this template -->
	<script src="/dsm/js/agency.min.js"></script>


</body>
</html>

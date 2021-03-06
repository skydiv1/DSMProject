<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DSM(Drone Service Market)</title>
    
    <!-- JQuery CDN -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
    <!-- Bootstrap core CSS -->
    <link href="/dsm/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="/dsm/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href=/dsm/css/agency.min.css" rel="stylesheet">

</head>
<!-- head 끝/////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<body>
	<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
<div class="container">
	<a class="navbar-brand js-scroll-trigger" href="/dsm/index.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DSM</a>
	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
	Menu <i class="fas fa-bars"></i>
	</button>
	<div class="collapse navbar-collapse" id="navbarResponsive">
		<ul class="navbar-nav text-uppercase ml-auto">
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/selectList.pr"><b>상품 목록</b></a>
			</li>
			<li class="nav-item" id="productEnrollment">
         	<a class="nav-link js-scroll-trigger"><b>상품 등록</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/selectList.bo"><b>게시판</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/views/member/login.jsp"><b>마이페이지</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/views/faq/FAQ.jsp"><b>고객센터</b></a>
			</li>
		</ul>
	</div>
</div>
</nav>

<header class="masthead" style="background-image: url('/dsm/img/drone_background.jpg'); background-size: 100% 500px; margin-top: 0px; background-position:center;">
<form action="<%= request.getContextPath()%>/login.me" method="POST">
<div class="container">
	<div class="intro-text" style="padding-top:35px;">
		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<div style="margin-bottom: 20px;">
			<input type="text" id="memberId" name="memberId" placeholder="아이디를 입력하세요" style="width:250px; height:40px; font-size: 12px; box-shadow:0px 0px 20px #000; border-radius:6px;">
		
		</div>
		<div style="margin-bottom: 20px">
			<input type="password" id="memberPwd" name="memberPwd" placeholder="비밀번호를 입력하세요" style="width:250px; height:40px; font-size: 12px; box-shadow:0px 0px 20px #000; border-radius:6px;">
		</div>
		<div>
		<input type="submit" id="login" value="로그인" class="btn btn-primary btn-xl text-uppercase js-scroll-trigger" style="padding: 7px 100px; box-shadow:0px 0px 10px #000; background-color:#fed136;">
		</div>
		<div style="margin-top:10px;"><a href="/dsm/views/member/find_Id.jsp">아이디 찾기</a> / <a href="/dsm/views/member/find_pw.jsp">비밀번호 찾기</a> / <a href="/dsm/views/member/user_terms2.jsp">회원가입</a></div>
	</div>
</div>
</form>
</header>

<script>
	$(function () {
		$("#productEnrollment").click(function () {
			$("#productEnrollment").css("cursor","pointer");
			alert("로그인이 필요한 서비스 입니다.");
		})
	})
</script>

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
</html> --%>
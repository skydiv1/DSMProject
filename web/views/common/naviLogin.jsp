<%@ page language="java" contentType="text/html; charset=UTF-8"
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

    <!-- Bootstrap core CSS -->
    <link href="/dsm/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!-- JS, Popper.js, and jQuery 부트스트랩 -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <!-- Custom fonts for this template -->
    <link href="/dsm/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="/dsm/css/agency.min.css" rel="stylesheet">

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
			<a class="nav-link js-scroll-trigger" href="/dsm/views/product/productList.jsp"><b>상품 목록</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/views/product/productEnrollment.jsp"><b>상품 등록</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/views/board/board.jsp"><b>게시판</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="#"><b>마이페이지</b></a>
			</li>
			<li class="nav-item">
			<a class="nav-link js-scroll-trigger" href="/dsm/views/faq/FAQ.jsp"><b>고객센터</b></a>
			</li>
		</ul>
	</div>
</div>
</nav>

<header class="masthead" style="background-image: url('/dsm/img/drone_background_login.png'); background-size: 100% 500px; margin-top: 0px; background-position:center;">
<div class="container">
	<div class="intro-text" style="padding-top:35px;">
		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<div>&nbsp;</div>
		<table style="margin-left:25%; width:600px;">
         	<tr>
         		<td rowspan="2">
         			<img class="mx-auto rounded-circle" src="/dsm/img/team/2.jpg" alt="" style=" width:120px; height:120px;">
         		</td>
         		<td style="padding-left:2%;">
              		<h6><b>DSMembers</b>님 반갑습니다.</h6>
              		<div>잔여 캐시: <b>100000</b>원</div>
         		</td>
        	</tr>
        	<tr>
        		<td>
        			<a href="#"><button type="button" class="btn btn-warning" onclick = "location.href = '/dsm/views/cash/cacheCharge.jsp'">캐시충전</button></a>
        			<a href="#"><button type="button" class="btn btn-light">내 정보 보기</button></a>
        			<a href="#"><button type="button" class="btn btn-light">로그아웃</button></a>
        			<a href="../admin/adminMain.jsp"><button type="button" class="btn btn-light">관리자페이지</button></a>
              <div class="btn btn-light">신고횟수: <span>0</span>회</div>
        		</td>
        	</tr>
          </table>
	</div>
</div>
</header>

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
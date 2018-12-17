<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

  <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DSM(Drone Service Market)</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.min.css" rel="stylesheet">

</head>

<body id="page-top">
 <!-- 네비게이션 바 -->
<%-- 		<%@ include file = "navi.jsp" %> --%> <!-- 로그인 전 -->
		<%@ include file = "naviLogin.jsp" %> <!-- 로그인 후 -->
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<!-- Header -->
<!-- header 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- 베스트판매자 -->
<section class="bg-light" id="portfolio">
<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h2 class="section-heading text-uppercase">베스트판매자</h2>
			<h3 class="section-subheading text-muted"><hr></h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/01-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>랭킹 1</h4>
				<p class="text-muted">
					IDIllustration
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/02-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>랭킹 2</h4>
				<p class="text-muted">
					IDGraphic Design
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/03-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>랭킹 3</h4>
				<p class="text-muted">
					IDIdentity
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/04-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>랭킹 4</h4>
				<p class="text-muted">
					IDBranding
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/05-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>랭킹 5</h4>
				<p class="text-muted">
					IDWebsite Design
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/06-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>랭킹 6</h4>
				<p class="text-muted">
					IDPhotography
				</p>
			</div>
		</div>
	</div>
</div>
</section>
<!-- 베스트판매자 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- 최근 본 상품 -->
<section class="bg-light" id="portfolio">
<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<h2 class="section-heading text-uppercase">최근 본 상품</h2>
			<h3 class="section-subheading text-muted"><hr></h3>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#" id="product1"> <!-- 링크 스크립트에서 처리 -->
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/01-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>상품 1의 제목</h4>
				<p class="text-muted">
					IDIllustration
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/02-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>상품 2의 제목</h4>
				<p class="text-muted">
					IDGraphic Design
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/03-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>상품 3의 제목</h4>
				<p class="text-muted">
					IDIdentity
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item" style="margin-left:180px;">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/04-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>상품 4의 제목</h4>
				<p class="text-muted">
					IDBranding
				</p>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item">
			<a class="portfolio-link" data-toggle="modal" href="#">
			<div class="portfolio-hover">
				<div class="portfolio-hover-content">
					<i class="fas fa-plus fa-3x"></i>
				</div>
			</div>
			<img class="img-fluid" src="img/portfolio/05-thumbnail.jpg" alt="">
			</a>
			<div class="portfolio-caption">
				<h4>상품 5의 제목</h4>
				<p class="text-muted">
					IDWebsite Design
				</p>
			</div>
		</div>
	</div>
</div>
</section>
<!-- 최근 본 상품 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

<!-- 스크립트 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<script>
	$(function () {
		$("#product1").click(function name() { // 최근 본 상품 1로 이동
			location.href="views/product/productDetail.jsp";
		});
	});
</script>  
<!-- 스크립트 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->       

              
<!-- Footer -->	
<%@ include file="/views/common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->

</body>
</html>

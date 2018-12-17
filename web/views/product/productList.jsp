<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<!-- 예전 버전아렁 현 버전이랑 호환문제?.. -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<!-- 시멘틱 -->
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css"> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script> -->
</head>
<body>
	<!-- 네비게이션 바 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
	<%-- <%@ include file="/views/common/navi.jsp" %> --%> <!-- 로그인 전 -->
	<%@ include file="/views/common/naviLogin.jsp"%> <!-- 로그인 후 -->
	<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<section class="bg-light" id="portfolio" style="">

	<div class="input-group input-group-lg"
		style="width: 70%; padding-left: 13%;">
		<input type="text" class="form-control"
			aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-lg"
			style="width: 30%; font-size: 20px" placeholder="검색어를 입력해주세요">
		<div class="input-group-prepend">
			<button class="input-group-text" id="inputGroup-sizing-lg"
				style="color: black;"><b>검색</b></button>
		</div>
	</div>
	<div style="padding-left: 13%;">
		'<span>웨딩</span>'으로 검색된 결과는 <span>15</span>건 입니다.
	</div>
	<div align="right" class="dropdown" style="padding-right: 13%;">
		<select class="btn btn-secondary">
			<option value="category" selected>카테고리</option>
			<option value="shooting">촬영</option>
			<option value="education">교육</option>
			<option value="edit">편집</option>
		</select>
	</div>
	<br><br>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid" src="/dsm/img/portfolio/01-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>상품 1의 제목</h4>
					<p class="text-muted"><spna>150000</spna>원</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid" src="/dsm/img/portfolio/02-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>상품 2의 제목</h4>
					<p class="text-muted"><span>130000</span>원</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid" src="/dsm/img/portfolio/03-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>상품 3의 제목</h4>
					<p class="text-muted"><span>170000</span>원</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid" src="/dsm/img/portfolio/04-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>상품 4의 제목</h4>
					<p class="text-muted"><span>200000</span>원</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid" src="/dsm/img/portfolio/05-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>상품 5의 제목</h4>
					<p class="text-muted"><span>220000</span>원</p>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 portfolio-item">
				<a class="portfolio-link" data-toggle="modal"
					href="#">
					<div class="portfolio-hover">
						<div class="portfolio-hover-content">
							<i class="fas fa-plus fa-3x"></i>
						</div>
					</div> <img class="img-fluid" src="/dsm/img/portfolio/06-thumbnail.jpg" alt="">
				</a>
				<div class="portfolio-caption">
					<h4>상품 6의 제목</h4>
					<p class="text-muted"><span>140000</span>원</p>
				</div>
			</div>
		</div>
	</div>
	<br><br>

	<div style="margin-left:41%">
		<nav aria-label="...">
		<ul class="pagination">
			<li class="page-item disabled"><a class="page-link" href="#"
				tabindex="-1">Previous</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2
					<span class="sr-only">(current)</span>
			</a></li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
		</nav>
	</div>
	</section>

	<!-- Footer ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
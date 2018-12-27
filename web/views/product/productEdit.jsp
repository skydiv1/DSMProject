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
<style>
</style>
</head>
<body>
	<!-- 네비게이션 바 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

	<%@ include file="../common/menubar.jsp"%>
	<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<section class="bg-light" id="portfolio" style="">
	<h2 style="margin-top: -80px; padding-left: 10%;">상품 수정</h2>
	<br>
	<div class="input-group input-group-lg"
		style="width: 70%; padding-left: 10%;">
		<div class="input-group-prepend">
			<span class="input-group-text" id="inputGroup-sizing-lg"
				style="color: black;"><b>제목</b></span>
		</div>
		<input type="text" class="form-control"
			aria-label="Sizing example input"
			aria-describedby="inputGroup-sizing-lg"
			style="width: 30%; font-size: 20px">
	</div>
	<div align="right" class="dropdown" style="padding-right: 10%;">
		<select class="btn btn-secondary">
			<option value="category" selected>카테고리</option>
			<option value="shooting">촬영</option>
			<option value="education">교육</option>
			<option value="edit">편집</option>
		</select>
	</div>
	<br>
	</div>
	<div style="padding-left: 10%; padding-right: 10%;">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">
						<div style="margin-left: 38%;">기본항목</div>
					</th>
					<th scope="col">
						<div style="margin-left: 38%;">가격</div>
					</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td width="50%">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<input type="radio"
										aria-label="Radio button for following text input">
								</div>
							</div>
							<input type="text" class="form-control"
								aria-label="Text input with radio button">
						</div>
					</td>
					<td width="50%">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">￦</span>
							</div>
							<input type="text" class="form-control"
								aria-label="Amount (to the nearest dollar)">
							<div class="input-group-append">
								<span class="input-group-text">.00</span>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<br>
	<div style="padding-left: 10%; padding-right: 10%;">
		<table class="table">
			<thead class="thead-light">
				<tr>
					<th scope="col">#</th>
					<th scope="col">
						<div style="margin-left: 38%;">추가항목</div>
					</th>
					<th scope="col">
						<div style="margin-left: 38%;">가격</div>
					</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td width="50%">
						<div class="input-group">
							<div class="input-group-prepend">
								<div class="input-group-text">
									<input type="radio"
										aria-label="Radio button for following text input">
								</div>
							</div>
							<input type="text" class="form-control"
								aria-label="Text input with radio button">
						</div>
					</td>
					<td width="50%">
						<div class="input-group mb-3">
							<div class="input-group-prepend">
								<span class="input-group-text">￦</span>
							</div>
							<input type="text" class="form-control"
								aria-label="Amount (to the nearest dollar)">
							<div class="input-group-append">
								<span class="input-group-text">.00</span>
							</div>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="margin-left: 89%;">
			<button type="button" class="btn btn-warning">추가</button>
			<button type="button" class="btn btn-danger">삭제</button>
		</div>
	</div>
	<br>

	<div class="form-group shadow-textarea"
		style="padding-left: 10%; padding-right: 10%;">
		<label for="exampleFormControlTextarea6"
			style="font-size: 20px; font: bold;">서비스 설명</label>
		<textarea class="form-control z-depth-1"
			id="exampleFormControlTextarea6" rows="20"
			placeholder="서비스 설명을 적어주세요"></textarea>
	</div>


	<input type="file" value="이미지 첨부"
		style="padding-left: 10%; padding-right: 10%;">
	<button type="button" class="btn btn-warning">추가</button>

	<div style="margin-left: 78%;">
		<button type="button" class="btn btn-warning">서비스 등록</button>
		<button type="button" class="btn btn-danger">취소</button>
	</div>

	</section>

	<!-- Footer ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<title>DSM(payment Page)</title>

<!-- 
	Bootstrap core CSS
    <link href="../../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	
    Custom fonts for this template
    <link href="../../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    Custom styles for this template
    <link href="../../css/agency.min.css" rel="stylesheet"> -->


   
   <meta name="format-detection" content="telephone=no" />
   <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<style>
input::placeholder {
	font-style: italic;
	font-size: 0.7em;
}


.tRow {
	background: lightgray;
	text-align: center;
}
 .wrapper {
           padding: 20px;
           margin: 100px auto;
           width: 400px;
           min-height: 200px;
           border-radius: 5px;
           box-shadow: 0 0 10px rgba(0,0,0,.1);
           background-color: #fff;
       }
       .rating{
           overflow: hidden;
           vertical-align: bottom;
           display: inline-block;
           width: auto;
           height: 30px;
       }
       .rating > input{
           opacity: 0;
           margin-right: -100%;
       }
       .rating > label{
           position: relative;
           display: block;
           float: right;
           background: url('../../img/star-off-big.png');
           background-size: 30px 30px;
       }
       .rating > label:before{
           display: block;
           opacity: 0;
           content: '';
           width: 30px;
           height: 30px;
           background: url('../../img/star-on-big.png');
           background-size: 30px 30px;
           transition: opacity 0.2s linear;
       }
       .rating > label:hover:before,
       .rating > label:hover ~ label:before,
       .rating:not(:hover) > :checked ~ label:before{
           opacity: 1;
       }
       
       td{
          padding:10px 10px 10px 10px;       
       }
       img{
          box-shadow:0px 0px 5px #000;        
       }     
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<%@ include file="../common/menubar.jsp"%>
	<!--/////////////////////////////////////////네비끝, 헤더시작//////////////////////////////////////////////////////////////////////////////////////////////  -->

	<!--/////////////////////////////////////////////헤더끝//////////////////////////////////////////////////////////////////////////////////////////  -->
<section class="bg-light" id="portfolio" style = "padding: 50px">


<div style="background : #2E2E2E; width:58%; height:250px; margin-top: 0px; margin-left:21%; background-position:center;">
	<div class="container">
		<div class="intro-text" style="padding-top: 35px;">
			
			<table style="width: 600px;" align = "center">
               <tr>
                  <td rowspan="3"><img class="mx-auto rounded-circle"
                     src="/dsm/img/profilePicture.jpg" alt=""
                     style="width: 150px; height: 150px;"></td>
                     
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;">
                  <span style = "color : white;">DSM Seller</span></td>
               </tr>
               <tr>
                  <td>
                     <div style = "color : white;">
				                        사진에 대한 필요성이 더욱 중요해진 멀티미디어 시대.<br>
							어떻게 하면 고객이 원하는 이미지를 만들 것인가 고민하는 스튜디오입니다.
                     </div>
                  </td>
               </tr>
               <tr>
                  <td>
	                 <div style="background: lightgray; text-align: center; font-size: 1.3em; display : inline-block; width : 45%; height : 10%; vertical-align : center; border-radius : 3px;">★★★★☆(4.0)
					 </div>
					 <div style = "display : inline-block;">&nbsp;&nbsp;</div>
                     <div style="background: lightgray; text-align: center; font-size: 1.3em; display : inline-block; width : 45%; height : 10%; vertical-align : center;border-radius : 3px;">총 작업수 : 
				                        <div style="background: lightgray; text-align: center;  display : inline-block;"> 78</div>
                     </div>
                  </td>
               </tr>
            </table>
            <div>&nbsp;</div>
			<div>&nbsp;</div>
			<div>&nbsp;</div>
		</div>
	</div>
	</div>
    <br><br>
	<!--///////////////////////////////////판매자 프로필 끝///////////////////////////////////////////////////////////////////  -->
	<div class="container" align="center" style="width: 60%">
		<div style="font-size: 1.3em; font-weight: bold; text-align: left">Jamsil123님의
			소개와 경력</div>
		<table class="table">
			<thead class="thead-dark">
			</thead>
			<tbody>
				<tr>
					<th class="tRow">자기소개</th>
					<td>이 시대의 보정왕</td>
				</tr>
				<tr>
					<th style = "vertical-align: middle;" class="tRow">자격증</th>
					<td>초 경량 비행장치 조종사 자격증<br><br>
					<img src = "/dsm/img/droneCertification.jpg" alt = "드론 자격증">
					</td>

				</tr>
				<tr>
					<th class="tRow">경력사항</th>
					<td>서울시 주관 제1회 드론비행 대회 은상 수상</td>
				</tr>
			</tbody>
		</table>
	</div>
	</section>
	<!--////////////////////////////베스트 만매자 시작///////////////////////////////////////////////////  -->

	<section class="bg-light" id="portfolio" style = "padding: 50px">
	<div class="container" align="center" style="width: 60%">
		<div style="font-size: 1.3em; font-weight: bold; text-align: left">Jamsil123님의
			서비스</div>
		<div class="col-md-4 col-sm-6 portfolio-item"
			style="display: inline-block; width: 33%">
			<a class="portfolio-link" data-toggle="modal" href="#">
				<div class="portfolio-hover">
					<div class="portfolio-hover-content">
						<i class="fas fa-plus fa-3x"></i>
					</div>
				</div> <img class="img-fluid" src="/dsm/img/portfolio/02-thumbnail.jpg"
				alt="">
			</a>
			<div class="portfolio-caption">
				<h4>드론 촬영</h4>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item"
			style="display: inline-block; width: 33%">
			<a class="portfolio-link" data-toggle="modal" href="#">
				<div class="portfolio-hover">
					<div class="portfolio-hover-content">
						<i class="fas fa-plus fa-3x"></i>
					</div>
				</div> <img class="img-fluid" src="/dsm/img/portfolio/03-thumbnail.jpg"
				alt="">
			</a>
			<div class="portfolio-caption">
				<h4>영상 편집 전문</h4>
			</div>
		</div>
		<div class="col-md-4 col-sm-6 portfolio-item"
			style="display: inline-block; width: 33%">
			<a class="portfolio-link" data-toggle="modal" href="#">
				<div class="portfolio-hover">
					<div class="portfolio-hover-content">
						<i class="fas fa-plus fa-3x"></i>
					</div>
				</div> <img class="img-fluid" src="/dsm/img/portfolio/03-thumbnail.jpg"
				alt="">
			</a>
			<div class="portfolio-caption">
				<h4>웨딩 촬영, 편집</h4>
			</div>
		</div>
	</div>
	</section>
	<!--////////////////////////////서비스 평가 시작///////////////////////////////////////////////////  -->





	<section class="bg-light" id="portfolio" style = "padding: 50px">
	<div class="container" style="width: 60%">
		<div style="font-size: 1.3em; font-weight: bold; text-align: left;">Jamsil123님의
			서비스 평가</div>
			<div style="background: lightgray; text-align: center; font-size: 1.7em;">★★★★☆(4.0)
			</div>

         
<table style="width: 600px;">
               <tr>
                  <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/customerProfile1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;"><span>18.12.07
                        14:02</span> <span class="rating" style="margin-left: 15px;"> <input
                        id="rating5_2" type="radio" name="rating2" value="5" checked>
                        <label for="rating5_2">5</label> <input id="rating4_2"
                        type="radio" name="rating2" value="4"> <label
                        for="rating4_2">4</label> <input id="rating3_2" type="radio"
                        name="rating2" value="3"> <label for="rating3_2">3</label>
                        <input id="rating2_2" type="radio" name="rating2" value="2">
                        <label for="rating2_2">2</label> <input id="rating1_2"
                        type="radio" name="rating2" value="1"> <label
                        for="rating1_2">1</label>
                  </span></td>
               </tr>
               <tr>
                  <td>
                     <div>
                        <b>kki***</b>
                     </div>
                     <div>저번에 이용했는데 이번에 또 이용해요 ㅎㅎ</div>
                  </td>
               </tr>
            </table>
            
            
            
<table style="width: 600px;">
               <tr>
                  <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/customerProfile2.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;"><span>18.12.07
                        14:02</span> <span class="rating" style="margin-left: 15px;"> <input
                        id="rating5_2" type="radio" name="rating2" value="5" checked>
                        <label for="rating5_2">5</label> <input id="rating4_2"
                        type="radio" name="rating2" value="4"> <label
                        for="rating4_2">4</label> <input id="rating3_2" type="radio"
                        name="rating2" value="3"> <label for="rating3_2">3</label>
                        <input id="rating2_2" type="radio" name="rating2" value="2">
                        <label for="rating2_2">2</label> <input id="rating1_2"
                        type="radio" name="rating2" value="1"> <label
                        for="rating1_2">1</label>
                  </span></td>
               </tr>
               <tr>
                  <td>
                     <div>
                        <b>doq***</b>
                     </div>
                     <div>친절하게 잘 해주네요!</div>
                  </td>
               </tr>
            </table>
            
		<table style="width: 600px;">
               <tr>
                  <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/customerProfile3.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
                  <td width="80%" style="border-bottom: 1px solid #EAEAEA;"><span>18.12.07
                        14:02</span> <span class="rating" style="margin-left: 15px;"> <input
                        id="rating5_2" type="radio" name="rating2" value="5" checked>
                        <label for="rating5_2">5</label> <input id="rating4_2"
                        type="radio" name="rating2" value="4"> <label
                        for="rating4_2">4</label> <input id="rating3_2" type="radio"
                        name="rating2" value="3"> <label for="rating3_2">3</label>
                        <input id="rating2_2" type="radio" name="rating2" value="2">
                        <label for="rating2_2">2</label> <input id="rating1_2"
                        type="radio" name="rating2" value="1"> <label
                        for="rating1_2">1</label>
                  </span></td>
               </tr>
               <tr>
                  <td>
                     <div>
                        <b>kqn***</b>
                     </div>
                     <div>감사합니다~~~</div>
                  </td>
               </tr>
            </table>
            
            
            
		
			

	</div>
	</section>
	<%@ include file="../common/footer.jsp"%>

	<!--//////////////////////////////////////////////////푸터시작/////////////////////////////////////////////////////////////////////////////////////  -->
	<!-- Bootstrap core JavaScript -->
	<!-- <script src="../../vendor/jquery/jquery.min.js"></script>
    <script src="../../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    Plugin JavaScript
    <script src="../../vendor/jquery-easing/jquery.easing.min.js"></script>

    Contact form JavaScript
    <script src="../../js/jqBootstrapValidation.js"></script>
    <script src="../../js/contact_me.js"></script>

    Custom scripts for this template
    <script src="../../js/agency.min.js"></script> -->
	<!--///////////////////////////////////////////푸터끝////////////////////////////////////////////////////////////////////////////////////////////  -->
</body>
</html>
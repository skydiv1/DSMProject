<%@page import="com.kh.w7.product.model.vo.PlusProduct"%>
<%@page import="com.kh.w7.common.Attachment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.w7.product.model.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Product product = (Product)request.getAttribute("product");
	Member member = (Member)request.getAttribute("member");
	ArrayList<Attachment> fileList = (ArrayList<Attachment>)request.getAttribute("fileList");
	Attachment detailImg1 = fileList.get(0);
	Attachment detailImg2 = fileList.get(1);
	Attachment detailImg3 = fileList.get(2);	
	Attachment detailImg4 = fileList.get(3);	
	Attachment detailImg5 = fileList.get(4);	
	Attachment detailImg6 = fileList.get(5);	 
	
	ArrayList<PlusProduct> pList = (ArrayList<PlusProduct>)request.getAttribute("pList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 제이쿼리 -->	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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

<!-- SummerNote -->
<!-- include libraries(jQuery, bootstrap) -->
<!-- <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

include summernote css/js
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.1/summernote.js"></script>

include summernote-ko-KR
<script src="lang/summernote-ko-KR.js"></script> -->

<style>
/* tr, td, table{
	padding: 2% 2% 2% 2%; 
	width:470px;
} */

#contentImgArea1, #contentImgArea2, #contentImgArea3, #contentImgArea4, #contentImgArea5, #contentImgArea6, 
#contentImg1, #contentImg2, #contentImg3, #contentImg4, #contentImg5, #contentImg6 
{
	width: 420px;
	height: 270px;
/*  	border: 2px dashed darkgray; */
	text-align: center;
	display: table-cell;
	vertical-align: middle;
}

#contentImg1, #contentImg2, #contentImg3, #contentImg4, #contentImg5, #contentImg6 {
	position: relative;
}

#text1, #text2, #text3, #text4, #text5, #text6{
	position: absolute;
/* 	text-align: center; */
}

input[type="number"]::-webkit-outer-spin-button, 
input[type="number"]::-webkit-inner-spin-button{
	-webkit-appearance: none;
	margin: 0;
}
</style>
</head>
<body>
	<!-- 네비게이션 바 ///////////////////////////////////////////////////////////////////////////////////////////////////////////////-->

	<%@ include file="../common/menubar.jsp"%>
	<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<% if(loginUser != null && loginUser.getMemberId().equals(member.getMemberId()) ){ %> <!-- 조건 추가 (작성자와 로그인 유저가 일치했을 경우 처리..) -->
	<section class="bg-light" id="portfolio" style="">
	<h2 style="margin-top: -80px; padding-left: 10%;">상품 수정</h2>
	<br>
	<form id="updateForm" action="" onsubmit="return check()" method="post" enctype="multipart/form-data"> <!-- enctype="multipart/form-data":파일을 넘길때 -->
		
		<input type="hidden" name="num" value="<%=product.getProductNo()%>">	<!--  업데이트 문에서 사용하기 위해 가져오고 숨겨서 화면에 띄우지 않는다. -->	

		<div class="input-group input-group-lg"
			style="width: 70%; padding-left: 10%;">
			<div class="input-group-prepend">
				<span class="input-group-text" id="inputGroup-sizing-lg"
					style="color: black;"><b>제목</b></span>
			</div>
			<input name="title" type="text" class="form-control"
				aria-label="Sizing example input"
				aria-describedby="inputGroup-sizing-lg"
				style="width: 30%; font-size: 20px" value="<%=product.getProductName() %>">
		</div>
		<div align="right" class="dropdown" style="padding-right: 10%;">
			<select class="btn btn-secondary" name="cateList">
				<option value="선택안함" selected>카테고리</option>
				<option value="촬영">촬영</option>
				<option value="교육">교육</option>
				<option value="편집">편집</option>
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
								<input name="basicItem" type="text" class="form-control" value="<%= product.getProductItem() %>"
									aria-label="Text input with radio button">
							</div>
						</td>
						<td width="50%">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">￦</span>
								</div>
								<input name="basicPrice"  type="number" class="form-control" onkeydown="javascript: return event.keyCode == 69 ? false : true"
									aria-label="Amount (to the nearest dollar)" value="<%= product.getProductItemPrice() %>">
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
			<table class="table" id="addtionalTable">
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
				<% for(int i=0; i<pList.size(); i++){ %>
					<tr>
						<th scope="row"><%=(i+1) %></th>
						<td width="50%">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<input   type="radio"
											aria-label="Radio button for following text input">
									</div>
								</div>
								<input name="additionalItem"type="text" class="form-control"
									aria-label="Text input with radio button" value="<%=pList.get(i).getPlusProductItem()%>">
								<input name="fixedItem"type="hidden" value="<%=pList.get(i).getPlusProductItem()%>">
							</div>
						</td>
						<td width="50%">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span class="input-group-text">￦</span>
								</div>
								<input name="additionalPrice"  type="number" class="form-control" onkeydown="javascript: return event.keyCode == 69 ? false : true"
									aria-label="Amount (to the nearest dollar)" value="<%=pList.get(i).getPlusProductPrice()%>">
								<input name="fixedPrice"type="hidden" value="<%=pList.get(i).getPlusProductPrice()%>">
								<div class="input-group-append">
									<span class="input-group-text">.00</span>
								</div>
							</div>
						</td>
					</tr>
					<% } %>
				</tbody>
			</table>
			<div style="margin-left: 89%;">
				<button type="button" class="btn btn-warning" id="additionalItem">추가</button>
				<button type="button" class="btn btn-danger" id="deleteItem">삭제</button>
			</div>
		</div>
		<br>

		<div class="form-group shadow-textarea"
			style="padding-left: 10%; padding-right: 10%;">
			<label for="exampleFormControlTextarea6"
				style="font-size: 20px; font: bold;">서비스 설명</label>
			<textarea name="content" class="form-control z-depth-1" style="resize: none;"
				id="exampleFormControlTextarea6" rows="20"><%= product.getProductContext() %></textarea>
<!-- 			<textarea name="content" id="content" class="summernote" rows="20" cols="" style="resize:none;"></textarea> -->
		</div>
		<br><br><br>
		
		<!-- 이미지 미리보기 -->
		<div style="padding-left: 10%; padding-right: 10%;">
			<label for="exampleFormControlTextarea6"
				style="font-size: 20px; font: bold;">이미지 첨부 (이미지는 최대 6장 까지 등록이 가능합니다.)</label>
		</div>
		
		<!-- 이미지 값의 기본키를 저장해서 서블릿으로 보내주기 위해  -->
		<% for(int i=0; i<fileList.size(); i++){ %>
<%-- 			<input type="hidden" name="imgsNo" value="<%=fileList.get(i).getImgNo()%>"> --%>
			<input type="hidden" name="imgsNo" value="<%=fileList.get(i).getImgNo()%>">
			<input type="hidden" name="changeImgs" value="<%=fileList.get(i).getChangeName()%>">
			<input type="hidden" name="originImgs" value="<%=fileList.get(i).getOriginName()%>">
		<% } %>
		
		<table align="center" border="0" width="80%" align="center">
			<tr>
				<td style="padding: 2% 2% 2% 2%;" width="470px">
					<div id="contentImgArea1" style="cursor:pointer;">
						<img id="contentImg1" name="img1" style="box-shadow: 0px 0px 10px #000;" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg1.getChangeName()%>">	
					</div>
				</td>
				<td  style="padding: 2% 2% 2% 2%;" width="470px">
						<% if(detailImg2.getChangeName() != null){ %>
						<div id="contentImgArea2" style="cursor:pointer;">
							<img id="contentImg2" name="img2" style="box-shadow: 0px 0px 10px #000;" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg2.getChangeName()%>">
						</div>
						<% }else{ %>
						<div id="contentImgArea2" style="cursor:pointer; border: 2px dashed darkgray;">
							<img id="contentImg2" style="box-shadow: 0px 0px 10px #000;" src=""><div id="text5" style="font-size: 20px; color: darkgray;">추가 이미지를 넣어주세요</div>
						</div>	
						<% } %>
				</td>
				<td  style="padding: 2% 2% 2% 2%;" width="470px">
						<% if(detailImg3.getChangeName() != null){ %>
						<div id="contentImgArea3" style="cursor:pointer;">
							<img id="contentImg3" name="img3" style="box-shadow: 0px 0px 10px #000;" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg3.getChangeName()%>">
						</div>
						<% }else{ %>
						<div id="contentImgArea3" style="cursor:pointer; border: 2px dashed darkgray;">
							<img id="contentImg3" style="box-shadow: 0px 0px 10px #000;" src=""><div id="text4" style="font-size: 20px; color: darkgray;">추가 이미지를 넣어주세요</div>
						</div>	
						<% } %>
				</td>
			</tr>
			<tr>
				<td style="padding: 2% 2% 2% 2%;">
						<% if(detailImg4.getChangeName() != null){ %>
						<div id="contentImgArea4" style="cursor:pointer;">
							<img id="contentImg4" name="img4" style="box-shadow: 0px 0px 10px #000;" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg4.getChangeName()%>">
						</div>
						<% }else{ %>
						<div id="contentImgArea4" style="cursor:pointer; border: 2px dashed darkgray;">
							<img id="contentImg4" style="box-shadow: 0px 0px 10px #000;" src=""><div id="text3" style="font-size: 20px; color: darkgray;">추가 이미지를 넣어주세요</div>
						</div>	
						<% } %>
				</td>
				<td style="padding: 2% 2% 2% 2%;">
						<% if(detailImg5.getChangeName() != null){ %>
						<div id="contentImgArea5" style="cursor:pointer;">
							<img id="contentImg5" name="img5" style="box-shadow: 0px 0px 10px #000;" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg5.getChangeName()%>">
						</div>
						<% }else{ %>
						<div id="contentImgArea5" style="cursor:pointer; border: 2px dashed darkgray;">
							<img id="contentImg5" style="box-shadow: 0px 0px 10px #000;" src=""><div id="text2" style="font-size: 20px; color: darkgray;">추가 이미지를 넣어주세요</div>
						</div>	
						<% } %>
				</td>
				<td style="padding: 2% 2% 2% 2%;">
						<% if(detailImg6.getChangeName() != null){ %>
						<div id="contentImgArea6" style="cursor:pointer;">
							<img id="contentImg6" name="img6" style="box-shadow: 0px 0px 10px #000;" src="<%=request.getContextPath()%>/image_uploadFiles/<%=detailImg6.getChangeName()%>">
						</div>
						<% }else{ %>
						<div id="contentImgArea6" style="cursor:pointer; border: 2px dashed darkgray;">
							<img id="contentImg6" style="box-shadow: 0px 0px 10px #000;" src=""><div id="text1" style="font-size: 20px; color: darkgray;">추가 이미지를 넣어주세요</div>
						</div>	
						<% } %>
				</td>
			</tr>
		</table>
		
		<div id="fileArea">
			<input type="file" id="thumbnailImg1" name="thumbnailImg1" onchange="loadImg(this, 1)" value="" style="padding-left: 10%; padding-right: 10%;"> 
			<input type="file" id="thumbnailImg2" name="thumbnailImg2" onchange="loadImg(this, 2)" value="" style="padding-left: 10%; padding-right: 10%;"> 
			<input type="file" id="thumbnailImg3" name="thumbnailImg3" onchange="loadImg(this, 3)" value="" style="padding-left: 10%; padding-right: 10%;"> 
			<input type="file" id="thumbnailImg4" name="thumbnailImg4" onchange="loadImg(this, 4)" value="" style="padding-left: 10%; padding-right: 10%;"> 
			<input type="file" id="thumbnailImg5" name="thumbnailImg5" onchange="loadImg(this, 5)" value="" style="padding-left: 10%; padding-right: 10%;"> 
			<input type="file" id="thumbnailImg6" name="thumbnailImg6" onchange="loadImg(this, 6)" value="" style="padding-left: 10%; padding-right: 10%;">
		</div>
		<!-- 이미지 미리보기 끝-->

		<br><br><br><br><br>
		<div style="margin-left: 78%;">
			<button type="submit" class="btn btn-warning" onclick="editPr();">상품 수정</button>
			<button type="submit" class="btn btn-danger" onclick="deletePr();">상품 삭제</button>
		</div>
	</form>
	</section>
	<% }else{ %>
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	<% } %>
	
	<!-- 스크립트  /////////////////////////////////////////////////////////////////////////////////////////// -->
	
		<script>
			function editPr() {	
				alert("정상적으로 수정되었습니다.");
				$("#updateForm").attr("action", "<%=request.getContextPath() %>/update.pr");		
				console.log($("#updateForm"));	
			}
			function deletePr() { 
 				 if(confirm("정말 삭제하시겠습니까?")) { // 확인
					console.log($("#updateForm"));
					$("#updateForm").attr("action", "<%=request.getContextPath()%>/deleteOne.pr");		
					return true;
				}else { // 취소
					console.log($("#updateForm"));
					return false;
				} 
			}
		</script>
	<script>
		cnt = 0;	
		$(function () {
			if($("input[name=additionalItem]").eq(0).val() != ""){
				cnt=1;
			} if($("input[name=additionalItem]").eq(1).val() != ""){
				cnt=2;
			}	
			/* 추가 버튼을 눌렀을 때 동작하는 함수 */
			$("#additionalItem").click(function () {	
				if(cnt<3){
			    	$('#addtionalTable > tbody:last').append('<tr><th scope="row">'+(cnt+1)+'</th>' 
			    		+'<td width="50%">'
						+'<div class="input-group">'
						+'<div class="input-group-prepend">'
						+'<div class="input-group-text">'
						+'<input type="radio" aria-label="Radio button for following text input">'
						+'</div>'
						+'</div>'
						+'<input name="additionalItem" type="text" class="form-control" aria-label="Text input with radio button">'
						+'<input name="fixedItem" type="hidden">'
						+'</div>'
						+'</td>'
						+'<td width="50%">'
						+'<div class="input-group mb-3">'
						+'<div class="input-group-prepend">'
						+'<span class="input-group-text">￦</span>'
						+'</div>'
						+'<input name="additionalPrice" type="number" class="form-control" aria-label="Amount (to the nearest dollar)"  onkeydown="javascript: return event.keyCode == 69 ? false : true">'
						+'<input name="fixedPrice" type="hidden">'
						+'<div class="input-group-append">'
						+'<span class="input-group-text">.00</span>'
						+'</div>'
						+'</div>'
						+'</td>'
						+'</tr>');
		    		cnt++;
    				console.log("cnt: "+cnt);
    				
				}else if(cnt>=3){
					alert("추가 항목은 최대 세 개까지 등록이 가능합니다.");
					cnt=3;
				}
			});
			
			/* 삭제 버튼을 눌렀을 때 동작하는 함수 */
		  	$('#deleteItem').click(function() {
		  		if(cnt<=3){
				    $('#addtionalTable > tbody:last > tr:last').remove();	
			  		cnt--;
			  		console.log("cnt: "+cnt);
		  		}else if(cnt<1){
		  			cnt=0;
		  		}
			});
		      
			/* 첨부파일 숨기기 */
	        $("#fileArea").hide();   
			
			/* 이미지가 있으면 띄워주고 없으면 숨긴다. */
	        if($("#contentImg2").attr("src").length<1){
				$("#contentImgArea2").hide(); // 해당 공간을 숨긴다.				
	        } if($("#contentImg3").attr("src").length<1){
				$("#contentImgArea3").hide();
	        } if($("#contentImg4").attr("src").length<1){
				$("#contentImgArea4").hide();
	        } if($("#contentImg5").attr("src").length<1){
				$("#contentImgArea5").hide();
	        } if($("#contentImg6").attr("src").length<1){
				$("#contentImgArea6").hide();
	        } 

			/* 이미지 첨부 영역 클릭 시 동작 */			
			$("#contentImgArea1").click(function(){
			    $("#thumbnailImg1").click();
				$("#contentImgArea2").show();
			});
			$("#contentImgArea2").click(function(){
			    $("#thumbnailImg2").click();
				$("#contentImgArea3").show();	
			});
			$("#contentImgArea3").click(function(){
			    $("#thumbnailImg3").click();
				$("#contentImgArea4").show();
			});
			$("#contentImgArea4").click(function(){
			    $("#thumbnailImg4").click();
				$("#contentImgArea5").show();
			});
			$("#contentImgArea5").click(function(){
			    $("#thumbnailImg5").click();
				$("#contentImgArea6").show();
			});
			$("#contentImgArea6").click(function(){
			    $("#thumbnailImg6").click();
			});
		});
		      
      function loadImg(value, num){ // 요소, 넘버 전달
         if(value.files && value.files[0]){ // files란 속성으로 value전달, 0번째면 파일이 있는경우
            var reader = new FileReader();
            reader.onload = function(e){ // 스트림이 생성 되었을때 
               switch(num){
	               case 1 : $("#contentImgArea1").css("border","0px"); $("#contentImg1").attr("src", e.target.result).css({"width":"100%","height":"100%"}); $("#text1").text(""); break; // e.target: 해당 요소
	               case 2 : $("#contentImgArea2").css("border","0px"); $("#contentImg2").attr("src", e.target.result).css({"width":"100%","height":"100%"}); $("#text2").text(""); break; 
	               case 3 : $("#contentImgArea3").css("border","0px"); $("#contentImg3").attr("src", e.target.result).css({"width":"100%","height":"100%"}); $("#text3").text(""); break; 
	               case 4 : $("#contentImgArea4").css("border","0px"); $("#contentImg4").attr("src", e.target.result).css({"width":"100%","height":"100%"}); $("#text4").text(""); break; 
	               case 5 : $("#contentImgArea5").css("border","0px"); $("#contentImg5").attr("src", e.target.result).css({"width":"100%","height":"100%"}); $("#text5").text(""); break; 
	               case 6 : $("#contentImgArea6").css("border","0px"); $("#contentImg6").attr("src", e.target.result).css({"width":"100%","height":"100%"}); $("#text6").text(""); break; 
	             }
            }
            reader.readAsDataURL(value.files[0]); // 파일에 대한 것을 URL을 읽는 것            
         }         
      }      
	</script>
	<script>
		/* 필수적으로 입력해야 하는 값, 입력하지 않았을 때 값 넘기지 않음 */
	    function check() {
	 		 if($("input[name=title]").val() == "") {
	 		    	alert("제목을 입력해주세요.");
	 		 		$("input[name=title]").focus();
	 		    	return false;
	 		 }else if($("input[name=basicItem]").val() == ""){
	   		    	alert("기본항목을 입력해주세요.");
	     		 	$("input[name=basicItem]").focus();
	     		    return false;
	 		 }else if($("input[name=basicPrice]").val() == ""){ 
	   		    	alert("기본항목의 가격을 입력해주세요.");
	     		 	$("input[name=basicPrice]").focus();
	     		    return false;
	 		 }else if($("input[name=content]").val() == ""){
	   		    	alert("서비스 설명을 입력해주세요.");
	     		 	$("input[name=content]").focus();
	     		    return false;
		  	 }else if($("input[name=additionalItem1]").val() == ""){ 
	     		 	$("input[name=additionalItem1]").val("추가항목 없음");
	     		 	$("input[name=additionalPrice1]").val("0");
	     		    return false;
	 		 }else if($("input[name=additionalItem2]").val() == ""){ 
	     		 	$("input[name=additionalItem2]").val("추가항목 없음");
	     		 	$("input[name=additionalPrice2]").val("0");
	     		    return false;
	 		 }else if($("input[name=additionalItem3]").val() == ""){ 
	     		 	$("input[name=additionalItem3]").val("추가항목 없음");
	     		 	$("input[name=additionalPrice3]").val("0");
	     		    return false;
	 		 }else return true;	
		}
		
		/* summerNote */
	    /* $(function() {
	        $('.summernote').summernote({
	          height: 300,          // 기본 높이값
	          minHeight: null,      // 최소 높이값(null은 제한 없음)
	          maxHeight: null,      // 최대 높이값(null은 제한 없음)
	          focus: true,          // 페이지가 열릴때 포커스를 지정함
	          lang: 'ko-KR'         // 한국어 지정(기본값은 en-US)
	        });
	      }); */
	</script>

	
	<!-- Footer ///////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<%@ include file="/views/common/footer.jsp"%>
	<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
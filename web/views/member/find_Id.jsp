<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>아이디찾기</title>
<style>
#link {
	font-size: 60px;
	font-color: black;
	/* 	align: center; */
	font-weight: bold;
	margin: 0 auto;
}

#link:link { /* 링크걸린 초기 상태 */
	/* 밑줄 없애기 */
	text-decoration: none;
}

#link:hover { /* 마우스가 올라간 상태 */
	/*underline, bold가 생기도록*/
	color: black;
}

table {
	margin-left: 30%;
	margin-top: 50px;
	/* 	text-align: center; */
}

p {
	padding-left:11%;
	font-weight: bold;
	text-color: gray;  
}
#searchId{
	text-decoration: none;
}
</style>
</head>

<body>
	<!-- 	<section class="bg-light" id="portfolio"> -->
	<div style="margin-left: 45%; font-size: 25px;">
					<a href="/dsm/index.jsp" id="link">DSM</a>
				</div>
		
				<hr>
				<hr>
			
	<div align="center">
				
					<div class="ui large buttons">
						<a href="find_Id.jsp;"><button class="ui button" id="searchId" 
							style="width: 470px; height: 50px; font-size: 20px;"><div style="color:white">아이디찾기</div></button>
				</a>
				<div class="or"></div>
				
					<a href="find_pw.jsp"><button class="ui button"
						style="width: 470px; height: 50px; font-size: 20px;"><div style="color:white">비밀번호찾기</div></button></a>
				
			</div>
			</div>
<!-- 	<form action="" method="GET"> -->

		

		<table width="60%" height="350px" style="padding-left: 230px;" >


			
			
			<tr>
				<td>
					<div style="margin-bottom: 15px; margin-left: 5%;">
						<input type="text" id="memberName" placeholder="이름을 입력하세요"
							style="width: 500px; height: 50px; margin: 0 auto; font-size: 20px; border-radius: 6px;">
					</div>
					<div style="margin-bottom: 15px; margin-left: 5%;";>
						<input type="text" id="memberEmail" placeholder="이메일을 입력하세요"
							style="width: 500px; height: 50px; font-size: 20px; border-radius: 6px;">
					</div>
				</td>
			</tr>
			<tr>
				<td><p>DMS 인증 시 입력되었던 이메일로 아이디를
						보내드립니다.</p></td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="btn btn-warning" id="findIdBtn" 
						style="width: 500px; height: 50px; font-size: 20px; border-radius: 6px; margin-left: 5%; color:gray;">이메일로
						아이디 전송</button>
				</td>
			</tr>

		</table>
		
<!-- 	</form> -->
	<script>
	$(function (){
		// 2번
		$("#findIdBtn").click(function (){
			 var memberName = $("#memberName").val();
			 var memberEmail = $("#memberEmail").val();
			console.log(memberName)
			console.log(memberEmail)
			 
			 $.ajax({
				url:"/dsm/find_id.me",
				type:"post",
				data:{memberName:memberName,
					memberEmail:memberEmail},
				
				
				success:function(data){ // data: 문자열이 들어온다
					if(data=="success"){
						alert("이메일로 아이디 전송되었습니다.")
					}else{
						alert("이름과 아이디를 다시 확인해주세요.")
					}
				}
			}); 
		});	
	});	
			 
	</script>
		<br> <br>
	
	<!-- 	</section> -->

	<%@ include file="/views/common/footer.jsp"%>
</body>



</html>

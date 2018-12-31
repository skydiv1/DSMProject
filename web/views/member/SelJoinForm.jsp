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
<script>
	src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity = "sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin = "anonymous"
</script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>JoinForm</title>
<style>
#link {
	font-size: 60px;
	font-color: black;
	/* 	align: center; */
	font-weight: bold;
	margin-left: 45%;
}

#link:link { /* 링크걸린 초기 상태 */
	/* 밑줄 없애기 */
	text-decoration: none;
}

#link:hover { /* 마우스가 올라간 상태 */
	/*underline, bold가 생기도록*/
	color: black;
}

form {
	padding: 0%;
}

#user {
	padding-top: 20%;
}

.btn btn-cancle {
	margin-right: 15%
}
</style>

</head>
<body>
	<a href="/web/index.jsp" id="link">DSM</a>
	<hr>
	<h3 align="center">판매자 가입 정보 입력</h3>
	<br>
	<hr>
	<form action="<%=request.getContextPath()%>/insertMember.me" method="post" name="join">


		<table align="center">
			<tr>
				<td><div class="form-group">
						<label for="inputId" class="col-sm-2 control-label">Id</label>
						<div class="col-sm-10">
							<input type="Id" class="form-control" id="memberId"
								name="memberId" style="width: 550px" placeholder="Id">
							<td style="padding-top: 14px;"><button id="idCheck"
									class="btn btn-danger" onclick="dupCheck(); return false;">중복확인</button></td>

						</div></td>

			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="memberPwd"
								name="memberPwd" maxlength="13" style="width: 550px"
								placeholder="Password"> <font color="red">*7~15자 영문 대 소문자, 숫자를 사용하세요.</font>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-4 control-label">Confirm
							Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="memberPwd2"
								name="memberPwd2" maxlength="13" style="width: 550px"
								placeholder="Password">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="Name" class="form-control" id="memberName"
								name="memberName" style="width: 550px" placeholder="Name">
						</div>
					</div></td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="inputTel" class="col-sm-2 control-label">Phone</label>

						<div class="col-sm-10">
							<input type="text" class="form-control" id="memberPhone"
								name="memberPhone" style="width: 550px" placeholder="Phone">
							<font color="red"> *숫자만 입력하세요.</font>
						</div>
					</div></td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="Email" class="form-control" id="memberEmail"
								name="memberEmail" style="width: 550px" placeholder="Email">
						</div>
					</div></td>
				<td style="padding-top: 14px;">
					<button class="btn btn-warning" onclick="return sendEmail();">이메일인증</button> 
						
				</td>
			</tr>
			<%!public int getRandom() {
		int random = 0;
		random = (int) Math.floor((Math.random() * (99999 - 10000 + 1))) + 10000;
		return random;
	}%>
	<span> <input type="hidden" value="<%=getRandom()%>"id="randomCode">
						 <input type="hidden" value="DroneServiceMarket@gmail.com" id="from"> 
						<input type="hidden" value="DSM" id="adName">
					</span>

			<tr>
				<td><div class="form-group">
						<label for="inputEConfirm" class="col-sm-2 control-label">인증번호</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="code" style="width: 250px" placeholder="인증번호 입력">
							

						</div>
					</div></td>
				<td style="padding-top: 14px;"><button class="btn btn-danger" onclick="return combtn();"
						>인증번호 확인</button></td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="exampleInputTel">Intro</label>
						<textarea class="form-control" rows="3" placeholder="자기소개를 입력하세요" id="sellerIntroduction" name="sellerIntroduction"></textarea>

					</div></td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="exampleInputLicence">Licence1</label> <input
							type="file" id="exampleInputLicence">

					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="exampleInputLicence2">Licence2</label> <input
							type="file" id="exampleInputLicence2">

					</div>
				</td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="exampleInputcareea">Careea</label>
						<textarea class="form-control" rows="3" placeholder="경력사항을 입력하세요" id="sellerCareer" name="sellerCareer"></textarea>
					</div></td>
			</tr>
		</table>


		<div align="center">
			<a href="/web/index.jsp">
				<button type="submit" class="btn btn-warning"
					style="width: 470px; height: 50px; font-size: 20px; border-radius: 6px;" onclick = "">회원가입</button>
			</a> <a href="/web/index.jsp">
				<button type="reset" class="btn btn-cancle"
					style="width: 470px; height: 50px; font-size: 20px; border-radius: 6px;"><div id="joinBtn" onclick="goMain();">취소하기</div></button>
			</a>
		</div></form>
		<script>
		function goMain() {
			location.href="<%=request.getContextPath()%>/index.jsp";			
		}		

		function insertMember() {
			$("#joinForm").submit();
			location.href = "<%=request.getContextPath()%>/insertMember.me";
		}
		
		
	</script>
<script>
		function insertCon(){
			
			join.action = "<%=request.getContextPath()%>/insertMember.me";
			var memberId=$("#memberId").val();
			var memberPwd=$("#memberPwd").val();
			var memberPwd2=$("#memberPwd2").val();
			var memberPwdCheck = /[a-zA-Z0-9]{7,15}/g;
			memberPwdResult = memberPwdCheck.test(memberPwd);
			
			if (($("#memberId").val() == "")) {
				alert("아이디를 입력해주세요.");
			}
			console.log(memberId);
			
				
				if(memberPwd==memberPwd2){
					if(memberPwdResult){
						$("#join").submit();
					alert("가입이 완료되었습니다.")
					}										
				}else{
					alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.\n 비밀번호를 확인해주세요.");
				}
			
					
			return false;
			
			
		}
		
		function goMain() {
			location.href="<%=request.getContextPath()%>/index.jsp";			
		}		

		<%-- function insertMember() {
			$("#joinForm").submit();
			location.href = "<%=request.getContextPath()%>/insertMember.me";
		} --%>
		
		
	
	function dupCheck(){
		var memberId = $("#memberId").val();
		console.log(memberId);
		var re = /[a-zA-Z0-9]{4,12}/g; // 아이디와 패스워드가 적합한지 검사할 정규식
	
		if(memberId==""){
			alert("아이디를 입력해주세요")
		}else if(re.test(memberId)){
			$.ajax({
				url:"/dsm/idCheck.me",
				type:"post",
				data:{memberId:memberId},
				success: function (data) {
					if(data == "success"){ // 서블릿에서 처리
						alert("중복 된 아이디 입니다");
					}else if(data == "fail"){
						alert("사용가능한 아이디 입니다.");
					}
				},
				error: function (data) {
					console.log("실패!");	
				}					
			});
		}else{
			alert("부적절한 아이디입니다 영,숫자 혼합 7~15글자 이내로 입력하십시오");
		}
	}
	
	function sendEmail(){
		var memberEmail=$("#memberEmail").val();
		var randomCode = $("#randomCode").val();
		var from = $("#from").val();memberName
		var adName = $("#adName").val();
	
		$.ajax({
			url:"/dsm/SendEmail.me",
			type:"post",
			data:{memberEmail:memberEmail,randomCode:randomCode,from:from,adName:adName},
			success:function(data){
				if(data == "YES"){
					alert("메일 발송");
				}else{
					alert("메일 발송 실패");
				}
			},
			error:function(data){
				console.log("이메일 통신 실패");
			}
			
		
		});
		return false;
	
	}
	/* function checkCode(){
		var v1= join.code_check.value;
		var v2= join.code.value;
		if(v1!=v2){
			document.getElementById('checkCode').style.color="red";
			document.getElementById('checkCode').innerHTML ="잘못된 인증번호";
			//mekeNull();
		}else{
			document.getElementById('checkCode').style.color="blue";
			document.getElementById('checkCode').innerHTML ="인증가능";
			//mekeReal();
			
		}
	
	} */
	function combtn(){
		var randomCode = $("#randomCode").val();
		
		if($("#code").val() == randomCode){
			alert("이메일 인증 성공");
			
			
		}else{
			alert("이메일 인증 실패");
			
			 
		}
		console.log($("#code").val()); 
		console.log(randomCode); 
		return false;
	}
	

	/* function memkReal() {
		var combtn = document.getElementById("combtn");
		combtn.type="submit";
	}
	function memkNull() {
		var combtn = document.getElementById("combtn");
		combtn.type="hidden";
	} */
	
	</script>
		<br>
		<%@ include file="/views/common/footer.jsp"%>
</body>
</html>
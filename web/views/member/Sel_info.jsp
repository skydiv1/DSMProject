<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String memberId = (String) request.getAttribute("memberId");
%>
<%
	String memberName = (String) request.getAttribute("memberName");
%>
<%
	String memberPhone = (String) request.getAttribute("memberPhone");
%>
<%
	String memberEmail = (String) request.getAttribute("memberEmail");
%>
<%
	String sellerIntroduction = (String) request.getAttribute("sellerIntroduction");
%>
<%
	String sellerCareer = (String) request.getAttribute("sellerCareer");
%>

<%
	int memberCode = (int) request.getAttribute("memberCode");
%>

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
<script>
	src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity = "sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin = "anonymous"
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>판매자 정보수정</title>
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
	<a href="/dsm/index.jsp" id="link">DSM</a>
	<hr>
	<h3 align="center">판매자 정보수정</h3>
	<br>
	<hr>
	<form action="<%=request.getContextPath()%>/updateInfo.me"
		method="post" id="updateForm">


		<table align="center">
			<tr>
				<td><div class="form-group">
						<label for="inputId" class="col-sm-2 control-label">Id</label>

						<div class="col-sm-10">
							<input type="text" class="form-control" id="memberId"
								name="memberId" style="width: 550px" value="<%=memberId%>"
								readonly> <input type="hidden" id="memberCode"
								name="memberCode" value="<%=memberCode%>">
							<% System.out.println("뷰"+memberCode); %>
						</div>
					</div></td>

			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="memberPwd"
								name="membePwd" style="width: 550px" placeholder="Password">
							<font color="red">*6~15자 영문 대 소문자, 숫자를 사용하세요.</font>
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
								name="memberPwd2" style="width: 550px" placeholder="Password">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="Name" class="form-control" id="memberName"
								name="memberName" style="width: 550px"
								placeholder="<%=memberName%>">
						</div>
					</div></td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="inputTel" class="col-sm-2 control-label">Phone</label>

						<div class="col-sm-10">
							<input type="text" class="form-control" id="memberPhone"
								name="memberPhone" style="width: 550px; ime-mode: disabled;"
								placeholder="<%=memberPhone%>"
								onkeydown='return onlyNumber(event)' onkeyup='removeChar(event)'>
							<font color="red"> *숫자만 입력하세요.</font>
						</div>
					</div></td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="memberEmail"
								name="memberEmail" style="width: 550px"
								placeholder="<%=memberEmail%>">
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
			<span> <input type="hidden" value="<%=getRandom()%>"
				id="randomCode"> <input type="hidden"
				value="DroneServiceMarket@gmail.com" id="from"> <input
				type="hidden" value="DSM" id="hiddenName">
			</span>

			<tr>
				<td><div class="form-group">
						<label for="inputEConfirm" class="col-sm-2 control-label">인증번호</label>
						<div class="col-sm-5">
							<input type="text" class="form-control" id="code"
								style="width: 250px" placeholder="인증번호 입력">


						</div>
					</div></td>
				<td style="padding-top: 14px;"><button class="btn btn-danger"
						onclick="return combtn();">인증번호 확인</button></td>

			</tr>

			<tr>
				<td>
					<div class="form-group">
						<label for="exampleInputFile">Profile photo</label> 
						<input type="file" id="profileImg" name="profileImg" onchange="loadImg(this, 1)">
						<input id="memberId" name="memberId" type="text" hidden>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="exampleInputTel">Intro</label>
						<textarea class="form-control" rows="3"
							placeholder="<%=sellerIntroduction%>" id="sellerIntroduction"
							name="sellerIntroduction"></textarea>

					</div></td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="exampleInputLicence">Licence1</label> 
						<input type="file" id="licenceImg" name="licenceImg" onchange="loadImg(this, 2)">
						

					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="exampleInputLicence2">Licence2</label> 
						<input type="file" id="licenceImg2" name="licenceImg2" onchange="loadImg(this, 3)">

					</div>
				</td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="exampleInputcareea">Career</label>
						<textarea class="form-control" rows="3"
							placeholder="<%=sellerCareer%>" id="sellerCareer"
							name="sellerCareer"></textarea>
					</div></td>
			</tr>

		</table>



		<div align="center">
			<button class="btn btn-warning"
				style="width: 470px; height: 50px; font-size: 20px; border-radius: 6px;"
				onclick="updateSel();">정보수정</button>
			<!-- </a> <a href="/web/index.jsp"> -->
			<button type="button" class="btn btn-cancle"
				style="width: 470px; height: 50px; font-size: 20px; border-radius: 6px;">
				<div id="joinBtn" onclick="return goMain();">취소하기</div>
			</button>
			<!-- </a> <a href="/web/index.jsp"> -->
			<button type="button" class="btn btn-defualt"
				style="width: 150px; height: 50px; font-size: 15px; border-radius: 6px;"
				onclick="leaveMember();">
				<div id="DeleteBtn">탈퇴하기</div>
			</button>

		</div>
	</form>
	<script>
		function updateSel(){
			var memberId=$("#memberId").val();
			var memberPwd=$("#memberPwd").val();
			var memberPwd2=$("#memberPwd2").val();
						
			var memberPwdCheck = /[a-zA-Z0-9]{6,15}/g;
			memberPwdResult = memberPwdCheck.test(memberPwd);
			
			if (($("#memberPwd").val() == "")) {
				alert("비밀번호를 입력하세요.");
			}
			console.log(memberId);
			if(memberPwdResult){
				//alert("정상");
			}
			
			if(memberPwd == memberPwd2){
				//alert("일치");
				$("#updateForm").submit();
				join.action = "<%=request.getContextPath()%>/updateInfo.me";
				<%-- location.href = "<%=request.getContextPath()%>/insertMember.me"; --%>
				
			}else{
				alert("비밀번호가 일치하지 않습니다. 비밀번호를 다시 확인해주세요.");
				return false;
			}
			
				
				
		}
		function leaveMember() {
			var memberCode2=$("input[name='memberCode']").val();
			location.href = '/dsm/leaveMember.me?memberCode='+memberCode2;
			alert("탈퇴처리가 완료되었습니다.")

		}
		function goMain() {
			location.href="<%=request.getContextPath()%>/index.jsp";			
		}	
		
		
		function onlyNumber(event){
			event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
			if ( (keyID >= 48 && keyID <= 57) || (keyID >= 96 && keyID <= 105) || keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
				return;
			else
				return false;
		}
		function removeChar(event) {
			event = event || window.event;
			var keyID = (event.which) ? event.which : event.keyCode;
			if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 ) 
				return;
			else
				event.target.value = event.target.value.replace(/[^0-9]/g, "");
		}
		function sendEmail() {
			var memberEmail = $("#memberEmail").val();
			var randomCode = $("#randomCode").val();
			var from = $("#from").val();
			
			var hiddenName = $("#hiddenName").val();

			$.ajax({
				url : "/dsm/SendEmail.me",
				type : "post",
				data : {
					memberEmail : memberEmail,
					randomCode : randomCode,
					from : from,
					hiddenName : hiddenName
				},
				success : function(data) {
					if (data == "success") {
						alert("메일이 발송되었습니다.");
					} else {
						alert("메일 발송을 실패하였습니다.");
					}
				},
				error : function(data) {
					console.log("이메일 통신에 실패");
				}

			});
			return false;

		}
		function combtn(){
			var randomCode = $("#randomCode").val();
			
			if($("#code").val() == randomCode){
				alert("이메일 인증에 성공하였습니다.");
				
				
			}else{
				alert("이메일 인증에 실패하였습니다.");
				
				 
			}
			console.log($("#code").val()); 
			console.log(randomCode); 
			return false;
		}
		 
		
		$("#memberId").val(memberId);

	
	function loadImg(value, num){
		if(value.files && value.files[0]){
			var reader = new FileReader();
			reader.onload = function(e){
				switch(num){
				case 1 : $("#profileImg").attr("src",e.target.result); break;
				case 2 : $("#licenceImg").attr("src",e.target.result); break;
				case 3 : $("#licenceImg2").attr("src",e.target.result); break;
				}
			}
		reader.readAsDataURL(value.files[0]);
		}
	}
	</script>
	<br>
	<%@ include file="/views/common/footer.jsp"%>
</body>
</html>
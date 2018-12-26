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
<script>
	src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity = "sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin = "anonymous"
</script>
<title>소비자 정보 수정</title>
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
.btn btn-cancle{
 margin-right:15%
}
</style>
<script language="javascript">
   function validate() {
       var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
       var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
       // 이메일이 적합한지 검사할 정규식

       var memberId = document.getElementById("memberId");
       var memberPwd = document.getElementById("memberPwd");
       var memberEmail = document.getElementById("memberEmail");
       var num1 = document.getElementById("num1");
       var num2 = document.getElementById("num2");

       
       // ------------ 이메일 까지 -----------

       if(!check(re,memberId)) {
           return false;
       }

       if(!check(re,memberPwd)) {
           return false;
       }

       if(join.memberPwd.value != join.memberPwd2.value) {
           alert("비밀번호가 다릅니다. 다시 확인해 주세요.");
           join.memberPwd.value = "";
           join.memberPwd.focus();
           return false;
       }

       if(memberEmail.value=="") {
           alert("이메일을 입력해 주세요");
           memberEmail.focus();
           return false;
       }

       if(!check(re2, memberEmail, "적합하지 않은 이메일 형식입니다.")) {
           return false;
       }

       if(join.memberName.value=="") {
           alert("이름을 입력해 주세요");
           join.memberName.focus();
           return false;
       }

       
       alert("회원가입이 완료되었습니다.");
   }

   function check(re, what, message) {
       if(re.test(what.value)) {
           return true;
       }
       alert(message);
       what.value = "";
       what.focus();
       //return false;
   }

</script>
</head>
<body>
	<a href="/web/index.jsp" id="link">DSM</a>
	<hr>
	<h3 align="center">소비자 가입 정보 입력</h3>
	<br>
	<hr>
	<form action="<%=request.getContextPath()%>/insertMember" method="post">
		
			
			<table align="center">
				<tr>
				<td><div class="form-group">
						<label for="inputId" class="col-sm-2 control-label">Id</label>
						<div class="col-sm-10">
							<input type="Id" class="form-control" id="memberId" name="memberId"
								style="width: 550px" placeholder="Id" readonly>
						</div>
						<td style="padding-top: 14px;"><button type="submit"
								class="btn btn-danger">중복확인</button></td>
					</div></td>

			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="memberPwd" name="membePwd"
								style="width: 550px" placeholder="Password">
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
							<input type="password" class="form-control" id="memberpwd2" name="memberPwd2"
								style="width: 550px" placeholder="Password">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="Name" class="form-control" id="memberName" name="memberName"
								style="width: 550px" placeholder="Name">
						</div>
					</div></td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="inputTel" class="col-sm-2 control-label">Phone</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="memberPhone1" name="memberPhone1" maxlength="3">-
							<input type="text" class="form-control" id="memberPhone2" name="memberPhone2" maxlength="4">-
							<input type="text" class="form-control" id="memberPhone3" name="memberPhone3" maxlength="4">
							
								
						</div>
					</div></td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="email" class="form-control" id="memberEmail" name="memberEmail"
								style="width: 550px" placeholder="Email">
						</div>
					</div></td>
				<td style="padding-top: 14px;">
					<button type="submit" class="btn btn-warning">이메일 인증</button>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputEConfirm" class="col-sm-2 control-label">인증번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEconfirm"
								style="width: 250px" placeholder="인증번호 입력">
						</div>
					</div></td>
				<td style="padding-top: 14px;"><button type="submit"
						class="btn btn-danger">인증번호 확인</button></td>
			</tr>
				
			</table>

		</table>
		
		<div align="center">
			<a href="#">
				<button type="submit" class="btn btn-warning"
					style="width: 400px; height: 50px; font-size: 20px; border-radius: 6px;">정보수정</button>
			</a> <a href="#">
				<button type="button" class="btn btn-cancle"
					style="width: 400px; height: 50px; font-size: 20px; border-radius: 6px;">취소하기</button>
			</a>
			<a href="#">
				<button type="submit" class="btn btn-defualt" 
					style="width: 150px; height: 50px; font-size: 15px; border-radius: 6px;">탈퇴하기</button>
			</a>
		</div>
<br>
		<%@ include file="/views/common/footer.jsp"%>
		
		
</body>
</html>
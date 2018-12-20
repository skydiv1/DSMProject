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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>
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
<script type="text/javascript">
	function validate() {

		// 이메일검사

		// 4글자이상(\w=[a-zA-Z0-9_],[\w-]:'-'까지는 허용) @가 나오고

		// hanmail.net, naver.com, lycos.co.kr, iei.or.kr

		// 1글자 이상(주소).글자 가 1~3번 반복

		var userid = document.getElementById("userid");

		// 첫글자는 반드시 영문소문자, 4~12자로 이루어지고, 숫자가  하나 이상 포함되어야한다.

		// 영문소문자와 숫자로만 이루어져야 한다.

		// \d : [0-9]와 같다. {n,m} : n에서 m사이

		if (!chk(/^[a-z][a-z\d]{3,11}$/, userid, "잘못된 형식의 ID입니다."))
			return false;

		if (!chk(/[\d]/, userid, "잘못된 형식의 ID입니다."))
			return false;

		//alert(re.test(userid.value));

		var pass = document.getElementById("pass");

		var pass1 = document.getElementById("pass1");

		if (!pwchk(pass, pass1, "비밀번호가 다릅니다."))

			//if(!pwchk(pass.value, pass2.value)) return false;

			// 이름 검사 : 2글자 이상,한글로만 입력

			// 통과하지 못하면 한글로 2글자 이상을 넣으세요 메세지 출력

			var name = document.getElementById("name");

		if (!chk(/^[가-힝]{2,}$/, name, "한글만 입력하세요!!!(2글자 이상)"))
			return false;

		var email = document.getElementById("email");

		if (!chk(/^[\w-]{4,}@[\w-]+(\.\w+){1,3}$/, email, "이메일 형식이 잘못되었습니다."))
			;

		var tel1 = document.getElementById("tel1");

		if (tel1.value != '') {

			if (!chk(/^0(11|1[016789])$/, tel1, "앞자리는 2~3자리 숫자"))
				return false;

		}

		var email = document.getElementById("email");

		//return false;

	}
	function chk(re, e, msg) {

		if (re.test(e.value))
			return true;

		alert(msg);

		e.value = "";

		e.focus();

		return false;

	}

	function pwchk(e1, e2, msg) {

		if (e1 == e2)
			return true;

		alert(msg);

		e.value = "";

		e.focus();

		return false;

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
							<input type="Id" class="form-control" id="inputId"
								style="width: 550px" placeholder="Id">
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
							<input type="password" class="form-control" id="inputPassword3"
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
							<input type="password" class="form-control" id="inputPassword3"
								style="width: 550px" placeholder="Password">
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<input type="Name" class="form-control" id="inputName"
								style="width: 550px" placeholder="Name">
						</div>
					</div></td>
			</tr>

			<tr>
				<td><div class="form-group">
						<label for="inputTel" class="col-sm-2 control-label">Phone</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputTel"
								style="width: 550px" placeholder="Phone">
						</div>
					</div></td>
			</tr>
			<tr>
				<td><div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="inputEmail"
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
			<a href="/web/index.jsp">
				<button type="submit" class="btn btn-warning"
					style="width: 470px; height: 50px; font-size: 20px; border-radius: 6px;">회원가입</button>
			</a> <a href="/web/index.jsp">
				<button type="reset" class="btn btn-cancle"
					style="width: 470px; height: 50px; font-size: 20px; border-radius: 6px;">취소하기</button>
			</a>
		</div>
		<br>
		<%@ include file="/views/common/footer.jsp"%>
</body>
</html>
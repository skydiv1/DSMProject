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
<script>
    	function check() {			
		  	//이메일 검사(adfg@dfds.dsf)
			//4글자 이상이 나오고 
			//@가 나오고 1글자 이상 주소 . 글자 1~3
			var email = document.getElementById("inputEmail").value;

		  	var regExp1 = /\w{4,}@\w+.\w{1,3}/;
		  	//var regExp1 = /\w\w\w\w@\w\w\w\w.\w\w\w/;
		  
 		  	if(regExp1.test(email)){
				alert("이메일 정상입력");				
			  	//return true;
			}else{
				alert("이메일 잘못입력");
				document.getElementById("inputEmail").select();
				return false;
			} 
		  	
		  	//fgfgf
	    	//아이디 검사
			//첫글자는 반드시 영문 소문자, 총 4~12자로 이루어지고
			//숫자가 반드시 하나 이상 포함되어야 함
			//영문 소문자와 숫자로 이루어져야 한다.
			var userid = document.getElementById("inputId").value;
			

			
		  	var regExp2 = /^[a-z]+[a-z0-9]{4,12}$/;
		  
		   	if(regExp2.test(userid)){
				alert("아이디 정상입력");			
				//return true;					
			}else{
				alert("아이디 잘못입력");	
				document.getElementById("inputId").select();
				return false;
			} 	
			
			
			//비밀번호 확인 검사
			//비밀번호와 비밀번호 확인 값이 일치
			var pass = document.getElementById("inputPassword").value;
			var pass1 = document.getElementById("inputPassword1").value;
			if(pass == pass1 && pass !=""){
				alert("비밀번호 일치");				
				//return true;		
			}else{
				alert("비밀번호 불일치");
				document.getElementById("inputPassword").select();
				return false;
			}
			
			
			//이름 검사
			//2글자 이상, 한글만
			var name = document.getElementById("inputName").value;

		  	var regExp4 = /^[가-힣]{2,}$/;
		  
		  	if(regExp4.test(name)){
				alert("이름 정상입력");			
				//return true;					
			}else{
				alert("이름 잘못입력");	
				document.getElementById("inputName").select();
				return false;
			}
		  	//return true;
		  	
			
			//전화번호 검사
			//전화번호 앞자리는 2~3자리 숫자
			//두번째자리는 3~4자리 숫자
			//세번째 자리는 4자리 숫자
			var tel1 = document.getElementById("inputTel1").value;
			

		  	var regExp5 = /^\d{11}$/;
		  	
		  
		  	if(regExp5.test(tel1)){
				alert("전화번호 정상입력");				
			}else{
				alert("전화번호 잘못입력");	
				document.getElementById("inputTel").select();
				return false;
			}
		  	return true;		  	
		}		
    </script>	
</body>
</html>

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
							<input type="password" class="form-control" id="inputPassword"
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
							<input type="password" class="form-control" id="inputPassword1"
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
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

<title>login</title> 
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

section {
	align: center;
}
</style>
</head>
<body>
<body>
<!-- 	<section class="bg-light" id="portfolio"> -->
	<form action="<%= request.getContextPath()%>/login.me" method="POST">

		<table width="60%" height="500px" style="padding-left: 230px;">
			<tr>
				<td><div style="margin-left:25%; font-size: 25px;"><a href="/dsm/index.jsp" id="link">DSM</a></div></td>
			</tr>
			
			<tr>
				<td>
					<div style="margin-bottom: 15px; margin-left:5%;" >
						<input type="text" id="" placeholder="아이디를 입력하세요" name="memberId" id="memberId"
							style="width: 500px; height: 50px; margin: 0 auto; font-size: 20px; border-radius: 6px;">
					</div>
					<div style="margin-bottom: 15px; margin-left:5%;";>
						<input type="password" id="" placeholder="비밀번호를 입력하세요" name="memberPwd" id="memberPwd"
							style="width: 500px; height: 50px; font-size: 20px; border-radius: 6px;">
					</div>
				</td>
			</tr>

			<tr>
				<td>
					<button type="submit" class="btn btn-warning"
						style="width: 500px; height: 50px; font-size: 20px; border-radius: 6px; margin-left:5%; margin-left:5%;"><a href=""><div style="color:white">로그인</div></a></button>
				</td>
			</tr>
			<tr>
				<td id="ta">
					<div style="margin-left:15%;" ><a href="/dsm/views/member/find_Id.jsp">아이디 찾기</a> | <a href="/dsm/views/member/find_pw.jsp">비밀번호 찾기</a> | <a href="/dsm/views/member/user_terms2.html">회원가입</a></div>
				</td>
			</tr>
		</table>
		<br>
		<br>
		
	</form>
<!-- 	</section> -->

	<%@ include file="/views/common/footer.jsp"%>
</body>



</html>


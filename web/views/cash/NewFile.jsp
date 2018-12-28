<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<button id = "testBtn">환급 테스트용 변수</button>
	
	<script>
		$(function(){
			$("#testBtn").click(function(){
				$.ajax({
					url : "https://openapi.open-platform.or.kr/v1.0/account/balance",
					data : {},
					type : "get"
					
					
				});
			});
		});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

 	<form id="requestForm">
	  <!-- Modal -->
	  <div class="modal fade" id="askModal" role="dialog">
	    <div class="modal-dialog modal-sm">
	      <div class="modal-content">
	        <div class="modal-header">	         
				<h1 class="modal-title" style="font-weight:bold ">신청 메세지</h1>
	        </div>
	        <div class="modal-body">
				<div align="center">
					<textarea name="requestText" id="requestText" rows="15%" cols="38%" name="ask" style="resize: none;" placeholder="날짜와 시간을 포함하여 신청메세지를 입력하세요."></textarea>
				</div>
	        </div>
	        <div class="modal-footer" style="align: center">          
				<button type="reset" class="btn btn-secondary" style="width:200px" data-dismiss="modal">취소</button>
				<button type="submit" id="submitForm" class="btn btn-warning" style="width: 200px">보내기</button>		
	        </div>
	      </div>
	    </div>
	  </div>
  	</form>  
</div>

<script>
	$(function () {
		$("#submitForm").click(function () {
			alert("신청이 정상적으로 완료되었습니다.");
			$("#requestForm").attr("action", "<%=request.getContextPath()%>/requestPopUp.pr");
		});
	});
</script>

</body>
</html>

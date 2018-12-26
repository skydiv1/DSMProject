<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">


		<!-- Modal -->
		<div class="modal fade" id="refundModal" role="dialog">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<div class="modal-header">

						<h1 class="modal-title" style="font-weight: bold">알림</h1>
					</div>
					<div class="modal-body">
						<div align="center">
							<textarea rows="10%" cols="30%" name="refund"
								style="resize: none;">환급이 완료되었습니다.</textarea>
						</div>
					</div>
					<div class="modal-footer" style="align: center">

						<button type="button" class="btn btn-secondary"
							style="width: 200px" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>

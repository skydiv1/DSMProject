<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style>
body {
	background: #fafafa;
}

.widget-area.blank {
	background: none repeat scroll 0 0 rgba(0, 0, 0, 0);
	-webkit-box-shadow: none;
	-moz-box-shadow: none;
	-ms-box-shadow: none;
	-o-box-shadow: none;
	box-shadow: none;
}

body .no-padding {
	padding: 0;
}

.widget-area {
	background-color: #fff;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	-ms-border-radius: 4px;
	-o-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
	-moz-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
	-ms-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
	-o-box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
	box-shadow: 0 0 16px rgba(0, 0, 0, 0.05);
	float: left;
	margin-top: 30px;
	padding: 25px 30px;
	position: relative;
	width: 100%;
}

.status-upload form textarea {
	background: none repeat scroll 0 0 #fff;
	border: medium none;
	-webkit-border-radius: 4px 4px 0 0;
	-moz-border-radius: 4px 4px 0 0;
	-ms-border-radius: 4px 4px 0 0;
	-o-border-radius: 4px 4px 0 0;
	border-radius: 4px 4px 0 0;
	color: #777777;
	float: left;
	font-family: Lato;
	font-size: 14px;
	height: 142px;
	letter-spacing: 0.3px;
	padding: 20px;
	width: 100%;
	resize: vertical;
	outline: none;
	border: 1px solid #F2F2F2;
}

.status-upload form button {
	border: medium none;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	-ms-border-radius: 4px;
	-o-border-radius: 4px;
	border-radius: 4px;
	color: #fff;
	float: right;
	font-family: Lato;
	font-size: 14px;
	letter-spacing: 0.3px;
	margin-right: 9px;
	margin-top: 9px;
	padding: 6px 15px;
}

.dropdown>a>span.green:before {
	border-left-color: #2dcb73;
}

.status-upload form button>i {
	margin-right: 7px;
}
</style>
</head>
<body>

	<!-- �׺���̼� �� -->
	<%--       <%@ include file = "../common/navi.jsp" %> --%>
	<%@ include file="../../common/naviLogin.jsp"%>
	<!-- �׺���̼� �� �� /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
	<br>
	<br>
	<div class="container">
		<h2>������ ��û�ߴµ���</h2>
		<hr>
		<table>
			<tr>
				<td align="center" width="76">�ۼ��� :</td>
				<td width="0">�������</td>

				<td align="center" width="76">��ȸ�� :</td>
				<td width="0">231</td>

				<td align="center" width="76">�ۼ��� :</td>
				<td width="0">18.11.30 10:35</td>
			</tr>
		</table>
		<div class="form-group">
			<hr>
			<div class="form-group">
				<label><h6>���Ǻз� :</h6></label> <input type="radio" name="����"
					value="����" checked="checked" disabled>���� <input
					type="radio" name="�Ű�" value="�Ű�" disabled>�Ű�
			</div>
			<label><h6>���� ����</h6></label>
			<textarea class="form-control" readonly rows="10" id="comment"
				placeholder="������ �Է��� �ּ���" readonly>
�����߾��µ��� ���� ���� ��Ȳ���� ��� �ؾߵǴ��� �˷��ּ���</textarea>
		</div>
		<hr>
		<table style="width: 100%;">
			<tr>
				<td rowspan="2" width="100px"><img
					class="mx-auto rounded-circle" src="/dsm/img/team/1.jpg" alt=""
					style="width: 90px; height: 90px;"></td>
			</tr>
			<tr>
				<td>
					<div class="widget-area no-padding blank">
						<div class="status-upload">
							<form>
								<textarea placeholder="�����ڴ�! �亯�� ������ �ۼ����ּ���"></textarea>
								<button type="submit" class="btn btn-success green">
									<i class="fa fa-share"> ���</i>
								</button>
								<button type="submit" class="btn btn-success green">
									<i class="fa fa-share"> ���</i>
								</button>
							</form>
						</div>
						<!-- Status Upload  -->
					</div> <!-- Widget Area -->
				</td>
			</tr>
		</table>
		<hr>
		<br> <br>
	</div>
	<!-- Footer -->
	<%@ include file="../../common/footer.jsp"%>
	<!-- footer �� /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
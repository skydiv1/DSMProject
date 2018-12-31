<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin_Customer_Service_Page</title>

<!-- Bootstrap Core CSS -->
<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="../vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="../dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="/dsm/views/admin/pages/adminMain.jsp">관리자
					페이지</a>
			</div>
			<!-- /.navbar-header -->

			<ul class="nav navbar-top-links navbar-right">
				<!-- /.dropdown -->
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="../../../index.jsp"><i
								class="fa fa-sign-out fa-fw"></i> 홈페이지로 이동</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
	                 <li>
                            <a href="/dsm/views/admin/pages/adminMember.jsp"><i class="fa fa-table fa-fw"></i> 회원관리</a>
                        </li>
						
						<li>
                            <a href="/dsm/selectAllRefund"><i class="fa fa-table fa-fw"></i> 환불관리</a>
                        </li>
						
						<li>
                            <a href="/dsm/views/admin/pages/adminQnaAnswer.jsp"><i class="fa fa-table fa-fw"></i> 고객센터</a>
                        </li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">고객센터</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">QnA Tables</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<table width="100%"
								class="table table-striped table-bordered table-hover"
								id="dataTables-example">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Phone</th>
										<th>E-mail</th>
										<th>회원 유형</th>
									</tr>
								</thead>
								<tbody>
									<tr class="odd gradeX">
										<td>Trident</td>
										<td>Internet Explorer 4.0</td>
										<td>Win 95+</td>
										<td class="center">4</td>
										<td class="center">X</td>
									</tr>
									<tr class="even gradeC">
										<td>Trident</td>
										<td>Internet Explorer 5.0</td>
										<td>Win 95+</td>
										<td class="center">5</td>
										<td class="center">C</td>
									</tr>
									<tr class="odd gradeA">
										<td>Trident</td>
										<td>Internet Explorer 5.5</td>
										<td>Win 95+</td>
										<td class="center">5.5</td>
										<td class="center">A</td>
									</tr>
									<tr class="even gradeA">
										<td>Trident</td>
										<td>Internet Explorer 6</td>
										<td>Win 98+</td>
										<td class="center">6</td>
										<td class="center">A</td>
									</tr>
									<tr class="odd gradeA">
										<td>Trident</td>
										<td>Internet Explorer 7</td>
										<td>Win XP SP2+</td>
										<td class="center">7</td>
										<td class="center">A</td>
									</tr>
									<tr class="even gradeA">
										<td>Trident</td>
										<td>AOL browser (AOL desktop)</td>
										<td>Win XP</td>
										<td class="center">6</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Firefox 1.0</td>
										<td>Win 98+ / OSX.2+</td>
										<td class="center">1.7</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Firefox 1.5</td>
										<td>Win 98+ / OSX.2+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Firefox 2.0</td>
										<td>Win 98+ / OSX.2+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Firefox 3.0</td>
										<td>Win 2k+ / OSX.3+</td>
										<td class="center">1.9</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Camino 1.0</td>
										<td>OSX.2+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Camino 1.5</td>
										<td>OSX.3+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Netscape 7.2</td>
										<td>Win 95+ / Mac OS 8.6-9.2</td>
										<td class="center">1.7</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Netscape Browser 8</td>
										<td>Win 98SE+</td>
										<td class="center">1.7</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Netscape Navigator 9</td>
										<td>Win 98+ / OSX.2+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.0</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.1</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1.1</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.2</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1.2</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.3</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1.3</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.4</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1.4</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.5</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1.5</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.6</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">1.6</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.7</td>
										<td>Win 98+ / OSX.1+</td>
										<td class="center">1.7</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Mozilla 1.8</td>
										<td>Win 98+ / OSX.1+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Seamonkey 1.1</td>
										<td>Win 98+ / OSX.2+</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Gecko</td>
										<td>Epiphany 2.20</td>
										<td>Gnome</td>
										<td class="center">1.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>Safari 1.2</td>
										<td>OSX.3</td>
										<td class="center">125.5</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>Safari 1.3</td>
										<td>OSX.3</td>
										<td class="center">312.8</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>Safari 2.0</td>
										<td>OSX.4+</td>
										<td class="center">419.3</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>Safari 3.0</td>
										<td>OSX.4+</td>
										<td class="center">522.1</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>OmniWeb 5.5</td>
										<td>OSX.4+</td>
										<td class="center">420</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>iPod Touch / iPhone</td>
										<td>iPod</td>
										<td class="center">420.1</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Webkit</td>
										<td>S60</td>
										<td>S60</td>
										<td class="center">413</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 7.0</td>
										<td>Win 95+ / OSX.1+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 7.5</td>
										<td>Win 95+ / OSX.2+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 8.0</td>
										<td>Win 95+ / OSX.2+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 8.5</td>
										<td>Win 95+ / OSX.2+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 9.0</td>
										<td>Win 95+ / OSX.3+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 9.2</td>
										<td>Win 88+ / OSX.3+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera 9.5</td>
										<td>Win 88+ / OSX.3+</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Opera for Wii</td>
										<td>Wii</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Nokia N800</td>
										<td>N800</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>Presto</td>
										<td>Nintendo DS browser</td>
										<td>Nintendo DS</td>
										<td class="center">8.5</td>
										<td class="center">C/A<sup>1</sup>
										</td>
									</tr>
									<tr class="gradeC">
										<td>KHTML</td>
										<td>Konqureror 3.1</td>
										<td>KDE 3.1</td>
										<td class="center">3.1</td>
										<td class="center">C</td>
									</tr>
									<tr class="gradeA">
										<td>KHTML</td>
										<td>Konqureror 3.3</td>
										<td>KDE 3.3</td>
										<td class="center">3.3</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeA">
										<td>KHTML</td>
										<td>Konqureror 3.5</td>
										<td>KDE 3.5</td>
										<td class="center">3.5</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeX">
										<td>Tasman</td>
										<td>Internet Explorer 4.5</td>
										<td>Mac OS 8-9</td>
										<td class="center">-</td>
										<td class="center">X</td>
									</tr>
									<tr class="gradeC">
										<td>Tasman</td>
										<td>Internet Explorer 5.1</td>
										<td>Mac OS 7.6-9</td>
										<td class="center">1</td>
										<td class="center">C</td>
									</tr>
									<tr class="gradeC">
										<td>Tasman</td>
										<td>Internet Explorer 5.2</td>
										<td>Mac OS 8-X</td>
										<td class="center">1</td>
										<td class="center">C</td>
									</tr>
									<tr class="gradeA">
										<td>Misc</td>
										<td>NetFront 3.1</td>
										<td>Embedded devices</td>
										<td class="center">-</td>
										<td class="center">C</td>
									</tr>
									<tr class="gradeA">
										<td>Misc</td>
										<td>NetFront 3.4</td>
										<td>Embedded devices</td>
										<td class="center">-</td>
										<td class="center">A</td>
									</tr>
									<tr class="gradeX">
										<td>Misc</td>
										<td>Dillo 0.8</td>
										<td>Embedded devices</td>
										<td class="center">-</td>
										<td class="center">X</td>
									</tr>
									<tr class="gradeX">
										<td>Misc</td>
										<td>Links</td>
										<td>Text only</td>
										<td class="center">-</td>
										<td class="center">X</td>
									</tr>
									<tr class="gradeX">
										<td>Misc</td>
										<td>Lynx</td>
										<td>Text only</td>
										<td class="center">-</td>
										<td class="center">X</td>
									</tr>
									<tr class="gradeC">
										<td>Misc</td>
										<td>IE Mobile</td>
										<td>Windows Mobile 6</td>
										<td class="center">-</td>
										<td class="center">C</td>
									</tr>
									<tr class="gradeC">
										<td>Misc</td>
										<td>PSP browser</td>
										<td>PSP</td>
										<td class="center">-</td>
										<td class="center">C</td>
									</tr>
									<tr class="gradeU">
										<td>Other browsers</td>
										<td>All others</td>
										<td>-</td>
										<td class="center">-</td>
										<td class="center">U</td>
									</tr>
								</tbody>
							</table>
							<!-- /.table-responsive -->

						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="../vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="../vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="../vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>

</body>
</html>
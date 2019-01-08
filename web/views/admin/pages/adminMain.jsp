<%@page import="com.kh.w7.admin.model.vo.Admin"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	Admin ad = (Admin)request.getAttribute("ad");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>������ ������</title>	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Bootstrap Core CSSaaa-->
<link href="/dsm/views/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/dsm/views/admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="/dsm/views/admin/dist/css/sb-admin-2.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="/dsm/views/admin/vendor/morrisjs/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="/dsm/views/admin/vendor/font-awesome/css/font-awesome.min.css"
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
			<a class="navbar-brand" href="/dsm/refreshPage">������ ������</a>
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
					<li><a href="/dsm/index.jsp"><i
							class="fa fa-sign-out fa-fw"></i> Ȩ�������� �̵�</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links --> <!-- ���� �κ��� ���� �Ǻκ� ���� �ϴ°�. ��� �߰� -->
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li><a href="/dsm/selectAllMember"><i class="fa fa-table fa-fw"></i> ȸ������</a>
					</li>

					<li><a href="/dsm/selectAllRefund"><i class="fa fa-table fa-fw"></i> ȯ�Ұ���</a>
					</li>

					<li><a href="/dsm/selectAllBoard"><i class="fa fa-table fa-fw"></i> ������</a>
					</li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div  class="col-lg-12">
					<h1 class="page-header">Ȩ������ ����</h1>
					<div align = "right">
					<!-- <button style = "width : 200px;  margin : 10px;" class="btn btn-default btn-block" onclick="location.href = '/dsm/refreshPage'">�����ϱ�</button> --></div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-3 col-md-6" style = "width : 700px;">
				
					<div class="panel panel-primary"> <!-- ǥ ���� ���ϴ� �κ� -->
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-bank fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge"><%= ad.getMoneyPlus() %></div>
									<div >�� �����ݾ�!</div>
									<div class="huge"><%= ad.getMoneyMinus() %></div>
									<div>�� ȯ�ޱݾ�!</div>
									<div class="huge"><%= ad.getMoneyDeal() %></div>
									<div>�� �ŷ� �ݾ�!</div>
								</div>
							</div>
						</div>
						<a href="/dsm/cashConvertExcel">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
			
				<div class="col-lg-3 col-md-6" style = "width : 500px;">
					<div class="panel panel-info" >
						<div class="panel-heading" >
							<div class="row" >
								<div class="col-xs-3">
									<i class="fa fa-shopping-cart fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge"><%= ad.getProductCount()%></div>
									<div>�� ��ǰ ��!</div>
								</div>
							</div>
						</div>
						<a href="/dsm/productConvert">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6" style = "width : 500px;">
					<div class="panel panel-warning" >
						<div class="panel-heading" >
							<div class="row" >
								<div class="col-xs-3">
									<i class="fa fa-pencil fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge"><%= ad.getBoardCount()%></div>
									<div>�� �Խñ� ��!</div>
								</div>
							</div>
						</div>
						<a href="/dsm/boardConvertExcel">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6" style = "width : 400px;">
					<div class="panel panel-yellow">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-credit-card fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge"><%= ad.getDealCount() %></div>
									<div>�� ���� ��!</div>
								</div>
							</div>
						</div>
						<a href="/dsm/cashConvertExcel">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				
				<div class="col-lg-3 col-md-6"  style = "width : 400px;">
					<div class="panel panel-red">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-user fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge"><%= ad.getMemberCount() %></div>
									<div>�� ȸ�� ��!</div>
								</div>
							</div>
						</div>
						<a href="/dsm/memberConvertExcel">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6"  style = "width : 400px;">
					<div class="panel panel-green">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-3">
									<i class="fa fa-credit-card fa-5x"></i>
								</div>
								<div class="col-xs-9 text-right">
									<div class="huge"><%= ad.getTax() %></div>
									<div>�� ��� ������!</div>
								</div>
							</div>
						</div>
						<a href="/dsm/cashConvertExcel">
							<div class="panel-footer">
								<span class="pull-left">View Details</span> <span
									class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
								<div class="clearfix"></div>
							</div>
						</a>
					</div>
					
				</div>
				
				<div class="row">
				<!-- <div class="col-lg-8">
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> Area Chart Example
							<div class="pull-right">
								<div class="btn-group">
									<button type="button"
										class="btn btn-default btn-xs dropdown-toggle"
										data-toggle="dropdown">
										Actions <span class="caret"></span>
									</button>
									<ul class="dropdown-menu pull-right" role="menu">
										<li><a href="#">Action</a></li>
										<li><a href="#">Another action</a></li>
										<li><a href="#">Something else here</a></li>
										<li class="divider"></li>
										<li><a href="#">Separated link</a></li>
									</ul>
								</div>
							</div>
						</div>
						/.panel-heading
						<div class="panel-body">
							<div id="morris-area-chart"></div>
						</div>
						/.panel-body
					</div>
					/.panel
				</div> -->
				
				
			</div>
			<!-- /.row -->
			
		
		<!-- /#page-wrapper -->

				<!-- /.col-lg-8 -->
				<div class="col-lg-4" >
					<!-- /.panel -->
					<div class="panel panel-default">
						<div class="panel-heading">
							<i class="fa fa-bar-chart-o fa-fw"></i> ȸ������
						</div>
						<div class="panel-body">
							<div id="morris-donut-chart"></div>
							<a href="#" class="btn btn-default btn-block">View Details</a>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
					<!-- /.panel .chat-panel -->
				</div>
				<!-- /.col-lg-4 -->
				
				

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			</div>
			

				
				
				
				
				
				
				
				
				<!-- /.col-lg-4 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->


	<script>
		donutData = [{
            label: "Customer Member",
            value: <%= ad.getCustomerCount()%>
        }, {
            label: "Seller Member",
            value: <%= ad.getSellerCount()%>
        }, {
            label: "Administer Member",
            value: <%= ad.getMemberCount() - ad.getCustomerCount() - ad.getSellerCount()%>
        }];
		
		
		
		
		
		$(function(){
			Morris.Donut({
			    element: 'morris-donut-chart',
			    data: donutData,
			    resize: true,
		        parseTime:false
		 	});

			
			
			
			/* 
			var areaData = {};
			areaData.push({
				 	period: '2016 Q1',
		            Member: 95,
		            Product: 33,
		            Deal: 55
			});
			
			
			Morris.Area({
				element: 'morris-area-chart',
				data : areaData,
				xkey: 'period',
		        ykeys: ['Member', 'Product', 'Deal'],
		        labels: ['Member', 'Product', 'Deal'],
		        pointSize: 2,
		        hideHover: 'auto',
		        resize: true
			}); */
			
			
		});
	</script>





	<!-- jQuery -->
	<script src="/dsm/views/admin/vendor/jquery/jquery.min.js?ver=1"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/dsm/views/admin/vendor/bootstrap/js/bootstrap.min.js?ver=1"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/dsm/views/admin/vendor/metisMenu/metisMenu.min.js?ver=1"></script>

	<!-- Morris Charts JavaScript -->
	<script src="/dsm/views/admin/vendor/raphael/raphael.min.js?ver=1"></script>
	<script src="/dsm/views/admin/vendor/morrisjs/morris.min.js?ver=1"></script>
	<script src="/dsm/views/admin/data/morris-data.js?ver=1"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/dsm/views/admin/dist/js/sb-admin-2.js?ver=1"></script>

</body>
</html>
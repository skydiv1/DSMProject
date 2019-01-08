<%@page import="com.kh.w7.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    %>
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
<link href="/dsm/views/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="/dsm/views/admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="/dsm/views/admin/vendor/datatables-plugins/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="/dsm/views/admin/vendor/datatables-responsive/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="/dsm/views/admin/dist/css/sb-admin-2.css" rel="stylesheet">

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
				<a class="navbar-brand"
					href="/dsm/refreshPage">관리자
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
						<li><a href="/dsm/index.jsp"><i
								class="fa fa-sign-out fa-fw"></i> 홈페이지로 이동</a></li>
					</ul> <!-- /.dropdown-user --></li>
				<!-- /.dropdown -->
			</ul>
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
	                 <li>
                            <a href="/dsm/selectAllMember"><i class="fa fa-table fa-fw"></i> 회원관리</a>
                        </li>
						
						<li>
                            <a href="/dsm/selectAllRefund"><i class="fa fa-table fa-fw"></i> 환불관리</a>
                        </li>
						
						<li>
                            <a href="/dsm/selectAllBoard"><i class="fa fa-table fa-fw"></i> 고객센터</a>
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
						<div class="panel-heading"><a href="/dsm/selectAllBoard">QnA 답변</a><label>&nbsp;&nbsp;|&nbsp;&nbsp;</label><a href="/dsm/selectAllFaq">FAQ작성</a></div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							 <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>게시글  번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>답변 여부</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% for(int i = 0; i < list.size() ; i++){ %>
                                    <tr class="odd gradeX" onclick = "location.href = '/dsm/selectBoard.bo?num=<%= list.get(i).getBoardNo() %>'" style="cursor:pointer">
                                        <td><%= list.get(i).getBoardNo() %></td>
                                        <td><%= list.get(i).getBoardTitle() %></td>
                                        <td><%= list.get(i).getMemberName() %></td>
                                        <td class="center"><%= list.get(i).getBoardDate() %></td>
                                        <% if(list.get(i).getBoardQnaAnswerYn() == 0){ %>
                                        <td class="center"><button onclick = "location.href = '/dsm/selectBoard.bo?num=<%= list.get(i).getBoardNo() %>'">답변하기</button></td>
                                        <% }else{ %>
                                        <td class="center"><button>응답완료</button></td>
                                        <% } %>
                                    </tr>
                                <%} %>
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
	<script src="/dsm/views/admin/vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="/dsm/views/admin/vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="/dsm/views/admin/vendor/metisMenu/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="/dsm/views/admin/vendor/datatables/js/jquery.dataTables.min.js"></script>
	<script src="/dsm/views/admin/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
	<script src="/dsm/views/admin/vendor/datatables-responsive/dataTables.responsive.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="/dsm/views/admin/dist/js/sb-admin-2.js"></script>

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
<%@page import="com.kh.w7.refund.model.vo.Refund"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%
    	ArrayList<Refund> list = (ArrayList<Refund>)request.getAttribute("list");
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- 	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous"> -->
	
	
    <title>Admin_Cash_Page</title>

    <!-- Bootstrap Core CSS -->
    <link href="/dsm/views/admin/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/dsm/views/admin/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/dsm/views/admin/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/dsm/views/admin/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/dsm/views/admin/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/dsm/views/admin/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


	<script>
		refundNoMap = {};
	</script>
	
	
</head>
<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="/dsm/refreshPage">관리자 페이지</a>
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
						<li><a href="/dsm//index.jsp"><i
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
                    <h1 class="page-header">환급관리</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	환급신청 판매자 목록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>환급 번호</th>
                                        <th>이름</th>
                                        <th>은행</th>
                                        <th>계좌</th>
                                        <th>생년월일</th>
                                        <th>금액</th>
                                        <th>신청날짜</th>
                                        <th>지급상태</th>
                                        <th>지급하기</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% for(int i = 0; i < list.size() ; i++){ %>
                                    <tr class="odd gradeX">
                                        <td><%= list.get(i).getRefund_no() %></td>
                                        <td><%= list.get(i).getMember_name() %></td>
                                        <td><%= list.get(i).getRefund_bank() %></td>
                                        <td class="center"><%= list.get(i).getRefund_account() %></td>
                                        <td class="center"><%= list.get(i).getMember_birth() %></td>
                                        <td class="center"><%= list.get(i).getRefund_money() %></td>
                                        <td class="center"><%= list.get(i).getRefund_applyDate() %></td>
                                        <% if(list.get(i).getRefund_StatusYN() == 0) {%>
                                        <td class="center">미지급</td>
                                        <% }else{ %>
                                        <td class="center">지급완료</td>
                                        <% } %>
                                        <% if(list.get(i).getRefund_StatusYN() == 0) {%>
                                        <td class="center" align = "center"><button style = "background : lightgray; color : black" onclick = 
                                        "location.href = '/dsm/updateRefundStatus?refundNo=<%= list.get(i).getRefund_no() %>'">지급완료</button></td>
                                        <% }else{ %>
                                        <td class="center"></td>
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
                    <div align = "right">
                    <button style = "background : lightgray; color : black; width : 100px; height : 40px; margin-right : 20px;" onclick = "window.print()">인쇄하기</button>
                    </div>
                    
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
            responsive: true
        });
    });
    

   

    </script>

</body>
</html>
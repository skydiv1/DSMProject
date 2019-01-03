<%@page import="com.kh.w7.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%
    	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Admin_Member_Page</title>

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
<script>
	temp = 0;
</script>
</head>
<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<a class="navbar-brand"
					href="/dsm/views/admin/pages/adminMain.jsp">������
					������</a>
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
			<!-- /.navbar-top-links -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
	                 <li>
                            <a href="/dsm/selectAllMember"><i class="fa fa-table fa-fw"></i> ȸ������</a>
                        </li>
						
						<li>
                            <a href="/dsm/selectAllRefund"><i class="fa fa-table fa-fw"></i> ȯ�Ұ���</a>
                        </li>
						
						<li>
                            <a href="/dsm/selectAllBoard"><i class="fa fa-table fa-fw"></i> ������</a>
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
					<h1 class="page-header">ȸ������</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">��ü ȸ�� ���</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							 <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ȸ����ȣ<br></th>
                                        <th>���̵�<br></th>
                                        <th>�̸�<br></th>
                                        <th>�̸���<br></th>
                                        <th>��ȣ<br></th>
                                        <th>�з�<br></th>
                                        <th>����<br></th>
                                        <th>��� Ƚ��<br></th>
                                        <th>���°���<br></th>
                                        <th>�ڰ���<br>���� ����</th>
                                        <th>�ڰ���<br>�̹���</th>
                                    </tr>
                                </thead>
                                <tbody>
                              <% for(int i = 0; i < list.size() ; i++){ %>
                                    <tr class="odd gradeX">
                                        <td><%= list.get(i).getMemberCode() %></td>
                                        <td><%= list.get(i).getMemberId() %></td>
                                        <td><%= list.get(i).getMemberName() %></td>
                                        <td class="center"><%= list.get(i).getMemberEmail() %></td>
                                        <td class="center"><%= list.get(i).getMemberPhone() %></td>
                                        <% if(list.get(i).getMemberCategory() == 0){%>
                                        <td class="center">�Һ���</td>
                                        <% }else if(list.get(i).getMemberCategory() == 1){ %>
                                        <td class="center">�Ǹ���</td>
                                        <% }else{ %>
                                        <td class="center">������</td>
                                        <% } %>
                                        
                                        
                                        <% if(list.get(i).getMemberStatus() == 0){%>
                                        <td class="center">����</td>
                                        <% }else if(list.get(i).getMemberStatus() == 1){ %>
                                        <td class="center">Ż��</td>
                                        <% }else if(list.get(i).getMemberStatus() == 2){ %>
                                        <td class="center">������Ʈ</td>
                                        <% } %>
                                        
                                        <td class="center"><div id = "warningCountDiv<%= list.get(i).getMemberCode() %>" style = "display : inline"><%= list.get(i).getBlackCount() %></div>&nbsp;&nbsp;
                                        <button style = "width : 30px ;background : lightgray; color : black" onclick = "plusMinusBtn('minus',<%= list.get(i).getMemberCode() %>)">-</button>
                                        <button style = "width : 30px ;background : lightgray; color : black" onclick = "plusMinusBtn('plus',<%= list.get(i).getMemberCode() %>)">+</button></td>
                                        
                                        
                                        <% if(list.get(i).getMemberStatus() == 0){%>
                                        <td class="center"><button style = "background : lightgray; color : black" onclick = "location.href = '/dsm/memberLightOut?memberCode=<%= list.get(i).getMemberCode() %>'">Ż��</button>
                                        <button style = "background : lightgray; color : black" onclick = "location.href = '/dsm/memberHeavyOut?memberCode=<%= list.get(i).getMemberCode() %>'">���� Ż��</button></td>
                                        <% }else if(list.get(i).getMemberStatus() == 1){ %>
                                        <td class="center"><button style = "background : lightgray; color : black" onclick = "location.href = '/dsm/memberRestore?memberCode=<%= list.get(i).getMemberCode() %>'">����</button></td>
                                        <% }else if(list.get(i).getMemberStatus() == 2){ %>
										<td class="center">&nbsp;</td>
                                        <% } %>
                                        
                                        <% if(list.get(i).getMemberCategory() == 1){%>
                                         	<% if(list.get(i).getSellerCertcheck() == 0){%>
                                        	<td class="center">������&nbsp;<button width = "20px" onclick = "location.href = '/dsm/imgCert?memberCode=<%= list.get(i).getMemberCode() %>'">����</button></td>
                                        	<% }else{ %>
                                        	<td class="center">����</td>
                                        	<% } %>
                                        <% }else{ %>
                                        <td class="center">&nbsp;</td>
                                        <% } %>
                                        
                                        <% if(list.get(i).getMemberCategory() == 1){%>
	                                        <% if(list.get(i).getSellerImgPath() != null) {%>
	                                        	<td class="center">
	                                        	<a href="<%= list.get(i).getSellerImgPath()%>" onclick="window.open(this.href, '�Ǹ��� �ڰ��� �̹���', 'width = 300, height = 300');return false;" target="_blank">
	                                        	<button>�̹��� Ȯ��</button>
	                                        	</a></td>    	
	                                        <% }else{ %>
	                                        	<td class="center">X</td>
	                                        <% } %>
                                        <% }else{ %>
                                         	<td class="center">&nbsp;</td>
                                        <% } %>
                                       	<%--  <% if(list.get(i).getPrivatememberStatus() != 1 && list.get(i).getPrivatememberStatus() != 3) {%>
                                        <td class="center" align = "center"><button style = "background : lightgray; color : black" onclick = "location.href = '/dsm/memberDelete?memberCode=<%= list.get(i).getMemberCode() %>'">Ż��</button></td>
                                        <% }else{ %>
                                        <td class="center"></td>
                                        <% } %> --%>
                                        
                                        
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
		
		function plusMinusBtn(what, memberCode){
			$.ajax({
				url : "/dsm/plusMinus",
				data : {what : what,
						memberCode : memberCode},
				type : "post",
				success : function(data){
					console.log(data);
					var count = Number($("#warningCountDiv"+memberCode).text());
					if(data == 'plus'){
						$("#warningCountDiv"+memberCode).text(count+1);
					}
					else{
						if(count <=0){
							//0���Ϸδ� �ȳ�������
						}
						else{
							$("#warningCountDiv"+memberCode).text(count-1);
						}
					}
				},
				error : function(data){
					console.log(data);
				}
			});
			
		}
		
	</script>

</body>
</html>
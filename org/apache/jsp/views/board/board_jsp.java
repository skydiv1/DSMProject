/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.34
 * Generated at: 2018-12-26 04:10:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.kh.w7.board.model.vo.*;

public final class board_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/views/board/../common/footer.jsp", Long.valueOf(1545785446026L));
    _jspx_dependants.put("/views/board/../common/navi.jsp", Long.valueOf(1545785447056L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.kh.w7.board.model.vo");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write(' ');

	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\" integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("\ttd{\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!-- 네비게이션 바 -->\r\n");
      out.write("< \t\t");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("    <title>DSM(Drone Service Market)</title>\n");
      out.write("    \n");
      out.write("    <!-- JQuery CDN -->\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("\t\n");
      out.write("    <!-- Bootstrap core CSS -->\n");
      out.write("    <link href=\"/dsm/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Custom fonts for this template -->\n");
      out.write("    <link href=\"/dsm/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>\n");
      out.write("\n");
      out.write("    <!-- Custom styles for this template -->\n");
      out.write("    <link href=/dsm/css/agency.min.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<!-- head 끝/////////////////////////////////////////////////////////////////////////////////////////////////////////////// -->\n");
      out.write("<body>\n");
      out.write("\t<nav class=\"navbar navbar-expand-lg navbar-dark fixed-top\" id=\"mainNav\">\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<a class=\"navbar-brand js-scroll-trigger\" href=\"/dsm/index.jsp\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;DSM</a>\n");
      out.write("\t<button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarResponsive\" aria-controls=\"navbarResponsive\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("\tMenu <i class=\"fas fa-bars\"></i>\n");
      out.write("\t</button>\n");
      out.write("\t<div class=\"collapse navbar-collapse\" id=\"navbarResponsive\">\n");
      out.write("\t\t<ul class=\"navbar-nav text-uppercase ml-auto\">\n");
      out.write("\t\t\t<li class=\"nav-item\">\n");
      out.write("\t\t\t<a class=\"nav-link js-scroll-trigger\" href=\"/dsm/selectList.pr\"><b>상품 목록</b></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"nav-item\" id=\"productEnrollment\">\n");
      out.write("         \t<a class=\"nav-link js-scroll-trigger\"><b>상품 등록</b></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"nav-item\">\n");
      out.write("\t\t\t<a class=\"nav-link js-scroll-trigger\" href=\"/dsm/views/board/board.jsp\"><b>게시판</b></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"nav-item\">\n");
      out.write("\t\t\t<a class=\"nav-link js-scroll-trigger\" href=\"/dsm/views/member/login.jsp\"><b>마이페이지</b></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"nav-item\">\n");
      out.write("\t\t\t<a class=\"nav-link js-scroll-trigger\" href=\"/dsm/views/faq/FAQ.jsp\"><b>고객센터</b></a>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("<header class=\"masthead\" style=\"background-image: url('/dsm/img/drone_background.jpg'); background-size: 100% 500px; margin-top: 0px; background-position:center;\">\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<div class=\"intro-text\" style=\"padding-top:35px;\">\n");
      out.write("\t\t<div>&nbsp;</div>\n");
      out.write("\t\t<div>&nbsp;</div>\n");
      out.write("\t\t<div>&nbsp;</div>\n");
      out.write("\t\t<div style=\"margin-bottom: 20px;\">\n");
      out.write("\t\t\t<input type=\"text\" id=\"\" placeholder=\"아이디를 입력하세요\" style=\"width:250px; height:40px; font-size: 12px; box-shadow:0px 0px 20px #000; border-radius:6px;\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div style=\"margin-bottom: 20px\">\n");
      out.write("\t\t\t<input type=\"password\" id=\"\" placeholder=\"비밀번호를 입력하세요\" style=\"width:250px; height:40px; font-size: 12px; box-shadow:0px 0px 20px #000; border-radius:6px;\">\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<a id=\"login\" class=\"btn btn-primary btn-xl text-uppercase js-scroll-trigger\" href=\"/dsm/login.me\" style=\"padding: 7px 60px; box-shadow:0px 0px 10px #000; background-color:#fed136;\"><label style=\"width:100px; height:12px; \">로그인</label></a>\n");
      out.write("\t\t<div style=\"margin-top:10px;\"><a href=\"/dsm/views/member/find_Id.jsp\">아이디 찾기</a> / <a href=\"/dsm/views/member/find_pw.jsp\">비밀번호 찾기</a> / <a href=\"/dsm/views/member/user_terms2.jsp\">회원가입</a></div>\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("\t$(function () {\n");
      out.write("\t\t$(\"#productEnrollment\").click(function () {\n");
      out.write("\t\t\t$(\"#productEnrollment\").css(\"cursor\",\"pointer\");\n");
      out.write("\t\t\talert(\"로그인이 필요한 서비스 입니다.\");\n");
      out.write("\t\t})\n");
      out.write("\t})\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("    <!-- Bootstrap core JavaScript -->\n");
      out.write("    <script src=\"/dsm/vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <script src=\"/dsm/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Plugin JavaScript -->\n");
      out.write("    <script src=\"/dsm/vendor/jquery-easing/jquery.easing.min.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Contact form JavaScript -->\n");
      out.write("    <script src=\"/dsm/js/jqBootstrapValidation.js\"></script>\n");
      out.write("    <script src=\"/dsm/js/contact_me.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Custom scripts for this template -->\n");
      out.write("    <script src=\"/dsm/js/agency.min.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write(" \r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->\r\n");
      out.write("<section class=\"bg-light\" id=\"portfolio\">\r\n");
      out.write("\r\n");
      out.write("\t<h2 style=\"margin:-10px -20px -10px 70px; padding-left:5%\">게시판</h2>\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<!-- 로그인한 사용자만 게시글 작성할 수 있게 만드는거 2018-12-24 오후 3:05분 -->\r\n");
      out.write("\t\t \t\t<div style=\"margin:10px 10px 10px 1050px\">\r\n");
      out.write("\t\t \t\t\t<a class=\"btn btn-primary pull-right \" href=\"boardWrite.jsp\">\r\n");
      out.write("\t\t \t\t\t");
      out.write("\r\n");
      out.write("\t\t \t\t\t\t<button>글쓰기</button>\r\n");
      out.write("\t\t \t\t\t");
      out.write("\t\r\n");
      out.write("\t\t \t\t\t</a>\r\n");
      out.write("\t\t \t\t</div>\r\n");
      out.write("\t\t <div class=\"row\" style=\"postion:static;\">\r\n");
      out.write("\t\t \t<table class=\"table table-striped\"  border:1px; solid #dddddd\">\r\n");
      out.write("\t\t \t\t<thead>\r\n");
      out.write("\t\t \t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 3% background-color:#eeeeee; text-align: center;\">번호</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 20% background-color:#eeeeee; text-align: center;\">제목</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 5% background-color:#eeeeee; text-align: center;\">작성자</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 5% background-color:#eeeeee; text-align: center;\">작성일</th>\r\n");
      out.write("\t\t\t\t\t\t<th style=\"width: 3% background-color:#eeeeee; text-align: center;\">조회수</th>\r\n");
      out.write("\t\t\t\t\t</tr>\t\t \t\t\r\n");
      out.write("\t\t \t\t</thead>\r\n");
      out.write("\t\t \t\t<tbody>\r\n");
      out.write("\t\t \t\t");
 for(Board b : list){ 
      out.write("\r\n");
      out.write("\t\t \t\t\t\t<tr>\t\t \t\t\t\t                      \r\n");
      out.write("                            <td>");
      out.print( b.getBoardNo() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( b.getMemberCode() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( b.getBoardTitle() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( b.getBoardDate() );
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print( b.getBoardCount() );
      out.write("</td>\r\n");
      out.write("                            \r\n");
      out.write("                        </tr>\r\n");
      out.write("                ");
 } 
      out.write("\r\n");
      out.write("\t\t \t\t</tbody>\t\t \t\r\n");
      out.write("\t\t \t</table>\t\t \t\r\n");
      out.write("\t\t \t<nav aria-label=\"page\" style=\"margin:0px 0px 0px 400px\">\r\n");
      out.write(" \t\t\t <ul class=\"pagination\">\r\n");
      out.write("    \t\t\t<li class=\"page-item\">\r\n");
      out.write("    \t\t\t  <a class=\"page-link\" href=\"#\" aria-label=\"Previous\">\r\n");
      out.write("        \t\t\t<span aria-hidden=\"true\">&laquo;</span>\r\n");
      out.write("        \t\t\t<span class=\"sr-only\">Previous</span>\r\n");
      out.write("      \t</a>\r\n");
      out.write("\t\t\t\t    </li>\r\n");
      out.write("\t\t\t\t    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">1</a></li>\r\n");
      out.write("\t\t\t\t    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">2</a></li>\r\n");
      out.write("\t\t\t\t    <li class=\"page-item\"><a class=\"page-link\" href=\"#\">3</a></li>\r\n");
      out.write("\t\t\t\t    <li class=\"page-item\">\r\n");
      out.write("\t\t\t\t      <a class=\"page-link\" href=\"#\" aria-label=\"Next\">\r\n");
      out.write("\t      \t  <span aria-hidden=\"true\">&raquo;</span>\r\n");
      out.write("\t        <span class=\"sr-only\">Next</span>\r\n");
      out.write("\t      </a>\r\n");
      out.write("\t    </li>\r\n");
      out.write("\t        \t <!-- 검색 드롭박스 부분 보류 -->\r\n");
      out.write(" <div class=\"searchArea\" id=\"searchText\" style=\"margin:0px 0px 0px 240px\">\r\n");
      out.write("    <button class=\"dropdown\" type=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">제목</button>\r\n");
      out.write("    <input type =\"text\"  placeholder=\"검색어 입력\">\r\n");
      out.write("    <button>검색</button>\r\n");
      out.write("    <div class=\"dropdown-menu\">\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">제목</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">작성자</a>\r\n");
      out.write("      <a class=\"dropdown-item\" href=\"#\">제목+내용</a>    \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("</div>\r\n");
      out.write("\t  </ul>\r\n");
      out.write("  \r\n");
      out.write("</nav>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t \t\r\n");
      out.write("\t\t \t</div>\r\n");
      out.write("\t\t \t\r\n");
      out.write("\t\t </div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write(" </section>\r\n");
      out.write("</body>\r\n");
      out.write("<br><br>\r\n");
      out.write("<!-- Footer -->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("    <title>DSM(Drone Service Market)</title>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"/dsm/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom fonts for this template -->\r\n");
      out.write("    <link href=\"/dsm/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>\r\n");
      out.write("    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"/dsm/css/agency.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<footer style=\"background-color:gray; height:300px;\">\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div class=\"row\">\r\n");
      out.write("\t\t<div class=\"col-md-4\" style=\"color:white;\">\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<b>고객센터</b><br>\r\n");
      out.write("\t\t\t070.4342.9483<br>\t\r\n");
      out.write("\t\t\t<br>\t\t\t\r\n");
      out.write("\t\t\t<br>\t\t\t\t\t\r\n");
      out.write("\t\t\t<b>고객센터 운영시간</b><br>\t\r\n");
      out.write("\t\t\t평일 09:00~18:00<br>\t\r\n");
      out.write("\t\t\t주말/공휴일 OFF<br>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-4\">\r\n");
      out.write("\t\t\t<ul class=\"list-inline quicklinks\">\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a style=\"color:white;\">- 목록 -</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"/dsm/views/product/productList.jsp\">상품 목록</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"/dsm/views/product/productEnrollment.jsp\">상품 등록</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">게시판</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">마이페이지</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a href=\"#\">고객센터</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-md-4\" style=\"color:white\">\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t(주) DMS 사업자 정보 <br>\r\n");
      out.write("\t\t\t(주)DMS|서울시 서초구 사임당로 157, 3층<br>\r\n");
      out.write("\t\t\t대표 : 한의희|개인정보관리책임자 : 한의희<br>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t사업자등록번호 : 613-81-65278<br>\r\n");
      out.write("\t\t\t통신판매업신고 : 2014-서울강남-01471호<br>\r\n");
      out.write("\t\t\t1544-6254|help@DMS.com<br>\r\n");
      out.write("\t\t\t호스팅 사업자: Amazon Web Service(AWS)<br>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("</footer>\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
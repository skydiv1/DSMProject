<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.board.model.vo.*"%>
<%-- <%
	Board b = (Board)request.getAttribute("b");
	Member m = (Member)request.getAttribute("m");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTDHTML4.01Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Insert title here</title>
        </head>
        <body>
            <!-- 네비게이션 바 -->
            <%@ include file="../common/menubar.jsp"%>
            <!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
            <br>
                <br>
 <% if(loginUser != null ){ %>
<div class="outer">
    <form id="updateForm" method="post">
        <div class="container">
            <caption>
                <h1>게시글 작성</h1>
            </caption>
            <hr>
                    <label>
                        <h3>제목 : &nbsp;</h3>
                    </label>
                    <h7>
                        <input name="title" placeholder="제목을 입력해 주세요" type="text"></h7>
                    <hr>
                        <td>
                            <h4>
                                <label>작성자 : &nbsp;</label>
                                <span><b><%=loginUser.getMemberName()%></b></span>
			    </h4>
			</td>
			<input type="hidden" value="<%=loginUser.getMemberCode()%>" name="memberCode">			
			    <hr>
			        <label>
			            <h3>내용
			            </h3>
			        </label>
			        <hr>
			                <textarea cols="60" name="context" name="context" placeholder="내용을 입력해 주세요" rows="15" type="context"></textarea>
			            <hr>
			                <div style="margin:0px 0px 0px 900px; margin-right:10px; ">
							<button class="btn btn-default" onclick="complet()">확인</button>
							<button class="btn btn-default" onclick="cancel()">취소</button>
							</div>
			<br>
			    <hr>
			        <br>
			    </div>
			     <script>
                function complet(){
					$("#updateForm").attr("action", "<%=request.getContextPath()%>/insert.bo");
				}
                function cancel(){
					$("#updateForm").attr("action", "<%=request.getContextPath()%>/selectList.bo");
				}
                </script>
				</form>
				</div>
				<% }else{
				request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
				request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);																	
				} %>
				
				<!-- Footer -->
				<%@ include file = "../common/footer.jsp" %>
				<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
				    </body>
				</html>
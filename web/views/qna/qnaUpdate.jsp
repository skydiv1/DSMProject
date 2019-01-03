<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.board.model.vo.*" import="com.kh.w7.reply.model.vo.*"%>
<%
	Board b = (Board)request.getAttribute("b");
	Member m = (Member)request.getAttribute("m");
	Reply r = (Reply)request.getAttribute("r");
%>
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
                    <div class="container">
                        <form>
                            <div class="form-group">
                                <label>
                                    <h2>글 수정</h2>
                                </label>
                               <hr>
						      <form action="<%= request.getContextPath() %>/updateFaq.faq" method="post">
						      <thead>
						        <div class="form-group">
						            <label>
						                <h3>제목 : &nbsp;</h3>
						            </label>
						            <h7><input type="text" style="width:300px" name="Boardtitle" placeholder="제목을 입력해 주세요" value="<%= b.getBoardTitle() %>"></h7>
						            <input type="hidden" name="BoardNo" value="<%= b.getBoardNo() %>">
						        </div>       
						      </thead>
						      <hr>
						      <tr height="1" bgcolor="#dddddd">
						          <td colspan="4" width="407"></td>
						      </tr>
						      <table>
						          <tr>
						              <td align="center" width="76">작성자 :
						              </td>
						             	<span>
						                  <b>
						                      <%=loginUser.getMemberName()%></b>
						              </span>               
						      </table>
						     <hr>
					        <div class="form-group">
					            <label>
					                <h6>문의 내용</h6>
					            </label>
					            <textarea cols="60" name="BoardContext" name="context" placeholder="내용을 입력해 주세요" rows="15" type="context"><%=b.getBoardContext()%></textarea>
					        </div>  
                             <div style="margin:0px 0px 0px 850px; margin-right:10px; ">
                                 <button class="btn btn-default onclick=" complet()"="complet()"">확인</button>
                                 <button class="btn btn-default onclick=" deleteBoard()"="deleteBoard()"">삭제하기</button>
                             </div>
                             <script>
                                 $(function complet() {
                                     $("#updateForm").attr("action", "<%=request.getContextPath()%>/updateQna.qna");
                                 });
                                 $(function deleteBoard() {
                                     $("#updateForm").attr("action", "<%=request.getContextPath()%>/deleteQna.qna");
                                 });
                             </script>
                         </div>
                         <hr></div>
                     </div>
                     <!-- Footer -->
                     <%@ include file = "../common/footer.jsp" %>
                     <!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
                 </body>
             </html>
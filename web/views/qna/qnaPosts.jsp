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
                        <thead>
                            <caption>
                                <h3>
                                    <span>
                                        <b>
                                            <%=b.getBoardTitle()%></b>
                                    </span>
                                </h3>
                            </caption>
                        </thead>
                        <table>
                            <tr>
                                <td align="center" width="76">
                                    <span>
                                        <b>
                                            <%=b.getMemberName()%></b>
                                    </span>
                                </td>
                                <td width="0"></td>
                                <hr>
                                    <td align="center" width="200">조회수 :
                                    </td>
                                    <td width="0">
                                        <span>
                                            <b>
                                                <%=b.getBoardCount()%></b>
                                        </span>
                                    </td>
                                    <td align="center" width="200">작성일 :
                                    </td>
                                    <td width="0">
                                        <span>
                                            <b>
                                                <%=b.getBoardDate()%></b>
                                        </span>
                                    </td>
                                </tr>
                            </table>
                            <hr>
                                <form>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1"></label>
                                        <textarea class="form-control" id="" placeholder="" rows="9"><%=b.getBoardContext()%></textarea>
                                    </div>
                                </form>
                               
				
                      <% if(loginUser !=null && loginUser.getMemberCategory() == 2) {%>
			  	<button class="btn btn-default" onclick="location.href='views/qna/qnaUpdate.jsp'">수정</button>
				<% } %>
                       <button class="btn btn-default" onclick="location.href='<%=request.getContextPath()%>/selectQnaList.qna'" style="margin:0px 0px 0px 1000px;" type="submit">목록으로</button>
                              
                      
                            </div>
                        </div>
                        <!-- Footer -->
                        <%@ include file = "../common/footer.jsp" %>
                        <!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
                    </body>
                </html>

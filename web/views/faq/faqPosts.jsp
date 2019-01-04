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
                        <caption>
                            <h2>
                                <span>
                                    <b>
                                        <%=b.getBoardTitle()%></b>
                                </span>
                            </td>
                        </h2>
                    </caption>
                </thead>
                <hr>
                    <tr height="1" bgcolor="#dddddd">
                        <td colspan="4" width="407"></td>
                    </tr>
                    <table>
                        <tr>
                            <td rowspan="2">
                                <img alt="" class="mx-auto rounded-circle" src="/dsm/img/team/1.jpg" style="width: 90px; height: 90px;"></td>
                                <td align="center" width="76">작성자 :
                                </td>
                                <td width="0">
                                    <span>
                                        <b>
                                            <%=b.getMemberName()%></b>
                                    </span>
                                </td>
                                <td align="center" width="76">조회수 :
                                </td>
                                <td width="0">
                                    <span><b><%=b.getBoardCount()%></b></span>
                                </td>
                                <td align="center" width="76">작성일 :
                                </td>
                                <td width="0">
                                    <span>
                                        <b>
                                            <%=b.getBoardDate()%></b>
                                    </span>
                                </td>
                            </tr>
                        </table>
                        <div class="form-group">
                            <hr>
                                <div class="form-group">
                                    <label>
                                        <h6>문의분류 :
                                        </h6>
                                    </label>
                                    <input checked="checked" disabled name="문의" type="radio" value="문의">문의.
                                        <input disabled name="신고" type="radio" value="신고">신고
                                        </div>
                                        <label>
                                            <h6>문의 내용</h6>
                                        </label>
                                        <textarea class="form-control" id="comment" placeholder="내용을 입력해 주세요" readonly readonly rows="10"><%=b.getBoardContext()%></textarea>
                                    </div>
                                    <hr>
                                        <div style="margin:0px 0px 0px 900px; margin-right:20px; ">
                                            <button class="btn btn-default" onclick="location.href='<%=request.getContextPath()%>/selectFaqList.faq'">목록</button>
                                            <% if(loginUser != null && loginUser.getMemberName().equals(b.getMemberName())){ %>
                                                <button class="btn btn-default" onclick="location.href='<%=request.getContextPath()%>/selectFaq.faq?num=<%=b.getBoardNo()%>'">수정</button>
                                            <% } %>
                                        </div>
                                        <form action="" method="post" name="">
                                            <font size="3" color="red">댓글 1</font>
                                            <br>
                                                <br>
                                                    <hr></form>
                                                    <table style="width: 600px;">
                                                        <tr>
                                                            <td rowspan="2">
                                                                <img alt="" class="mx-auto rounded-circle" src="/dsm/img/team/1.jpg" style="width: 90px; height: 90px;"></td>
                                                                <td width="80%" style="border-bottom: 1px solid #EAEAEA;">
                                                                    <span>18.12.02
                                                                                                14:02</span>
                                                                </span>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <div>
                                                                    <b>관리자</b>
                                                                </div>
                                                                <div>문의해주신 내용은 잘 봤습니다. 해당 문의내용은 저희 운영진이 운영방침에 맞게 조치를 취하겠습니다. 그럼 오늘도 즐거운 하루 되세요
                                                                </div>
                                                            </td>
                                                        </tr>
                                                    </table>
                                                    <hr>
                                                        <br>
                                                            <br></div>
                                                            <!-- Footer -->
                                                            <%@ include file = "../common/footer.jsp" %>
                                                            <!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
                                                        </body>
                                                    </html>
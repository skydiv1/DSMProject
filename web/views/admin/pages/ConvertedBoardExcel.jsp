
<%@page import="com.kh.w7.board.model.vo.Board"%>
<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>	<%--엑셀 파일 선언 --%>
<%@ page import="java.text.SimpleDateFormat" %>
<%

	//출력 데이타 받기
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");

    
	
	
	//파일명에 다운로드 날짜 붙여주기 위해 작성
	Date date=new Date();
	SimpleDateFormat dayformat=new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
	SimpleDateFormat hourformat=new SimpleDateFormat("hhmmss", Locale.KOREA);
	String day=dayformat.format(date);
	String hour=hourformat.format(date);
	String fileName="DSM홈페이지 게시판 내역_"+day+"_"+hour;
	
	//필수 선언 부분
	//.getBytes("KSC5601"),"8859_1") 을 통한 한글파일명 깨짐 방지
	response.setHeader("Content-Disposition", "attachment; filename="+new String((fileName).getBytes("KSC5601"),"8859_1")+".xls");
	response.setHeader("Content-Description", "JSP Generated Date");
%>

<!doctype html>
<html lang="ko" style="overflow:hidden">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title></title>
</head>

<body bgcolor="#ffffff" text="#000000" topmargin="0" leftmargin="0">

<table width="784" border="1" bordercolor="#A2AFCC" bordercolorlight="#ffffff" bordercolordark="#6C717D" cellspacing="0" cellpadding="0">
	<thead>
	   <tr align="center">
		<th scope="col" bgcolor="CDCDCD">게시판 코드</th>
		<th scope="col" bgcolor="CDCDCD">회원 코드</th>
		<th scope="col" bgcolor="CDCDCD">회원 아이디</th>
		<th scope="col" bgcolor="CDCDCD">게시판 제목</th>
		<th scope="col" bgcolor="CDCDCD">게시판 내용</th>
		<th scope="col" bgcolor="CDCDCD">등록일자</th>
		<th scope="col" bgcolor="CDCDCD">분류</th>
		<th scope="col" bgcolor="CDCDCD">조회수</th>
		<th scope="col" bgcolor="CDCDCD">삭제여부</th>
		<th scope="col" bgcolor="CDCDCD">답변여부</th>
	   </tr>
	</thead>
	<tbody>
	<% for(int i=0; i< list.size(); i++){ 	%>
		<tr>
			<td style="text-align:left;"><%= list.get(i).getBoardNo()%> </td>
			<td style="text-align:left; mso-number-format:\#\,\#\#0\;" ><%= list.get(i).getMemberCode()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberName()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardTitle()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardContext()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardDate()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardCategory()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardCount()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardDelete()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBoardQnaAnswerYn()%> </td>
			
		</tr>
	 <%}%>
	</tbody>
</table>

</body>

</html>
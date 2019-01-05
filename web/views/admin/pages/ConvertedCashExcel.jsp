<%@page import="com.kh.w7.admin.model.vo.Cash"%>
<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>	<%--엑셀 파일 선언 --%>
<%@ page import="java.text.SimpleDateFormat" %>
<%

	//출력 데이타 받기
	ArrayList<Cash> list = (ArrayList<Cash>)request.getAttribute("list");

    
	
	
	//파일명에 다운로드 날짜 붙여주기 위해 작성
	Date date=new Date();
	SimpleDateFormat dayformat=new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
	SimpleDateFormat hourformat=new SimpleDateFormat("hhmmss", Locale.KOREA);
	String day=dayformat.format(date);
	String hour=hourformat.format(date);
	String fileName="DSM홈페이지 캐시 내역_"+day+"_"+hour;
	
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
		<th scope="col" bgcolor="CDCDCD">캐시 코드</th>
		<th scope="col" bgcolor="CDCDCD">맴버 코드</th>
		<th scope="col" bgcolor="CDCDCD">회원 아이디</th>
		<th scope="col" bgcolor="CDCDCD">회원 보유 캐시</th>
		<th scope="col" bgcolor="CDCDCD">변동 카테고리</th>
		<th scope="col" bgcolor="CDCDCD">거래 번호</th>
		<th scope="col" bgcolor="CDCDCD">거래 금액</th>
		<th scope="col" bgcolor="CDCDCD">충전 번호</th>
		<th scope="col" bgcolor="CDCDCD">충전 금액</th>
		<th scope="col" bgcolor="CDCDCD">환급 번호</th>
		<th scope="col" bgcolor="CDCDCD">환급 금액</th>
	   </tr>
	</thead>
	<tbody>
	<% for(int i=0; i< list.size(); i++){ 	%>
		<tr>
			<td style="text-align:left;"><%= list.get(i).getMemberCashCode()%> </td>
			<td style="text-align:left; mso-number-format:\#\,\#\#0\;" ><%= list.get(i).getMemberCode()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberId()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberCashNowCash()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberCashCategory()%> </td>
			<td style="text-align:left;"><%= list.get(i).getDealNo()%> </td>
			<td style="text-align:left;"><%= list.get(i).getDealMoney()%> </td>
			<td style="text-align:left;"><%= list.get(i).getPayNo()%> </td>
			<td style="text-align:left;"><%= list.get(i).getPayMoney()%> </td>
			<td style="text-align:left;"><%= list.get(i).getRefundNo()%> </td>
			<td style="text-align:left;"><%= list.get(i).getRefundMoney()%> </td>
			
		</tr>
	 <%}%>
	</tbody>
</table>

</body>

</html>
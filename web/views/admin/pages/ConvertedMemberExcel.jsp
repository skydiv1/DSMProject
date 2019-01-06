
<%@page import="com.kh.w7.member.model.vo.Member"%>
<%@ page contentType="application/vnd.ms-excel; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>	<%--엑셀 파일 선언 --%>
<%@ page import="java.text.SimpleDateFormat" %>
<%

	//출력 데이타 받기
	ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

    
	
	
	//파일명에 다운로드 날짜 붙여주기 위해 작성
	Date date=new Date();
	SimpleDateFormat dayformat=new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
	SimpleDateFormat hourformat=new SimpleDateFormat("hhmmss", Locale.KOREA);
	String day=dayformat.format(date);
	String hour=hourformat.format(date);
	String fileName="DSM홈페이지 회원 내역_"+day+"_"+hour;
	
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
		<th scope="col" bgcolor="CDCDCD">회원 코드</th>
		<th scope="col" bgcolor="CDCDCD">회원 아이디</th>
		<th scope="col" bgcolor="CDCDCD">회원 이름</th>
		<th scope="col" bgcolor="CDCDCD">회원 이메일</th>
		<th scope="col" bgcolor="CDCDCD">휴대폰번호</th>
		<th scope="col" bgcolor="CDCDCD">회원 분류</th>
		<th scope="col" bgcolor="CDCDCD">회원 상태</th>
		<th scope="col" bgcolor="CDCDCD">경고 횟수</th>
		<th scope="col" bgcolor="CDCDCD">판매자 자기소개</th>
		<th scope="col" bgcolor="CDCDCD">판매자 평점</th>
		<th scope="col" bgcolor="CDCDCD">판매자 은행명</th>
		<th scope="col" bgcolor="CDCDCD">판매자 계좌번호</th>
		<th scope="col" bgcolor="CDCDCD">경력사항</th>
		<th scope="col" bgcolor="CDCDCD">판매자인증여부</th>
		<th scope="col" bgcolor="CDCDCD">인증사진 경로</th>
	   </tr>
	</thead>
	<tbody>
	<% for(int i=0; i< list.size(); i++){ 	%>
		<tr>
			<td style="text-align:left;"><%= list.get(i).getMemberCode()%> </td>
			<td style="text-align:left; mso-number-format:\#\,\#\#0\;" ><%= list.get(i).getMemberId()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberName()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberEmail()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberPhone()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberCategory()%> </td>
			<td style="text-align:left;"><%= list.get(i).getMemberStatus()%> </td>
			<td style="text-align:left;"><%= list.get(i).getBlackCount()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerIntroduction()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerGrade()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerBank()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerAccount()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerCareer()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerCertcheck()%> </td>
			<td style="text-align:left;"><%= list.get(i).getSellerImgPath()%> </td>
			
		</tr>
	 <%}%>
	</tbody>
</table>

</body>

</html>
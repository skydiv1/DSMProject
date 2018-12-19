<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!-- 네비게이션 바 -->
<%-- 		<%@ include file = "../common/navi.jsp" %> --%>
		<%@ include file = "../common/naviLogin.jsp" %>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
			<div class="container">
				<thead>
        <caption> <h3>상품 등록시키는 방법</h3> </caption>
        </thead>
         <table>
    <tr>
      <td rowspan="2"><img class="mx-auto rounded-circle"
                     src="/dsm/img/team/1.jpg" alt=""
                     style="width: 90px; height: 90px;"></td>
      <td align="center" width="76"><b>관리자</b></td>     
      <td width="0"></td>  
      
      <td align="center" width="200">조회수 : </td>      
      <td width="0"><b>213</b></td>	
      
      <td align="center" width="200">작성일 : </td>      
      <td width="0"><b>18.11.29 16:25</b></td>
     </tr>
     </table>
        <hr>
			<form>
			  
			  <div class="form-group">
			    <label for="exampleInputPassword1"></label>
			    <textarea class="form-control" rows="9" id="" placeholder="">상품을 등록하는 방법은 서비스등록 버튼을 클릭하여 서비스 등록목 서비스 등록버튼을 클릭후
양식에 맞게 상품 글을 작성한 후 등록을 하면 상품이 등록됩니다.</textarea>
			  </div>
			
				</form>
			  <button type="submit" class="btn btn-default"  style="margin:0px 0px 0px 1000px;" onclick="location.href='/dsm/views/faq/FAQ.jsp'">목록으로</button>
			  
				
			</div>	
	</div>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
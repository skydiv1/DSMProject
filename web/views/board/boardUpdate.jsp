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
	<%@ include file="../common/menubar.jsp"%>
<!-- 네비게이션 바 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<br><br>	
<div class="container">
			<thead>
        <div class="form-group">
			    <label ><h3>제목 </h3></label>
			    <input type="text" class="form-control"  placeholder="바람서리 불변함은 우리 기상일세">
			  </div>
			  <hr>
			 <div class="input-group">
			  <div class="custom-file">
			    <input type="file" class="custom-file-input" id="" >
			    <label class="custom-file-label" >파일을 선택해주세요</label>
			  </div>
			  <div class="input-group-append">
			    <button class="btn btn-outline-secondary" type="button" id="inputGroupFileAddon04">Button</button>
			  </div>
			</div>
        </thead>
        
	 <tr height="1" bgcolor="#dddddd"><td colspan="4" width="407"></td></tr>
	
   	<hr>
     <div class="form-group">
			   <div class="form-group"><h3>내용</h3>
			   <textarea class="form-control"  rows="10"  id="comment" placeholder="내용을 입력해 주세요">
말이다 청춘! 너의 두손을 가슴에 대고 물방아 같은 심장의 고동을 들어 보라 청춘의 피는 끓는다 끓는 피에 뛰노는 심장은 거선의 기관과 같이 힘있다 이것이다 인류의 역사를 꾸며 내려온 동력은 바로 이것이다 이성은 투명하되 얼음과 같으며 지혜는 날카로우나 갑 속에 든 칼이다 청춘의 끓는 피가 아니더면 인간이 얼마나 쓸쓸하랴? 얼음에 싸인 만물은 얼음이 있을 뿐이다 그들에게 생명을 불어 넣는 것은 따뜻한 봄바람이다 풀밭에 속잎나고 가지에 싹이 트고 꽃 피고 새 우는 봄날의 천지는 얼마나 기쁘며 얼마나 아름다우냐? 이것을 얼음 속에서 불러 내는 것이 따뜻한 봄바람이다 인생에 따뜻한 봄바람을 불어

끓는 피다 청춘의 피가 뜨거운지라 인간의 동산에는 사랑의 풀이 돋고 이상의 꽃이 피고 희망의 놀이 뜨고 열락의 새가 운다사랑의 풀이 없으면 인간은 사막이다 오아이스도 없는 사막이다 보이는 끝까지 찾아다녀도 목숨이 있는 때까지 방황하여도 보이는 것은 거친 모래뿐일 것이다 이상의 꽃이 없으면 쓸쓸한 인간에 남는 것은 영락과 부패 뿐이다 낙원을 장식하는 천자만홍이 어디 있으며 인생을 풍부하게 하는 온갖 과실이 어디 있으랴? 이상! 우리의 청춘이 가장 많이 품고 있는 이상! 이것이야말로 무한한 가치를 가진 것이다 사람은 크고 작고 간에 이상이 있음으로써 용감하고 굳세게 살 수 있는 것이다
			   </textarea>
			  </div>
      
			<div style="margin:0px 0px 0px 870px; margin-right:10px; ">	
			  <button class="btn btn-default"  onclick="location.href='./boardPosts.jsp'">취소</button>
			  <button class="btn btn-default"  onclick="location.href='./boardPosts.jsp'">수정</button>
			  <button class="btn btn-default"  >삭제</button>
			 </div> 
				<hr>
			</form>
			</div>	
			</table>
			
	
		<br>
		<br>
		<br>
<!-- Footer -->
		<%@ include file = "../common/footer.jsp" %>
<!-- footer 끝 /////////////////////////////////////////////////////////////////////////////////////////////////////////// -->
</body>
</html>
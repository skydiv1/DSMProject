package com.kh.w7.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.w7.common.PageInfo;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.mypage.model.service.MypageService;
import com.kh.w7.mypage.model.vo.MyPage;

@WebServlet("/selectList.Acc")
public class AcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AcceptServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();

		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int loginCode = loginUser.getMemberCode();
		
		
				//페이징처리 
				int currentPage;	
				int limit;	
				int maxPage;	
				int startPage;	
				int endPage;	
				
				//현재 페이지 처리
				currentPage = 1;
				
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				//한 페이지에 보여질 목록 갯수
				limit = 3;
				
				MypageService ms = new MypageService();
				//전체 게시글 수 조회
				int listCount = ms.getAccListCount(loginCode);
				//총 페이지 수 계산
				maxPage = listCount / limit;
				if(listCount%limit>0) {
					maxPage++;
				}
				
				//현재 페이지에 보여줄 시작페이지 수
				startPage = ((currentPage-1) / limit)* limit + 1;
			
				//목록 아래쪽에 보여질 마지막 페이지 수
				endPage = startPage +limit - 1;
				
				if(maxPage < endPage) {
					endPage = maxPage;
				}
				
				PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
			
				
				ArrayList<MyPage>acceptlist = new MypageService().selectAcceptList(loginCode,currentPage, limit);
		
				HashMap<String, Object> result = new HashMap<>();
				result.put("aclist", acceptlist);
				result.put("currentPage"	,currentPage);
				result.put("maxPage"		,maxPage);
				result.put("startPage"		,startPage);
				result.put("endPage"		,endPage);
				
				
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				new Gson().toJson(result, response.getWriter());

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

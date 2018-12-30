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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.kh.w7.common.PageInfo;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.mypage.model.service.MypageService;
import com.kh.w7.mypage.model.vo.MyPage;

@WebServlet("/selectList.ap")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		HttpSession session = request.getSession();

		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int loginCode = loginUser.getMemberCode();
		
		//--------------- 페이징처리 추가 -------------------
		int currentPage;	//현재 페이지를 표시할 변수
		int limit;			//한 페이지에 게시글이 몇 개가 보여질 것인지 표시
		int maxPage;		//전체 페이지에서 가장 마지막 페이지
		int startPage;		//한번에 표시될 페이지가 시작할 페이지
		int endPage;		//한번에 표시될 페이지가 끝나는 페이지
		
		//현재 페이지 처리
		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//한 페이지에 보여질 목록 갯수
		limit = 3;
		
		MypageService ms = new MypageService();
		//전체 게시글 수 조회
		int listCount = ms.getListCount(loginCode);
		System.out.println("&&&&&&&&&&&&&" + listCount);
		//총 페이지 수 계산
		//예를 들어, 목록 수가 123개면 페이지수는 13페이지가 필요하다.
		maxPage = listCount / limit;
		if(listCount%limit>0) {
			maxPage++;
		}
		
		//현재 페이지에 보여줄 시작페이지 수
		//1, 11, 21, 31,...
		startPage = ((currentPage-1) / limit)* limit + 1;
	
		//목록 아래쪽에 보여질 마지막 페이지 수(10, 20, 30, ...)
		endPage = startPage +limit - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<MyPage>list = new MypageService().selectList(loginCode, currentPage, limit);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("aplist", list);
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

package com.kh.w7.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.mypage.model.service.MypageService;
import com.kh.w7.mypage.model.vo.MyPage;

@WebServlet("/selectList.wait")
public class WaitingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public WaitingServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		Member loginUser = (Member)session.getAttribute("loginUser");
		
		int loginCode = loginUser.getMemberCode();
		
		ArrayList<MyPage>waitlist = new MypageService().selectWaitingList(loginCode);
		System.out.println("대기자목록 list servlet:"+waitlist);
				
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(waitlist, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

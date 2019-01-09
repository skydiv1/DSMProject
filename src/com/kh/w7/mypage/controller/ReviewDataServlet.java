package com.kh.w7.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.mypage.model.service.MypageService;

@WebServlet("/reviewstar.seller")
public class ReviewDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReviewDataServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		Member loginUser = (Member)session.getAttribute("loginUser");
		
		
		int loginCode = loginUser.getMemberCode();
		int rstar = Integer.parseInt(request.getParameter("rstar"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		String rtext = request.getParameter("rtext");
		
		
		int result = new MypageService().ReviewUpdate(loginCode,rstar,rtext,productNo);
		
		System.out.println("황민규뻐킹맨");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

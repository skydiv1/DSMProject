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

@WebServlet("/cancelupdate.consumer")
public class CancelUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancelUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Member loginUser = (Member)session.getAttribute("loginUser");
		int loginCode = loginUser.getMemberCode();
		
		int no = Integer.parseInt(request.getParameter("no"));
		String textContent = request.getParameter("textContent");
	
		int result = new MypageService().cancelUpdate(loginCode,no,textContent);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

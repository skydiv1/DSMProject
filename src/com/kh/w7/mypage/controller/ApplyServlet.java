package com.kh.w7.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.mypage.model.service.MypageService;
import com.kh.w7.mypage.model.vo.MyPage;

@WebServlet("/selectList.ap")
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApplyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//HttpSession session = request.getSession();

		/*Member loginUser = (Member)session.getAttribute("loginUser");
		int loginCode = loginUser.getMember_code();*/
		
		int loginCode = 2;
		
		ArrayList<MyPage>list = new MypageService().selectList(loginCode);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
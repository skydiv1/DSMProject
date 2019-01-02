package com.kh.w7.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.mypage.model.service.MypageService;

@WebServlet("/canceldelete.consumer")
public class CancelDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancelDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dealnum = Integer.parseInt(request.getParameter("dealnum"));
	
		int result = new MypageService().cancelDelete(dealnum);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(result, response.getWriter());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

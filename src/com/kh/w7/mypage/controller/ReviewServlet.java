package com.kh.w7.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.mypage.model.service.MypageService;


@WebServlet("/review.seller")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int dealnum = Integer.parseInt(request.getParameter("dealnum"));
	
		ArrayList<HashMap<String, Object>>reviewlist = new MypageService().reviewSeller(dealnum);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(reviewlist, response.getWriter());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

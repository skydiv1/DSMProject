package com.kh.w7.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.admin.model.service.AdminService;

/**
 * Servlet implementation class WarningCountPlusMinusServlet
 */
@WebServlet("/plusMinus")
public class WarningCountPlusMinusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WarningCountPlusMinusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String what = request.getParameter("what");
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		
		System.out.println("what : " + what);
		System.out.println("memberCode : " + memberCode);
		
		
		int result = new AdminService().countPlusMinus(what, memberCode);
		
		
		System.out.println("result : " + result);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(what, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

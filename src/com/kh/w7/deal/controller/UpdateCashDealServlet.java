package com.kh.w7.deal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.deal.model.service.DealService;

/**
 * Servlet implementation class UpdateCashDealServlet
 */
@WebServlet("/updateDealCash")
public class UpdateCashDealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCashDealServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int customerCode = Integer.parseInt(request.getParameter("customerCode"));
		int sellerCode = Integer.parseInt(request.getParameter("sellerCode"));
		int dealNo = Integer.parseInt(request.getParameter("dealNo"));
		int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
		int nowCash = Integer.parseInt(request.getParameter("nowCash"));
		
		/*
		 * 정상적으로 인자전달 완료
		 * System.out.println("customerCode : " + customerCode);
		System.out.println("sellerCode : " + sellerCode);
		System.out.println("dealNo : " + dealNo);
		System.out.println("totalPrice : " + totalPrice);*/
		
		int result = new DealService().updateCashDeal(customerCode, sellerCode, dealNo, totalPrice, nowCash);
		
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(result, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

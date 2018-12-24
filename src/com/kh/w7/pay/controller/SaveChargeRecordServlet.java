package com.kh.w7.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.pay.model.service.PayService;
import com.kh.w7.pay.model.vo.Pay;

/**
 * Servlet implementation class SaveChargeRecordServlet
 */
@WebServlet("/saveCharge.pa")
public class SaveChargeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveChargeRecordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int buyer_code = Integer.parseInt(request.getParameter("buyer_code"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		//String buyer_name = request.getParameter("buyer_name");
		
		/*
		// 인자 전달 성공
		System.out.println("buyer_code : " + buyer_code);
		System.out.println("buyer_name : " + buyer_name);
		System.out.println("amount : " + amount);*/
		
		Pay p = new Pay();
		p.setMember_code(buyer_code);
		p.setPay_price(amount);
		
		int result = new PayService().insertPay(p);
		
		String page = "";
		
		
		
		if(result > 0) {
			page = "index.jsp";
			response.sendRedirect(page);
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "결제정보 저장 실패!");
			request.getRequestDispatcher(page).forward(request, response);
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

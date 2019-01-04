package com.kh.w7.product.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.deal.model.vo.Deal;
import com.kh.w7.deal.model.vo.DealList;
import com.kh.w7.product.model.service.DealService;

/**
 * Servlet implementation class SelectDealInfoServlet
 */
@WebServlet("/insertDealInfo.pr")
public class InsertDealInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDealInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		System.out.println("상품 번호(서블릿) : "+productNo);
		int customerCode = Integer.parseInt(request.getParameter("customerCode"));
		System.out.println("고객 번호(서블릿) : "+customerCode);
		int sellerCode = Integer.parseInt(request.getParameter("sellerCode"));
		System.out.println("판매자 번호(서블릿) : "+sellerCode);
		int dealPrice = Integer.parseInt(request.getParameter("dealPrice"));
		System.out.println("상품 가격(서블릿) : "+dealPrice);
		String requestText = request.getParameter("requestText");
		System.out.println("신청 내용(서블릿) : "+requestText);
		int additionalOption = Integer.parseInt(request.getParameter("additionalOption"));
		System.out.println("총 상품 가격(서블릿) : "+additionalOption);
//		int dealOptionPrice = Integer.parseInt(request.getParameter("dealOptionPrice"));
//		System.out.println("상품 번호(서블릿) : "+dealOptionPrice);
		
		Deal deal = new Deal();
		deal.setProductNo(productNo);
		deal.setCustomerCode(customerCode);
		deal.setSellerCode(sellerCode);
		deal.setMainProductPrice(dealPrice);
		//deal.setSubProductPrice(dealOptionPrice);
				
		DealList dealList = new DealList();
		dealList.setAddmessage1(requestText);
		
		int result = new DealService().insertDeal(deal, dealList);
		System.out.println("deal(서블릿) : "+deal);
		System.out.println("dealList(서블릿) : "+dealList);
		
		String page = "";
		if(result>0) {
			page = "views/member/ConsumerMyPage.jsp";
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "실패!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

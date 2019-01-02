package com.kh.w7.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectDealInfoServlet
 */
@WebServlet("/selectDealInfo.pr")
public class SelectDealInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDealInfoServlet() {
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
		System.out.println("소비자코드(서블릿) : "+customerCode);
		int sellerCode = Integer.parseInt(request.getParameter("sellerCode"));
		System.out.println("판매자코드(서블릿) : "+sellerCode);
		int dealPrice = Integer.parseInt(request.getParameter("dealPrice"));
		System.out.println("기본 상품금액(서블릿) : "+dealPrice);
		int dealOptionPrice = Integer.parseInt(request.getParameter("dealOptionPrice"));
		System.out.println("기본+추가 상품금액(서블릿) : "+dealOptionPrice);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

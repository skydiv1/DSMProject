package com.kh.w7.deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.deal.model.service.DealService;
import com.kh.w7.deal.model.vo.Deal;

/**
 * Servlet implementation class SelectOneProductServlet
 */
@WebServlet("/selectOneProduct.de")
public class SelectOneProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
		/*
		 * 제대로 넘어옴
		 * System.out.println("memberCode : " + memberCode);
		System.out.println("productNo : " + productNo);
		*/
		
		ArrayList<Deal> list = new ArrayList<Deal>();
		Deal d = new Deal();
		
		list = new DealService().selectOneProduct(memberCode, productNo);
		
		System.out.println("serveltList : "+list);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

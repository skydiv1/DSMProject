package com.kh.w7.deal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.w7.deal.model.service.DealService;
import com.kh.w7.deal.model.vo.Deal;
import com.kh.w7.member.model.vo.Member;

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
		
		
			
		  HttpSession session = request.getSession();
	      Member loginUser = (Member)session.getAttribute("loginUser");
	      
	      int memberCode = loginUser.getMemberCode();
     
     
	      int productno = Integer.parseInt(request.getParameter("productno")); //6번 상품
	      
	      System.out.println("memberCode : " + memberCode);
	      System.out.println("productNo : " + productno);
	      
	      
	      ArrayList<Deal> list = new ArrayList<Deal>();
	      Deal d = new Deal();
	
	      list = new DealService().selectOneProduct(memberCode, productno);
	      
	      session.setAttribute("payList", list);
	      
	      System.out.println("serveltList : "+list);
			
	      response.setContentType("application/json");
	      response.setCharacterEncoding("UTF-8");
	      new Gson().toJson(list, response.getWriter());

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
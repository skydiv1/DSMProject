package com.kh.w7.product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.product.model.service.ProductService;

/**
 * Servlet implementation class RequestPopUpServlet
 */
@WebServlet("/requestPopUp.pr")
public class RequestPopUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPopUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestText = request.getParameter("requestText");
		System.out.println("신청 메시지(서블릿) : "+requestText);
		
		/*int result = new ProductService().insertRequestForm(dealList객체);
		
		String page="";
		if(result>0) {
			page="views/member/ConsumerMyPage.jsp";
		}else {							
			page="views/common/errorPage.jsp";
			request.setAttribute("msg", "상품 목록 조회 실패!");		
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

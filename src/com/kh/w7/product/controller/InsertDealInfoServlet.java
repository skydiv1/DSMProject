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
import com.kh.w7.product.model.service.DealService;

/**
 * Servlet implementation class SelectDealInfoServlet
 */
@WebServlet("/selectDealInfo.pr")
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
		int productNum = Integer.parseInt(request.getParameter("productNum"));
		System.out.println("상품 번호(서블릿) : "+productNum);
		
		Deal deal = new Deal();
		deal.setProductNo(productNum);
		//deal.setSubProductPrice(dealOptionPrice);
		System.out.println("deal : "+deal);
		
		int result = new DealService().insertDeal(deal);
		
		String page = "";
		if(result>0) {
			PrintWriter out = response.getWriter();
			out.println("<html><head></head>");
			out.println("<body>");
			out.println("</body></html>");
			out.close();
			
			//page = "views/common/AskPopUp.jsp";
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

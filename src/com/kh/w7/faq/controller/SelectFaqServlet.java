package com.kh.w7.faq.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.board.model.service.BoardService;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.faq.model.service.FaqService;

/**
 * Servlet implementation class SelectBoardServlet
 */
@WebServlet("/selectFaq.faq")
public class SelectFaqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFaqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		Board b = new FaqService().selectOne(num);
		
		String page="";
		if(b != null) {
			page = "views/faq/faqUpdate.jsp";
			request.setAttribute("b", b);		
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "수정을 할 수 없습니다.");
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

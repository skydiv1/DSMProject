package com.kh.w7.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.board.model.vo.Board;
import com.kh.w7.common.PageInfo;
import com.kh.w7.faq.model.service.FaqService;
import com.kh.w7.qna.model.service.QnaService;

/**
 * Servlet implementation class SelectQnaListServlet
 */
@WebServlet("/selectQnaList.qna")
public class SelectQnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectQnaListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int currentPage;	
		int limit;			
		int maxPage;		
		int startPage;		
		int endPage;		
		

		currentPage = 1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		

		limit = 10;
		
		QnaService qna = new QnaService();

		int listCount = qna.getListCount();
		maxPage = (int)((double)listCount / limit + 0.9);
		
		startPage = (((int)((double)currentPage / limit + 0.9)) - 1) * limit + 1;
		

		endPage = startPage + 10 - 1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
	
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		
		ArrayList<Board> list = new QnaService().selectList(currentPage, limit);
		      
		System.out.println(list);
		
		
		String page = "";
		if(list != null) {
			request.setAttribute("list", list);
			request.setAttribute("pi", pi);
			page = "views/qna/QNA.jsp";
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

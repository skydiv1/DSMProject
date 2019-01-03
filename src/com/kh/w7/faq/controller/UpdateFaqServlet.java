package com.kh.w7.faq.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.board.model.service.BoardService;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.faq.model.service.FaqService;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateFaq.faq")
public class UpdateFaqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFaqServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int BoardNo = Integer.parseInt(request.getParameter("BoardNo"));
		String title = request.getParameter("Boardtitle");
		String context = request.getParameter("BoardContext");

		
		System.out.println(BoardNo);
		System.out.println(title);
		System.out.println(context);

		Board b = new Board();
		b.setBoardTitle(title);
		b.setBoardContext(context);
		b.setBoardNo(BoardNo);		

	
		
		int result = new FaqService().updateFaq(b);
		
		String page = "";
		if(result > 0) {
			page = "views/dsm/selectOne.faq?num="+BoardNo;
			response.sendRedirect("/dsm/selectOne.faq?num=" + BoardNo);
		}else {
			request.setAttribute("msg", "수정안됨");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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

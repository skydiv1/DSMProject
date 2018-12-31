package com.kh.w7.board.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.w7.board.model.service.BoardService;
import com.kh.w7.board.model.vo.Board;
import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet("/insert.bo")
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String uno = request.getParameter("memberCode");
		String context = request.getParameter("context");
		
		/*java.sql.Date day = null;*/
		
		
		
		Board b = new Board();
		b.setMemberName(uno);
		b.setBoardTitle(title);
		b.setBoardContext(context);
		
		int result = new BoardService().insertBoard(b);
		
		System.out.println(uno);
		System.out.println(title);
		System.out.println(context);
		
		
		String page="";
	
		if(result>0) {
			page = "/dsm/selectList.bo";
			/*response.sendRedirect(request.getContextPath()+"/selectList.bo");*/
			response.sendRedirect(page);
			
		}else {
			request.setAttribute("msg", "실패");
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








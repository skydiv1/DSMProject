package com.kh.w7.board.controller;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.board.model.service.BoardService;
import com.kh.w7.board.model.vo.Board;

/**
 * Servlet implementation class UpdateBoardServlet
 */
@WebServlet("/updateBoard.bo")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int boardNo = Integer.parseInt(request.getParameter("BoardNo"));
		String title = request.getParameter("Boardtitle");
		String content = request.getParameter("BoardContext");

		
		System.out.println(boardNo);
		System.out.println(title);
		System.out.println(content);

		Board b = new Board();
		b.setBoardTitle(title);
		b.setBoardContext(content);
		b.setBoardNo(boardNo);		

	
		
		int result = new BoardService().updateBoard(b);
		
		String page = "";
		if(result > 0) {
			page = "views/dsm/selectOne.bo?num="+boardNo;
			response.sendRedirect("/dsm/selectOne.bo?num=" + boardNo);
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

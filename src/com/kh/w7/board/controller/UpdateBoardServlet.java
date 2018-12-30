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
		String title = request.getParameter("Boardtitle");
		String content = request.getParameter("BoardContext");
		int boardNo = Integer.parseInt(request.getParameter("BoardNo"));
		String date = request.getParameter("Boarddate");
		
		/*System.out.println(title);
		System.out.println(content);
		System.out.println(nno);
		System.out.println(date);*/
		
		java.sql.Date day = null;
		
		if(date != "") {
			String[] drr = date.split("-");
			int[] irr = new int[drr.length];
			for(int i = 0; i < irr.length; i++) {
				irr[i] = Integer.parseInt(drr[i]);
			}
			
			day = new java.sql.Date(new GregorianCalendar(irr[0], irr[1] - 1, irr[2]).getTimeInMillis());
		}else {
			day = new java.sql.Date(new GregorianCalendar().getTimeInMillis());
		}
		
		Board b = new Board();
		b.setBoardTitle(title);
		b.setBoardContext(content);
		b.setBoardDate(day);
		b.setBoardNo(boardNo);		
	
		
		int result = new BoardService().updateBoard(b);
		
		String page = "";
		if(result > 0) {
			response.sendRedirect("/jsp/selectOne.no?num=" + boardNo);
		}else {
			request.setAttribute("msg", "공지사항 수정 실패!");
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

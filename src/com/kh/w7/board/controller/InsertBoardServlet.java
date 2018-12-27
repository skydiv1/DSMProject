package com.kh.w7.board.controller;

import java.io.IOException;

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
		int membercode = Integer.parseInt(request.getParameter("membercode"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		String writer = String.valueOf(((Member)(request.getSession().getAttribute("loginUser"))).getMemberCode());
		
		Board b = new Board();
		
		b.setBoardTitle(title);
		b.setBoardContext(content);
		
		int result = new BoardService().insertBoard(b);
		
		String page = "";
		if(result > 0) {
			response.sendRedirect(request.getContextPath() + "/selectList.bo");
		}else {
			request.setAttribute("msg", "寃뚯떆�뙋 �옉�꽦 �떎�뙣");
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








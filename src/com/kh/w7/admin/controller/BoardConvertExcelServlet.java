package com.kh.w7.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.admin.model.service.AdminService;
import com.kh.w7.admin.model.vo.ProductExcel;
import com.kh.w7.board.model.vo.Board;

/**
 * Servlet implementation class BoardConvertExcelServlet
 */
@WebServlet("/boardConvertExcel")
public class BoardConvertExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardConvertExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Board> list = new ArrayList<Board>();
		list = new AdminService().BoardConvertExcel();
		
		String page = "";
		if(list != null) {
			page = "views/admin/pages/ConvertedBoardExcel.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시판 테이블 엑셀 전환 실패!");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

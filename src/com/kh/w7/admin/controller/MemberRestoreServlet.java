package com.kh.w7.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.admin.model.service.AdminService;

/**
 * Servlet implementation class MemberRestoreServlet
 */
@WebServlet("/memberRestore")
public class MemberRestoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRestoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		
		int result = new AdminService().memberRestoreF(memberCode);
		
		String page = "";
		if(result>0) {
			page = "/dsm/selectAllMember";
			response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "일반 회원 복구 실패!");
			request.getRequestDispatcher(page).forward(request, response);
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

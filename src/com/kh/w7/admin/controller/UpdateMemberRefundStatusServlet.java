package com.kh.w7.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.admin.model.service.AdminService;

/**
 * Servlet implementation class UpdateMemberRefundStatusServlet
 */
@WebServlet("/updateRefundStatus")
public class UpdateMemberRefundStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberRefundStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int refundNo = Integer.parseInt(request.getParameter("refundNo"));
		
		System.out.println("refundNo : " + refundNo);
		
		int result = new AdminService().updateRefundStatus(refundNo);
		
		String page = "";
		if(result > 0) {
			page = "/dsm/selectAllRefund";
			response.sendRedirect(page);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 환급상태 변경 실패!");
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

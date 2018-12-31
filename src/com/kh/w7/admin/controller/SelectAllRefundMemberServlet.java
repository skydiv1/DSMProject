package com.kh.w7.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.admin.model.service.AdminService;
import com.kh.w7.refund.model.vo.Refund;

/**
 * Servlet implementation class SelectAllRefundMemberServlet
 */
@WebServlet("/selectAllRefund")
public class SelectAllRefundMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllRefundMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Refund r = new Refund();
		ArrayList<Refund> list = new ArrayList<Refund>();
		
		list = new AdminService().SelectAllRefundMember();
		
		System.out.println(list);
		
		String page = "";
		if(list != null) {
			page = "views/admin/pages/adminCash.jsp";
			request.setAttribute("list", list);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "환급 신청자 목록 불러오기 실패!");
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

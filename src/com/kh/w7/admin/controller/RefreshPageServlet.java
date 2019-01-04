package com.kh.w7.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.admin.model.service.AdminService;
import com.kh.w7.admin.model.vo.Admin;

/**
 * Servlet implementation class RefreshPageServlet
 */
@WebServlet("/refreshPage")
public class RefreshPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클릭시 프로시저가 동작하며 페이지가 갱신, 각종 admin정보를 반환하도록 함
		
		
		
		Admin ad = new Admin();
		ad = new AdminService().refreshPage();
		
		String page = "";
		
		if(ad != null) {
			page = "views/admin/pages/adminMain.jsp";
			request.setAttribute("ad", ad);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "관리자 메인페이지 갱신 실패!");
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

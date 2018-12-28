package com.kh.w7.pay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.pay.model.service.PayService;

/**
 * Servlet implementation class SelectChargeUserInfoServlet
 */
@WebServlet("/selectUser.pa")
public class SelectChargeUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectChargeUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		
		/*정상적으로 인자값이 전달됨
		 * System.out.println("memberCode : " + memberCode);*/
		
		int nowCash = new PayService().selectMemberNowCash(memberCode);
		
		String page = "";
		if(nowCash > 0) {
			page = "views/cash/cacheCharge.jsp";
			request.setAttribute("nowCash", nowCash);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 현재 캐시량 조회에 실패했습니다!");
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

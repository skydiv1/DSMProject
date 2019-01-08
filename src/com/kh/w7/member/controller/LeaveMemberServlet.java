package com.kh.w7.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.service.MemberService;

/**
 * Servlet implementation class LeaveMemberServlet
 */
@WebServlet("/leaveMember.me")
public class LeaveMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("서블릿&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7");
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		
		//String memberCode = request.getParameter("memberCode");
		System.out.println("memberCode: " + memberCode);
		
		int result = new MemberService().leaveMember(memberCode);
		System.out.println("result : " + result);
		if (result > 0) {
			request.setAttribute("msg", "탈퇴에 성공하셨습니다.");
				
			
			response.sendRedirect("/dsm/logout.me");
		} else {// 다 했을때 팝업시도
			request.setAttribute("msg", "정보수정 실패!");
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

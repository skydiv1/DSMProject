package com.kh.w7.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet("/find_pwd.me")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String memberName = request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberEmail = request.getParameter("memberEmail");
		String memberPwd = request.getParameter("memberPwd");
		String randomCode = request.getParameter("randomCode");
		System.out.println(memberName);
		System.out.println(memberId);
		System.out.println(memberEmail);
		System.out.println(memberPwd);
		System.out.println(randomCode);
		
		System.out.println("서블릿0000");

		int result = new MemberService().findpwd( memberName, memberId, memberEmail, randomCode);

		if (result > 0) {

			request.setAttribute("randomCode", randomCode);

			request.getRequestDispatcher("/SendIdpw.me").forward(request, response);

			response.getWriter().print("YES");
		 System.out.println("서블릿ifㅇㅇㅇ");

		} else {
			response.getWriter().print("NO");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

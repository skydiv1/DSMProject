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
 * Servlet implementation class IdPwFindServlet
 */
@WebServlet("/find_id.me")
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindIdServlet() {
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
		String memberEmail = request.getParameter("memberEmail");

		String memberId = new MemberService().find(memberName, memberEmail);

		if (memberId != "") {
			request.setAttribute("memberId", memberId);

			request.getRequestDispatcher("/SendIdpw.me").forward(request, response);

			response.getWriter().print("success");

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

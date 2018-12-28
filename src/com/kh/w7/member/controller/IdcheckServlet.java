package com.kh.w7.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.dao.MemberDao;
import com.kh.w7.member.model.service.MemberService;

/**
 * Servlet implementation class IdcheckServlet
 */
@WebServlet("/idCheck.me")
public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IdcheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		int result = new MemberService().idCheck(memberId);
		System.out.println(result);
		if(result>0) {
			response.getWriter().print("success");
		}else {
			response.getWriter().print("fail");
		}
		/*PrintWriter out = response.getWriter();

		if (result > 0) {
			out.append("fail");
		} else {
			out.append("success");
		}
		out.flush();
		out.close();*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html;charset=UTF-8");
		// String memberId= request.getParameter("memberId");
		// response.getWriter().write(new MemberDao().idCheck(memberId)+"");
		doGet(request, response);
	}

}

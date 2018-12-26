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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");

		System.out.println("memberId: " +memberId);
		System.out.println("memberPwd: " +memberPwd);
		
		Member reqMember = new Member();
		reqMember.setMemberId(memberId);
		reqMember.setMemberPwd(memberPwd);
		
		
		Member loginUser = new MemberService().loginCheck(reqMember);
		
		
		
		if(loginUser != null) { // 로그인 성공 시
			request.getSession().setAttribute("loginUser", loginUser);
			System.out.println("11111");
			response.sendRedirect("index.jsp"); // index.jsp로 재요청
			System.out.println("2");
			
		}else {
			request.setAttribute("msg", "로그인 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

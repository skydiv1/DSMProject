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
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember.me")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String member_id = request.getParameter("member_id");
		String member_pwd = request.getParameter("member_pwd");
		String member_name = request.getParameter("member_name");
		String member_phone = request.getParameter("member_phone");
		String member_email = request.getParameter("member_email");
		String seller_introduction = request.getParameter("seller_introduction");
		String seller_career = request.getParameter("seller_career");
	
		Member reqMember = new Member();
		reqMember.setMember_id(member_id);
		reqMember.setMember_pwd(member_pwd);
		reqMember.setMember_name(member_name);
		reqMember.setMember_phone(member_phone);
		reqMember.setMember_email(member_email);
		reqMember.setSeller_introduction(seller_introduction);
		reqMember.setSeller_career(seller_career);
		
		int result = new MemberService().insertMember(reqMember);
		
		
		if(result>0) {
			request.getSession().setAttribute("msg", "회원가입에 성공하셨습니다.");
			
			response.sendRedirect("views/common/successPage.jsp");
		}else {//다 했을때 팝업시도
			request.setAttribute("msg", "회원가입 실패!");
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

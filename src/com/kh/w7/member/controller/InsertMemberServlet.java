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
/*@WebServlet("/insertMember.me")*/
@WebServlet("/insertSel.me")
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
		request.setCharacterEncoding("utf-8");
		String memberId = request.getParameter("memberId");
		String memberPwd = request.getParameter("memberPwd");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberEmail = request.getParameter("memberEmail");
		String sellerIntroduction = request.getParameter("sellerIntroduction");
		String sellerCareer = request.getParameter("sellerCareer");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPwd: " + memberPwd);
		System.out.println("memberName: " + memberName);
		System.out.println("memberPhone: " + memberPhone);
		System.out.println("memberEmail: " + memberEmail);
		System.out.println("selleIntroduction: " + sellerIntroduction);
		System.out.println("sellerCareer: " + sellerCareer);
		
		
		Member reqMember = new Member();
		reqMember.setMemberId(memberId);
		reqMember.setMemberPwd(memberPwd);
		reqMember.setMemberName(memberName);
		reqMember.setMemberPhone(memberPhone);
		reqMember.setMemberEmail(memberEmail);
		reqMember.setSellerIntroduction(sellerIntroduction);
		reqMember.setSellerCareer(sellerCareer);
		

		
		/*int result = new MemberService().insertMember(reqMember);*/
//		int result = new MemberService().insertSel(reqMember);
		
//		if(result>0) {
//			request.getSession().setAttribute("msg", "회원가입에 성공하셨습니다.");
//			
//			response.sendRedirect("index.jsp");
//		}else {//다 했을때 팝업시도
//			request.setAttribute("msg", "회원가입 실패!");
//			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
//		}
		
	
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

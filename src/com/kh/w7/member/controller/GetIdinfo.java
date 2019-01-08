package com.kh.w7.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class GetIdifo
 */
@WebServlet("/GetIdinfo.me")
public class GetIdinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetIdinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member=(Member)request.getSession().getAttribute("loginUser");
		int memberCode = member.getMemberCode();
		String memberId = member.getMemberId();
		String memberName = member.getMemberName();
		String memberPhone = member.getMemberPhone();
		String memberEmail = member.getMemberEmail();
		String sellerIntroduction = member.getSellerIntroduction();
		String sellerCareer = member.getSellerCareer();
		int memberCategory =member.getMemberCategory(); ;
		String page ="";
		if(memberCategory ==0) {
			page="views/member/con_info.jsp";
			
		}else if(memberCategory==1) {
			page="views/member/Sel_info.jsp";
		}
		request.setAttribute("memberCode", memberCode);
		request.setAttribute("memberId", memberId);
		request.setAttribute("memberName", memberName);
		request.setAttribute("memberPhone", memberPhone);
		request.setAttribute("memberEmail", memberEmail);
		request.setAttribute("sellerIntroduction", sellerIntroduction);
		request.setAttribute("sellerCareer", sellerCareer);
		
		RequestDispatcher view= request.getRequestDispatcher(page);
		view.forward(request, response);
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

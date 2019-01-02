package com.kh.w7.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.service.SellerProfileService;
import com.kh.w7.product.model.vo.Product;

/**
 * Servlet implementation class NoticeResistServlet
 */
@WebServlet("/noticeResist.pr")
public class NoticeResistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeResistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		System.out.println("memberCode(판매자 번호) : "+memberCode);

		// member 개인정보 객체 + 상품 리스트(ArrayList)
		Member member = new Member();
		member.setMemberCode(memberCode);
		
		Product product = new Product();
		ArrayList<Product> productList = new SellerProfileService().selectSellerList(memberCode);
		
		String page = "";
		if(productList != null) {
			request.setAttribute("productList", productList);
			request.setAttribute("member", member);		
			page = "views/cash/noticeResist.jsp";
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "판매자 프로필보기 실패!");
		}
		
		RequestDispatcher view = request.getRequestDispatcher(page);
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

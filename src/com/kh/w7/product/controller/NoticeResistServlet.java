package com.kh.w7.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.common.Attachment;
import com.kh.w7.common.PageInfo;
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.service.ProductService;
import com.kh.w7.product.model.service.ReviewService;
import com.kh.w7.product.model.service.SellerProfileService;
import com.kh.w7.product.model.vo.PlusProduct;
import com.kh.w7.product.model.vo.Product;
import com.kh.w7.product.model.vo.Review;

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
		
		// =============== 페이징 처리 추가 ==============
		int currentPage;	// 현재 페이지를 표시할 변수 (ex. 내가 1페이지를 보고 있는지 2페이지를 보고 있는지)
		int limit;			// 한 페이지에 게시글이 몇 개가 보여질 것인지 표시
		int maxPage;		// 전체 페이지에서 가장 마지막 페이지 (총 필요한 페이지가 필요하다.)
		int startPage;		// 한 번에 표시될 페이지가 시작할 페이지 (123456789 중 1페이지) / (11 12 13 14 15 16 17 18 19 20 중 11페이지)
		int endPage;		// 한 번에 표시될 페이지가 끝나는 페이지
		
		// 현재 페이지 처리
		currentPage=1;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // 아무 값이 없을 때는 1페이지부터 보여준다.
		}
		
		// 한 페이지에 보여질 목록 개수
		//limit = 10; // 한 페이지에 1번~10번까지 보여준다.
		limit = 6; // 한 페이지에 1번~6번까지만 보여준다.
		
		int memberCode = Integer.parseInt(request.getParameter("memberCode"));
		System.out.println("memberCode(판매자 번호) : "+memberCode);
		
		SellerProfileService sps = new SellerProfileService();
		// 해당 판매자 전체 게시글 수 조회
		int listCount = sps.getListCount(memberCode);
		System.out.println("listCount 확인 (서블릿)"+listCount);
		
		// 총 페이지 수 계산
		// ex. 목록 수가 123개면 페이지 수는 13페이지가 필요하다.
		// ex. 목록 수가 68개면 페이지 수는 11페이지가 필요하다.
		maxPage = (int)((double)listCount / limit + 0.9); // 공식처럼 사용하는 방식 / 게시물 한개가 차지하는 수 0.1
		
		// 현재 페이지에 보여줄 시작페이지 수
		// ex. 1, 11, 21, 31, ...
		startPage = (((int)((double)currentPage/ limit + 0.9)) - 1) * limit + 1;
		
		// 목록 아래쪽에 보여질 마지막 페이지 수(10, 20, 30, ...)
		//endPage = startPage + 10 -1;
		endPage = startPage + 6 -1;
		
		if(maxPage < endPage) { // endPage 20페이지, maxPage가 13페이지면 -> 13페이지를 maxPage로 바꿔준다.
			endPage = maxPage;
		}
		
		// 객체로 만들어서 사용
		PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
		// -------------------------------------------------------------------------------------------------------

		HashMap<String, Object> hmap = new SellerProfileService().selectSellerList(memberCode, currentPage, limit);
		
		ArrayList<Product> pList = (ArrayList<Product>)hmap.get("product");
		ArrayList<Attachment> imgList = (ArrayList<Attachment>)hmap.get("attachment");

		ArrayList<Review> reviewList = new ReviewService().selectAllReviewList(memberCode);
		
		Member member = (Member)hmap.get("member");
		System.out.println("member 서블릿 : "+member);
		
		String page = "";
		if(hmap != null) {
			request.setAttribute("pList", pList);
			request.setAttribute("imgList", imgList);	
			request.setAttribute("member", member);	
			request.setAttribute("pi", pi);		
			request.setAttribute("memberCode", memberCode);		
			request.setAttribute("reviewList", reviewList);		
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

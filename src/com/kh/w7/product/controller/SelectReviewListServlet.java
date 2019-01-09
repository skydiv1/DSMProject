package com.kh.w7.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.product.model.service.ReviewService;
import com.kh.w7.product.model.vo.Review;

/**
 * Servlet implementation class SelectReviewListServlet
 */
@WebServlet("/reviewList.pr")
public class SelectReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String productNum = request.getParameter("productNum"); // jsp에서 상품 번호 받아온다.
		System.out.println("productNo(리뷰 서블릿) : "+productNum);
		/*Review review = new Review();
		review.setProductNo(Integer.parseInt(productNo));*/
		
		ArrayList<Review> reviewList = new ReviewService().selectReviewList(productNum);

		ArrayList<Review> reviewList2 = new ArrayList<Review>();
		
		int count = 0;
		for(int i=0; i<reviewList.size(); i++) {
			for(int j = 0; j <reviewList2.size(); j++) {
				if(reviewList.get(i).getMemberCode() == reviewList2.get(j).getMemberCode()) {
					count++;
				}
			}
			if(count == 0) {
				reviewList2.add(reviewList.get(i));
				
			}
			count = 0;
			
		}
		System.out.println("reviewList : "+reviewList);
		System.out.println("reviewList2 : "+reviewList2);
		
		
		
		
		if(reviewList != null) {
			request.setAttribute("reviewList", reviewList2);
			new Gson().toJson(reviewList2, response.getWriter());		
		}else {
			request.setAttribute("msg", "리뷰 조회 실패!");			
			String page="views/common/errorPage.jsp";			
			RequestDispatcher view = request.getRequestDispatcher(page);
			view.forward(request, response);
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

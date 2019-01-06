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
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.service.ReviewService;
import com.kh.w7.product.model.service.SellerProfileService;
import com.kh.w7.product.model.vo.Review;

/**
 * Servlet implementation class SelectBestSellerServlet
 */
@WebServlet("/selectBestSeller.pr")
public class SelectBestSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBestSellerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Member bestSeller = new SellerProfileService().findBestSeller();
		
		int reviewCount = new SellerProfileService().selectReviewList();

		if(bestSeller != null && reviewCount>0) {
			request.setAttribute("bestSeller", bestSeller);		
			request.setAttribute("reviewList", reviewCount);	
			response.sendRedirect("index.jsp");
		}else {
			request.setAttribute("msg", "베스트 판매자 검색 실패");			
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

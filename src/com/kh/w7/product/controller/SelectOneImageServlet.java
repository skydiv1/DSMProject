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
import com.kh.w7.member.model.vo.Member;
import com.kh.w7.product.model.service.ProductService;
import com.kh.w7.product.model.vo.PlusProduct;
import com.kh.w7.product.model.vo.Product;

/**
 * Servlet implementation class SelectOneImageServlet
 */
@WebServlet("/selectOne.pr")
public class SelectOneImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 쿼리 스트링으로 넘긴 값 파라미터로 받는다.
		int num = Integer.parseInt(request.getParameter("num"));
		
		HashMap<String, Object> hmap = new ProductService().selectThumbnailMap(num);
		System.out.println(hmap);
		Product product= (Product)hmap.get("product"); // Dao에서 값을 받아온 후 깨내준다.
		Member member = (Member)hmap.get("member");
		ArrayList<PlusProduct> pList = (ArrayList<PlusProduct>)hmap.get("plusProduct");
		ArrayList<Attachment> fileList = (ArrayList<Attachment>)hmap.get("attachment");

		for(int i=0; i<pList.size(); i++) {
			System.out.println((i+1)+"번 추가상품(서블릿): "+pList.get(i));
		}
		for(int i=0; i<fileList.size(); i++) {
			System.out.println((i+1)+"번 이미지(서블릿): "+fileList.get(i));
		}		
		
		String page = "";
		if(hmap != null) {
			page = "views/product/productDetail.jsp";
			request.setAttribute("product", product);
			request.setAttribute("fileList", fileList);
			request.setAttribute("member", member);
			request.setAttribute("pList", pList);
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "상품 상세보기 실패!");
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

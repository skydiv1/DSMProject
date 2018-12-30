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

import com.google.gson.Gson;
import com.kh.w7.common.PageInfo;
import com.kh.w7.product.model.service.ProductService;

/**
 * Servlet implementation class SearchListServlet
 */
@WebServlet("/searchList.pr")
public class SearchListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* 검색 단어 가지오기 */
		String searchList = request.getParameter("searchList");
		System.out.println("searchList: "+searchList);

		/* 한글 인코딩 */
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
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
		
		ProductService ps = new ProductService();
		// 특정 게시글 수 조회
		int listCount = ps.getTitleListCount(searchList);
		
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

		// 조회
		//ArrayList<Product> list = new ProductService().selectList(currentPage, limit);
		ArrayList<HashMap<String, Object>> list = new ProductService().searchtList(currentPage, listCount, limit, searchList); 
		
		/* 출력 */
		//new Gson().toJson(listCount, response.getWriter());
		new Gson().toJson(list, response.getWriter()); // 누구에게 어떤 정보를 보낼것인지 정하면 끝
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

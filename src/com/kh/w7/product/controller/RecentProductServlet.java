package com.kh.w7.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.product.model.service.ProductService;

/**
 * Servlet implementation class RecentProduct
 */
@WebServlet("/recentProduct.pr")
public class RecentProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecentProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNo1 = request.getParameter("pNo1");
		String pNo2 = request.getParameter("pNo2");
		String pNo3 = request.getParameter("pNo3");
		String pNo4 = request.getParameter("pNo4");
		String pNo5 = request.getParameter("pNo5");
		String pNo6 = request.getParameter("pNo6");
		
		ArrayList<String> tempArr = new ArrayList<String>(); // 임시로 담을 공간 (빈 값이 들어갈 수 있기 때문)
		tempArr.add(pNo1);
		tempArr.add(pNo2);
		tempArr.add(pNo3);
		tempArr.add(pNo4);
		tempArr.add(pNo5);
		tempArr.add(pNo6);
		
		ArrayList<String> pNoArr = new ArrayList<String>();
		for(int i = 0; i<tempArr.size();i++) {
			if(!(tempArr.get(i).equals(""))) {
				pNoArr.add(tempArr.get(i));
			}
		}
		System.out.println(pNoArr);

		ArrayList<HashMap<String, Object>> list = new ProductService().resentProductList(pNoArr); 
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
	
		new Gson().toJson(list	, response.getWriter());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

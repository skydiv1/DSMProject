package com.kh.w7.mypage.controller;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/selectList.consumer")
public class CunsumerMypageSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CunsumerMypageSelectList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
			
	
			//온니 페이지 이동만
			String page = "";
			
				page = "views/member/ConsumerMyPage.jsp";
				
			
			RequestDispatcher view = request.getRequestDispatcher(page);
			view.forward(request, response);
			
			
		
		}
			
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

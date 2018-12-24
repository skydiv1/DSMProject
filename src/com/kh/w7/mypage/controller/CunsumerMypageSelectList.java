package com.kh.w7.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.w7.member.model.vo.Member;
import com.kh.w7.mypage.model.service.MypageService;
import com.kh.w7.mypage.model.vo.MyPage;


@WebServlet("/selectList.consumer")
public class CunsumerMypageSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CunsumerMypageSelectList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		//로그인유저의 Member테이블의 member_code와 (소비자일때)Deal테이블의 customer_code를 비교해서 같으면 Deal테이블의 정보를 불러오자
		Member loginUser = (Member)session.getAttribute("loginUser");
		MyPage cCode = new MyPage();
		int clogin =cCode.getCustomerCode();
	
		
		if(loginUser.getMember_code() == clogin) {
			ArrayList<MyPage>list = new MypageService().selectList(clogin); 
		
			String page = "";
			if(list != null) {
				page = "views/member/ConsumerMyPage.jsp";
				request.setAttribute("list", list);
			}else {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "마이페이지 조회 실패!");
			}
			RequestDispatcher view = request.getRequestDispatcher(page);
			view.forward(request, response);
		
		}
			
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

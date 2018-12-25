package com.kh.w7.refund.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AccountCertServlet
 */
@WebServlet("/accountCert.re")
public class AccountCertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String bank = request.getParameter("bank");
		String account = request.getParameter("account");
		
		/*
		 *정상출력
		 * System.out.println("name : " + name);
		System.out.println("birth : " + birth);
		System.out.println("bank : " + bank);
		System.out.println("account : " + account);*/
		
		String result= "";
		
		switch(bank) {
		case "국민은행":
			if(account.length() == 16 && account.indexOf("-") == 6 && account.lastIndexOf("-") == 9)
				result = "정상적인 국민은행 계좌입니다";
			else
				result = "잘못된 국민은행 계좌입니다, 다시 입력해주세요";
			break;
		case "신한은행":
			if((account.length() == 13 && account.indexOf("-") == 3 && account.lastIndexOf("-") == 6)||(account.length() == 14 && account.indexOf("-") == 3 && account.lastIndexOf("-") == 7))
				result = "정상적인 신한은행 계좌입니다";
			else
				result = "잘못된 신한은행 계좌입니다, 다시 입력해주세요";
			break;
		case "기업은행":
			if(account.length() == 17 && account.indexOf("-") == 3 && account.indexOf("-", 4) == 10 && account.indexOf("-", 11) ==13)
				result = "정상적인 기업은행 계좌입니다";
			else
				result = "잘못된 기업은행 계좌입니다, 다시 입력해주세요";
			break;
		case "우리은행":
			if(account.length() == 15 && account.indexOf("-") == 4 && account.lastIndexOf("-") == 8)
				result = "정상적인 우리은행 계좌입니다";
			else
				result = "잘못된 우리은행 계좌입니다, 다시 입력해주세요";
			break;
		case "하나은행":
			if(account.length() == 16 && account.indexOf("-") == 3 && account.lastIndexOf("-") == 10)
				result = "정상적인 하나은행 계좌입니다";
			else
				result = "잘못된 하나은행 계좌입니다, 다시 입력해주세요";
			break;
		case "농협":
			if((account.length() == 13 && account.indexOf("-") == 3 && account.lastIndexOf("-") == 6)||(account.length() == 14 && account.indexOf("-") == 4 && account.lastIndexOf("-") == 7))
				result = "정상적인 농협 계좌입니다";
			else
				result = "잘못된 농협 계좌입니다, 다시 입력해주세요";
			break;
		case "지역농협":
			if((account.length() == 16 && account.indexOf("-") == 6 && account.lastIndexOf("-") == 9)||(account.length() == 16 && account.indexOf("-") == 3 &&  account.indexOf("-", 4) == 8 &&account.indexOf("-", 9) == 13))
				result = "정상적인 지역농협 계좌입니다";
			else
				result = "잘못된 지역농협 계좌입니다, 다시 입력해주세요";
			break;	
		}
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(result, response.getWriter());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

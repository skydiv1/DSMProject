package com.kh.w7.refund.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.refund.model.service.RefundService;
import com.kh.w7.refund.model.vo.Refund;

/**
 * Servlet implementation class ApplyRefundServlet
 */
@WebServlet("/applyRefund.re")
public class ApplyRefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyRefundServlet() {
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
		String StrRefundMoney = request.getParameter("refundMoney");
		
		//숫자만 때오기
		StrRefundMoney = StrRefundMoney.substring(0, StrRefundMoney.indexOf('원')-1);
		int refundMoney = Integer.parseInt(StrRefundMoney);
		/*정상출력
		System.out.println("name : " + name);
		System.out.println("birth : " + birth);
		System.out.println("bank : " + bank);
		System.out.println("account : " + account);
		System.out.println("refundMoney : " + refundMoney);*/
		
		Refund r = new Refund();
		r.setMember_code(3); //임시로 만든 신청 회원 코드
		r.setRefund_money(refundMoney);
		r.setMember_name(name);
		r.setMember_birth(birth);
		r.setRefund_bank(bank);
		r.setRefund_account(account);
		
		
		int result = new RefundService().insertRefundData(r);
		
		
		//System.out.println("servlet result : " + result);
		
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

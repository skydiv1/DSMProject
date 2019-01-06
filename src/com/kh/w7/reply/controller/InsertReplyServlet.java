package com.kh.w7.reply.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.w7.reply.model.service.ReplyService;
import com.kh.w7.reply.model.vo.Reply;

/**
 * Servlet implementation class InsertReplyServlet
 */
@WebServlet("/insertReply.re")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int BoardNo = Integer.parseInt(request.getParameter("BoardNo"));
		int MemberCode = Integer.parseInt(request.getParameter("MemberCode"));
		String Context = request.getParameter("Context");
		
		System.out.println(BoardNo);
		System.out.println(MemberCode);
		System.out.println(Context);
		
		Reply r = new Reply();
		r.setBoardNo(BoardNo);
		r.setMemberCode(MemberCode);
		r.setReplyContext(Context);		
		
		ArrayList<Reply> replyList = new ReplyService().insertReply(r);
		
		response.setContentType("application/json");
		new Gson().toJson(replyList, response.getWriter());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.kh.w7.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.w7.member.model.service.MemberService;
import com.kh.w7.member.model.vo.Member;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet("/find_pwd.me")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindPwdServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String memberName=request.getParameter("memberName");
		String memberId = request.getParameter("memberId");
		String memberEmail = request.getParameter("memberEmail");
		String randomCode = request.getParameter("randomCode");
		
		
		System.out.println(memberName);
		System.out.println(memberId);
		System.out.println(memberEmail);
		System.out.println(randomCode);
		
		Properties p = new Properties();// 정보를 담을 객체
		p.put("mail.smtp.user", "droneservicemarket@gmail.com");//본인 아이디
		p.put("mail.smtp.host", "smtp.gmail.com"); 
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable","true"); 
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");

		try{
		    Authenticator auth = new SMTPAuthenticator();
		    Session ses = Session.getDefaultInstance(p, auth);
		    
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    
		 
		    InternetAddress from = new InternetAddress("droneservicemarket@gmail.com");//본인아이디
             
            // 이메일 발신자
            msg.setFrom(from);
            
            // 이메일 수신자
            InternetAddress to = new InternetAddress(memberEmail);
            msg.setRecipient(Message.RecipientType.TO, to);
             
            // 이메일 제목
            msg.setSubject("[DSM] 임시비밀번호 발급", "UTF-8");
             
            // 이메일 내용
            request.setAttribute("randomCode", randomCode);
            msg.setText("DSM에 요청하신 회원님의 임시비밀번호입니다. 로그인 후 비밀번호를 변경해주세요.<br><br>임시비밀번호 : " + randomCode, "UTF-8");
       
             
            // 이메일 헤더
            msg.setHeader("content-Type", "text/html");
             
            //DB에 있는 비밀번호 임시비밀번호로 변경하기
            int result = new MemberService().findpwd(randomCode, memberId, memberEmail, memberName);
            if(result > 0) {
            	//메일보내기   
            	System.out.println("이프 전까지되나여");
                Transport.send(msg);
           
                System.out.println("보냄");
                
                response.getWriter().print("SUCCESS");
            }else {
            	response.getWriter().print("FAIL");
            }
                  
		} catch(Exception e){
		  e.printStackTrace();
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

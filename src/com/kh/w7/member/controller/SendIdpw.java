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

/**
 * Servlet implementation class SendIdpw
 */
@WebServlet("/SendIdpw.me")
public class SendIdpw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendIdpw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String memberEmail = request.getParameter("memberEmail");
		String memberId = (String) request.getAttribute("memberId");
		
		String randomCode = (String) request.getAttribute("randomCode");
		
		
		System.out.println("memberPwd : " + randomCode);

		
		Properties prop = new Properties();// 정보를 담을 객체
		prop.put("mail.smtp.user", "DroneServiceMarket@gmail.com");
		prop.put("mail.smtp.host", "smtp.gmail.com"); 
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.starttls.enable","true"); 
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");
		
		try{
		    Authenticator auth = new SMTPAuthenticator();
		    Session ses = Session.getDefaultInstance(prop, auth);
		    
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    
		    InternetAddress from = new InternetAddress("DroneServiceMarket@gmail.com");
             
            // 이메일 발신자
            msg.setFrom(from);
            
            // 이메일 수신자
            InternetAddress to = new InternetAddress(memberEmail);
            msg.setRecipient(Message.RecipientType.TO, to);
             
            // 이메일 제목
            if("memberId" != null) {
            	msg.setSubject("요청하신 DSM 아이디입니다. ", "UTF-8");
            }else if("randomCode" != null) {
            	msg.setSubject("요청하신 DSM 임시비밀번호 입니다.", "UTF-8");
            }
            
            // 이메일 내용
            if("memberId" != null) {
            	 request.setAttribute("memberId", memberId);
                 msg.setText("아이디 : "+ memberId, "UTF-8");
            }else if("randomCode" != null) {
            	request.setAttribute("memberPwd", randomCode);
                msg.setText("임시 비밀번호 : "+ randomCode, "UTF-8");
            }
           
            // 이메일 헤더
            msg.setHeader("content-Type", "text/html");
             
            //메일보내기   
            Transport.send(msg);
            
            response.getWriter().print("YES");
            
		} catch(Exception e){
		response.getWriter().print("NO");
		  e.printStackTrace();
		}
		
		
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

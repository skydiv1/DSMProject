package com.kh.w7.member.controller;

import java.io.IOException;
import java.net.Authenticator;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendEmail
 */
@WebServlet("/SendEmail.me")
public class SendEmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SendEmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String memberEmail = request.getParameter("memberEmail");
		String randomCode = request.getParameter("randomCode");
		String from = request.getParameter("from");
		String hiddenName = request.getParameter("hiddenName");
		
		//정보담을 객체
		Properties prop = new Properties();
		prop.put("mail.smtp.user", "DroneServiceMarket@gmail.com");
		prop.put("mail.smtp.host", "smtp.gmail.com"); 
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.starttls.enable","true"); 
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");

		try{
		    SMTPAuthenticator auth = new SMTPAuthenticator();
		    Session session = Session.getDefaultInstance(prop, auth);
		    
		    MimeMessage msg = new MimeMessage(session); //세션생성
		    
		   
		    msg.setSentDate(new Date());
		    InternetAddress froms = new InternetAddress("DroneServiceMarket@gmail.com");
             
            
            msg.setFrom(froms);//발신인
            
            
            InternetAddress to = new InternetAddress(memberEmail);
            msg.setRecipient(Message.RecipientType.TO, to);//수신인
             
            
            msg.setSubject("DSM 인증코드 발송입니다", "UTF-8");//제목
             
            
            request.setAttribute("randomCode", randomCode);//내용
            msg.setText(randomCode, "UTF-8");
       
             
            
            msg.setHeader("content-Type", "text/html");//헤더
             
            
            javax.mail.Transport.send(msg);//보내기
           response.getWriter().print("success");
            
		} catch(Exception e){
		response.getWriter().print("NO");
		  e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
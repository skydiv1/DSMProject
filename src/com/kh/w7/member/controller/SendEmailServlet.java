package com.kh.w7.member.controller;

import java.io.IOException;
import java.net.Authenticator;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
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
public class SendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SendEmail() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props= System.getProperties();
		props.put("mail.smtp.user", "DroneServiceMarket");
		props.put("mail.smtp.host","smtp.google.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Authenticator auth = new MyAuthentication();
		
		Session session = Session.getDefaultInstance(props);
		MimeMessage msg = new MimeMessage(session);
	
		try {
			msg.setSentDate(new Date());
			
			InternetAddress from= new InternetAddress("보내는 사람");
			
			msg.setFrom();
			
			String email= request.getParameter("memberEmail");
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO,to);
			
			msg.setSubject("이메일 인증번호","UTF-8");
			
			String code = request.getParameter("code_check");
			request.setAttribute("code", code);
			msg.setText(code,"UTF-8");
			
			msg.setHeader("content-Type", "text/html");
			
			javax.mail.Transport.send(msg);
			System.out.println("보냈다");
			
		}catch (AddressException e) {
			e.printStackTrace();
		}catch (MessagingException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd= request.getRequestDispatcher("인증");
		rd.forward(request, response);
		
	    }
		}
	class MyAuthentication extends Authenticator{
		PasswordAuthentication pa;
		
		public MyAuthentication() {
			String id ="DroneServiceMarket";
			String pw ="admin123!";
					
			pa= new PasswordAuthentication(id, pw);
					

	}
		
		
		
			return pa;
		}

}

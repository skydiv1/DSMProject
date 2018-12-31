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
		String adName = request.getParameter("adName");
		
		System.out.println("memberEmail : " + memberEmail);
		System.out.println("randomCode : " + randomCode);
		System.out.println("from : " + from);
		
		Properties prop = new Properties();// 정보를 담을 객체
		prop.put("mail.smtp.user", "DroneServiceMarket@gmail.com");
		prop.put("mail.smtp.host", "smtp.gmail.com"); 
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.starttls.enable","true"); 
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.socketFactory.fallback", "false");

		/*p.put("mail.smtp.starttls.enable","true"); 
		p.put("mail.smtp.host", "smtp.gmail.com"); 
		p.put("mail.smtp.port", "587"); //25,587
		p.put("mail.smtp.auth", "true"); */
		
		try{
		    SMTPAuthenticator auth = new SMTPAuthenticator();
		    Session session = Session.getDefaultInstance(prop, auth);
		    
		    MimeMessage msg = new MimeMessage(session); // 메일의 내용을 담을 객체
		    
		   
		    msg.setSentDate(new Date());
		    InternetAddress froms = new InternetAddress("DroneServiceMarket@gmail.com");
             
            // 이메일 발신자
            msg.setFrom(froms);
            
            // 이메일 수신자
            InternetAddress to = new InternetAddress(memberEmail);
            msg.setRecipient(Message.RecipientType.TO, to);
             
            // 이메일 제목
            msg.setSubject("DSM 인증코드 발송입니다", "UTF-8");
             
            // 이메일 내용
            request.setAttribute("randomCode", randomCode);
            msg.setText(randomCode, "UTF-8");
       
             
            // 이메일 헤더
            msg.setHeader("content-Type", "text/html");
             
            //메일보내기
            javax.mail.Transport.send(msg);


		 
		    
		    
		    
		    
		   /* Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); 
		 
		    Address toAddr = new InternetAddress(fullEmail);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		    */
		    
		    //msg.setFrom(new InternetAddress(mail_from));
            //msg.addRecipient(Message.RecipientType.TO, toAddr);
            /*msg.setSubject(title, "UTF-8");
            msg.setContent(randomCode, "text/html; charset=UTF-8");
            msg.setHeader("Content-type", "text/html; charset=UTF-8");
 */
		    
           //Transport.send(msg);
       
            System.out.println("보냄");
            
            response.getWriter().print("YES");
            
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
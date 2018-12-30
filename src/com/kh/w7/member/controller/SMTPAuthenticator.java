package com.kh.w7.member.controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class SMTPAuthenticator extends Authenticator{
	PasswordAuthentication pa;
	 
	 
	 
    public SMTPAuthenticator() {

        String id="DroneServiceMarket";
        String pw = "admin123!";
        
        pa = new PasswordAuthentication(id, pw);

    }

	

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return pa;
    }
	
	
	/*public class SMTPAuthenticatior extends Authenticator{ 
	    @Override
	    protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication("takbububu@gmail.com","qwer1234*");
	    }*/
	}

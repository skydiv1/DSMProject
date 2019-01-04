/*package com.kh.w7.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LoginWrapper extends HttpServletRequestWrapper{ // Request로 생각해도 무관

	public LoginWrapper(HttpServletRequest request) {
		super(request); // 부모 쪽으로 request 넘김
	}
	
	@Override
	public String getParameter(String key) {
		String value="";
		if(key != null && key.equals("memberPwd")) { // 비번을 부모 객체에서 불러오는데 그 값이 같다면
			value = getSha512(super.getParameter("memberPwd"));// 암호화 처리 메소드(아래에서 수행)
		}else {
			value = super.getParameter(key); // super:HttpServletRequest / 부모의 getParameter로 키를 넘김			
		}
		
		return value;
	}
	
	private static String getSha512(String memberPwd) {
		String encPwd="";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = memberPwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			
			encPwd = Base64.getEncoder().encodeToString(md.digest()); // 객체 암호화 (내부 로직이나 코드는 알 수 없다.)
			
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encPwd; // 암호화 처리된 pwd를 넘겨준다.
	}
	
}
*/
package com.kh.w7.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.kh.w7.wrapper.LoginWrapper;

/**
 * Servlet Filter implementation class IncryptFilter
 */
@WebFilter("*.me") /* Member Service 에서만 사용 */
public class IncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public IncryptFilter() {
    	System.out.println("객체 생성 확인!");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 다운 캐스팅 (사용하기위해)
		HttpServletRequest hRequest = (HttpServletRequest)request;
		
		// 가공 처리 하기 위해 사용 (LoginWrapper.java 클래스 호출)
		LoginWrapper lw = new LoginWrapper(hRequest);
		
		chain.doFilter(lw, response); // lw: 변경된 request 사용
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

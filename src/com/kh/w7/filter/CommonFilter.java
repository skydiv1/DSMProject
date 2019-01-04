package com.kh.w7.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CommonFilter implements Filter {

    public CommonFilter() {
    	System.out.println("객체 생성1");
    }

	public void destroy() { // 필터가 종료될 때
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		chain.doFilter(request, response); // 다음 필터로 request, response을 넘김
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// 라이프사이클은 서블릿과 동일
	}

}

package com.example.mbboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/admin/*")
public class MyFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 선행 필터 return; 인증(세션안에 로그인정보가 없다 return;), 인가(세션안에 로그인 정보는 있지만 정보중 이 요청을 허가할 정보가 없다)
		chain.doFilter(request, response);	// 최종 목적지 servlet or jsp or controller
		
		// 후행 필터
	}
}

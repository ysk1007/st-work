package com.example.mbboard.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebFilter("/a/*")
public class AAllFilter implements Filter{
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		
		log.info("/a/* 선행코드");
		
		if(true) {	// 인증(데이터 검사), 인가(권한 검사) 검사
			// redirect 후에... return;
			return;
		}
		
		chain.doFilter(request, response);
		log.info("/a/* 후행코드");
	}
}

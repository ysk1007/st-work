package com.example.ssecurity;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// SpringSecurity 필터를 Bean으로 등록 -> 체인형태로 등록
	// Http 요청/응답 가로채서 랩핑하여 SpringSecurity에 사용가능한 HttpSecurity 타입으로 변환시켜 인자로 받음
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		// 인자값(httpSecurity)를 이용하여 인증, 인가를 설정
		
		// 1) CSRF 설정이 기본값이 true - form에서 값을 넘길때 약속된 암호화된 토큰값을 넘겨야 한다 -> 사용하지 않도록 변경
		// SpringSecurity 설정값 중 CSRF 설정정보를 가지는 CsrfConfigure 정보값을 변경
		httpSecurity.csrf((csrfConfigure)-> csrfConfigure.disable());
		
		// 2) 인가 설정
		// SpringSecurity 설정값 AuthorizationManagerRequestMatcherRegistry(인가 리스트) 설정 정보를 수정
		httpSecurity.authorizeHttpRequests((requestMatcherRegistry)->
				requestMatcherRegistry.requestMatchers("/","/login", "/loginAction", "/addUser", "/addUserAction", "/WEB-INF/views/**").permitAll()
									  .requestMatchers("/admin/**").hasRole("ADMIN")	// 테이블 role 컬럼값이 "ROLE_ADMIN"
									  .requestMatchers("/user/**").hasRole("ADMIN")
									  .requestMatchers("/user/**").hasRole("USER")		// 테이블 role 컬럼값이 "ROLE_USER"
									  .anyRequest().authenticated()
			);
		
		// 3) 인증(로그인) 설정
		// formLoginConfigurer 설정값을 변경
		httpSecurity.formLogin((formLoginConfigurer) -> 
			formLoginConfigurer.loginPage("/login")
								// 인증을 위해 필터 가로채는 loginAction 주소 -> userDetailService의 구현체를 호출 -> UserDetail 구현체 반환
							   .loginProcessingUrl("/loginAction")
							   .successHandler(new AuthenticationSuccessHandler() { // 성공 했을 때
								   @Override
									public void onAuthenticationSuccess(HttpServletRequest request,
											HttpServletResponse response, Authentication authentication)
											throws IOException, ServletException {
										System.out.println("로그인 성공");
										// reques 값을 가공, response
										response.sendRedirect("/home");
									}
							   })
							   .failureHandler(new AuthenticationFailureHandler() {	// 실패 했을 때
								   @Override
									public void onAuthenticationFailure(HttpServletRequest request,
											HttpServletResponse response, AuthenticationException exception)
											throws IOException, ServletException {
									   System.out.println("로그인 실패");
									   response.sendRedirect("/login");
									}
							   })
							   
			);
		
		 // 4) 인증(로그아웃) 설정
		 httpSecurity.logout((logoutConfigurer)->
		 				logoutConfigurer.logoutUrl("/logout")
		 								.invalidateHttpSession(true)
		 								.logoutSuccessUrl("/login")
		 );
		 
		 
		return httpSecurity.build();
	}
}

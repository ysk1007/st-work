package com.example.oauth2client.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.example.oauth2client.service.CustomOAuth2Service;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CustomOAuth2Service customOAuth2Service;

    SecurityConfig(CustomOAuth2Service customOAuth2Service) {
        this.customOAuth2Service = customOAuth2Service;
    }
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		httpSecurity.csrf(csrfConfigurer  -> csrfConfigurer.disable());

		// 인가설정
		httpSecurity.authorizeHttpRequests(requestMatcherRegistry -> 
					requestMatcherRegistry.requestMatchers("/","/WEB-INF/view/**","/login/**","/oauth2/**").permitAll()
										  .anyRequest().authenticated()
		);
		
		// 로그인
		httpSecurity.formLogin(formLoginConfigurer  -> formLoginConfigurer.disable());
		
		// Oauth2 로그인 설정
		// httpSecurity.oauth2Login(Customizer.withDefaults());	// GET으로 login 요청이 오면 가로채서 OAuth2 기본 설정을 사용함
		httpSecurity.oauth2Login(oAuth2LoginConfigurer  -> 
							oAuth2LoginConfigurer.loginPage("/login")
												 .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig.userService(customOAuth2Service))
		);
		return httpSecurity.build();
	}
}

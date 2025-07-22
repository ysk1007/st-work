package com.example.configsever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableConfigServer
@SpringBootApplication
public class ConfigseverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigseverApplication.class, args);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf((configure) -> configure.disable());
        httpSecurity.authorizeHttpRequests((matcher) -> matcher.anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults()); // 웹브라우저가 기본적으로 제공하는 로그인창 사용
		
		return httpSecurity.build();
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	// 사용자를 반환하는 userDetailsService는 하나의 아이디만을 사용할거니까 빈안에 인메모리방식으로 한명의 사용자를 등록 
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("admin")
                .password(bCryptPasswordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1);
    }
	
}

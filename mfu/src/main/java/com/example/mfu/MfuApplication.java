package com.example.mfu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MfuApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(MfuApplication.class, args);
	}

	// 파일저장 패스 맵핑 (물리적 패스 : 프로젝트 밖, 논리적 접근:프로젝트 안인것 처럼)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 서비스하면 addResourceHandler(프로젝트안에서 사용할때 패스) addResourceLocations(서비스PC 폴더 위치)
		registry.addResourceHandler("/upload/**").addResourceLocations("file:///c:/project/upload/");
	}
}

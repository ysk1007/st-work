package com.example.oauth2client;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.oauth2client.mapper")
public class Oauth2clientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2clientApplication.class, args);
	}

}

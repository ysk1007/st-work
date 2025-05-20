package com.example.schProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchProjectApplication.class, args);
	}

}

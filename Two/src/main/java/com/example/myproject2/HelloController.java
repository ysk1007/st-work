package com.example.myproject2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")	// second/hello
	public String hello() {
		return "hello";
	}
}

package com.example.dbtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dbtest.entity.TestEntity;
import com.example.dbtest.repository.TestRepository;

@Controller
public class TestController {
	@Autowired
	TestRepository tr;
	
	@GetMapping("/testList")
	public String testList(Model model) {
		List<TestEntity> list = tr.findAll();
		model.addAttribute("list",list);
		return "testList";
	}
}

// Springboot

// Spring 프레임워크 : @Autowired
// controller - servlet - @Controller <- Spring MVC 프레임 워크
// DAO - @Repository JDBC코드 X <- JPA ORM 프레임워크
// JSP - {{}} <- tEMPLATE Engine
// log 프레임워크
// Spring security,...


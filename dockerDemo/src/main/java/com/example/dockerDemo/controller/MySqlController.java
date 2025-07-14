package com.example.dockerDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dockerDemo.service.MySqlService;

@Controller
public class MySqlController {

	@Autowired MySqlService mySqlService;
	
	@GetMapping("/getMysqlToday")
	public String getMySqlToday(Model model) {
		model.addAttribute("today",mySqlService.getMysqlToday());
		return "today";
	}
}

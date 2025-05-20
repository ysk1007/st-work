package com.example.chartjs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChartController {
	
	@GetMapping({"/","/chart"})
	public String chart() {
		return "chart";
	}
}

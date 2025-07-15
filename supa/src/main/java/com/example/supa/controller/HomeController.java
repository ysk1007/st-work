package com.example.supa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.supa.mapper.NowMapper;

@RestController
public class HomeController {
	@Autowired NowMapper nowMapper;
	
	/*
	 * @GetMapping("/") public String home() { return nowMapper.selectNow(); }
	 */
	
	
	/*
	 * com.example.sup.mapper.BoardMapper
	 * com.example.sup.service.BoardService
	 * com.example.sup.controller.BoardController
	 * com.example.sup.dto.BoardDto
	 */
}

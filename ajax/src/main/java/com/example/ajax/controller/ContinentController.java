package com.example.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ajax.mapper.CityMapper;
import com.example.ajax.mapper.ContinentMapper;
import com.example.ajax.mapper.CountryMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ContinentController {
	@Autowired ContinentMapper continentMapper;
	@Autowired CountryMapper countryMapper;
	@Autowired CityMapper cityMapper;
	
	@GetMapping({"/","/continentList"})
	public String continentList(Model model
			,@RequestParam(value="continent", defaultValue="0") Integer ctnNo
			,@RequestParam(value="country", defaultValue="0") Integer ctNo
			,@RequestParam(value="city", defaultValue="0") Integer cNo) {
		
		model.addAttribute("continentList",continentMapper.selectContinentList());
		
		log.info("ctnNo : " + ctnNo);
		log.info("ctNo : " + ctNo);
		log.info("cNo : " + cNo);
		
		if(ctnNo != null) {
			model.addAttribute("countryList",countryMapper.selectCountryList(ctnNo));
			model.addAttribute("ctnNo",ctnNo);
		}
		if(ctNo != null) {
			model.addAttribute("cityList",cityMapper.selectCityList(ctNo));
			model.addAttribute("ctNo",ctNo);
		}
		
		if(cNo != null) {
			model.addAttribute("cNo",cNo);
		}
		
		return "continentList";
	}
}

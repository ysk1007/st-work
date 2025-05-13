package com.example.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ajax.mapper.CityMapper;
import com.example.ajax.mapper.ContinentMapper;
import com.example.ajax.mapper.CountryMapper;

@Controller
public class CntnntController {
	@Autowired ContinentMapper continentMapper;
	@Autowired CountryMapper countryMapper;
	@Autowired CityMapper cityMapper;
	
	@GetMapping("/cntnntList")
	public String continentList(Model model
			,@RequestParam(value="continent", defaultValue="0") Integer ctnNo
			,@RequestParam(value="country", defaultValue="0") Integer ctNo
			,@RequestParam(value="city", defaultValue="0") Integer cNo) {
		
		model.addAttribute("cntnntList",continentMapper.selectContinentList());
		model.addAttribute("cntList",countryMapper.selectCountryList(ctnNo));
		model.addAttribute("ctyList",cityMapper.selectCityList(ctNo));
		
		model.addAttribute("ctnNo",ctnNo);
		model.addAttribute("ctNo",ctNo);
		model.addAttribute("cNo",cNo);
		
		return "cntnntList";
	}
}

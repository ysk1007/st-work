package com.example.schProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.schProject.dto.SampleForm;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SampleController {
	@GetMapping("/addSample")
	public String addSample() {
		return "addSample";
	}
	
	@PostMapping("/addSample")
	public String addSample(@Valid SampleForm sampleForm, Errors errors, Model model) {
		// 커맨드 객체 sampleForm이 생성될때 @Valid 유효성 검증이 먼저 선행된다.
		// -> 에러 발생시 Errors 객체에 에러정보가 추가
		log.info(sampleForm.toString());
		// @Valid 선행작업에서 Errors가 발생한다면 : 입력값 유효성 검사 후 입력 실패
		
		if(errors.hasErrors()) {
			for(FieldError e : errors.getFieldErrors()) {
				model.addAttribute(e.getField() + "Error", e.getDefaultMessage());
			}
			
			return "addSample";
		}
		
		return "redirect:/";	// 입력 성공시 리다이렉트 url
	}
	
}

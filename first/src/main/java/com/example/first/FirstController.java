package com.example.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller	// Servlet 역할
public class FirstController {
	
	@GetMapping("/hi")
	public String niceToMeetYou(Model model) {
		model.addAttribute("name", "구디2");	// request.setAttribute("name", "goodee");
		return "greetings";	// request.getRequestDispatcher("/greetings.mustache").forward(request, response);
	}

}

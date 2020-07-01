package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class Democontroller {
	
	@GetMapping("/out")
	public String out() {
		return "hello.html";	
	}
	
	@GetMapping("/list")
	public String result(Model model) {

		model.addAttribute("name","donkey");
		model.addAttribute("age",30);
		model.addAttribute("height",170);
		return "hello";
	}

}

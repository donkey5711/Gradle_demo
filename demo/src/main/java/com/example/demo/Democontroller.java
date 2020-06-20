package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Democontroller {
	
	@RequestMapping("/out")
	public String out() {
		return "hello.html";
		
	}
	@RequestMapping("/list")
	public String result(Model model) {

		model.addAttribute("name","daniel");
		model.addAttribute("age",18);
		return "hello";
	}

}

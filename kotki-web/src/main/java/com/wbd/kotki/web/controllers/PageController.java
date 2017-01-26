package com.wbd.kotki.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	

	@RequestMapping("/")
	public String getIndex(Model model){
		return "index";
	}
	
	@RequestMapping("/contact")
	public String getContact(Model model){
		model.addAttribute("title", "Kontakt");
		return "contact";
	}

}

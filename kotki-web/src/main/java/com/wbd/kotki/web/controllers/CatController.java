package com.wbd.kotki.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wbd.kotki.application.servicies.CatService;

@Controller
public class CatController {
	
	@Autowired
	private CatService cats;

	@RequestMapping("/")
	public String getIndex(Model model){
		model.addAttribute("cats", cats.getCatsList());
		model.addAttribute("unnCats", cats.getUnadopptedCatList());
		return "index";
	}
}

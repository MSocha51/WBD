package com.wbd.kotki.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wbd.kotki.application.servicies.CatService;
import com.wbd.kotki.model.entities.Cat;

@Controller
public class CatController {
	
	@Autowired
	private CatService cats;

	@RequestMapping("/")
	public String getIndex( Model model){
		model.addAttribute("cats", cats.getCatsList());
		model.addAttribute("unnCats", cats.getUnadopptedCatList());
		return "index";
	}
	@RequestMapping("/cats")
	public String getCats( Model model){
		model.addAttribute("cats", cats.getCatsList());
		model.addAttribute("unnCats", cats.getUnadopptedCatList());
		return "cats";
	}
	@RequestMapping("/cats/cat-{id}")
	public String getCat(@PathVariable Long id, Model model){
		Cat cat = cats.getByID(id);
		model.addAttribute("cat", cat);
		model.addAttribute("title", cat.getName());
		model.addAttribute("cats", cats.getCatsList());
		model.addAttribute("unnCats", cats.getUnadopptedCatList());
		return "cat";
	}
}

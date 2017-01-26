package com.wbd.kotki.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.wbd.kotki.application.servicies.CatService;
import com.wbd.kotki.model.entities.Cat;
import com.wbd.kotki.web.dtos.CatDTO;

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
		return "cat";
	}
	@RequestMapping("/contact")
	public String getContact( Model model){
		model.addAttribute("title", "Kontakt");
		return "contact";
	}
	@GetMapping("/addCat")
	public String getAddPerson(Model model){
		model.addAttribute("catDTO", new CatDTO());
		model.addAttribute("title", "Dodaj kota");
		return "addCat";
	}
	@PostMapping("/addCat")
	public String getAddPerson(Model model, @ModelAttribute("catDTO") @Valid CatDTO catDto, BindingResult result){
		if(result.hasErrors()){
			model.addAttribute(result.getClass()+".catDTO", result);
			model.addAttribute("catDTO", catDto);
			model.addAttribute("title", "Dodaj kota");
			return "addCat";
		}else{
			Long id = cats.addCat(catDto);
			return "redirect:/cats/cat-"+id;
		}
		
	}
}

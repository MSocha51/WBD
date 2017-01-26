package com.wbd.kotki.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@RequestMapping("/cats")
	public String getUnnadoptedCatsListPage( Model model){
		model.addAttribute("unnCats", cats.getUnadopptedCatList());
		return "cats";
	}
	@RequestMapping("/cats/cat-{id}")
	public String getCatPage(@PathVariable Long id, Model model,Long adopted){
		Cat cat = cats.getByID(id);
		model.addAttribute("cat", cat);
		model.addAttribute("title", cat.getName());
		Long one = new Long(1);
		if(one.equals(adopted) || cat.getOwner()!=null) {
			model.addAttribute("message", "Kotek jest już zaadoptowany");
			model.addAttribute("addopted", true);
		}else  model.addAttribute("addopted", false);
		
		return "cat";
	}
	@PreAuthorize("hasRole('ROLE_WORKER')")
	@GetMapping("/cats/cat-{id}/edit")
	public String getCatEditPage(@PathVariable Long id, Model model){
		Cat cat = cats.getByID(id);
		CatDTO catDto = cratreDto(cat);
		model.addAttribute("catDTO", catDto);
		model.addAttribute("title", "Edytuj: "+cat.getName());
		model.addAttribute("id", id);
		return "edit";
	}

	@PreAuthorize("hasRole('ROLE_WORKER')")
	@PostMapping("/cats/cat-{id}/edit")
	public String postCatEdit(Model model,@PathVariable Long id, @ModelAttribute("catDTO") @Valid CatDTO catDto, BindingResult result){
		if(result.hasErrors()){			
			model.addAttribute(result.getClass()+".catDTO", result);
			model.addAttribute("catDTO", catDto);
			model.addAttribute("title", "Dodaj kota");
			model.addAttribute("id", id);
			return "edit";
		}else{
			cats.addCat(catDto,id);			
			return "redirect:/cats/cat-"+id;
		}
		
		
	}
	@PreAuthorize("hasRole('ROLE_WORKER')")
	@PostMapping("/cats/cat-{id}/delete")
	public String postCatDelete(@PathVariable Long id){
			cats.deleteCat(id);
			return "redirect:/cats";		
	}
	@PreAuthorize("hasRole('ROLE_USER')")
	@PostMapping("/cats/cat-{id}/adopt")
	public String postCatAdopt(Model model, @PathVariable Long id){
			Cat cat = cats.getByID(id);
			if(cat.getOwner()==null){
				String mail = SecurityContextHolder.getContext().getAuthentication().getName();			
				cats.adoptCat(id, mail);
				return "redirect:/cats/cat-"+id+"?adopted=1";	
			}else{
				return "redirect:/cats/cat-"+id;
			}
				
	}
	@PreAuthorize("hasRole('ROLE_WORKER')")
	@GetMapping("/addCat")
	public String getAddPerson(Model model){
		model.addAttribute("catDTO", new CatDTO());
		model.addAttribute("title", "Dodaj kota");
		return "addCat";
	}
	@PreAuthorize("hasRole('ROLE_WORKER')")
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
	private CatDTO cratreDto(Cat cat) {
		CatDTO catDto = new CatDTO();
		catDto.setName(cat.getName());
		catDto.setBirthdayDate(cat.getBirthdayDate());
		catDto.setPaws(cat.getPaws().toString());
		catDto.setRace(cat.getRace().getRaceName());
		catDto.setSex(cat.getSex().toString());
		catDto.setSight(cat.getSight().toString());
		catDto.setSterizlization(cat.getSterizlization().toString());
		return catDto;
	}
}

package com.wbd.kotki.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wbd.kotki.application.servicies.UserService;
import com.wbd.kotki.model.entities.Client;
import com.wbd.kotki.web.dtos.RegisterDTO;
@Controller
public class LoginAndRegisterController {
	
	@Autowired
	private UserService users;

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Nieprawidłowy login albo hasło");
		if (logout != null)
			model.addAttribute("message", "Udało Ci się pomyślnie zalogować");
		return "login";
	}

	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			return "redirect:/login?logout";
		}else{
			return "redirect:/";
		}
		
	}
	
	@GetMapping("register")
	public String getRegisterPage(Model model){
		model.addAttribute("registerDto",new RegisterDTO());
		return "register";
	}
	
	@PostMapping("register")
	public String postRegister(Model model, @ModelAttribute("registerDto") @Valid RegisterDTO registerDto , BindingResult result){
		if(result.hasErrors()){
			model.addAttribute(result.getClass()+".registerDto", result);
			model.addAttribute("registerDto", registerDto);
			return "register";
		}else{
			users.addClientUser(registerDto);
			return "redirect:/";
		}
		
	}
	//@PreAuthorize("isAutenticated()")
	@RequestMapping("/profile")
	public String getProfile(Model model){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Client client = users.getByMail(username);
		model.addAttribute("client",client);
		model.addAttribute("title", "Twoje konto");
		return "profile";
	}

}

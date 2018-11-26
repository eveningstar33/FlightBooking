package com.dgs.flightreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dgs.flightreservation.entities.User;
import com.dgs.flightreservation.repos.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	// To use logging we need to define a field 
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);  

	@RequestMapping("/showReg")
	public String showRegistrationPage() {
		return "login/registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(@ModelAttribute User user) {
		userRepository.save(user); 
		return "login/login";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, ModelMap modelMap) {
		LOGGER.error("ERROR");
		LOGGER.warn("WARN");
		LOGGER.info("INFO");
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");

		User user = userRepository.findByEmail(email); 
		if (user.getPassword().equals(password)) {
			return "findFlights";
		} else {
			modelMap.addAttribute("msg", "Invalid email or password. Please try again.");
		}
		return "login/login";
	}
}

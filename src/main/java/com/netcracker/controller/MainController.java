package com.netcracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model, @RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		if (error != null) {
			model.addAttribute("error", "Invalid username or password!");
		}
		if (logout != null) {
			model.addAttribute("logout", "You've been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public String aboutPage(Model model) {
		return "about";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "admin";
	}

	@RequestMapping(value = "/curator", method = RequestMethod.GET)
	public String curatorPage(Model model) {
		return "curator";
	}

	@RequestMapping(value = "/hr", method = RequestMethod.GET)
	public String hrPage(Model model) {
		return "hr";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentPage(Model model) {
		return "student";
	}
}
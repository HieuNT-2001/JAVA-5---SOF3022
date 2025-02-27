package com.fpoly.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fpoly.model.Contact;
import com.fpoly.service.ContactService;

@Controller
@RequestMapping("/contact-us")
public class ContactController {

	private final ContactService cs;

	public ContactController(ContactService ContactService) {
		this.cs = ContactService;
	}

	@GetMapping
	public String index(Model model) {
		model.addAttribute("contact", new Contact());
		model.addAttribute("content", "client/contact");
		return "layout/base";
	}

	@PostMapping
	public String add(@ModelAttribute("contact") Contact ct) {
		cs.add(ct);
		return "redirect:/contact-us";
	}
}

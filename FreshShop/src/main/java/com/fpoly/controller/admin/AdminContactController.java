package com.fpoly.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.model.Contact;
import com.fpoly.service.ContactService;

@Controller
@RequestMapping("/admin/contact-us")
public class AdminContactController {

    private final ContactService contactService;

    public AdminContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public String list(Model model) {
        List<Contact> contacts = this.contactService.getAll();
        model.addAttribute("contacts", contacts);
        model.addAttribute("content", "admin/contact/list");
        return "layout/admin-base";
    }

}

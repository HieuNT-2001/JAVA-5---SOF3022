package com.fpoly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CaculatorController {

    @GetMapping("/caculator/form")
    public String showCaculatorForm() {
        return "caculator";
    }

    @PostMapping("/caculator/form")
    public String handleSubmit(double param1, double param2, Model model) {
        double perimeter = (param1 + param2) * 2;
        double area = param1 * param2;
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "caculator";
    }

}

package com.fpoly.fpoly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorld {
    @GetMapping("/poly/hello")
    public String getMethodName(Model model) {
        model.addAttribute("title", "Spring boot starter");
        model.addAttribute("content", "Hello World");
        return "HelloWorld";
    }

}

package com.hinhhoc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("navbar")
public class navbarController {

    @GetMapping("")
    public String showNavbar() {
        return "navbar/Master";
    }

    @GetMapping("/equation")
    public String showEquation() {
        return "navbar/Equation";
    }

    @PostMapping("/equation")
    public String handleEquation(HttpServletRequest request, Model model) {
        double a = Double.parseDouble(request.getParameter("paramA"));
        double b = Double.parseDouble(request.getParameter("paramB"));
        double c = Double.parseDouble(request.getParameter("paramC"));
        // quadratic equation
        double delta = b * b - 4 * a * c;
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            model.addAttribute("result", "Có hai nghiệm: " + x1 + " và " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            model.addAttribute("result", "Có một nghiệm: " + x);
        } else {
            model.addAttribute("result", "Không có nghiệm thực.");
        }
        return "navbar/Equation";
    }

    @GetMapping("/exchange")
    public String showExchangeForm() {
        return "navbar/Exchange";
    }

    @PostMapping("/exchange")
    public String handleExchange(HttpServletRequest request, Model model) {
        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("curruency"));
        double result = amount / rate;
        model.addAttribute("result", result);
        return "navbar/Exchange";
    }

    @GetMapping("/leapyear")
    public String showLeapYearForm() {
        return "navbar/LeapYear";
    }

    @PostMapping("/leapyear")
    public String handleLeapYear(HttpServletRequest request, Model model) {
        int year = Integer.parseInt(request.getParameter("year"));
        boolean isLeapYear = false;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                isLeapYear = year % 400 == 0;
            } else {
                isLeapYear = true;
            }
        }
        model.addAttribute("year", year);
        model.addAttribute("result", isLeapYear);
        return "navbar/LeapYear";
    }

}

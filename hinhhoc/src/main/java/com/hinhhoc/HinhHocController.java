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
@RequestMapping("hinh-hoc")
public class HinhHocController {

    @GetMapping("hinh-chu-nhat")
    public String showFormRetangle() {
        return "geometry/HinhChuNhat";
    }

    @PostMapping("hinh-chu-nhat")
    public String handleRetangle(HttpServletRequest request, Model model) {
        double param1 = Double.parseDouble(request.getParameter("param1"));
        double param2 = Double.parseDouble(request.getParameter("param2"));
        double perimeter = (param1 + param2) * 2;
        double area = param1 * param2;
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "geometry/HinhChuNhat";
    }

    @GetMapping("hinh-tam-giac")
    public String showFormTriangle() {
        return "geometry/HinhTamGiac";
    }

    @PostMapping("hinh-tam-giac")
    public String handleTriangle(HttpServletRequest request, Model model) {
        double param1 = Double.parseDouble(request.getParameter("param1"));
        double param2 = Double.parseDouble(request.getParameter("param2"));
        double param3 = Double.parseDouble(request.getParameter("param3"));
        double perimeter = param1 + param2 + param3;
        double p = perimeter / 2;
        double area = Math.sqrt(p * (p - param1) * (p - param2) * (p - param3));
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "geometry/HinhTamGiac";
    }

    @GetMapping("hinh-tron")
    public String showFormCircle() {
        return "geometry/HinhTron";
    }

    @PostMapping("hinh-tron")
    public String handleCircle(HttpServletRequest request, Model model) {
        double radius = Double.parseDouble(request.getParameter("radius"));
        double perimeter = radius * 2 * Math.PI;
        double area = radius * radius * Math.PI;
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("area", area);
        return "geometry/HinhTron";
    }

}

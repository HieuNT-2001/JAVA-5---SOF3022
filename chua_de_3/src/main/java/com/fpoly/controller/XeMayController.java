package com.fpoly.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fpoly.model.XeMay;
import com.fpoly.service.XeMayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/xemay")
public class XeMayController {

    private final XeMayService xeMayService;

    public XeMayController(XeMayService xeMayService) {
        this.xeMayService = xeMayService;
    }

    @GetMapping("/hien-thi")
    public String showForm(Model model) {
        XeMay xeMay = new XeMay();
        List<XeMay> listXeMay = xeMayService.getAllXeMay();
        model.addAttribute("xeMay", xeMay);
        model.addAttribute("listXeMay", listXeMay);
        System.out.println(listXeMay);
        model.addAttribute("title", "Xe Máy");
        model.addAttribute("content", "layout/home");
        return "layout/base";
    }

    @PostMapping("/add")
    public String addXeMay(@ModelAttribute("XeMay") XeMay xeMay) {
        xeMayService.saveXeMay(xeMay);
        return "redirect:/xemay/hien-thi";
    }

    @GetMapping("/remove/{id}")
    public String removeXeMay(@PathVariable("id") int id) {
        xeMayService.deleteXeMay(id);
        return "redirect:/xemay/hien-thi";
    }

}

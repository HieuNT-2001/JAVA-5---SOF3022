package com.hinhhoc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @RequestMapping("my-url/content")
    public String method11(Model model) {
        model.addAttribute("var", "FPT <b>polytechnic</b>");
        return "demo/my-template/content";
    }

    @RequestMapping("my-url/attribute")
    public String method2(Model model) {
        model.addAttribute("photo", "photo.png");
        model.addAttribute("ho", "Nguyễn");
        model.addAttribute("ten", "Nghiệm");
        model.addAttribute("myclass", "btn-danger");
        return "demo/my-template/attribute";
    }

    @RequestMapping("my-url/support")
    public String method3(Model model) {
        Student bean = Student.builder().fullname("Nguyễn Nghiệm").mark(9.5).build();
        model.addAttribute("student", bean);
        return "demo/my-template/support";
    }

}

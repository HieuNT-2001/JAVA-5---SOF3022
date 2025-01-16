package com.hinhhoc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping("poly/student")
    public String studentDetail(Model model) {
        model.addAttribute("fullname", "Nguyễn Trung Hiếu");
        model.addAttribute("mark", 7.75);
        model.addAttribute("gender", true);
        model.addAttribute("birthday", new Date());
        model.addAttribute("photo", "Photo.png");
        return "demo/student";
    }

    @RequestMapping("poly/student/bean")
    public String studentDetailBean(Model model) {
        Student bean = Student.builder()
                .fullname("Nguyễn Trung Hiếu")
                .mark(8).gender(true).build();
        model.addAttribute("student", bean);
        return "demo/student2";
    }

}

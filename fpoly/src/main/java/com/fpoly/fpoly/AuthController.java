package com.fpoly.fpoly;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @GetMapping("/login/form")
    public String showLoginForm() {
        return "form";
    }

    @PostMapping("/login/form")
    public String handleLogin(String username, String password, Model model) {
        if (username.equals("poly") && password.equals("123")) {
            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("alertClass", "alert-success");
        } else {
            model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu!");
            model.addAttribute("alertClass", "alert-danger");
        }
        return "form";
    }

}

package com.fpoly.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String handleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request) {
        String message = "Sai tên đăng nhập hoặc mật khẩu!";
        if (username.equals("admin") && password.equals("123")) {
            message = "Đăng nhập thành công!";
        }
        request.setAttribute("message", message);
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        return "HelloWorld";
    }

    @GetMapping("upload")
    public String showUpload() {
        return "upload";
    }

    @PostMapping("upload")
    public String uploadFile(@RequestPart("photo_file") MultipartFile file, Model model) {
        if (!file.isEmpty()) {
            try {
                // Tên thư mục lưu ảnh
                String dir = System.getProperty("user.dir") + "/photos";
                // String dir = servletContext.getRealPath("/photos");

                // Tạo một đối tượng ảnh file cho thư mục lưu ảnh
                File uploadDir = new File(dir);

                // Tạo thư mục nếu chưa tồn tại
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                // Lấy tên gốc của tệp
                String originFilename = file.getOriginalFilename();

                // Tạo tên ảnh duy nhất
                String safeFileName = UUID.randomUUID().toString() + "_" + originFilename;

                // Đường dẫn tệp đích trên hệ thống
                File destination = new File(dir, safeFileName);

                // Lưu tệp
                file.transferTo(destination);

                // URL truy cập tệp qua trình duyệt
                String fileUrl = "/photos/" + safeFileName;

                // Gửi URL tới model để hiển thị trong view
                model.addAttribute("fileUrl", fileUrl);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "HelloWorld";
    }

}

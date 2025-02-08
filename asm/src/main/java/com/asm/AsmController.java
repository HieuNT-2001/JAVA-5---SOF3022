package com.asm;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AsmController {

    @GetMapping({ "/", "/home" })
    public String home() {
        return "layout";
    }

    @GetMapping("/tien-dien")
    public String showElectricityBillForm() {
        return "electricity_bill";
    }

    @PostMapping("/tien-dien")
    public String handleElectricityBill(HttpServletRequest request, Model model) {
        int electricAmount = Integer.parseInt(request.getParameter("electric-amount"));
        if (electricAmount < 0) {
            model.addAttribute("message", "Số điện không hợp lệ!");
        } else {
            double total = 0;
            if (electricAmount <= 50) {
                total = electricAmount * 1893;
            } else if (electricAmount <= 100) {
                total = 50 * 1893 + (electricAmount - 50) * 1956;
            } else if (electricAmount <= 200) {
                total = 50 * 1893 + 50 * 1956 + (electricAmount - 100) * 2271;
            } else if (electricAmount <= 300) {
                total = 50 * 1893 + 50 * 1956 + 100 * 2271 + (electricAmount - 200) * 2860;
            } else if (electricAmount <= 400) {
                total = 50 * 1893 + 50 * 1956 + 100 * 2271 + 100 * 2860 + (electricAmount - 300) * 3197;
            } else {
                total = 50 * 1893 + 50 * 1956 + 100 * 2271 + 100 * 2860 + 100 * 2927 + (electricAmount - 400) * 3302;
            }
            model.addAttribute("total", total);
        }
        return "electricity_bill";
    }

    @GetMapping("/tien-nuoc")
    public String showElecWaterForm() {
        return "water_bill";
    }

    @PostMapping("/tien-nuoc")
    public String handleWaterBill(HttpServletRequest request, Model model) {
        int waterAmount = Integer.parseInt(request.getParameter("water-amount"));
        if (waterAmount < 0) {
            model.addAttribute("message", "Số nước không hợp lệ!");
        } else {
            double total = 0;
            if (waterAmount <= 10) {
                total = waterAmount * 5973;
            } else if (waterAmount <= 20) {
                total = 10 * 5973 + (waterAmount - 10) * 7052;
            } else if (waterAmount <= 30) {
                total = 10 * 5973 + 10 * 7052 + (waterAmount - 20) * 8669;
            } else {
                total = 10 * 5973 + 10 * 7052 + 10 * 8669 + (waterAmount - 30) * 15929;
            }
            double vat = total * 0.05;
            double environmenFee = total * 0.1;
            double payment = total + vat + environmenFee;
            model.addAttribute("total", total);
            model.addAttribute("vat", vat);
            model.addAttribute("environmenFee", environmenFee);
            model.addAttribute("payment", payment);

        }
        return "water_bill";
    }

    @GetMapping("/cuoc-dien-thoai")
    public String showPhoneBillForm() {
        return "phone_bill";
    }

    @PostMapping("/cuoc-dien-thoai")
    public String handlePhoneBill(HttpServletRequest request, Model model) {
        int phoneAmnout = Integer.parseInt(request.getParameter("phone-amount"));
        if (phoneAmnout < 0) {
            model.addAttribute("message", "Số phút gọi không hợp lệ!");
        } else {
            double total = 25000;
            if (phoneAmnout <= 50) {
                total = phoneAmnout * 600;
            } else if (phoneAmnout <= 100) {
                total = 50 * 600 + (phoneAmnout - 50) * 400;
            } else {
                total = 50 * 600 + 50 * 400 + (phoneAmnout - 100) * 200;
            }
            model.addAttribute("total", total);
        }
        return "phone_bill";
    }

    @GetMapping("vay-ngan-hang")
    public String showBankLoanForm() {
        return "bank_loan";
    }

    @PostMapping("vay-ngan-hang")
    public String handleBankLoan(HttpServletRequest request, Model model) {
        double loanAmount = Double.parseDouble(request.getParameter("loan-amount"));
        double interestRate = Double.parseDouble(request.getParameter("interest-rate")) / 100;
        int loanDuration = Integer.parseInt(request.getParameter("loan-duration"));
        if (loanAmount < 0 || interestRate < 0 || loanDuration < 0) {
            model.addAttribute("message", "Dữ liệu không hợp lệ!");
        } else {
            ArrayList<Object> datas = new ArrayList<>();
            double principal = loanAmount / loanDuration;
            for (int i = 0; i < loanDuration; i++) {
                double interest = loanAmount * interestRate;
                double monthlyPayment = principal + interest;
                loanAmount -= principal;
                datas.add(new Object[] { principal, interest, monthlyPayment, loanAmount });
            }
            model.addAttribute("datas", datas);
        }
        return "bank_loan";
    }

}

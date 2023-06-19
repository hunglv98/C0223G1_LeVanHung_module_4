package com.example.ss3.controller;

import com.example.ss3.model.Email;
import com.example.ss3.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @RequestMapping("")
    public String show(Model model) {
        model.addAttribute("language", emailService.getLanguageList());
        model.addAttribute("size", emailService.getPageList());
        model.addAttribute("email", new Email());
        return "index";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute Email email) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("size", email.getSize());
        model.addAttribute("filter", email.isFilter());
        model.addAttribute("signature", email.getSignature());
        return "show";
    }
}

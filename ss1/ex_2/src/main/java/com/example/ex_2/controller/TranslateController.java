package com.example.ex_2.controller;

import com.example.ex_2.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TranslateController {
    @Autowired
    private ITranslateService translateService;

    @GetMapping("")
    public String show() {
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String english, Model model) {
        model.addAttribute("english", english);
        model.addAttribute("vietnamese", translateService.getVietnamese(english));
        return "index";
    }
}

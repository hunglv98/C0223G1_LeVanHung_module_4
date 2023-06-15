package com.example.ss1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("")
    public String convert() {
        return "index";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam("usd") int usd, @RequestParam("rate") int rate, Model model) {
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", (usd * rate));
        return "index";
    }

}

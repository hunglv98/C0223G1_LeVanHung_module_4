package com.example.ss1.controller;

import com.example.ss1.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private IConvertService convertService;
    @GetMapping("")
    public String convert() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") double usd, @RequestParam("rate") double rate, Model model) {
        model.addAttribute("usd", usd);
        model.addAttribute("rate", rate);
        model.addAttribute("vnd", convertService.getVnd(usd,rate));
        return "index";
    }

}

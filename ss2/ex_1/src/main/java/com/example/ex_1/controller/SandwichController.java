package com.example.ex_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("")
    public String show() {
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment, Model model) {
        if (condiment == null) {
            model.addAttribute("result", "Not Selected");
        } else
            model.addAttribute("result", Arrays.toString(condiment));
        return "index";
    }
}
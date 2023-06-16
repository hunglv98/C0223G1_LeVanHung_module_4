package com.example.ex_2.controller;

import com.example.ex_2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String show() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculate(@RequestParam double num1, @RequestParam double num2, @RequestParam String calculation, Model model) {
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", calculatorService.getResult(num1, num2, calculation));
        return "index";
    }
}

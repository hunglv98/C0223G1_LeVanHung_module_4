package com.example.ex_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class TranslateController {
    @GetMapping("")
    public String show() {
        return "index";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model) {
        Map<String, String> list = new LinkedHashMap<>();
        list.put("Cat", "Con Mèo");
        list.put("Dog", "Con Chó");
        list.put("Lion", "Sư Tủ");
        list.put("Tiger", "Con Hổ");
        String result = "";
        for (String s : list.keySet()) {
            if (s.equals(english)) {
                result = list.get(s);
                break;
            }
        }
        if (result.equals("")) {
            result = "Not found";
        }
        model.addAttribute("english", english);
        model.addAttribute("vietnamese", result);
        return "index";
    }
}

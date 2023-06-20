package com.example.demo1.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
//    @Autowired
//    private IProductService productService;
    @GetMapping("")
    public String getList(Model model){
//        List<Product> list = productService.getList();
//        model.addAttribute("list",list);
        return "/list";
    }
}

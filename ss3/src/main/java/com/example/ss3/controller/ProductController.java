package com.example.ss3.controller;

import com.example.ss3.model.Product;
import com.example.ss3.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getList(Model model) {
        List<Product> list = productService.getList();
        model.addAttribute("list", list);
        return "/list";
    }

    @GetMapping("/show-form-add")
    public String showFormAdd(Model model) {
        model.addAttribute("product", new Product());
        return "/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.addProduct(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (productService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy đối tượng này");
        } else {
            productService.deleteProduct(id);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công");
        }
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        if (product == null) {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy đối tượng này");
            return "redirect:/";
        } else {
            model.addAttribute("product", product);
            return "/edit";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.editProduct(product);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        List<Product> list = productService.findByName(name);
        if (list.size() == 0) {
            return "redirect:/";
        } else {
            model.addAttribute("list", list);
            return "/list";
        }
    }
}

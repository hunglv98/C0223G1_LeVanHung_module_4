package com.example.ex1.controller;

import com.example.ex1.model.Blog;
import com.example.ex1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        List<Blog> list = blogService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/show-form-add")
    public String showFormAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(LocalDate.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found Object");
        } else {
            blogService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        }
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found Object");
            return "redirect:/blog";
        } else {
            model.addAttribute("blog", blogService.findById(id));
            return "edit";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blog.setDate(LocalDate.now());
        blogService.update(blog);
        redirectAttributes.addFlashAttribute("message", "Update Successfully");
        return "redirect:/blog";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam String name, Model model) {
        if (name.equals("")) {
            return "redirect:/blog";
        } else {
            List<Blog> list = blogService.searchByName(name);
            model.addAttribute("list", list);
            return "list";
        }
    }
}

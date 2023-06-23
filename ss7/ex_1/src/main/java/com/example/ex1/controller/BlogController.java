package com.example.ex1.controller;

import com.example.ex1.model.Blog;
import com.example.ex1.model.BlogType;
import com.example.ex1.service.IBlogService;
import com.example.ex1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 2, sort = "date", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> list = blogService.findAll(pageable);
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        List<BlogType> blogTypeList = blogTypeService.findAllByStatusIsFalse();
        model.addAttribute("blog", new Blog());
        model.addAttribute("blogTypeList", blogTypeList);
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
            List<BlogType> blogTypeList = blogTypeService.findAllByStatusIsFalse();
            model.addAttribute("blog", blogService.findById(id));
            model.addAttribute("blogTypeList", blogTypeList);
            return "edit";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        if (blogService.findById(blog.getId()) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found Object");
        } else {
            blogService.update(blog);
            redirectAttributes.addFlashAttribute("message", "Update Successfully");
        }
        return "redirect:/blog";
    }

    @PostMapping("/search")
    public String searchByName(@RequestParam String name, Model model, @PageableDefault(size = 2) Pageable pageable) {
        if (name.equals("")) {
            return "redirect:/blog";
        } else {
            Page<Blog> list = blogService.searchByName(name, pageable);
            model.addAttribute("list", list);
            return "list";
        }
    }
}

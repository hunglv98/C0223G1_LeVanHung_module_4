package com.example.ex1.controller;

import com.example.ex1.model.BlogType;
import com.example.ex1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogType")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;

    @GetMapping("")
    public String showList(Model model, @PageableDefault(size = 2, sort = "name") Pageable pageable) {
        Page<BlogType> list = blogTypeService.findAllByStatusFalse(pageable);
        model.addAttribute("list", list);
        return "listType";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (blogTypeService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not found Object");
        } else {
            blogTypeService.delete(id);
            redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        }
        return "redirect:/blogType";
    }

    @GetMapping("add")
    public String showAddForm(Model model) {
        model.addAttribute("blogType", new BlogType());
        return "addType";
    }

    @PostMapping("add")
    public String add(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {
        blogTypeService.save(blogType);
        redirectAttributes.addFlashAttribute("message", "Create Successfully");
        return "redirect:/blogType";
    }

    @GetMapping("edit/{id}")
    public String showFormEdit(@PathVariable int id, RedirectAttributes redirectAttributes, Model model) {
        if (blogTypeService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Object");
            return "redirect:/blogType";
        } else {
            model.addAttribute("blogType", blogTypeService.findById(id));
            return "editType";
        }
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute BlogType blogType, RedirectAttributes redirectAttributes) {
        if (blogTypeService.findById(blogType.getId()) == null) {
            redirectAttributes.addFlashAttribute("message", "Not Found Object");
        } else {
            blogTypeService.update(blogType);
            redirectAttributes.addFlashAttribute("message", "Update Successfully");
        }
        return "redirect:/blogType";
    }
}

package com.example.ex_2.controller;

import com.example.ex_2.dto.MusicDto;
import com.example.ex_2.model.Music;
import com.example.ex_2.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping()
    public String showList(@PageableDefault(size = 3) Pageable pageable, Model model) {
        Page<Music> list = musicService.getList(pageable);
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "add";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        Music musicEntity = new Music();
        BeanUtils.copyProperties(musicDto, musicEntity);
        musicService.add(musicEntity);
        redirectAttributes.addFlashAttribute("message", "CREATE SUCCESSFULLY");
        return "redirect:/music";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (musicService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "NOT FOUND OBJECT");
        } else {
            musicService.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "REMOVE SUCCESSFULLY");
        }
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (musicService.findById(id) == null) {
            redirectAttributes.addFlashAttribute("message", "NOT FOUND OBJECT");
            return "redirect:/music";
        }
        Music music = musicService.findById(id);
        MusicDto musicDto = new MusicDto();
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute MusicDto musicDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDto, music);
        musicService.update(music);
        redirectAttributes.addFlashAttribute("message", "UPDATE SUCCESSFULLY!!!");
        return "redirect:/music";
    }
}

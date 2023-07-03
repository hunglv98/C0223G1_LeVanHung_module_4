package com.example.ex_1.controller;


import com.example.ex_1.model.Blog;
import com.example.ex_1.service.IBlogService;
import com.example.ex_1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> showList() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> add(@RequestBody Blog blog) {
        if (blogService.findById(blog.getId()) != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> detail(@PathVariable int id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Blog blog = blogService.findById(id);
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> edit(@PathVariable int id, @RequestBody Blog blog) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blog.setId(id);
            blogService.update(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (blogService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/search/{name}")
    @CrossOrigin("*")
    public ResponseEntity<List<Blog>> searchByName(@PathVariable String name) {
        List<Blog> blogList = blogService.searchByName(name);
        if (blogList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/showByNumber/{number}")
    public ResponseEntity<List<Blog>> showListByNumber(@PathVariable int number) {
        return new ResponseEntity<>(blogService.getListByNumber(number), HttpStatus.OK);
    }
}

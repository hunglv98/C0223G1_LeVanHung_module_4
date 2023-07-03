package com.example.ex_1.controller;


import com.example.ex_1.model.Blog;
import com.example.ex_1.model.BlogType;
import com.example.ex_1.service.IBlogService;
import com.example.ex_1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/blogType")
public class BlogTypeController {
    @Autowired
    private IBlogTypeService blogTypeService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<BlogType>> showList() {
        List<BlogType> list = blogTypeService.findAllByStatusIsFalse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> add(@RequestBody BlogType blogType) {
        if (blogTypeService.findById(blogType.getId()) != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        blogTypeService.save(blogType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        if (blogTypeService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogTypeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> edit(@PathVariable int id, @RequestBody BlogType blogType) {
        if (blogTypeService.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogType.setId(id);
            blogTypeService.update(blogType);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> showByType(@PathVariable int id) {
        List<Blog> list = blogService.findBlogByBlogType_Id(id);
        if (list.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}

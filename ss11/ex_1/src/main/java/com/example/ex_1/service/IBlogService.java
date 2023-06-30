package com.example.ex_1.service;


import com.example.ex_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void delete(int id);

    Page<Blog> searchByName(String name, Pageable pageable);

    List<Blog> findBlogByBlogType_Id(int id);
}

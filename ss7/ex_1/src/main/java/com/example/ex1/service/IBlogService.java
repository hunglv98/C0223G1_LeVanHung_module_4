package com.example.ex1.service;

import com.example.ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void delete(int id);

    Page<Blog> searchByName(String name, Pageable pageable);
}

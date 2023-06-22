package com.example.ex1.service;

import com.example.ex1.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void delete(int id);

    List<Blog> searchByName(String name);
}

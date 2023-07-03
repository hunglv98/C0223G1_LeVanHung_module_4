package com.example.ex_1.service;


import com.example.ex_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void delete(int id);

    List<Blog> searchByName(String name);

    List<Blog> findBlogByBlogType_Id(int id);

    List<Blog> getListByNumber(int num);
}

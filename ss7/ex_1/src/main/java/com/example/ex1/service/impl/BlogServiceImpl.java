package com.example.ex1.service.impl;

import com.example.ex1.model.Blog;
import com.example.ex1.repo.IBlogRepo;
import com.example.ex1.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepo blogRepo;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepo.findBlogByStatusIsFalse(pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepo.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id).orElse(
                null
        );
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        blog.setStatus(true);
        blogRepo.save(blog);
    }

    @Override
    public Page<Blog> searchByName(String name, Pageable pageable) {
        return blogRepo.findBlogByNameContainingAndStatusIsFalse(name, pageable);
    }
}

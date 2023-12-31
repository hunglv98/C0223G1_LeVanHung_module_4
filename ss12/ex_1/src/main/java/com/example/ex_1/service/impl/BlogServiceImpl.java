package com.example.ex_1.service.impl;

import com.example.ex_1.model.Blog;
import com.example.ex_1.repo.IBlogRepo;
import com.example.ex_1.service.IBlogService;
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
    public List<Blog> findAll() {
        return blogRepo.findBlogByStatusIsFalse();
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
    public List<Blog> searchByName(String name) {
        return blogRepo.findBlogByNameContainingAndStatusIsFalse(name);
    }

    @Override
    public List<Blog> findBlogByBlogType_Id(int id) {
        return blogRepo.findBlogByBlogType_Id(id);
    }

    @Override
    public List<Blog> getListByNumber(int num) {
        return blogRepo.getListByNumber(num);
    }
}

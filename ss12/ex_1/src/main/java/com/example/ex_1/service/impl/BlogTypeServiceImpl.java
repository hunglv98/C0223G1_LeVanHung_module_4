package com.example.ex_1.service.impl;


import com.example.ex_1.model.BlogType;
import com.example.ex_1.repo.IBlogTypeRepo;
import com.example.ex_1.service.IBlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTypeServiceImpl implements IBlogTypeService {
    @Autowired
    private IBlogTypeRepo blogTypeRepo;


    @Override
    public List<BlogType> findAllByStatusIsFalse() {
        return blogTypeRepo.findAllByStatusIsFalse();
    }

    @Override
    public void save(BlogType blogType) {
        blogTypeRepo.save(blogType);
    }

    @Override
    public void update(BlogType blogType) {
        blogTypeRepo.save(blogType);
    }

    @Override
    public void delete(int id) {
        BlogType blogType = findById(id);
        blogType.setStatus(true);
        blogTypeRepo.save(blogType);
    }

    @Override
    public BlogType findById(int id) {
        return blogTypeRepo.findById(id).orElse(null);
    }

    @Override
    public Page<BlogType> findAllByStatusFalse(Pageable pageable) {
        return blogTypeRepo.findAllByStatusFalse(pageable);
    }
}

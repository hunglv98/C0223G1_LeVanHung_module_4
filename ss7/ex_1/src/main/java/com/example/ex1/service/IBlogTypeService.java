package com.example.ex1.service;

import com.example.ex1.model.BlogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogTypeService {
    List<BlogType> findAllByStatusIsFalse();

    void save(BlogType blogType);

    void update(BlogType blogType);

    void delete(int id);

    BlogType findById(int id);

    Page<BlogType> findAllByStatusFalse(Pageable pageable);
}

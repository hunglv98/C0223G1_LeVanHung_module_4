package com.example.ex1.repo;

import com.example.ex1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    Page<Blog> findBlogByStatusIsFalse(Pageable pageable);

    Page<Blog> findBlogByNameContainingAndStatusIsFalse(String name, Pageable pageable);

}

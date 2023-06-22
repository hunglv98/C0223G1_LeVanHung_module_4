package com.example.ex1.repo;

import com.example.ex1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    List<Blog> findBlogByNameContaining(String name);
}

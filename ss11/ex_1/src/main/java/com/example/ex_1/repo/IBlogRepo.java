package com.example.ex_1.repo;


import com.example.ex_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    List<Blog> findBlogByStatusIsFalse();

    Page<Blog> findBlogByNameContainingAndStatusIsFalse(String name, Pageable pageable);

    List<Blog> findBlogByBlogType_Id(int id);

}

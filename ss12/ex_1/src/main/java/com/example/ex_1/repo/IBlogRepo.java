package com.example.ex_1.repo;


import com.example.ex_1.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    List<Blog> findBlogByStatusIsFalse();

    List<Blog> findBlogByNameContainingAndStatusIsFalse(String name);

    List<Blog> findBlogByBlogType_Id(int id);

    @Query(nativeQuery = true, value = "select * from blog where status=false limit :num")
    List<Blog> getListByNumber(@Param("num") int num);

}

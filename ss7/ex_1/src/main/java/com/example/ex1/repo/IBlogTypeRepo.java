package com.example.ex1.repo;

import com.example.ex1.model.BlogType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogTypeRepo extends JpaRepository<BlogType, Integer> {
    List<BlogType> findAllByStatusIsFalse();

    Page<BlogType> findAllByStatusFalse(Pageable pageable);
}

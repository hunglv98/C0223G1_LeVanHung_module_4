package com.example.ex_1.repo;

import com.example.ex_1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book, Integer> {
}

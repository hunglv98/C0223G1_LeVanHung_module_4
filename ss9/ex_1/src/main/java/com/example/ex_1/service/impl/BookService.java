package com.example.ex_1.service.impl;

import com.example.ex_1.model.Book;
import com.example.ex_1.repo.IBookRepo;
import com.example.ex_1.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepo bookRepo;

    @Override
    public List<Book> getList() {
        return bookRepo.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void update(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void delete(int id) {
        bookRepo.delete(findById(id));
    }

    @Override
    public Book findById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

}

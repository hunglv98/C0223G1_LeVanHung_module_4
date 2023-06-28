package com.example.ex_1.service;

import com.example.ex_1.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getList();

    void add(Book book);

    void update(Book book);

    void delete(int id);

    Book findById(int id);
}

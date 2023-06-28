package com.example.ex_1.service;

import com.example.ex_1.model.Book;
import com.example.ex_1.model.Booking;

import java.util.List;

public interface IBookingService {
    boolean existsAllByCode(int code);

    List<Booking> getList();

    void add(Book book, int code);

    void deleteById(int id);

    Booking findByIdBooking(int idBooking);
}

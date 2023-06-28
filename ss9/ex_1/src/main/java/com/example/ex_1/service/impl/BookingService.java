package com.example.ex_1.service.impl;

import com.example.ex_1.model.Book;
import com.example.ex_1.model.Booking;
import com.example.ex_1.repo.IBookingRepo;
import com.example.ex_1.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepo bookingRepo;

    @Override
    public boolean existsAllByCode(int code) {
        return bookingRepo.existsAllByCode(code);
    }

    @Override
    public List<Booking> getList() {
        return bookingRepo.findAll();
    }

    @Override
    public void add(Book book, int code) {
        Booking booking = new Booking();
        booking.setDateBooking(LocalDate.now());
        booking.setCode(code);
        booking.setBook(book);
        bookingRepo.save(booking);
    }


    @Override
    public void deleteById(int id) {
        bookingRepo.deleteById(id);
    }

    @Override
    public Booking findByIdBooking(int idBooking) {
        return bookingRepo.findByCode(idBooking);
    }
}

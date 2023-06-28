package com.example.ex_1.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate dateBooking;
    private int code;
    @ManyToOne
    private Book book;

    public Booking() {
    }

    public Booking(int id, LocalDate dateBooking, int code, Book book) {
        this.id = id;
        this.dateBooking = dateBooking;
        this.code = code;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int idBooking) {
        this.code = idBooking;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

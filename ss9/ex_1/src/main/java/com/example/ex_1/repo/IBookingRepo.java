package com.example.ex_1.repo;

import com.example.ex_1.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingRepo extends JpaRepository<Booking, Integer> {
    Booking findByCode(int id);

    boolean existsAllByCode(int code);
}

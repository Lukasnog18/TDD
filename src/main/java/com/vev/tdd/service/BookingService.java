package com.vev.tdd.service;

import com.vev.tdd.model.BookingModel;
import com.vev.tdd.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Period;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    public int daysCalculator(String name) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
        return Period.between(bookingModelOptional.get().getCheckIn(), bookingModelOptional.get().getCheckOut()).getDays();
    }

    public String SearchNameById(String id) {
        Optional<BookingModel> bookingModelOptional = bookingRepository.findById(id);
        return bookingModelOptional.get().getReserveName();
    }
}

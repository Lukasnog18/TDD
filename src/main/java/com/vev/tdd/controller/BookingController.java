package com.vev.tdd.controller;

import com.vev.tdd.model.BookingModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @GetMapping
    @ResponseBody
    public String getAll(){
        return "OK";
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<BookingModel> save (@RequestBody BookingModel bookingModel) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
    }

}

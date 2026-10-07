package com.autocare.controller;

import com.autocare.model.Booking;
import com.autocare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class BookingController {

    @Autowired
    private BookingRepository repository;

    @PostMapping("bookings")
    public Map<String, Object> createBooking(@RequestBody Booking booking) {
        Map<String, Object> response = new HashMap<>();
        try {
            repository.save(booking);
            response.put("success", true);
            response.put("message", "Booking confirmed!");
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }

    @GetMapping("bookings")
    public Map<String, Object> getBookings() {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("success", true);
            response.put("bookings", repository.findAll());
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", e.getMessage());
        }
        return response;
    }
}
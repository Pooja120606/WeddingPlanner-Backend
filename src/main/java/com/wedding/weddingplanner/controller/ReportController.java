package com.wedding.weddingplanner.controller;

import com.wedding.weddingplanner.model.Booking;
import com.wedding.weddingplanner.repository.BookingRepository;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import com.wedding.weddingplanner.repository.VendorRepository;
import com.wedding.weddingplanner.model.Vendor;

import com.wedding.weddingplanner.repository.UserRepository;
import com.wedding.weddingplanner.model.User;
import com.wedding.weddingplanner.enums.Role;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {

    private final BookingRepository bookingRepository;

    private final VendorRepository vendorRepository;

    private final UserRepository userRepository;

   public ReportController(BookingRepository bookingRepository,
                        VendorRepository vendorRepository,
                        UserRepository userRepository) {

    this.bookingRepository = bookingRepository;
    this.vendorRepository = vendorRepository;
    this.userRepository = userRepository;
    }

    @GetMapping("/bookings")
    public List<Booking> getBookingReport(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {

        return bookingRepository.findBookingsBetween(from, to);
    }
    @GetMapping("/vendors")
    public List<Vendor> getVendorReport() {

        return vendorRepository.findAll();
    }
   @GetMapping("/users")
    public List<User> getUserReport() {
        return userRepository.findByRole(Role.CLIENT);
    }
}
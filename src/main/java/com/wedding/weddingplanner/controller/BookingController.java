package com.wedding.weddingplanner.controller;

import com.wedding.weddingplanner.model.Booking;
import com.wedding.weddingplanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "http://localhost:8080")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    // CLIENT creates booking
    @PostMapping("/create/{vendorId}")
    public Booking createBooking(@PathVariable Long vendorId,
                                 @RequestBody Booking booking,
                                 Authentication authentication) {

        return bookingService.createBooking(vendorId, booking, authentication.getName());
    }

    // CLIENT views their bookings
    @GetMapping("/client")
    public List<Booking> getClientBookings(Authentication authentication) {

        return bookingService.getClientBookings(authentication.getName());
    }

    // VENDOR views their bookings
    @GetMapping("/vendor")
    public List<Booking> getVendorBookings(Authentication authentication) {

        return bookingService.getVendorBookings(authentication.getName());
    }

    // ADMIN views all bookings
    @GetMapping("/admin")
    public List<Booking> getAllBookings() {

        return bookingService.getAllBookings();
    }

    // ADMIN confirms booking
    @PutMapping("/confirm/{id}")
    public ResponseEntity<String> confirmBooking(@PathVariable Long id) {

        bookingService.updateBookingStatus(id, "CONFIRMED");

        return ResponseEntity.ok("Booking confirmed");
    }

    // ADMIN cancels booking
    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long id) {

        bookingService.updateBookingStatus(id, "CANCELLED");

        return ResponseEntity.ok("Booking cancelled");
    }

    // ADMIN deletes booking
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {

        bookingService.deleteBooking(id);

        return ResponseEntity.ok("Booking deleted");
    }
}
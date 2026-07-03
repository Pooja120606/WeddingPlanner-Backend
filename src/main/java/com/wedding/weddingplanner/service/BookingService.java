package com.wedding.weddingplanner.service;

import com.wedding.weddingplanner.model.Booking;
import com.wedding.weddingplanner.model.User;
import com.wedding.weddingplanner.model.Vendor;
import com.wedding.weddingplanner.repository.BookingRepository;
import com.wedding.weddingplanner.repository.UserRepository;
import com.wedding.weddingplanner.repository.VendorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VendorRepository vendorRepository;

    // CLIENT books vendor
    public Booking createBooking(Long vendorId, Booking booking, String clientEmail) {

        User client = userRepository.findByEmail(clientEmail)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        booking.setClient(client);
        booking.setVendor(vendor);
        booking.setStatus("REQUESTED");

        return bookingRepository.save(booking);
    }

    // CLIENT views their bookings
    public List<Booking> getClientBookings(String email) {

        User client = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return bookingRepository.findByClientId(client.getId());
    }

    // VENDOR views their bookings
    public List<Booking> getVendorBookings(String email) {

        User vendorUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        return bookingRepository.findByVendor_User_Id(vendorUser.getId());
    }

    // ADMIN views all bookings
    public List<Booking> getAllBookings() {

        return bookingRepository.findAll();
    }

    // UPDATE booking status
    public void updateBookingStatus(Long id, String status) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setStatus(status);

        bookingRepository.save(booking);
    }

    // DELETE booking
    public void deleteBooking(Long id) {

        bookingRepository.deleteById(id);
    }
}
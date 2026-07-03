package com.wedding.weddingplanner.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate eventDate;

    private String eventLocation;

    private String status; // REQUESTED, CONFIRMED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public LocalDate getEventDate() { return eventDate; }

    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }

    public String getEventLocation() { return eventLocation; }

    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public User getClient() { return client; }

    public void setClient(User client) { this.client = client; }

    public Vendor getVendor() { return vendor; }

    public void setVendor(Vendor vendor) { this.vendor = vendor; }
}
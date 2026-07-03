package com.wedding.weddingplanner.model;

import com.wedding.weddingplanner.enums.VendorStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessName;

    private String category; // Photographer, Decorator, Catering

    private String location;

    private Double price;

    @Column(name = "image_url")
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private VendorStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // Vendor owner

    // Getters and Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getBusinessName() { return businessName; }

    public void setBusinessName(String businessName) { this.businessName = businessName; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public VendorStatus getStatus() { return status; }

    public void setStatus(VendorStatus status) { this.status = status; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
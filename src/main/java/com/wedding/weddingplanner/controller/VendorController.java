package com.wedding.weddingplanner.controller;

import com.wedding.weddingplanner.model.Vendor;
import com.wedding.weddingplanner.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import com.wedding.weddingplanner.repository.VendorRepository;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
@CrossOrigin(origins = "http://localhost:8080")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private VendorRepository vendorRepository;

    // Vendor creates profile (VENDOR role)
    @PostMapping("/create")
    public Vendor createVendor(@RequestBody Vendor vendor, Authentication authentication) {
        return vendorService.createVendor(vendor, authentication.getName());
    }

    // Admin approves vendor
    @PutMapping("/approve/{id}")
    public Vendor approveVendor(@PathVariable Long id) {
        return vendorService.approveVendor(id);
    }

    // Client views approved vendors
    @GetMapping("/approved")
    public List<Vendor> getApprovedVendors() {
        return vendorService.getApprovedVendors();
    }

    @GetMapping("/pending")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Vendor> getPendingVendors() {
        return vendorService.getPendingVendors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        Vendor vendor = vendorService.getVendorById(id);
        return ResponseEntity.ok(vendor);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteVendor(@PathVariable Long id) {
        vendorService.deleteVendor(id);
        return ResponseEntity.ok("Vendor deleted successfully");
    }

    @PostMapping("/admin/create")
    @PreAuthorize("hasRole('ADMIN')")
    public Vendor adminCreateVendor(@RequestBody Vendor vendor) {
        return vendorService.adminCreateVendor(vendor);
    }

   @PutMapping("/{id}")
    public Vendor updateVendor(@PathVariable Long id, @RequestBody Vendor updatedVendor) {

        Vendor vendor = vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        vendor.setBusinessName(updatedVendor.getBusinessName());
        vendor.setCategory(updatedVendor.getCategory());
        vendor.setLocation(updatedVendor.getLocation());
        vendor.setPrice(updatedVendor.getPrice());
        vendor.setImageUrl(updatedVendor.getImageUrl());

        return vendorRepository.save(vendor);
    }

}
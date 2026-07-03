package com.wedding.weddingplanner.service;

import com.wedding.weddingplanner.enums.VendorStatus;
import com.wedding.weddingplanner.model.User;
import com.wedding.weddingplanner.model.Vendor;
import com.wedding.weddingplanner.repository.UserRepository;
import com.wedding.weddingplanner.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private UserRepository userRepository;

    // Vendor creates profile
    public Vendor createVendor(Vendor vendor, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        vendor.setUser(user);
        vendor.setStatus(VendorStatus.PENDING);

        return vendorRepository.save(vendor);
    }

    // Admin approves vendor
    public Vendor approveVendor(Long vendorId) {

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        vendor.setStatus(VendorStatus.APPROVED);

        return vendorRepository.save(vendor);
    }

    // Client views approved vendors
    public List<Vendor> getApprovedVendors() {
        return vendorRepository.findByStatus(VendorStatus.APPROVED);
    }
    public List<Vendor> getPendingVendors() {
        return vendorRepository.findByStatus(VendorStatus.PENDING);
    }
    public Vendor getVendorById(Long id) {
    return vendorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vendor not found"));
    }

    public void deleteVendor(Long id) {
    Vendor vendor = vendorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vendor not found"));

    vendorRepository.delete(vendor);
    }

    public Vendor adminCreateVendor(Vendor vendor) {

    vendor.setStatus(VendorStatus.APPROVED);

    return vendorRepository.save(vendor);
    }
}
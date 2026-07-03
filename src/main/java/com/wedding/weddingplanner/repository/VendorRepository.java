package com.wedding.weddingplanner.repository;

import com.wedding.weddingplanner.model.Vendor;
import com.wedding.weddingplanner.enums.VendorStatus;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface VendorRepository extends JpaRepository<Vendor, Long> {

   
    List<Vendor> findByStatus(VendorStatus status);

    List<Vendor> findByUserId(Long userId);

    List<Vendor> findByStatus(String status);

    List<Vendor> findAll();
}
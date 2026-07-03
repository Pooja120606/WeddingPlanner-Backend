package com.wedding.weddingplanner.service;

import com.wedding.weddingplanner.model.WeddingPackage;
import com.wedding.weddingplanner.repository.WeddingPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingPackageService {

    @Autowired
    private WeddingPackageRepository weddingPackageRepository;

    public WeddingPackage createPackage(WeddingPackage weddingPackage) {
        return weddingPackageRepository.save(weddingPackage);
    }

    public List<WeddingPackage> getAllPackages() {
        return weddingPackageRepository.findAll();
    }

    public WeddingPackage getPackageById(Long id) {
        return weddingPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));
    }
}
package com.wedding.weddingplanner.controller;

import com.wedding.weddingplanner.model.WeddingPackage;
import com.wedding.weddingplanner.service.WeddingPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/packages")
@CrossOrigin(origins = "*")
public class WeddingPackageController {

    @Autowired
    private WeddingPackageService weddingPackageService;

    // Create package (ADMIN only ideally, but we allow for now)
    @PostMapping("/create")
    public WeddingPackage createPackage(@RequestBody WeddingPackage weddingPackage) {
        return weddingPackageService.createPackage(weddingPackage);
    }

    // Get all packages
    @GetMapping
    public List<WeddingPackage> getAllPackages() {
        return weddingPackageService.getAllPackages();
    }

    // Get package by ID
    @GetMapping("/{id}")
    public WeddingPackage getPackageById(@PathVariable Long id) {
        return weddingPackageService.getPackageById(id);
    }
}
package com.wedding.weddingplanner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/api/admin/dashboard")
    public String adminDashboard() {
        return "Welcome Admin";
    }

    @GetMapping("/api/vendor/dashboard")
    public String vendorDashboard() {
        return "Welcome Vendor";
    }

    @GetMapping("/api/client/dashboard")
    public String clientDashboard() {
        return "Welcome Client";
    }
}
package com.wedding.weddingplanner.controller;

import com.wedding.weddingplanner.model.User;
import com.wedding.weddingplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wedding.weddingplanner.dto.LoginRequest;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")  
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request) {
        return userService.loginUser(request.getEmail(), request.getPassword());
    }
}
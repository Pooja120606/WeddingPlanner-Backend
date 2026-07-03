package com.wedding.weddingplanner.service;

import com.wedding.weddingplanner.model.User;
import com.wedding.weddingplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.wedding.weddingplanner.security.JwtUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
    @Autowired
    private JwtUtil jwtUtil;

    public String loginUser(String email, String password) {

    User user = userRepository.findByEmail(email)
            .orElse(null);

    if (user == null) {
        return "USER NOT FOUND";
    }

    if (!passwordEncoder.matches(password, user.getPassword())) {
        return "PASSWORD NOT MATCH";
    }

    return jwtUtil.generateToken(user.getEmail(), user.getRole().name());
}
}
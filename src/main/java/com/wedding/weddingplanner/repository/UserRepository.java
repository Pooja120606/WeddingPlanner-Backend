package com.wedding.weddingplanner.repository;

import com.wedding.weddingplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;   
import com.wedding.weddingplanner.enums.Role;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findByRole(Role role);

}
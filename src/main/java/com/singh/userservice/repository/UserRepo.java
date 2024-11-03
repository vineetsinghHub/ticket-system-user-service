package com.singh.userservice.repository;

import com.singh.userservice.dto.UserDTO;
import com.singh.userservice.entity.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDAO, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameAndPassword(String username, String password);
}

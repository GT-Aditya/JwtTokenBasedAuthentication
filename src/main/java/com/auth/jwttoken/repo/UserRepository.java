package com.auth.jwttoken.repo;

import java.util.Optional;

import com.auth.jwttoken.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findByEmail(String email);
}

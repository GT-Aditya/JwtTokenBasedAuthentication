package com.auth.jwttoken.controller;

import com.auth.jwttoken.model.User;
import com.auth.jwttoken.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<String> login(@RequestBody User user){
        String token = userService.loginUser(user);
        return ResponseEntity.ok(token);
    }

    @PostMapping
    public ResponseEntity<User> signup(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }
}

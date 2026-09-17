
package com.example.myproject.controller;

import com.example.myproject.service.UserService;
import com.example.myproject.dto.RegisterRequest;
import com.example.myproject.dto.RegisterResponse;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/app/v1/auth")
public class UserController {

    private final UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request) {

        RegisterResponse response = us.registerUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/users")
    public String get() {
        return "Get is returning";
    }
}
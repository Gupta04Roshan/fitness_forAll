package com.project.fitness.controller;

import com.project.fitness.Service.UserService;
import com.project.fitness.Dto.RegisterRequest;
import com.project.fitness.Dto.UserResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
//@AllArgsConstructor
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    //private final JwtUtils jwtUtils;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(userService.register(registerRequest));
    }



    }

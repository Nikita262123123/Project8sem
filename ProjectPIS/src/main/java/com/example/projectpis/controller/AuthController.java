package com.example.projectpis.controller;

import com.example.projectpis.dto.GoogleLoginDTO;
import com.example.projectpis.dto.RegisterDTO;
import com.example.projectpis.entity.User;
import com.example.projectpis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/register")
    public void register(@RequestBody RegisterDTO dto) {
        service.register(dto);
    }

    @PostMapping("/google")
    public User googleLogin(@RequestBody GoogleLoginDTO dto) {
        return service.googleLogin(dto.getEmail());
    }
}
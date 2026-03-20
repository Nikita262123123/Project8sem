package com.example.projectpis.service;

import com.example.projectpis.dto.RegisterDTO;
import com.example.projectpis.entity.Role;
import com.example.projectpis.entity.User;
import com.example.projectpis.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public void register(RegisterDTO dto) {
        User u = new User();
        u.setUsername(dto.username);
        u.setPassword(encoder.encode(dto.password));
        u.setRole(Role.NONE);
        u.setApproved(false);
        repo.save(u);
    }

    public List<User> getUnapproved() {
        return repo.findAll().stream()
                .filter(u -> !u.isApproved())
                .toList();
    }

    public void approve(Long id) {
        User u = repo.findById(id).orElseThrow();
        u.setApproved(true);
        u.setRole(Role.EMPLOYEE);
        repo.save(u);
    }

    public User googleLogin(String email) {

        return repo.findByUsername(email)
                .orElseGet(() -> {
                    User u = new User();
                    u.setUsername(email);
                    u.setPassword("google"); // заглушка
                    u.setRole(Role.EMPLOYEE);
                    u.setApproved(true);
                    return repo.save(u);
                });
    }
}
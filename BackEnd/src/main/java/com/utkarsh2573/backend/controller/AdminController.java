package com.utkarsh2573.backend.controller;

import com.utkarsh2573.backend.model.Role;
import com.utkarsh2573.backend.model.User;
import com.utkarsh2573.backend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    @PostMapping("/change-user-password")
    public void changeUserPassword(@RequestBody Map<String, String> body) {
        User user = repo.findByRole(Role.USER);
        user.setPassword(encoder.encode(body.get("password")));
        repo.save(user);
    }
}
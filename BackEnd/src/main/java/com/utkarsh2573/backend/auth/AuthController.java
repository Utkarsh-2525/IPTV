package com.utkarsh2573.backend.auth;

import com.utkarsh2573.backend.model.User;
import com.utkarsh2573.backend.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwt;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest req) {

        User user = repo.findByUsername(req.username())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!encoder.matches(req.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return Map.of(
                "token", jwt.generate(user.getUsername(), user.getRole().name()),
                "role", user.getRole().name()
        );
    }
}
package com.utkarsh2573.backend.auth;

import com.utkarsh2573.backend.model.User;
import com.utkarsh2573.backend.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repo;
    private final JwtUtil jwt;
    private final PasswordEncoder encoder;

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody LoginRequest req) {
        User u = repo.findByUsername(req.username()).orElseThrow();
        if (!encoder.matches(req.password(), u.getPassword()))
            throw new RuntimeException("Invalid");

        return Map.of(
                "token", jwt.generate(u.getUsername(), u.getRole().name()),
                "role", u.getRole().name()
        );
    }
}

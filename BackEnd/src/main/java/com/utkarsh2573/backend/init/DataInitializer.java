package com.utkarsh2573.backend.init;

import com.utkarsh2573.backend.model.Role;
import com.utkarsh2573.backend.model.User;
import com.utkarsh2573.backend.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(new User("admin", encoder.encode("admin@123"), Role.ADMIN));
                repo.save(new User("user", encoder.encode("user@123"), Role.USER));
            }
        };
    }
}

package com.example.security_practic.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Метод для хеширования пароля
    public String hashPassword(String plainTextPassword) {
        return passwordEncoder.encode(plainTextPassword);
    }

    // Метод для проверки пароля
    public boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return passwordEncoder.matches(plainTextPassword, hashedPassword);
    }
}
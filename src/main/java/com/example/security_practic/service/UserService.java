package com.example.security_practic.service;

import com.example.security_practic.model.User;
import com.example.security_practic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public User registerUser(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordService.hashPassword(password));

        return userRepository.save(newUser);
    }
}
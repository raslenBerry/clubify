package com.example.clubify_backend.service;

import com.example.clubify_backend.model.User;
import com.example.clubify_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64encoder = Base64.getUrlEncoder();

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register (User user) {
        // Check if user already exists or not
        if (checkUserExist(user))
            return null;

            user.setToken(generateToken());

           return userRepository.save(user);
    }

    private String generateToken() {
        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64encoder.encodeToString(token);

    }

    private boolean checkUserExist(User user) {
        User existingUser = userRepository.findById(user.getEmail()).orElse(null);

        return existingUser != null;
    }

    public User login(User user) {
        User existingUser = userRepository.findById(user.getEmail()).orElse(null);

        if (
                existingUser.getEmail().equals(user.getEmail()) &&
                        existingUser.getPassword().equals(user.getPassword())
        ) {
            existingUser.setPassword("");
            return existingUser;

    }
        return null;
    }
}

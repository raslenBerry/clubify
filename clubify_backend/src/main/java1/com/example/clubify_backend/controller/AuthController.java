package com.example.clubify_backend.controller;
import com.example.clubify_backend.model.User;
import com.example.clubify_backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User Register(@RequestBody User user) {
        return authService.register(user);

    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {

        return authService.login(user);

    }
}

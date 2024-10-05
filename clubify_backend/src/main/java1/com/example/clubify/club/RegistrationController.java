package com.example.clubify.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping
    public ResponseEntity<Registration> createRegistration(@RequestBody Registration registration) {
        registration.setStatus("notapproved"); // Ensure default value
        Registration savedRegistration = registrationRepository.save(registration);
        return ResponseEntity.ok(savedRegistration);
    }
}

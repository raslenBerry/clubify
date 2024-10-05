package com.example.clubify.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/competition-registration")
public class CompetitionRegistrationController {
    @Autowired
    private CompetitionRegistrationRepository registrationRepository;

    @PostMapping
    public ResponseEntity<String> registerForCompetition(@RequestBody CompetitionRegistration registration) {
        // Logique pour enregistrer l'inscription à la compétition
        registration.setStatus("notapproved");
        registrationRepository.save(registration);
        return ResponseEntity.ok("Inscription réussie");
    }
}


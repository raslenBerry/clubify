package com.example.clubify.competition;

import com.example.clubify.club.Registration;
import com.example.clubify.club.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @Autowired
    private CompetitionRegistrationService registrationService;

    @GetMapping("/notapproved")
    public List<CompetitionRegistration> getNotApprovedRegistrations() {
        return registrationService.getNotApprovedRegistrations();
    }
    @GetMapping("/approved")
    public List<CompetitionRegistration> getApprovedRegistrations() {
        return registrationService.getApprovedRegistrations();
    }

    @PutMapping("/{id}")
    public CompetitionRegistration updateRegistration(@PathVariable Long id, @RequestBody CompetitionRegistration updatedRegistration) {
        return registrationService.updateRegistration(id, updatedRegistration);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegistration(@PathVariable Long id) {
        if (registrationRepository.existsById(id)) {
            registrationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


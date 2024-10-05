package com.example.clubify.club;

import com.example.clubify.user.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/notapproved")
    public List<Registration> getNotApprovedRegistrations() {
        return registrationService.getNotApprovedRegistrations();
    }
    @GetMapping("/approved")
    public List<Registration> getApprovedRegistrations() {
        return registrationService.getApprovedRegistrations();
    }
    @PutMapping("/{id}")
    public Registration updateRegistration(@PathVariable Long id, @RequestBody Registration updatedRegistration) {
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

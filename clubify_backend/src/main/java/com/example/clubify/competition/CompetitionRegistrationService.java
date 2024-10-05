package com.example.clubify.competition;

import com.example.clubify.club.Registration;
import com.example.clubify.club.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CompetitionRegistrationService {
    @Autowired
    private CompetitionRegistrationRepository registrationRepository;
    public List<CompetitionRegistration> getNotApprovedRegistrations() {
        return registrationRepository.findByStatus("notapproved");
    }
    public CompetitionRegistration updateRegistration(Long registrationId, CompetitionRegistration updatedRegistration) {
        CompetitionRegistration existingRegistration = registrationRepository.findById(registrationId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid registration Id: " + registrationId));

        // Update fields if they are not null in the updatedRegistration
        if (updatedRegistration.getNom() != null) {
            existingRegistration.setNom(updatedRegistration.getNom());
        }
        if (updatedRegistration.getPrenom() != null) {
            existingRegistration.setPrenom(updatedRegistration.getPrenom());
        }
        if (updatedRegistration.getAdresseEmail() != null) {
            existingRegistration.setAdresseEmail(updatedRegistration.getAdresseEmail());
        }
        if (updatedRegistration.getWhyJoin() != null) {
            existingRegistration.setWhyJoin(updatedRegistration.getWhyJoin());
        }

        existingRegistration.setStatus("approved");

        // Save the updated registration
        return registrationRepository.save(existingRegistration);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }

    public List<CompetitionRegistration> getApprovedRegistrations() {
        return registrationRepository.findByStatus("approved");
    }
}

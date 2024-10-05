package com.example.clubify.club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    public List<Registration> getNotApprovedRegistrations() {
        return registrationRepository.findByStatus("notapproved");
    }
    public List<Registration> getApprovedRegistrations() {
        return registrationRepository.findByStatus("approved");
    }
    public Registration updateRegistration(Long registrationId, Registration updatedRegistration) {
        Registration existingRegistration = registrationRepository.findById(registrationId)
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
        if (updatedRegistration.getHowDidYouHear() != null) {
            existingRegistration.setHowDidYouHear(updatedRegistration.getHowDidYouHear());
        }

        existingRegistration.setStatus("approved");

        // Save the updated registration
        return registrationRepository.save(existingRegistration);
    }

    public void deleteRegistration(Long id) {
        registrationRepository.deleteById(id);
    }


}

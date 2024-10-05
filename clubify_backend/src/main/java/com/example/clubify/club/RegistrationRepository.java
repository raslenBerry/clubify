package com.example.clubify.club;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByStatus(String status);
}

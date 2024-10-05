package com.example.clubify.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRegistrationRepository extends JpaRepository<CompetitionRegistration, Long> {
}

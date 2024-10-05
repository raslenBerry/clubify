package com.example.clubify.sorties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sortiesRepository extends JpaRepository<sorties, Long> {
}

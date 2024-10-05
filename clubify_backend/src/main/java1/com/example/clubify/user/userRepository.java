package com.example.clubify.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Long> {
  user findByAdresseEmailAndMdp(String adresseEmail, String mdp);
}

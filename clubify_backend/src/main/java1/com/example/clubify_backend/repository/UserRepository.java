package com.example.clubify_backend.repository;
import com.example.clubify_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}

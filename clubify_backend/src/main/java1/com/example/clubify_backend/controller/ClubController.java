package com.example.clubify_backend.controller;

import com.example.clubify_backend.exception.RessourceNotFoundException;
import com.example.clubify_backend.model.Club;
import com.example.clubify_backend.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;

    // Get all actions
    @GetMapping
    public List<Club> getAllClubs(){
        return clubRepository.findAll();
    }

    // Create action rest api
    @PostMapping
    public Club createClub(@RequestBody Club club){
        return clubRepository.save(club);
    }

    // get action by id rest api
    @GetMapping("/{id}")
    public ResponseEntity<Club>  getClubById(@PathVariable Long id) throws RessourceNotFoundException {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Club not exist with id :" + id));
        return ResponseEntity.ok(club);
    }

    // update action rest api
    @PutMapping("/{id}")
public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club clubDetails) throws RessourceNotFoundException {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Action not exist with id :" + id));

        club.setTitle(clubDetails.getTitle());
        club.setDescription(clubDetails.getDescription());
        club.setLocation(clubDetails.getLocation());
        club.setCategory(clubDetails.getCategory());
        club.setImage(clubDetails.getImage());
        club.setCreator(clubDetails.getCreator());
        club.setMembers(clubDetails.getMembers());

        Club updatedClub = clubRepository.save(club);
        return ResponseEntity.ok(updatedClub);
    }

    // delete action rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClub(@PathVariable Long id) throws RessourceNotFoundException {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Club not exist with id :" + id));

        clubRepository.delete(club);
        return ResponseEntity.ok(Boolean.TRUE);
    }



}

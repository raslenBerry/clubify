package com.example.clubify.club;

import com.example.clubify.exception.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    @Autowired
    private ClubRepository clubRepository;

    // Get all clubs
    @GetMapping
    public List<Club> getAllClubs(){
        return clubRepository.findAll();
    }

    // Create club
    @PostMapping
    public Club createClub(@RequestBody Club club){
        return clubRepository.save(club);
    }

    // Get club by ID
    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Long id) throws RessourceNotFoundException {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Club not exist with id :" + id));
        return ResponseEntity.ok(club);
    }

    // Update club
    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club clubDetails) throws RessourceNotFoundException {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Club not exist with id :" + id));

        club.setTitle(clubDetails.getTitle());
        club.setDescription(clubDetails.getDescription());
        club.setLocation(clubDetails.getLocation());
        club.setCategory(clubDetails.getCategory());
        club.setImage(clubDetails.getImage());
        club.setCreator(clubDetails.getCreator());

        Club updatedClub = clubRepository.save(club);
        return ResponseEntity.ok(updatedClub);
    }

    // Delete club
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteClub(@PathVariable Long id) throws RessourceNotFoundException {
        Club club = clubRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Club not exist with id :" + id));

        clubRepository.delete(club);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    // Get clubs by creator
    @GetMapping("/creator/{creator}")
    public List<Club> getClubsByCreator(@PathVariable String creator) {
        return clubRepository.findByCreator(creator);
    }
}

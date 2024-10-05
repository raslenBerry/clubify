package com.example.clubify.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    @Autowired
    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public ResponseEntity<List<competition>> getAllCompetitions() {
        List<competition> competitions = competitionService.getAllCompetitions();
        return ResponseEntity.ok(competitions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<competition> getCompetitionById(@PathVariable Long id) {
        Optional<competition> competition = competitionService.getCompetitionById(id);
        return competition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<competition> addCompetition(@RequestBody competition competition) {
        competition savedCompetition = competitionService.addCompetition(competition);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompetition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        competitionService.deleteCompetition(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<competition> updateCompetition(@PathVariable Long id, @RequestBody competition updatedCompetition) {
        competition competition = competitionService.updateCompetition(id, updatedCompetition);
        if (competition != null) {
            return ResponseEntity.ok(competition);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


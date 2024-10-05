package com.example.clubify.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Optional<competition> getCompetitionById(Long id) {
        return competitionRepository.findById(id);
    }

    public competition addCompetition(competition competition) {
        return competitionRepository.save(competition);
    }

    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }

    public competition updateCompetition(Long id, competition updatedCompetition) {
        if (competitionRepository.existsById(id)) {
            updatedCompetition.setId(id);
            return competitionRepository.save(updatedCompetition);
        }
        return null;
    }
}

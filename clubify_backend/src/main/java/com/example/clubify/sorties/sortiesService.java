package com.example.clubify.sorties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sortiesService {

    @Autowired
    private sortiesRepository sortieRepository;

    public List<sorties> findAllSorties() {
        return sortieRepository.findAll();
    }

    public sorties findSortieById(Long codeSortie) {
        return sortieRepository.findById(codeSortie).orElse(null);
    }

    public sorties addSortie(sorties sorties) {
        return sortieRepository.save(sorties);
    }

    public sorties updateSortie(sorties sorties) {
        return sortieRepository.save(sorties);
    }

    public void deleteSortie(Long codeSortie) {
        sortieRepository.deleteById(codeSortie);
    }
}

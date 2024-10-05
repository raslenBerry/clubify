package com.example.clubify.sorties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@RequestMapping("/sorties")
public class sortiesController {

    @Autowired
    private sortiesService sortieService;

    @GetMapping("/all")
    public ResponseEntity<List<sorties>> getAllSorties() {
        List<sorties> sorties = sortieService.findAllSorties();
        return new ResponseEntity<>(sorties, HttpStatus.OK);
    }

    @GetMapping("/find/{codeSortie}")
    public ResponseEntity<sorties> getSortieByCode(@PathVariable("codeSortie") Long codeSortie) {
        sorties sortie = sortieService.findSortieById(codeSortie);
        if (sortie != null) {
            return new ResponseEntity<>(sortie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<sorties> addSortie(@RequestBody sorties sortie) {
        sorties newSortie = sortieService.addSortie(sortie);
        return new ResponseEntity<>(newSortie, HttpStatus.CREATED);
    }

    @PutMapping("/update/{codeSortie}")
    public ResponseEntity<sorties> updateSortie(@RequestBody sorties sortie) {
        sorties updatedSortie = sortieService.updateSortie(sortie);
        return new ResponseEntity<>(updatedSortie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{codeSortie}")
    public ResponseEntity<?> deleteSortie(@PathVariable("codeSortie") Long codeSortie) {
        sortieService.deleteSortie(codeSortie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

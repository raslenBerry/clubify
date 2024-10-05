package com.example.clubify.sorties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class sorties {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue
    private Long codeSortie;
    private String lieu;
    private String description;
    private double prix;
    private String photo;

    public sorties(Long codeSortie, String lieu, String description, double prix, String photo) {
        this.codeSortie = codeSortie;
        this.lieu = lieu;
        this.description = description;
        this.prix = prix;
        this.photo = photo;
    }

    public sorties() {
        
    }

    public Long getCodeSortie() {
        return codeSortie;
    }

    public void setCodeSortie(Long codeSortie) {
        this.codeSortie = codeSortie;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "sorties{" +
                "codeSortie=" + codeSortie +
                ", lieu='" + lieu + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", photo='" + photo + '\'' +
                '}';
    }
}


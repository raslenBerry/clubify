package com.example.clubify.user;

import jakarta.persistence.*;

@Entity
public class user{
  @Id
  @Column(nullable = false, updatable = false)
  @GeneratedValue
  private Long id;
  private String nom;
    private String prenom;
    private String adresseEmail;
    private String mdp;
    @Column(name = "role", length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'USER'")
    private String role;

    public user(Long id, String nom, String prenom, String adresseEmail, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresseEmail = adresseEmail;
        this.mdp = mdp;
        this.role = role;
    }

    public user() {

    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public String getMdp() {
        return mdp;
    }

    public String getRole() {
        return role;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

}

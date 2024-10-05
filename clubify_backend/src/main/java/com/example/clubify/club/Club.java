package com.example.clubify.club;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List; // Import List interface

@Entity
@Table(name = "clubs")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;


    @Column(name = "location")
    private String location;

    @Column(name = "category")
    private String category;

    @Column(name = "image")
    private String image;

    @Column(name = "creator")
    private String creator;

    public Club() {
    }

    public Club(String title, String description, String date, String time, String location, String category, String image, String creator) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.image = image;
        this.creator = creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}



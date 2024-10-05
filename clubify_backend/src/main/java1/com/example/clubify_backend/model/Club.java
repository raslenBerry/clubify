package com.example.clubify_backend.model;

import jakarta.persistence.*;
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

    // Modify participants to be a list of strings
    @ElementCollection
    @CollectionTable(name = "members", joinColumns = @JoinColumn(name = "club_id"))
    @Column(name = "member_name")
    private List<String> members;

    public Club() {
    }

    public Club(String title, String description, String date, String time, String location, String category, String image, String creator, List<String> members) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.image = image;
        this.creator = creator;
        this.members = members;
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

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}

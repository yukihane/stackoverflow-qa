package com.example.so66104427;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BLOG")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bId;
    @Column(length = 100)
    private String title;
    @Column(length = 200)
    private String shortDescription;
    private String description;
    private String date;
    private String image;
    private String display_image;
    private String prof_image;

    @ManyToOne
    private User user;

    public Blog() {
        super();
        // TODO Auto-generated constructor stub
    }

    public int getbId() {
        return bId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDisplay_image() {
        return display_image;
    }

    public void setDisplay_image(String display_image) {
        this.display_image = display_image;
    }

    public String getProf_image() {
        return prof_image;
    }

    public void setProf_image(String prof_image) {
        this.prof_image = prof_image;
    }

}

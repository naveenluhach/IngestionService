package com.example.feedbackservice.model;

import javax.persistence.*;

@Entity
@Table(name = "twittermetadata")
public class TwitterMetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

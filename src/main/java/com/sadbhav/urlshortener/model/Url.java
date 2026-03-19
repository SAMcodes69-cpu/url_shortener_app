package com.sadbhav.urlshortener.model;


//jakarta is a JPA library used to talk to database
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Entity tells that this class is database table
// Id gives a primary id to table
// GeneratedValue provides how id is generated

// Getter and setter are lombok functionality and it auto generate getter setter for marked variables
@Getter
@Entity
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(unique = true)
    private String originalUrl;

    @Setter
    @Column(unique = true)
    private String shortCode;

    public Url(String originalUrl, String shortCode){
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
    }
    public Url(){
    }
}

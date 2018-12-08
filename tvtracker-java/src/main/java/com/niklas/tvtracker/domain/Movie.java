package com.niklas.tvtracker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Title is required")
    @Column(updatable = false, unique = true)
    private String title;
    @NotBlank(message = "Genre is required")
    private String genre;
    @NotNull(message = "IMDB rating is required")
    private double rating;
    @NotBlank(message = "Movie description is required")
    private String description;


    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date created_At;
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date updated_At;


    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}




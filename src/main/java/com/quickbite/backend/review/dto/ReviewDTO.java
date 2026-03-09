package com.quickbite.backend.review.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class ReviewDTO {
    @NotNull
    private Integer idUser;
    @NotNull
    private Integer idRestaurant;

    private String description;
    @NotNull
    private Integer rate;
    @NotNull
    private LocalTime createdAt;

    // Constructors
    public ReviewDTO() {}

    public ReviewDTO(Integer idUser, Integer idRestaurant, String description, Integer rate) {
        this.idUser = idUser;
        this.idRestaurant = idRestaurant;
        this.description = description;
        this.rate = rate;
        this.createdAt = LocalTime.now();
    }

    // Getters and Setters
    public Integer getIdUser() { return idUser; }
    public void setIdUser(Integer idUser) { this.idUser = idUser; }
    public Integer getIdRestaurant() { return idRestaurant; }
    public void setIdRestaurant(Integer idRestaurant) { this.idRestaurant = idRestaurant; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }
    public LocalTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalTime createdAt) { this.createdAt = createdAt; }
}

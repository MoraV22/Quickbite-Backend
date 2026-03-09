package com.quickbite.backend.review.domain;


import com.quickbite.backend.restaurant.domain.Restaurant;
import com.quickbite.backend.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalTime;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private Integer rate;

    @Column(nullable = false)
    private LocalTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    // Constructors
    public Review() {}

    public Review(String description, Integer rate, User user, Restaurant restaurant) {
        this.description = description;
        this.rate = rate;
        this.user = user;
        this.restaurant = restaurant;
        this.createdAt = LocalTime.now();
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }
    public LocalTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalTime createdAt) { this.createdAt = createdAt; }


}

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
    private LocalTime created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}

package com.quickbite.backend.review.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class ReviewDTO {
    @NotBlank
    private Integer id_user;
    @NotBlank
    private Integer id_restaurant;

    private String description;
    @NotBlank
    private Integer rate;
    @NotBlank
    private LocalTime createdAt;
}

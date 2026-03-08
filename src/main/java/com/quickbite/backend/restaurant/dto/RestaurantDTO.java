package com.quickbite.backend.restaurant.dto;


import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class RestaurantDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private Integer rate;
    @NotBlank
    private String foodType;
    @NotBlank
    private LocalTime openHour;
    @NotBlank
    private LocalTime closeHour;
}

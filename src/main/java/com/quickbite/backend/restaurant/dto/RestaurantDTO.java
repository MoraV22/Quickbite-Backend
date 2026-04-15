package com.quickbite.backend.restaurant.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class RestaurantDTO {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotNull
    private Integer rate;
    @NotBlank
    private String foodType;
    @NotNull
    private LocalTime openHour;
    @NotNull
    private LocalTime closeHour;

    // Constructors
    public RestaurantDTO() {}

    public RestaurantDTO(Integer id,String name, String address, Integer rate, String foodType, LocalTime openHour, LocalTime closeHour) {
        this.id = id;
            this.name = name;
            this.address = address;
            this.rate = rate;
            this.foodType = foodType;
            this.openHour = openHour;
            this.closeHour = closeHour;
        }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {}
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }

    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }

    public LocalTime getOpenHour() { return openHour; }
    public void setOpenHour(LocalTime openHour) { this.openHour = openHour; }

    public LocalTime getCloseHour() { return closeHour; }
    public void setCloseHour(LocalTime closeHour) { this.closeHour = closeHour; }
}

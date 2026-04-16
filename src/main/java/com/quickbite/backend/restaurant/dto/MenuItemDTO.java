package com.quickbite.backend.restaurant.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MenuItemDTO {
        @NotNull
        private Integer id;
        @NotNull
        private Integer restaurantId;
        @NotBlank
        private String name;
        @NotBlank
        private String description;
        @NotNull
        private Double price;
        @NotNull
        private Double calories;

        // Constructors
        public MenuItemDTO() {}

        public MenuItemDTO(Integer id, Integer restaurantId, String name, String description, Double price, Double calories) {
            this.id= id;
            this.restaurantId = restaurantId;
            this.name = name;
            this.description = description;
            this.price = price;
            this.calories = calories;
        }

        // Getters and Setters
        public Integer getId() { return id; }
        public void setId(Integer id) { this.id = id; }
        public Integer getRestaurantId() { return restaurantId; }
        public void setRestaurantId(Integer restaurantId) { this.restaurantId = restaurantId; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }
        public Double getCalories() { return calories; }
        public void setCalories(Double calories) { this.calories = calories; }
        
}

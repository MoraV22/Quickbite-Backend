package com.quickbite.backend.restaurant.dto;

import jakarta.validation.constraints.NotBlank;

public class MenuItemDTO {
        @NotBlank
        private Integer restaurant_id;
        @NotBlank
        private String name;
        @NotBlank
        private String description;
        @NotBlank
        private Double price;
        @NotBlank
        private Double calories;
}

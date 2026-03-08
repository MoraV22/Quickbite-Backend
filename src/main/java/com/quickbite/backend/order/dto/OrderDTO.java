package com.quickbite.backend.order.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class OrderDTO {
    @NotBlank
    private Integer user_id;
    @NotBlank
    private Integer total_price;
    @NotBlank
    private Integer tax;
    @NotBlank
    private String address;
    @NotBlank
    private OrderStatus status;
    @NotBlank
    private LocalTime createdAt;
}

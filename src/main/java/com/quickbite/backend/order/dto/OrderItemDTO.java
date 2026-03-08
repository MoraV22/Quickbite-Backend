package com.quickbite.backend.order.dto;

import jakarta.validation.constraints.NotBlank;

public class OrderItemDTO {
    @NotBlank
    private Integer id_order;
    @NotBlank
    private Integer id_item;
    @NotBlank
    private Integer quantity;
    @NotBlank
    private Double price;
}

package com.quickbite.backend.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class OrderDTO {

    @NotNull
    public Integer userId;
    @NotBlank
    public String address;
    @NotNull
    public OrderStatus status;
    @NotNull
    public LocalDateTime createdAt;
    @NotNull
    public List<OrderItemDTO> items;

    // Constructors
    public OrderDTO() {}

    public OrderDTO(Integer userId, String address, OrderStatus status, List<OrderItemDTO> itemIds) {
        this.userId = userId;
        this.address = address;
        this.status = status;
        this.createdAt = LocalDateTime.now();
        this.items = itemIds;

    }

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
}

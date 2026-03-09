package com.quickbite.backend.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class OrderDTO {
    @NotNull
    private Integer userId;
    @NotNull
    private Double totalPrice;
    @NotNull
    private Double tax;
    @NotBlank
    private String address;
    @NotNull
    private OrderStatus status;
    @NotNull
    private LocalTime createdAt;

    // Constructors
    public OrderDTO() {}

    public OrderDTO(Integer userId, Double totalPrice, Double tax, String address, OrderStatus status) {
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.address = address;
        this.status = status;
        this.createdAt = LocalTime.now();
    }

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public Double getTax() { return tax; }
    public void setTax(Double tax) { this.tax = tax; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public LocalTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalTime createdAt) { this.createdAt = createdAt; }
}

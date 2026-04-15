package com.quickbite.backend.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.List;

public class OrderDTO {
    @NotBlank
    private Integer id;
    @NotNull
    public Integer userId;
    @NotNull
    public Double totalPrice;
    @NotNull
    public Double tax;
    @NotBlank
    public String address;
    @NotNull
    public OrderStatus status;
    @NotNull
    public LocalTime createdAt;
    @NotNull
    public List<OrderItemDTO> items;

    // Constructors
    public OrderDTO() {}

    public OrderDTO(Integer id,Integer userId, Double totalPrice, Double tax, String address, OrderStatus status, List<OrderItemDTO> itemIds) {
        this.id = id;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.tax = tax;
        this.address = address;
        this.status = status;
        this.createdAt = LocalTime.now();
        this.items = itemIds;

    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
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

    public List<OrderItemDTO> getItems() { return items; }
    public void setItems(List<OrderItemDTO> items) { this.items = items; }
}

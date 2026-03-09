package com.quickbite.backend.order.dto;

import jakarta.validation.constraints.NotNull;

public class OrderItemDTO {
    @NotNull
    private Integer idOrder;
    @NotNull
    private Integer idItem;
    @NotNull
    private Integer quantity;
    @NotNull
    private Double price;

    // Constructors
    public OrderItemDTO() {}

    public OrderItemDTO(Integer idOrder, Integer idItem, Integer quantity, Double price) {
        this.idOrder = idOrder;
        this.idItem = idItem;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public Integer getIdOrder() { return idOrder; }
    public void setIdOrder(Integer idOrder) { this.idOrder = idOrder; }
    public Integer getIdItem() { return idItem; }
    public void setIdItem(Integer idItem) { this.idItem = idItem; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    
}

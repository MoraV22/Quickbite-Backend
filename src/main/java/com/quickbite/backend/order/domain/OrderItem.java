package com.quickbite.backend.order.domain;

import com.quickbite.backend.restaurant.domain.MenuItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private MenuItem menuItem;

    @Min(0)
    @Column(nullable = false)
    private int quantity;

    @Min(0)
    @Column(nullable = false)
    private double price;

    // Constructors
    public OrderItem() {}

    public OrderItem(Order order, MenuItem menuItem, int quantity, double price) {
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public MenuItem getMenuItem() { return menuItem; }
    public void setMenuItem(MenuItem menuItem) { this.menuItem = menuItem; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

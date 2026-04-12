package com.quickbite.backend.order.domain;

import com.quickbite.backend.order.dto.OrderStatus;
import com.quickbite.backend.user.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Min(0)
    @Column(nullable = false)
    public double totalPrice;

    @Column(nullable = false)
    public String address;

    @Min(0)
    @Column(nullable = false)
    public double tax;

    @Column(nullable = false)
    public LocalTime createdAt;

    @Enumerated(EnumType.STRING)
    public OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    public List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    // Constructors
    public Order() {}

    public Order(double price, String address, double tax, User user) {
        this.totalPrice = price;
        this.address = address;
        this.tax = tax;
        this.user = user;
        this.createdAt = LocalTime.now();
        this.status = OrderStatus.CREATED;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    public LocalTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalTime createdAt) { this.createdAt = createdAt; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}

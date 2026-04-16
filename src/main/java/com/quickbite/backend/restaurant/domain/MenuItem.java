package com.quickbite.backend.restaurant.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quickbite.backend.order.domain.OrderItem;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @JsonIgnore
    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderItem> orderItems;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Double calories;

    // Constructors
    public MenuItem() {}

    public MenuItem(Restaurant restaurant, String name, String description, Double price, Double calories) {
        this.restaurant = restaurant;
        this.name = name;
        this.description = description;
        this.price = price;
        this.calories = calories;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Restaurant getRestaurant() { return restaurant; }
    public void setRestaurant(Restaurant restaurant) { this.restaurant = restaurant; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public Double getCalories() { return calories; }
    public void setCalories(Double calories) { this.calories = calories; }
}

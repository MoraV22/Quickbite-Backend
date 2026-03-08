package com.quickbite.backend.order.domain;

import com.quickbite.backend.restaurant.domain.MenuItem;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_order", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    private MenuItem menu_item;

    @Min(0)
    @Column(nullable = false)
    private int quantity;

    @Min(0)
    @Column(nullable = false)
    private double price;
}

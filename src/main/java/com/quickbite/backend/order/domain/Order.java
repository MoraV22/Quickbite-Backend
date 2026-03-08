package com.quickbite.backend.order.domain;

import com.quickbite.backend.order.dto.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import org.apache.catalina.User;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Min(0)
    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String address;

    @Min(0)
    @Column(nullable = false)
    private double tax;

    @Column(nullable = false)
    private LocalTime createdAt;

    @Column(nullable = false)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.quickbite.backend.restaurant.domain;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String address;

    @Column(nullable = false)
    private Integer rate;

    @Column(nullable = false)
    private String foodType;

    @Column(nullable = false)
    private LocalTime openHour;

    @Column(nullable = false)
    private LocalTime closeHour;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems;


    // Constructors
    public Restaurant() {}

    public Restaurant(String name, String address, Integer rate, String foodType, LocalTime openHour, LocalTime closeHour) {
        this.name = name;
        this.address = address;
        this.rate = rate;
        this.foodType = foodType;
        this.openHour = openHour;
        this.closeHour = closeHour;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }
    public String getFoodType() { return foodType; }
    public void setFoodType(String foodType) { this.foodType = foodType; }
    public LocalTime getOpenHour() { return openHour; }
    public void setOpenHour(LocalTime openHour) { this.openHour = openHour; }
    public LocalTime getCloseHour() { return closeHour; }
    public void setCloseHour(LocalTime closeHour) { this.closeHour = closeHour; }

}

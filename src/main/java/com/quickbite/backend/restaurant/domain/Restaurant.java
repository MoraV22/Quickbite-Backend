package com.quickbite.backend.restaurant.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quickbite.backend.user.domain.User;
import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @JsonIgnore
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

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    // Constructors
    public Restaurant() {}

    public Restaurant(String name, String address, Integer rate, String foodType, LocalTime openHour, LocalTime closeHour, User user) {
        this.name = name;
        this.address = address;
        this.rate = rate;
        this.foodType = foodType;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.user = user;
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
    public void setUser(User user) { this.user = user; }

}

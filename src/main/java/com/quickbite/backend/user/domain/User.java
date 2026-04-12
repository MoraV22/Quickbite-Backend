package com.quickbite.backend.user.domain;

import com.quickbite.backend.order.domain.Order;
import com.quickbite.backend.user.dto.RoleType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname1;

    @Column()
    private String surname2;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer rate;

    @Enumerated(EnumType.STRING)
    private RoleType userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentInfo> paymentMethods;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    // Constructors
    public User() {}

    public User(String name, String surname1, String email, String password, RoleType userType) {
        this.name = name;
        this.surname1 = surname1;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.rate = 5; // Default rating
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname1() { return surname1; }
    public void setSurname1(String surname1) { this.surname1 = surname1; }

    public String getSurname2() { return surname2; }
    public void setSurname2(String surname2) { this.surname2 = surname2; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }

    public RoleType getUserType() { return userType; }
    public void setUserType(RoleType userType) { this.userType = userType; }

    public List<PaymentInfo> getPaymentMethods() { return paymentMethods; }
    public void setPaymentMethods(List<PaymentInfo> paymentMethods) { this.paymentMethods = paymentMethods; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }

}
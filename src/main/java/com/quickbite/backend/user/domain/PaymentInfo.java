package com.quickbite.backend.user.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
@Entity
@Table(name = "payments_info")
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 4)
    private String cardLast4;

    @Column(nullable = false)
    private String brand;

    @Min(1)
    @Max(12)
    @Column(nullable = false)
    private Integer expirationMonth;

    @Min(2026)
    @Max(2060)
    @Column(nullable = false)
    private Integer expirationYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    // Constructors
    public PaymentInfo() {}

    public PaymentInfo(String cardLast4, String brand, Integer expirationMonth, Integer expirationYear, User user) {
        this.cardLast4 = cardLast4;
        this.brand = brand;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.user = user;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCardLast4() { return cardLast4; }
    public void setCardLast4(String cardLast4) { this.cardLast4 = cardLast4; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Integer getExpirationMonth() { return expirationMonth; }
    public void setExpirationMonth(Integer expirationMonth) { this.expirationMonth = expirationMonth; }

    public Integer getExpirationYear() { return expirationYear; }
    public void setExpirationYear(Integer expirationYear) { this.expirationYear = expirationYear; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

}

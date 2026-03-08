package com.quickbite.backend.user.domain;
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
    private String card_last4;

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

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}

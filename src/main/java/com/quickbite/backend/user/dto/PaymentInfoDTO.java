package com.quickbite.backend.user.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PaymentInfoDTO {

    private Integer id;

    @NotBlank(message = "Card last 4 digits are required")
    private String cardLast4;

    @NotBlank(message = "Brand is required")
    private String brand;

    @NotNull(message = "Expiration month is required")
    @Min(value = 1, message = "Expiration month must be between 1 and 12")
    @Max(value = 12, message = "Expiration month must be between 1 and 12")
    private Integer expirationMonth;

    @NotNull(message = "Expiration year is required")
    @Min(value = 2026, message = "Expiration year must be 2026 or later")
    @Max(value = 2060, message = "Expiration year must be 2060 or earlier")
    private Integer expirationYear;

    @NotNull(message = "User ID is required")
    private Integer userId;

    // Constructors
    public PaymentInfoDTO() {}

    public PaymentInfoDTO(Integer id, String cardLast4, String brand, Integer expirationMonth, Integer expirationYear, Integer userId) {
        this.id = id;
        this.cardLast4 = cardLast4;
        this.brand = brand;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.userId = userId;
    }

    public PaymentInfoDTO(String cardLast4, String brand, Integer expirationMonth, Integer expirationYear, Integer userId) {
        this.cardLast4 = cardLast4;
        this.brand = brand;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.userId = userId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardLast4() {
        return cardLast4;
    }

    public void setCardLast4(String cardLast4) {
        this.cardLast4 = cardLast4;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Integer expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Integer getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Integer expirationYear) {
        this.expirationYear = expirationYear;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}


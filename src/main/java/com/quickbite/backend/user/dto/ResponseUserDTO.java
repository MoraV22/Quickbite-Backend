package com.quickbite.backend.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

//this is a template for responses when a user api request is done
public class ResponseUserDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String surname1;

    // optional
    private String surname2;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private Integer rate;

    @NotBlank
    private String role;

    // optional
    private String phoneNumber;

    // Constructors
    public ResponseUserDTO() {}

    public ResponseUserDTO(String name, String surname1, String email, Integer rate, String role) {
        this.name = name;
        this.surname1 = surname1;
        this.email = email;
        this.rate = rate;
        this.role = role;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname1() { return surname1; }
    public void setSurname1(String surname1) { this.surname1 = surname1; }

    public String getSurname2() { return surname2; }
    public void setSurname2(String surname2) { this.surname2 = surname2; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}

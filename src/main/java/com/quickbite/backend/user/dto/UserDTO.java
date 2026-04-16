package com.quickbite.backend.user.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {

    @NotNull
    private Integer id;
    @NotBlank
    private String name;

    @NotBlank
    private String surname1;

    private String surname2;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotNull
    private Integer rate;

    private String phoneNumber;

    @NotNull
    private RoleType userType;

    // Constructors
    public UserDTO() {}

    public UserDTO(Integer id,String name, String surname1,String surname2, String email, String password, RoleType userType) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.rate = 0;
    }

    public UserDTO(Integer id,String name, String surname1, String email, String password, RoleType userType) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.rate = 0;
    }
    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id){this.id = id;}

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

    public Integer getRate() { return rate; }
    public void setRate(Integer rate) { this.rate = rate; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public RoleType getUserType() { return userType; }
    public void setUserType(RoleType userType) { this.userType = userType; }
}
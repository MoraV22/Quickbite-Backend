package com.quickbite.backend.user.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
public class CreateUserDTO {

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

    @NotBlank
    private int rate;

    private String phoneNumber;

    @NotBlank
    private RoleType userType;
}
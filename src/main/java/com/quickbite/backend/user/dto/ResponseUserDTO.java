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
    private int rate;

    @NotBlank
    private String role;

    // optional
    private String phoneNumber;
}

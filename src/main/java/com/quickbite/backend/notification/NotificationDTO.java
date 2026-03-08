package com.quickbite.backend.notification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class NotificationDTO {

    @NotBlank
    private Integer id_user;

    @NotBlank
    private String title;
    @NotBlank
    private String message;

    @NotBlank
    private SubjectType subject;

    @NotBlank
    private LocalTime submitted_at;


}
package com.quickbite.backend.notification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class NotificationDTO {

    @NotNull
    private Integer userId;

    @NotBlank
    private String title;
    @NotBlank
    private String message;

    @NotNull
    private SubjectType subject;

    @NotNull
    private LocalTime submittedAt;

    // Constructors
    public NotificationDTO() {}

    public NotificationDTO(Integer userId, String title, String message, SubjectType subject) {
        this.userId = userId;
        this.title = title;
        this.message = message;
        this.subject = subject;
        this.submittedAt = LocalTime.now();
    }

    // Getters and Setters
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public SubjectType getSubject() { return subject; }
    public void setSubject(SubjectType subject) { this.subject = subject; }

    public LocalTime getSubmittedAt() { return submittedAt; }
    public void setSubmittedAt(LocalTime submittedAt) { this.submittedAt = submittedAt; }
}
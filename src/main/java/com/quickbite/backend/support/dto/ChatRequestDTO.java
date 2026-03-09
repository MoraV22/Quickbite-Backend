package com.quickbite.backend.support.dto;

import com.quickbite.backend.notification.SubjectType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class ChatRequestDTO {

    @NotNull
    private Integer userId;
    @NotNull
    private String message;
    @NotNull
    private LocalTime sentAt;
    @NotNull
    private SubjectType subject;

    public ChatRequestDTO() {
    }

    public ChatRequestDTO(Integer userId, String message, SubjectType subject) {
        this.userId = userId;
        this.message = message;
        this.subject = subject;
        this.sentAt = LocalTime.now();
    }

    public Integer getUserId() {
        return userId;
    }
    public String getMessage() {
        return message;
    }
    public LocalTime getSentAt() {
        return sentAt;
    }
    public SubjectType getSubject() {
        return subject;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setSentAt(LocalTime sentAt) {
        this.sentAt = sentAt;
    }
    public void setSubject(SubjectType subject) {
        this.subject = subject;
    }
    
    
}

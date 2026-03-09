package com.quickbite.backend.support.dto;

import com.quickbite.backend.notification.SubjectType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public class ChatAnswerDTO {
    @NotNull
    private Integer userId;
    @NotNull
    private String message;
    @NotNull
    private LocalTime receivedAt;
    @NotNull
    private SubjectType subject;

    public ChatAnswerDTO() {
    }

    public ChatAnswerDTO(Integer userId, String message, SubjectType subject) {
        this.userId = userId;
        this.message = message;
        this.subject = subject;
        this.receivedAt = LocalTime.now();
    }

    public Integer getUserId() {
        return userId;
    }
    public String getMessage() {
        return message;
    }

    public LocalTime getReceivedAt() {
        return receivedAt;
    }
    public  SubjectType getSubject() {
        return subject;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public  void setMessage(String message) {
        this.message = message;
    }
    public void setReceivedAt(LocalTime receivedAt) {
        this.receivedAt = receivedAt;
    }
    public void setSubject(SubjectType subject) {
        this.subject = subject;}
}

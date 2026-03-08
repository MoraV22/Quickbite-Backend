package com.quickbite.backend.support.dto;

import com.quickbite.backend.notification.SubjectType;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public class ChatRequestDTO {

    @NotBlank
    private Integer userId;
    @NotBlank
    private String message;
    @NotBlank
    private LocalTime sent_at;
    @NotBlank
    private SubjectType subject;
}

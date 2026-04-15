package com.quickbite.backend.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    public record HealthResponse(String status, String applicationName, Instant timestamp) {}

    private final String applicationName;

    public HealthController(@Value("${spring.application.name:quickbite}") String applicationName) {
        this.applicationName = applicationName;
    }

    @GetMapping
    public HealthResponse health() {
        return new HealthResponse("UP", applicationName, Instant.now());
    }
}


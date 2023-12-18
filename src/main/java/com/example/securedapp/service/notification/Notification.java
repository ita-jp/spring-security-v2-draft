package com.example.securedapp.service.notification;

public record Notification(
        long id,
        String message,
        String createdBy
) {
}

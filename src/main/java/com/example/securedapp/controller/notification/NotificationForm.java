package com.example.securedapp.controller.notification;

import jakarta.validation.constraints.NotBlank;

public record NotificationForm(
        @NotBlank String message
) {
}

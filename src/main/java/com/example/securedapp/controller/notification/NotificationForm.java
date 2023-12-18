package com.example.securedapp.controller.notification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NotificationForm(
        @NotBlank
        @Size(max = 256, message = "256文字以内で入力してください")
        String message
) {
}

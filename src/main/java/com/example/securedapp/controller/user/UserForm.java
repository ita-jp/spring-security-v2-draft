package com.example.securedapp.controller.user;

import com.example.securedapp.controller.validator.UniqueUsername;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank
        @UniqueUsername
        String username,
        @NotBlank
        String password
) {
}

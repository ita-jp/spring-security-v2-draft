package com.example.securedapp.controller.user;

import com.example.securedapp.controller.validator.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserForm(
        @NotBlank
        @UniqueUsername
        String username,
        @Size(min = 12, max = 100)
        String password
) {
}

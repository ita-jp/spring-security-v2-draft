package com.example.securedapp.controller.user;

import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}

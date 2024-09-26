package com.br.paulohbs.Secure.Password.domain;

import jakarta.validation.constraints.NotBlank;

public record PasswordDTO(
        @NotBlank(message = "The field is mandatory")
        String password) {
}

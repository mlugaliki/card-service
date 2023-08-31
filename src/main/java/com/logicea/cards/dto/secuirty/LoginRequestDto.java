package com.logicea.cards.dto.secuirty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record LoginRequestDto(@NotBlank
                              @Email
                              String email,
                              @NotBlank
                              String password) implements Serializable {
}

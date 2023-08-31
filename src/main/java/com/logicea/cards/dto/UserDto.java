package com.logicea.cards.dto;

import com.logicea.cards.models.Roles;

public record UserDto(String email, String firstName, String surname, String password, Roles role) {
}

package com.logicea.cards.services;

import com.logicea.cards.dto.UserDto;
import com.logicea.cards.models.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    Users findById(long id);

    Users save(UserDto user);

    Users findByEmail(String email);

    UserDetailsService userDetailsService();
}

package com.logicea.cards.services;

import com.logicea.cards.dto.secuirty.JwtAuthResponse;
import com.logicea.cards.dto.secuirty.LoginRequestDto;

public interface AuthenticationService {
    JwtAuthResponse signin(LoginRequestDto request);
}

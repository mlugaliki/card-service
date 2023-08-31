package com.logicea.cards.services.impl;

import com.logicea.cards.dto.secuirty.JwtAuthResponse;
import com.logicea.cards.dto.secuirty.LoginRequestDto;
import com.logicea.cards.repositories.UserRepository;
import com.logicea.cards.services.AuthenticationService;
import com.logicea.cards.services.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signin(LoginRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        var user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return new JwtAuthResponse(jwt);
    }
}

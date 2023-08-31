package com.logicea.cards.web;

import com.logicea.cards.dto.secuirty.JwtAuthResponse;
import com.logicea.cards.dto.secuirty.LoginRequestDto;
import com.logicea.cards.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signin(@RequestBody LoginRequestDto request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}

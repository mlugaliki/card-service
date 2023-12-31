package com.logicea.cards.web;

import com.logicea.cards.dto.CardDto;
import com.logicea.cards.dto.CardResponse;
import com.logicea.cards.dto.SearchDto;
import com.logicea.cards.models.Users;
import com.logicea.cards.services.CardService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<CardResponse<CardDto>> saveCard(@AuthenticationPrincipal Users user, @RequestBody @Valid  CardDto cardDto) {
        return ResponseEntity.ok(cardService.saveCard(user, cardDto));
    }

    @PostMapping(value = "/search")
    public ResponseEntity<CardResponse<List<CardDto>>> searchCard(@AuthenticationPrincipal Users user, @RequestBody SearchDto cardDto) {
        return ResponseEntity.ok(cardService.search(user, cardDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CardResponse<CardDto>> updateCard(@AuthenticationPrincipal Users user, @RequestBody @Valid  CardDto cardDto, @PathVariable long id) {
        return ResponseEntity.ok(cardService.saveCard(id, user, cardDto));
    }
}

package com.logicea.cards.web;

import com.logicea.cards.dto.CardDto;
import com.logicea.cards.dto.CardResponse;
import com.logicea.cards.dto.SearchDto;
import com.logicea.cards.models.Users;
import com.logicea.cards.services.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<CardResponse<CardDto>> saveCard(@AuthenticationPrincipal Users user, @RequestBody CardDto cardDto) {
        return ResponseEntity.ok(cardService.saveCard(user, cardDto));
    }

    @PostMapping(value = "/search")
    public ResponseEntity<CardResponse<List<CardDto>>> searchCard(@AuthenticationPrincipal Users user, @RequestBody SearchDto cardDto) {
        return ResponseEntity.ok(cardService.search(user, cardDto));
    }
}

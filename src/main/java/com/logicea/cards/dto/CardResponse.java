package com.logicea.cards.dto;

import lombok.Data;

@Data
public class CardResponse<T> {
    private String status;
    private String message;
    private T data;

    public CardResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}

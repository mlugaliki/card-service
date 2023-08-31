package com.logicea.cards.dto;

import com.logicea.cards.models.Status;

import java.io.Serializable;
import java.time.LocalDate;

public record SearchDto(String name,
                        String colour,
                        Status status,
                        LocalDate createDate,
                        String orderColumn,
                        String direction) implements Serializable {
    // name, color, status and date of creation
}

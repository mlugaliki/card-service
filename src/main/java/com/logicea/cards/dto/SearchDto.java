package com.logicea.cards.dto;

import com.logicea.cards.models.Status;

import java.io.Serializable;
import java.time.LocalDate;

public record SearchDto(String name,
                        String colour,
                        Status status,
                        LocalDate createDate,
                        OrderColumn orderColumn,
                        OrderBy direction) implements Serializable {
}

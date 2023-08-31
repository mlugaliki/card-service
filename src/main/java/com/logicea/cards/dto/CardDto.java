package com.logicea.cards.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.logicea.cards.models.Status;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CardDto(Long id,
                      String name,
                      String description,
                      String colour,
                      Status status,
                      LocalDateTime createdAt) implements Serializable {
}

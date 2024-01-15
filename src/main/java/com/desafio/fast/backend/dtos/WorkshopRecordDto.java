package com.desafio.fast.backend.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record WorkshopRecordDto(@NotBlank String nome, @NotNull String dataRealizacao, @NotBlank String descricao) {
}

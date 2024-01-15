package com.desafio.fast.backend.dtos;

import jakarta.validation.constraints.NotBlank;

public record ColaboradorRecordDto(@NotBlank String nome) {
}

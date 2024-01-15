package com.desafio.fast.backend.dtos;

import com.desafio.fast.backend.models.ColaboradorModel;
import com.desafio.fast.backend.models.WorkshopModel;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record AtaRecordDto(@NotNull WorkshopModel workshop, List<ColaboradorModel> colaboradores) {
}

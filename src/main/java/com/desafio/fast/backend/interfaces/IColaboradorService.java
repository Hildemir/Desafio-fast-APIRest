package com.desafio.fast.backend.interfaces;

import com.desafio.fast.backend.dtos.ColaboradorRecordDto;
import com.desafio.fast.backend.models.ColaboradorModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IColaboradorService {
    ColaboradorModel salvarColaborador(ColaboradorRecordDto colaboradorRecordDto);

    List<ColaboradorModel> resgatarColaboradores();

    Optional<ColaboradorModel> resgatarColaborador(UUID id);

    Object atualizarColaborador(ColaboradorModel colaboradorModel, ColaboradorRecordDto colaboradorRecordDto);
    void deletarColaborador(UUID id);
}

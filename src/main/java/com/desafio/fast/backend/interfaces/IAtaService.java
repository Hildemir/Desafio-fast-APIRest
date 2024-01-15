package com.desafio.fast.backend.interfaces;

import com.desafio.fast.backend.dtos.AtaRecordDto;
import com.desafio.fast.backend.models.AtaModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IAtaService {
    AtaModel salvarAta(AtaRecordDto ataRecordDto);

    Optional<AtaModel> resgatarAta(UUID id);

    List<AtaModel> resgatarAtas();

    Object atualizarAta(AtaModel ataModel, AtaRecordDto ataRecordDto);

    void deletarAta(UUID id);

    AtaModel adicionarColaborador(AtaModel ataModel, UUID idColaborador);

    AtaModel removerColaborador(AtaModel ataModel, UUID idColaborador);
}

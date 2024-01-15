package com.desafio.fast.backend.interfaces;

import com.desafio.fast.backend.dtos.AtaRecordDto;
import com.desafio.fast.backend.dtos.ColaboradorRecordDto;
import com.desafio.fast.backend.models.AtaModel;
import com.desafio.fast.backend.models.ColaboradorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IAtaController {
    ResponseEntity<AtaModel> salvarAta(AtaRecordDto ataRecordDto);

    ResponseEntity<List<AtaModel>> resgatarAtas();

    ResponseEntity<Object> resgatarAta(UUID id);

    ResponseEntity<Object> atualizarAta(UUID id, AtaRecordDto ataRecordDto);

    ResponseEntity<Object> deletarAta(UUID id);

    ResponseEntity<Object> adicionarColaborador(UUID id, UUID idColaborador);

    ResponseEntity<Object> removerColaborador(UUID id, UUID idColaborador);
}

package com.desafio.fast.backend.interfaces;

import com.desafio.fast.backend.dtos.ColaboradorRecordDto;
import com.desafio.fast.backend.models.ColaboradorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IColaboradorController {

    ResponseEntity<ColaboradorModel> salvarColaborador(ColaboradorRecordDto colaboradorRecordDto);

    ResponseEntity<List<ColaboradorModel>> resgatarColaboradores();

    ResponseEntity<Object> resgatarColaborador(UUID id);

    ResponseEntity<Object> atualizarColaborador(UUID id, ColaboradorRecordDto colaboradorRecordDto);

    ResponseEntity<Object> deletarColaborador(UUID id);
}

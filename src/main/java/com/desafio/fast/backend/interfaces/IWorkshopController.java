package com.desafio.fast.backend.interfaces;

import com.desafio.fast.backend.dtos.WorkshopRecordDto;
import com.desafio.fast.backend.models.WorkshopModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface IWorkshopController {
    ResponseEntity<WorkshopModel> salvarWorkshop(WorkshopRecordDto workshopRecordDto);

    ResponseEntity<List<WorkshopModel>> resgatarWorkshops();

    ResponseEntity<Object> resgatarWorkshop(UUID id);

    ResponseEntity<Object> atualizarWorkshop(UUID id, WorkshopRecordDto workshopRecordDto);

    ResponseEntity<Object> deletarWorkshop(UUID id);
}

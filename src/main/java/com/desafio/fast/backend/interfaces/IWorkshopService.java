package com.desafio.fast.backend.interfaces;

import com.desafio.fast.backend.dtos.WorkshopRecordDto;
import com.desafio.fast.backend.models.ColaboradorModel;
import com.desafio.fast.backend.models.WorkshopModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IWorkshopService {
    WorkshopModel salvarWorkshop(WorkshopRecordDto workshopRecordDto);

    List<WorkshopModel> resgatarWorkshops();

    Optional<WorkshopModel> resgatarWorkshop(UUID id);

    Object atualizarWorkshop(WorkshopModel workshopModel, WorkshopRecordDto workshopRecordDto);

    void deletarWorkshop(UUID id);
}

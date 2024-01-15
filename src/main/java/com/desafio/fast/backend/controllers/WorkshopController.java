package com.desafio.fast.backend.controllers;

import com.desafio.fast.backend.dtos.WorkshopRecordDto;
import com.desafio.fast.backend.interfaces.IWorkshopController;
import com.desafio.fast.backend.interfaces.IWorkshopService;
import com.desafio.fast.backend.models.ColaboradorModel;
import com.desafio.fast.backend.models.WorkshopModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class WorkshopController implements IWorkshopController {

    @Autowired
    private IWorkshopService workshopService;

    @PostMapping("/workshops")
    @Override
    public ResponseEntity<WorkshopModel> salvarWorkshop(@RequestBody @Valid WorkshopRecordDto workshopRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workshopService.salvarWorkshop(workshopRecordDto));
    }

    @GetMapping("/workshops")
    @Override
    public ResponseEntity<List<WorkshopModel>> resgatarWorkshops() {
        return ResponseEntity.status(HttpStatus.OK).body(workshopService.resgatarWorkshops());
    }

    @GetMapping("/workshops/{id}")
    @Override
    public ResponseEntity<Object> resgatarWorkshop(@PathVariable(value = "id") UUID id) {
        Optional<WorkshopModel> workshop = workshopService.resgatarWorkshop(id);
        if(workshop.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workshop não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(workshop.get());
    }

    @PutMapping("/workshops/{id}")
    @Override
    public ResponseEntity<Object> atualizarWorkshop(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid WorkshopRecordDto workshopRecordDto) {
        Optional<WorkshopModel> workshop = workshopService.resgatarWorkshop(id);
        if(workshop.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workshop não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(workshopService.atualizarWorkshop(workshop.get(), workshopRecordDto));
    }

    @DeleteMapping("/workshops/{id}")
    @Override
    public ResponseEntity<Object> deletarWorkshop(@PathVariable(value = "id") UUID id) {
        Optional<WorkshopModel> workshop = workshopService.resgatarWorkshop(id);
        if(workshop.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workshop nãoi encontrado");
        }
        workshopService.deletarWorkshop(id);
        return ResponseEntity.status(HttpStatus.OK).body("Workshop deletado com sucesso.");
    }
}

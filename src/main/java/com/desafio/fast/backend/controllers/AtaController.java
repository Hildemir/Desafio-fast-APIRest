package com.desafio.fast.backend.controllers;

import com.desafio.fast.backend.dtos.AtaRecordDto;
import com.desafio.fast.backend.dtos.ColaboradorRecordDto;
import com.desafio.fast.backend.interfaces.IAtaController;
import com.desafio.fast.backend.interfaces.IAtaService;
import com.desafio.fast.backend.models.AtaModel;
import com.desafio.fast.backend.models.ColaboradorModel;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class AtaController implements IAtaController {

    @Autowired
    IAtaService ataService;

    @PostMapping("/atas")
    @Override
    public ResponseEntity<AtaModel> salvarAta(@RequestBody @Valid AtaRecordDto ataRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ataService.salvarAta(ataRecordDto));
    }

    @GetMapping("/atas")
    @Override
    public ResponseEntity<List<AtaModel>> resgatarAtas() {
        return ResponseEntity.status(HttpStatus.OK).body(ataService.resgatarAtas());
    }

    @GetMapping("/atas/{id}")
    @Override
    public ResponseEntity<Object> resgatarAta(@PathVariable(value="id")UUID id) {
        Optional<AtaModel> ata =  ataService.resgatarAta(id);
        if(ata.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ata não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ata.get());
    }

    @PutMapping("/atas/{id}")
    @Override
    public ResponseEntity<Object> atualizarAta(@PathVariable(value="id") UUID id,
                                               @RequestBody @Valid AtaRecordDto ataRecordDto) {
        Optional<AtaModel> ata = ataService.resgatarAta(id);
        if(ata.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ata não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ataService.atualizarAta(ata.get(), ataRecordDto));
    }

    @DeleteMapping("/atas/{id}")
    @Override
    public ResponseEntity<Object> deletarAta(@PathVariable(value="id") UUID id) {
        Optional<AtaModel> ata = ataService.resgatarAta(id);
        if(ata.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ata não encontrada.");
        }
        ataService.deletarAta(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ata deletada com sucesso.");
    }

    @PutMapping("/atas/{idAta}/colaboradores/{idColaborador}")
    @Override
    public ResponseEntity<Object> adicionarColaborador(@PathVariable(value="idAta") UUID idAta,
                                                       @PathVariable(value = "idColaborador") UUID idColaborador) {
        Optional<AtaModel> ata = ataService.resgatarAta(idAta);
        if(ata.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ata não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ataService.adicionarColaborador(ata.get(), idColaborador));
    }

    @DeleteMapping("/atas/{idAta}/colaboradores/{idColaborador}")
    @Override
    public ResponseEntity<Object> removerColaborador(@PathVariable(value="idAta") UUID idAta,
                                                       @PathVariable(value = "idColaborador") UUID idColaborador) {
        Optional<AtaModel> ata = ataService.resgatarAta(idAta);
        if(ata.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ata não encontrada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(ataService.removerColaborador(ata.get(), idColaborador));
    }
}

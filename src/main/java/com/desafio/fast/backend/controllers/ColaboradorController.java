package com.desafio.fast.backend.controllers;

import com.desafio.fast.backend.dtos.ColaboradorRecordDto;
import com.desafio.fast.backend.interfaces.IColaboradorController;
import com.desafio.fast.backend.models.ColaboradorModel;
import com.desafio.fast.backend.interfaces.IColaboradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ColaboradorController implements IColaboradorController {

    @Autowired
    IColaboradorService colaboradorService;

    @PostMapping("/colaboradores")
    @Override
    public ResponseEntity<ColaboradorModel> salvarColaborador(@RequestBody @Valid ColaboradorRecordDto colaboradorRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(colaboradorService.salvarColaborador(colaboradorRecordDto));
    }

    @GetMapping("/colaboradores")
    @Override
    public ResponseEntity<List<ColaboradorModel>> resgatarColaboradores() {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.resgatarColaboradores());
    }

    @GetMapping("/colaboradores/{id}")
    @Override
    public ResponseEntity<Object> resgatarColaborador(@PathVariable(value="id")UUID id) {
        Optional<ColaboradorModel> colaborador =  colaboradorService.resgatarColaborador(id);
        if(colaborador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(colaborador.get());
    }

    @PutMapping("/colaboradores/{id}")
    @Override
    public ResponseEntity<Object> atualizarColaborador(@PathVariable(value="id")UUID id,
                                                       @RequestBody @Valid ColaboradorRecordDto colaboradorRecordDto) {
        Optional<ColaboradorModel> colaborador = colaboradorService.resgatarColaborador(id);
        if(colaborador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.atualizarColaborador(colaborador.get(), colaboradorRecordDto));
    }

    @DeleteMapping("/colaboradores/{id}")
    @Override
    public ResponseEntity<Object> deletarColaborador(@PathVariable(value="id") UUID id) {
        Optional<ColaboradorModel> colaborador = colaboradorService.resgatarColaborador(id);
        if(colaborador.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado.");
        }
        colaboradorService.deletarColaborador(id);
        return ResponseEntity.status(HttpStatus.OK).body("Colaborador deletado com sucesso.");
    }
}

package com.desafio.fast.backend.services;

import com.desafio.fast.backend.dtos.ColaboradorRecordDto;
import com.desafio.fast.backend.interfaces.IColaboradorService;
import com.desafio.fast.backend.models.ColaboradorModel;
import com.desafio.fast.backend.repositories.ColaboradorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ColaboradorService implements IColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Override
    public ColaboradorModel salvarColaborador(ColaboradorRecordDto colaboradorRecordDto) {
        var colaboradorModel = new ColaboradorModel();
        BeanUtils.copyProperties(colaboradorRecordDto, colaboradorModel);
        return colaboradorRepository.save(colaboradorModel);
    }

    @Override
    public List<ColaboradorModel> resgatarColaboradores() {
        return colaboradorRepository.findAll();
    }

    @Override
    public Optional<ColaboradorModel> resgatarColaborador(UUID id) {
        return colaboradorRepository.findById(id);
    }

    @Override
    public Object atualizarColaborador(ColaboradorModel colaboradorModel, ColaboradorRecordDto colaboradorRecordDto) {
        BeanUtils.copyProperties(colaboradorRecordDto, colaboradorModel);
        return colaboradorRepository.save(colaboradorModel);
    }

    @Override
    public void deletarColaborador(UUID id) {
        colaboradorRepository.deleteById(id);
    }
}

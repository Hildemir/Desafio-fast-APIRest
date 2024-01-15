package com.desafio.fast.backend.services;

import com.desafio.fast.backend.dtos.AtaRecordDto;
import com.desafio.fast.backend.interfaces.IAtaService;
import com.desafio.fast.backend.models.AtaModel;
import com.desafio.fast.backend.models.ColaboradorModel;
import com.desafio.fast.backend.repositories.AtaRepository;
import com.desafio.fast.backend.repositories.ColaboradorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtaService implements IAtaService {

    @Autowired
    AtaRepository ataRepository;

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Override
    public AtaModel salvarAta(AtaRecordDto ataRecordDto) {
        var ataModel = new AtaModel();
        BeanUtils.copyProperties(ataRecordDto, ataModel);
        return ataRepository.save(ataModel);
    }

    @Override
    public List<AtaModel> resgatarAtas() {
        return ataRepository.findAll();
    }

    @Override
    public Optional<AtaModel> resgatarAta(UUID id) {
        return ataRepository.findById(id);
    }

    @Override
    public Object atualizarAta(AtaModel ataModel, AtaRecordDto ataRecordDto) {
        BeanUtils.copyProperties(ataRecordDto, ataModel);
        return ataRepository.save(ataModel);
    }

    @Override
    public void deletarAta(UUID id) {
        ataRepository.deleteById(id);
    }

    @Override
    public AtaModel adicionarColaborador(AtaModel ataModel, UUID idColaborador) {
        ColaboradorModel novoParticipante = colaboradorRepository.findById(idColaborador).get();
        List<ColaboradorModel> participantes = ataModel.getColaboradores();
        participantes.add(novoParticipante);
        ataModel.setColaboradores(participantes);
        return ataRepository.save(ataModel);
    }

    @Override
    public AtaModel removerColaborador(AtaModel ataModel, UUID idColaborador) {
        ColaboradorModel exParticipante = colaboradorRepository.findById(idColaborador).get();
        List<ColaboradorModel> participantes = ataModel.getColaboradores();
        participantes.remove(exParticipante);
        ataModel.setColaboradores(participantes);
        return ataRepository.save(ataModel);
    }
}

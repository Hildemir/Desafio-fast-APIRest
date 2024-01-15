package com.desafio.fast.backend.services;

import com.desafio.fast.backend.dtos.WorkshopRecordDto;
import com.desafio.fast.backend.interfaces.IWorkshopService;
import com.desafio.fast.backend.models.WorkshopModel;
import com.desafio.fast.backend.repositories.WorkshopRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkshopService implements IWorkshopService {

    @Autowired
    WorkshopRepository workshopRepository;

    @Override
    public WorkshopModel salvarWorkshop(WorkshopRecordDto workshopRecordDto) {
        var workshopModel = new WorkshopModel();
        BeanUtils.copyProperties(workshopRecordDto, workshopModel);
        return workshopRepository.save(workshopModel);
    }

    @Override
    public List<WorkshopModel> resgatarWorkshops() {
        return workshopRepository.findAll();
    }

    @Override
    public Optional<WorkshopModel> resgatarWorkshop(UUID id) {
        return workshopRepository.findById(id);
    }

    @Override
    public Object atualizarWorkshop(WorkshopModel workshopModel, WorkshopRecordDto workshopRecordDto) {
        BeanUtils.copyProperties(workshopRecordDto, workshopModel);
        return workshopRepository.save(workshopModel);
    }

    @Override
    public void deletarWorkshop(UUID id) {
        workshopRepository.deleteById(id);
    }
}

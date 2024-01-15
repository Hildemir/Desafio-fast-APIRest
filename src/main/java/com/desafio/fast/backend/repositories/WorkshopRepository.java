package com.desafio.fast.backend.repositories;

import com.desafio.fast.backend.models.WorkshopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkshopRepository extends JpaRepository<WorkshopModel, UUID> {
}

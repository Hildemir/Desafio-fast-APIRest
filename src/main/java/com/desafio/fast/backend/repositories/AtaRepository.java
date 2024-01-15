package com.desafio.fast.backend.repositories;

import com.desafio.fast.backend.models.AtaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AtaRepository extends JpaRepository<AtaModel, UUID> {
}

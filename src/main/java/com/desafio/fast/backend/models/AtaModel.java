package com.desafio.fast.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ATA")
public class AtaModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAta;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private WorkshopModel workshop;

    @ManyToMany
    @JoinTable(
            name = "ata_colaborador",
            joinColumns = @JoinColumn(name = "ata_id"),
            inverseJoinColumns = @JoinColumn(name = "colaborador_id")
    )
    private List<ColaboradorModel> colaboradores;

    public UUID getIdAta() {
        return idAta;
    }

    public void setIdAta(UUID idAta) {
        this.idAta = idAta;
    }

    public WorkshopModel getWorkshop() {
        return workshop;
    }

    public void setWorkshop(WorkshopModel workshop) {
        this.workshop = workshop;
    }

    public List<ColaboradorModel> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<ColaboradorModel> colaboradores) {
        this.colaboradores = colaboradores;
    }
}

package com.desafio.fast.backend.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_COLABORADOR")
public class ColaboradorModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idColaborador;
    private String nome;

    public UUID getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(UUID idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

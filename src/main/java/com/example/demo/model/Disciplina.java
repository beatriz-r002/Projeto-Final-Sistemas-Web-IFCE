package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplina") // Nome exato da tabela no seu banco
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT no MySQL
    @Column(name = "cód_disciplina") // Mapeia o nome exato da coluna com acento
    private Integer codDisciplina;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    // --- CONSTRUTORES ---
    public Disciplina() {
    }

    public Disciplina(String nome, Integer cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    // --- GETTERS E SETTERS ---
    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
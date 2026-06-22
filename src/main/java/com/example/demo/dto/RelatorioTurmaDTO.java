package com.example.demo.dto;

import com.example.demo.model.Disciplina;

public class RelatorioTurmaDTO {
    private Disciplina disciplina;
    private long totalAlunos;
    private long totalTurmas;

    public RelatorioTurmaDTO(Disciplina disciplina, long totalAlunos, long totalTurmas) {
        this.disciplina = disciplina;
        this.totalAlunos = totalAlunos;
        this.totalTurmas = totalTurmas;
    }

    public Disciplina getDisciplina() { return disciplina; }
    public long getTotalAlunos() { return totalAlunos; }
    public long getTotalTurmas() { return totalTurmas; }
    public long getTotalCargaHoraria() { return disciplina.getCargaHoraria() * totalTurmas; }
}
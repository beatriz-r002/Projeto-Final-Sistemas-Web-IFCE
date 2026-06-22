package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT do cód_turma
    @Column(name = "cód_turma")
    private Integer codTurma;

    @ManyToOne
    @JoinColumn(name = "matricula_professor", nullable = false) // Chave estrangeira para professores
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "cód_disciplina", nullable = false) // Chave estrangeira para disciplina
    private Disciplina disciplina;

    @Column(nullable = false)
    private Integer semestre;

    @Column(name = "núm_alunos", nullable = false)
    private Integer numAlunos;

    @Column(nullable = false)
    private String turno; // No banco está como ENUM, no Java tratamos como String tranquilamente

    // --- CONSTRUTORES ---
    public Turma() {
    }

    public Turma(Professor professor, Disciplina disciplina, Integer semestre, Integer numAlunos, String turno) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.semestre = semestre;
        this.numAlunos = numAlunos;
        this.turno = turno;
    }

    // --- GETTERS E SETTERS ---
    public Integer getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Integer codTurma) {
        this.codTurma = codTurma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumAlunos() {
        return numAlunos;
    }

    public void setNumAlunos(Integer numAlunos) {
        this.numAlunos = numAlunos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
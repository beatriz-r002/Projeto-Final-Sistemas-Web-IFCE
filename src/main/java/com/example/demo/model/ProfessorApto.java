package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professor_apto")
public class ProfessorApto {

    @EmbeddedId
    private ProfessorAptoMat id = new ProfessorAptoMat();

    @ManyToOne
    @MapsId("matriculaProfessor") // Liga com o atributo dentro de ProfessorAptoId
    @JoinColumn(name = "matricula_professor") // Nome exato da coluna no MySQL
    private Professor professor;

    @ManyToOne
    @MapsId("codDisciplina") // Liga com o atributo dentro de ProfessorAptoId
    @JoinColumn(name = "cód_disciplina") // Nome exato da coluna no MySQL
    private Disciplina disciplina;

    // Construtores
    public ProfessorApto() {}

    public ProfessorApto(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
        this.id = new ProfessorAptoMat(professor.getMatricula(), disciplina.getCodDisciplina());
    }

    // Getters e Setters
    public ProfessorAptoMat getId() { return id; }
    public void setId(ProfessorAptoMat id) { this.id = id; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public Disciplina getDisciplina() { return disciplina; }
    public void setDisciplina(Disciplina disciplina) { this.disciplina = disciplina; }
}
package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class ProfessorAptoMat implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer matriculaProfessor;
    private Integer codDisciplina;

    // Construtor padrão
    public ProfessorAptoMat() {}

    public ProfessorAptoMat(Integer matriculaProfessor, Integer codDisciplina) {
        this.matriculaProfessor = matriculaProfessor;
        this.codDisciplina = codDisciplina;
    }

    // Getters e Setters
    public Integer getMatriculaProfessor() { return matriculaProfessor; }
    public void setMatriculaProfessor(Integer matriculaProfessor) { this.matriculaProfessor = matriculaProfessor; }

    public Integer getCodDisciplina() { return codDisciplina; }
    public void setCodDisciplina(Integer codDisciplina) { this.codDisciplina = codDisciplina; }

    // Obrigatório para chaves compostas em Java
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfessorAptoMat that = (ProfessorAptoMat) o;
        return Objects.equals(matriculaProfessor, that.matriculaProfessor) && 
               Objects.equals(codDisciplina, that.codDisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaProfessor, codDisciplina);
    }
}
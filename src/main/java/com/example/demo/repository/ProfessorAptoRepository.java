package com.example.demo.repository;

import com.example.demo.model.ProfessorApto;
import com.example.demo.model.ProfessorAptoMat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfessorAptoRepository extends JpaRepository<ProfessorApto, ProfessorAptoMat> {
    List<ProfessorApto> findByDisciplinaCodDisciplina(Integer codDisciplina);
    List<ProfessorApto> findByProfessorMatricula(Integer matricula);
}
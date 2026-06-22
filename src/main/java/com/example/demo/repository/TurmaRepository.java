package com.example.demo.repository;

import com.example.demo.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {
    List<Turma> findByProfessorMatricula(Integer matricula);
}
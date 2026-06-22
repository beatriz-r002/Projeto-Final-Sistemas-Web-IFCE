package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professor-apto")
public class ProfessorAptoController {

    @Autowired private ProfessorAptoRepository professorAptoRepository;
    @Autowired private ProfessorRepository professorRepository;
    @Autowired private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("registros", professorAptoRepository.findAll());
        return "professor-apto/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("professores", professorRepository.findAll());
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        return "professor-apto/form";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam Integer matriculaProfessor,
                         @RequestParam Integer codDisciplina) {
        Professor professor = professorRepository.findById(matriculaProfessor)
            .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        Disciplina disciplina = disciplinaRepository.findById(codDisciplina)
            .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        ProfessorAptoMat id = new ProfessorAptoMat(matriculaProfessor, codDisciplina);
        if (!professorAptoRepository.existsById(id)) {
            professorAptoRepository.save(new ProfessorApto(professor, disciplina));
        }
        return "redirect:/professor-apto";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam Integer matriculaProfessor,
                          @RequestParam Integer codDisciplina) {
        ProfessorAptoMat id = new ProfessorAptoMat(matriculaProfessor, codDisciplina);
        professorAptoRepository.deleteById(id);
        return "redirect:/professor-apto";
    }
}
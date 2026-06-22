package com.example.demo.controller;

import com.example.demo.model.Turma;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired private TurmaRepository turmaRepository;
    @Autowired private ProfessorRepository professorRepository;
    @Autowired private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("turmas", turmaRepository.findAll());
        return "turmas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("turma", new Turma());
        model.addAttribute("professores", professorRepository.findAll());
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        return "turmas/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Turma turma = turmaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        model.addAttribute("turma", turma);
        model.addAttribute("professores", professorRepository.findAll());
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        return "turmas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@RequestParam(required = false) Integer codTurma,
                         @RequestParam Integer matriculaProfessor,
                         @RequestParam Integer codDisciplina,
                         @RequestParam Integer semestre,
                         @RequestParam Integer numAlunos,
                         @RequestParam String turno) {
        Turma turma = codTurma != null
            ? turmaRepository.findById(codTurma).orElse(new Turma())
            : new Turma();

        turma.setProfessor(professorRepository.findById(matriculaProfessor).orElseThrow());
        turma.setDisciplina(disciplinaRepository.findById(codDisciplina).orElseThrow());
        turma.setSemestre(semestre);
        turma.setNumAlunos(numAlunos);
        turma.setTurno(turno);
        turmaRepository.save(turma);
        return "redirect:/turmas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        turmaRepository.deleteById(id);
        return "redirect:/turmas";
    }
}
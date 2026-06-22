package com.example.demo.controller;

import com.example.demo.dto.RelatorioTurmaDTO;
import com.example.demo.model.Turma;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired private DisciplinaRepository disciplinaRepository;
    @Autowired private ProfessorRepository professorRepository;
    @Autowired private ProfessorAptoRepository professorAptoRepository;
    @Autowired private TurmaRepository turmaRepository;

    @GetMapping
    public String index() {
        return "consultas/index";
    }

    // Consulta E: professores aptos por disciplina
    @GetMapping("/por-disciplina")
    public String porDisciplina(Model model,
                                @RequestParam(required = false) Integer codDisciplina) {
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        if (codDisciplina != null) {
            model.addAttribute("registros",
                professorAptoRepository.findByDisciplinaCodDisciplina(codDisciplina));
            model.addAttribute("disciplinaSelecionada",
                disciplinaRepository.findById(codDisciplina).orElse(null));
        }
        return "consultas/por-disciplina";
    }

    // Consulta F: disciplinas ministradas por professor com totais
    @GetMapping("/por-professor")
    public String porProfessor(Model model,
                               @RequestParam(required = false) Integer matricula) {
        model.addAttribute("professores", professorRepository.findAll());
        if (matricula != null) {
            List<Turma> turmas = turmaRepository.findByProfessorMatricula(matricula);

            List<RelatorioTurmaDTO> relatorio = turmas.stream()
                .collect(Collectors.groupingBy(t -> t.getDisciplina().getCodDisciplina()))
                .entrySet().stream()
                .map(e -> {
                    List<Turma> grupo = e.getValue();
                    long totalAlunos = grupo.stream().mapToLong(Turma::getNumAlunos).sum();
                    return new RelatorioTurmaDTO(grupo.get(0).getDisciplina(), totalAlunos, grupo.size());
                })
                .collect(Collectors.toList());

            model.addAttribute("relatorio", relatorio);
            model.addAttribute("professorSelecionado",
                professorRepository.findById(matricula).orElse(null));
        }
        return "consultas/por-professor";
    }
}
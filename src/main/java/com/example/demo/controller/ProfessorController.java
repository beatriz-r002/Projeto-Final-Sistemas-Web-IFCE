package com.example.demo.controller;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("professores", professorRepository.findAll());
        return "professores/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("professor", new Professor());
        return "professores/form";
    }

    @GetMapping("/editar/{matricula}")
    public String editar(@PathVariable Integer matricula, Model model) {
        Professor professor = professorRepository.findById(matricula)
            .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        model.addAttribute("professor", professor);
        return "professores/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Professor professor) {
        professorRepository.save(professor);
        return "redirect:/professores";
    }

    @GetMapping("/excluir/{matricula}")
    public String excluir(@PathVariable Integer matricula) {
        professorRepository.deleteById(matricula);
        return "redirect:/professores";
    }
}
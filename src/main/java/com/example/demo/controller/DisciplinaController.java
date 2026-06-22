package com.example.demo.controller;

import com.example.demo.model.Disciplina;
import com.example.demo.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("disciplinas", disciplinaRepository.findAll());
        return "disciplinas/lista";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplinas/form";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
        model.addAttribute("disciplina", disciplina);
        return "disciplinas/form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
        return "redirect:/disciplinas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Integer id) {
        disciplinaRepository.deleteById(id);
        return "redirect:/disciplinas";
    }
}
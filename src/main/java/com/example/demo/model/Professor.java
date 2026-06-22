package com.example.demo.model; // 

import jakarta.persistence.*;

@Entity
@Table(name = "professores") // Nome exato da tabela no phpMyAdmin
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Isso indica que é AUTO_INCREMENT
    private Integer matricula;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(length = 50)
    private String telefone;

    // --- CONSTRUTORES ---
    public Professor() {
    }

    public Professor(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // --- GETTERS E SETTERS ---
    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
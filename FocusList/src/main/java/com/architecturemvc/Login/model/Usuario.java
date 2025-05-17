package com.architecturemvc.Login.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "login")
    private String login;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL)
    private List<Tarefas> tarefas = new ArrayList<>();

}

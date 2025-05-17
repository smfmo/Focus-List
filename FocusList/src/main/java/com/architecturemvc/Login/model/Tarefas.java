package com.architecturemvc.Login.model;

import com.architecturemvc.Login.model.Enum.Prioridade;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private LocalDate dataCriacao = LocalDate.now();

    @Column
    private LocalDate dataConclusao;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.MEDIA;

    @Column
    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}

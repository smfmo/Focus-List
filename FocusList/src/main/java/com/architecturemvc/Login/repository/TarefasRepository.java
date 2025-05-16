package com.architecturemvc.Login.repository;

import com.architecturemvc.Login.model.Tarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TarefasRepository extends JpaRepository<Tarefas, UUID> {

}

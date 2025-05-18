package com.architecturemvc.Login.service;

import com.architecturemvc.Login.model.Tarefas;
import com.architecturemvc.Login.repository.TarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;

    public List<Tarefas> listarTarefas(String email){
        if (tarefasRepository.findByUsuarioEmail(email) != null){
            return tarefasRepository.findAll();
        }
        return null;
    }

    public void salvar(Tarefas tarefas){
        tarefasRepository.save(tarefas);
    }

    public void marcarConcluida(UUID id){
        Tarefas tarefas = tarefasRepository.findById(id).orElseThrow();
        tarefas.setConcluida(!tarefas.isConcluida());
        tarefasRepository.save(tarefas);
    }

    public void deletar(UUID id){
        if(tarefasRepository.existsById(id)){
            tarefasRepository.deleteById(id);
        }
    }
}

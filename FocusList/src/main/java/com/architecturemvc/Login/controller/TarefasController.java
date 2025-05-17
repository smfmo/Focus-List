package com.architecturemvc.Login.controller;

import com.architecturemvc.Login.model.Tarefas;
import com.architecturemvc.Login.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;

    @GetMapping
    public String listarTarefas(Model model){
        model.addAttribute("tarefas", tarefasService.listarTarefas());
        model.addAttribute("tarefa", new Tarefas());
        return "tarefas";
    }

    @PostMapping
    public String salvarTarefa(@ModelAttribute Tarefas tarefas){
        tarefasService.salvar(tarefas);
        return "redirect:/tarefas";
    }

    @GetMapping("concluida/{id}")
    public String marcarConcluida(@PathVariable("id") UUID id){
        tarefasService.marcarConcluida(id);
        return "redirect:/tarefas";
    }

    @DeleteMapping("/{id}")
    public String deletarTarefa(@PathVariable("id") UUID id){
        tarefasService.deletar(id);
        return "redirect:/tarefas";
    }
}

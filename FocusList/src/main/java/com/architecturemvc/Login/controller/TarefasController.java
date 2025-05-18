package com.architecturemvc.Login.controller;

import com.architecturemvc.Login.model.Tarefas;
import com.architecturemvc.Login.model.Usuario;
import com.architecturemvc.Login.repository.UsuarioRepository;
import com.architecturemvc.Login.service.TarefasService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tarefas")
public class TarefasController {

    private final TarefasService tarefasService;
    private final UsuarioRepository repository;

    @GetMapping
    public String listarTarefas(Model model, Authentication authentication){
        String email = authentication.getName();

        List<Tarefas> tarefas = tarefasService.listarTarefas(email);
        model.addAttribute("tarefas", tarefas);
        return "tarefas";
    }

    @PostMapping
    public String salvarTarefa(@ModelAttribute Tarefas tarefas,
                               Authentication authentication){
        String email = authentication.getName();
        Usuario usuario = repository.findByEmail(email);
        tarefas.setUsuario(usuario);
        tarefasService.salvar(tarefas);
        return "redirect:/tarefas";
    }

    @GetMapping("concluida/{id}")
    public String marcarConcluida(@PathVariable("id") UUID id){
        tarefasService.marcarConcluida(id);
        return "redirect:/tarefas";
    }

    @GetMapping("/{id}")
    public String deletarTarefa(@PathVariable("id") UUID id){
        tarefasService.deletar(id);
        return "redirect:/tarefas";
    }
}

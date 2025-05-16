package com.architecturemvc.Login.service;

import com.architecturemvc.Login.model.Usuario;
import com.architecturemvc.Login.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void salvarUsuario(Usuario usuario){

    }
}

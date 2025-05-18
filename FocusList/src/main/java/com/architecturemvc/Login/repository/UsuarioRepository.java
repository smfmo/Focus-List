package com.architecturemvc.Login.repository;

import com.architecturemvc.Login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Usuario findByEmail(String email);
}

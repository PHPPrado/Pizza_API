package com.project.pizzaria.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Procura o email passado no banco de dados
    UserDetails findByEmail(String email);
}

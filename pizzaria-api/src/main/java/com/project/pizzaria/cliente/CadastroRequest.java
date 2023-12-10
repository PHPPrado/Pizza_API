package com.project.pizzaria.cliente;

import com.project.pizzaria.usuario.RegistroDTO;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

// Classe que une 2 DTOs diferentes para popular 2 tabelas durante o cadastro

@Getter
@Setter
public class CadastroRequest {
    @Valid
    private ClienteDTO clienteDTO;
    @Valid
    private RegistroDTO registroDTO;
}

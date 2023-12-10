package com.project.pizzaria.cliente;

//Responsável pela tabela Cliente onde estão cadastradados dados pessoais dos usuários
public record ClienteDTO(String nome, String cpf, String cepEntrega, String telefone) {
}

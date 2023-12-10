package com.project.pizzaria.usuario;

//Responsável pela tabela usuários no banco de dados, onde estão contidos email e senha cadastrados
public record RegistroDTO(String email, String senha, UsuarioRole role) {
}

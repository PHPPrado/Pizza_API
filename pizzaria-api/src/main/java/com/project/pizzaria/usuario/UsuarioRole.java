package com.project.pizzaria.usuario;

public enum UsuarioRole {

    //Cargo dos usuários autenticados
    USER("user");

    private String role;

    UsuarioRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

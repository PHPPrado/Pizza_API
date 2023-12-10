package com.project.pizzaria.cliente;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @NotNull
    @Email
    private String email;

    @NotBlank(message = "O campo não pode estar vazio")
    private String nome;


    @NotNull
    @Size(min = 11, max = 11)
    private String cpf;


    @Pattern(regexp = "\\d{8}")
    @Size(min = 8, max = 8)
    private String cepEntrega;

    @Size(min = 11, max = 11)
    private String telefone;

    public Cliente(String email, String nome, String cpf, String cepEntrega, String telefone) {

        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.cepEntrega = cepEntrega;
        this.telefone = telefone;
    }


    //ajustar depois
    public boolean logar(){

        return true ;
    }

    public boolean resetSenha(){

        return false;
    }



}

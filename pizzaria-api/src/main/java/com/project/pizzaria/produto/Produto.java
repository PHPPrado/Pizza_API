package com.project.pizzaria.produto;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table
@Entity
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;
    @NotBlank(message = "O campo não pode estar vazio")
    private String nome;
    private String descrição;
    @NotNull(message = "O campo não pode ser nulo")
    private float valor;


    //ajustar a lógica para atualizar o valor no bd
    public boolean atualizarValor(float novoValor){

        return true;
    }


}

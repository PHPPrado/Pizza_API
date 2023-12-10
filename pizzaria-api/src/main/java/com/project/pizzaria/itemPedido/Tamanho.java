package com.project.pizzaria.itemPedido;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tamanho {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTamanho;

    @NotBlank(message = "O campo não pode estar vazio")
    private String tamanho;

}

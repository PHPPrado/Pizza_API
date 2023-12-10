package com.project.pizzaria.pedido;

import com.project.pizzaria.cliente.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @DateTimeFormat
    private LocalDateTime momento;

    @NotNull
    @NotBlank
    private float valor;

    private String status;

    @NotNull
    @NotBlank
    private String pagamento;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    private void adicionarItem(){

    }

    private void finalizarPedido(){

    }


}

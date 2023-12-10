package com.project.pizzaria.pedido;

import com.project.pizzaria.produto.Produto;
import com.project.pizzaria.cliente.Cliente;


import java.time.LocalDateTime;

public record PedidoResponseDTO(Integer idPedido, LocalDateTime momento, String Status, Float valor, Cliente Cliente
        , String pagamento ) {
    public PedidoResponseDTO(Pedido pedido) {
        this (pedido.getIdPedido(), pedido.getMomento(), pedido.getStatus(),
                pedido.getValor(), pedido.getCliente(), pedido.getPagamento());
    }
}

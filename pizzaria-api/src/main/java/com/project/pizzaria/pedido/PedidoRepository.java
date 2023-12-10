package com.project.pizzaria.pedido;

import com.project.pizzaria.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Pedido findByIdPedido(int id);

    List<Pedido> findByCliente(Cliente cliente);
}



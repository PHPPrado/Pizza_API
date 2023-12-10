package com.project.pizzaria.itemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TamanhoRepository extends JpaRepository<Tamanho, Integer> {
    Tamanho findByTamanho(String tamanho);
}

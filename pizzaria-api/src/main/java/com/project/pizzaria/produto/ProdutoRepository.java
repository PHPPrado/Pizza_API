package com.project.pizzaria.produto;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Produto findByIdProduto(int id);
}

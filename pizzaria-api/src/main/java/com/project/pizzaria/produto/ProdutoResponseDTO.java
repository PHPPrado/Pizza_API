package com.project.pizzaria.produto;

public record ProdutoResponseDTO(Integer id, String nome, String descrição, Float valor ) {
    public ProdutoResponseDTO(Produto produto) {
        this (produto.getIdProduto(), produto.getNome(), produto.getDescrição(), produto.getValor());
    }
}

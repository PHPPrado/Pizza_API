package com.project.pizzaria.controller;

import com.project.pizzaria.cliente.ClienteRepository;
import com.project.pizzaria.produto.ProdutoRepository;
import com.project.pizzaria.produto.ProdutoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class ProdutoController {


    @Autowired
    public ProdutoRepository produtoRepository;



    @Autowired
    public ClienteRepository clienteRepository;

    //Listar todos os produtos

    @GetMapping("/all")
    public List<ProdutoResponseDTO> getAllProdutos() {
        List<ProdutoResponseDTO> listarProdutos = produtoRepository.findAll().stream().map(ProdutoResponseDTO::new).toList();
        return listarProdutos;

    }


//    //Seleção de 1 produto
//
//    @GetMapping("/produtos/{id}")
//    public Optional<Pedido> getProdutoById(@PathVariable String idItemPedido){
//
//        return pedidoRepository.findById(Integer.parseInt(idItemPedido));
//    }


}

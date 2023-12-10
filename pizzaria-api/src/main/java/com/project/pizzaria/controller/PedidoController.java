package com.project.pizzaria.controller;

import com.project.pizzaria.cliente.Cliente;
import com.project.pizzaria.cliente.ClienteRepository;
import com.project.pizzaria.itemPedido.ItemPedido;
import com.project.pizzaria.itemPedido.ItemPedidoRepository;
import com.project.pizzaria.itemPedido.TamanhoRepository;
import com.project.pizzaria.pedido.Pedido;
import com.project.pizzaria.pedido.PedidoRepository;
import com.project.pizzaria.pedido.PedidoResponseDTO;
import com.project.pizzaria.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    public PedidoRepository pedidoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public ItemPedidoRepository itemPedidoRepository;

    @Autowired
    public TamanhoRepository tamanhoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    

    
    //Recebe os itens do carrinho um por um e adiciona no banco
    @GetMapping("/add/{idProduto}/{tamanho}/{quantidade}/{idPedido}")
    @Transactional
    public ItemPedido criarPedido(
            @PathVariable("idProduto") int idProduto,
        @PathVariable("tamanho") String tamanho,
        @PathVariable("quantidade") int quantidade,
            @PathVariable("idPedido")int idPedido) {

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setProduto(produtoRepository.findByIdProduto(idProduto));
        itemPedido.setTamanho(tamanhoRepository.findByTamanho(tamanho));
        itemPedido.setQuantidade(quantidade);
        itemPedido.setPedido(pedidoRepository.findByIdPedido(idPedido));
        itemPedidoRepository.save(itemPedido);
        return itemPedido;
    }
    
    @GetMapping("/cancelar/{idPedido}")
    public List<PedidoResponseDTO> delete(@PathVariable int idPedido){
        pedidoRepository.deleteById(idPedido);
        List<PedidoResponseDTO> listarPedido = pedidoRepository.findAll().stream().map(PedidoResponseDTO::new).toList();
        return listarPedido;
    }


    //Retorna todos os pedidos de todos o clientes
    @GetMapping
    public List<PedidoResponseDTO> getAllPedidos() {
        List<PedidoResponseDTO> listarPedido = pedidoRepository.findAll().stream().map(PedidoResponseDTO::new).toList();
        return listarPedido;
    }

    //Retorna os pedidos do usuário logado
    @GetMapping("/listar")
    public List<Pedido> getPedidosCliente(Principal principal) {

        var usuario = principal.getName();
        Cliente cliente = clienteRepository.findByEmail(usuario);
        List<Pedido> listarPedido = pedidoRepository.findByCliente(cliente);

        return listarPedido;

    }
}

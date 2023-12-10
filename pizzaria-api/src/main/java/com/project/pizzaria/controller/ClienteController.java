package com.project.pizzaria.controller;

import com.project.pizzaria.cliente.Cliente;
import com.project.pizzaria.cliente.CepDTO;
import com.project.pizzaria.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/perfil")
public class ClienteController {

    @Autowired
    public ClienteRepository clienteRepository;

    // Altera o endereço de entrega do cliente
    @PutMapping(value = "/alterarEndereco")
    @ResponseBody
    public void alterarEndereco(Principal principal, @RequestBody CepDTO cepDTO){

        var usuario = principal.getName();
        var cep = cepDTO.cep();
        Cliente cliente = clienteRepository.findByEmail(usuario);
        if(cliente != null) {
            cliente.setCepEntrega(cep);
            clienteRepository.save(cliente);
        }

    }

}


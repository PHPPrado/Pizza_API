package com.project.pizzaria.controller;

import com.project.pizzaria.cliente.CadastroRequest;
import com.project.pizzaria.cliente.Cliente;
import com.project.pizzaria.cliente.ClienteDTO;
import com.project.pizzaria.cliente.ClienteRepository;
import com.project.pizzaria.infra.security.TokenService;
import com.project.pizzaria.usuario.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClienteRepository clienteRepository;



    //Responsável pelo login do usuário

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dados) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.email(),dados.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.geradorToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }




    //Responsável pelo cadastro do usuário

    @PostMapping("/cadastro")
    public ResponseEntity cadastro(@RequestBody @Valid CadastroRequest request) {
        RegistroDTO registroDTO = request.getRegistroDTO();
        ClienteDTO clienteDTO = request.getClienteDTO();

        if(this.usuarioRepository.findByEmail(registroDTO.email()) != null) return ResponseEntity.badRequest().body("Email já cadastrado");

        String encryptedPassword = new BCryptPasswordEncoder().encode(registroDTO.senha());
        Usuario novoUsuario = new Usuario(registroDTO.email(), encryptedPassword, registroDTO.role());
        Cliente novoCliente = new Cliente(registroDTO.email(), clienteDTO.nome() ,clienteDTO.cpf(), clienteDTO.cepEntrega(),clienteDTO.telefone() );

        this.usuarioRepository.save(novoUsuario);
        this.clienteRepository.save(novoCliente);

        return ResponseEntity.ok("Cadastro realizado com sucesso");
    }


}

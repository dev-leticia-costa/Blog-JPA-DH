package br.com.digitalhouse.blogpessoal.controller;

import br.com.digitalhouse.blogpessoal.model.UsuarioLoginModel;
import br.com.digitalhouse.blogpessoal.model.UsuarioModel;
import br.com.digitalhouse.blogpessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UsuarioLoginModel> Autentication(@RequestBody Optional<UsuarioLoginModel> usuario)
    {
        return usuarioService.Logar(usuario)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .build());
    }

    //--> Aqui adicionamos um Optional de usuarios que estava trazendo valores nulos
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioModel> Post(@RequestBody UsuarioModel user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.CadastrarUsuario(user));
    }

}

//uma camada a mais de dependencia

package com.agendamento.barbearia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agendamento.barbearia.dto.UsuarioDTO;
//import com.agendamento.barbearia.entity.Usuario;
import com.agendamento.barbearia.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    // |=======| ATRIBUTOS |=======|
    @Autowired
    private UsuarioService usuarioService;

    // |=======| MÉTODOS |=======|
    // CADASTRAR:
    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.cadastrarUsuario(usuarioDTO);
    }

}

package com.agendamento.barbearia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agendamento.barbearia.entity.RespostaEntity;
import com.agendamento.barbearia.entity.Usuario;
import com.agendamento.barbearia.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    // |=======| ATRIBUTOS |=======|
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespostaEntity respostaEntity;

    // |=======| MÉTODOS |=======|
    // CADASTRAR USUÁRIO:
    public ResponseEntity<?> cadastrarUsuario(Usuario usuario){
           
        

        if(usuario.getNome().equals("")){
            respostaEntity.setMensagem("Nome não pode ser enviado vazio!");
            return new ResponseEntity<RespostaEntity>(respostaEntity, HttpStatus.BAD_REQUEST);
        }else if(usuario.getEmail().equals("")){
            respostaEntity.setMensagem("Email não pode ser enviado vazio!");
            return new ResponseEntity<RespostaEntity>(respostaEntity, HttpStatus.BAD_REQUEST);
        }else if(usuario.getSenha().equals("")){
            respostaEntity.setMensagem("Senha não pode ser enviada vazia!");
            return new ResponseEntity<RespostaEntity>(respostaEntity, HttpStatus.BAD_REQUEST);
        }

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            respostaEntity.setMensagem("Email informado já foi cadastrado!");
            return new ResponseEntity<RespostaEntity>(respostaEntity, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }
}

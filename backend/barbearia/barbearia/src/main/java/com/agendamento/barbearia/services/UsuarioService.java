package com.agendamento.barbearia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.agendamento.barbearia.dto.ProfissionalDTO;
import com.agendamento.barbearia.dto.UsuarioDTO;
import com.agendamento.barbearia.entity.Profissional;
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
    // ======= CADASTRAR USUÁRIO =======
    public ResponseEntity<?> cadastrarUsuario(UsuarioDTO usuarioDTO){
           
        // CONFERINDO SE O EMAIL É VÁLIDO:
        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            respostaEntity.setMensagem("Email informado já foi cadastrado!");
            return new ResponseEntity<RespostaEntity>(respostaEntity, HttpStatus.CONFLICT);
        }

        Usuario usuario;
        // CONFERINDO SE É UM PROFISSIONAL:
        if(usuarioDTO.getRole().equals("PROFISSIONAL")){

            if(!(usuarioDTO instanceof ProfissionalDTO)){
                respostaEntity.setMensagem("Todos os campos do Profissional devem ser preenchidos!");
                return new ResponseEntity<RespostaEntity>(respostaEntity, HttpStatus.BAD_REQUEST);
            }
            Profissional profissional = new Profissional();
            profissional.setDescricao(((ProfissionalDTO)usuarioDTO).getDescricao());
            usuario = profissional;
        }else{
            usuario = new Usuario();
        }

        // ADICIONAR CAMPOS EM COMUM(NOME, EMAIL, SENHA E ROLE)
        usuario.setNome(usuarioDTO.getNome());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setRole(usuarioDTO.getRole());

        return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }
}

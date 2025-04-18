package com.agendamento.barbearia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    
    @NotBlank(message = "Nome é obrigatório!")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Email é obrigatório!")
    @Email(message = "Email deve ser válido!")
    private String email;

    @NotBlank(message = "Senha é obrigatória!")
    @Size(min = 6, message = "Senha tem que ter no mínimo 6 caracteres")
    private String senha;

    @NotBlank(message = "Hierarquia é obrigatória!")
    private String role;

}

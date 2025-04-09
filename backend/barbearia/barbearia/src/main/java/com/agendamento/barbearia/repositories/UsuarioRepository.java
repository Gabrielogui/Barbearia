package com.agendamento.barbearia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agendamento.barbearia.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public boolean existsByEmail(String email);
}

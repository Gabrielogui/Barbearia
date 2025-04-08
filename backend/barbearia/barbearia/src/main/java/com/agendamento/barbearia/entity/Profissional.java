package com.agendamento.barbearia.entity;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("PROFISSIONAL")
public class Profissional extends Usuario{
    // |=======| ATRIBUTOS |=======|
    private String descricao;

    @OneToMany(mappedBy = "profissional")
    private List<Servicos> listaServicos;

    @OneToMany(mappedBy = "profissional")
    private List<Agendar> listaAgendamentos;
}

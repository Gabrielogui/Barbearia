package com.agendamento.barbearia.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "servicos")
public class Servicos {
    // |=======| ATRIBUTOS |=======|
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   

    private String nome;
    private String descricao;
    private Integer duracao;
    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;
}

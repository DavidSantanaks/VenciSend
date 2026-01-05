package com.br.projetoVenciSend.produto;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos {
    
    @Id
    @GeneratedValue
    UUID id;
    String nome;
    String dataValidade;
    Long quantidade;
    Long cliente_id;
    Boolean ativo;
}

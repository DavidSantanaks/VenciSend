package com.br.projetoVenciSend.clientes;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "clientes")
@Entity

public class Clientes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean ativo;
    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    

    public Clientes() {
    }

    public Clientes(String nome){

        this.nome = nome;
        this.ativo = true;
        this.dataCriacao = LocalDateTime.now();

    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
     public boolean isAtivo() {
        return ativo;
    }
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    

}

package com.br.projetoVenciSend.clientes;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "pessoas")
@Entity

public class Pessoas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;
    private boolean ativo;

    public boolean isAtivo() {
        return ativo;
    }



    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }



    public Pessoas(String nome, String senha){

        this.nome = nome;
        this.senha = senha;
        this.ativo = true;
    }



    public Pessoas() {
    }


    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}

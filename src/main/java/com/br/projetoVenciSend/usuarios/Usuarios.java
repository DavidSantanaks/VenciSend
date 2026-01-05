package com.br.projetoVenciSend.usuarios;

import java.util.UUID;

import com.br.projetoVenciSend.clientes.Clientes;
import com.br.projetoVenciSend.usuarios.Enum.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "usuarios")
@Entity
public class Usuarios {
    
    @Id
    @GeneratedValue
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    private String senha;

    @ManyToOne(optional = false)
    private Clientes clientes;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    private boolean ativo = true;

    public Usuarios(){}

    public Usuarios(String email, String senha, Clientes clientes){

        this.email = email;
        this.senha = senha;
        this.clientes = clientes;
        
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
  
   
    public boolean isAtivo() {
        return ativo;
    }
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

}

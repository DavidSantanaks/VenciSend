package com.br.projetoVenciSend.clientes.Record;

import java.time.LocalDateTime;

public record ClientesListagemDTO(Long id, String nome, Boolean ativo, LocalDateTime dataCriacao) {
    
    
}

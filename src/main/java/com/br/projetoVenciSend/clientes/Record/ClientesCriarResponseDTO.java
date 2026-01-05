package com.br.projetoVenciSend.clientes.Record;

import java.time.LocalDateTime;

public record ClientesCriarResponseDTO(Long id, String nome, LocalDateTime dataCadastro) {
    
}

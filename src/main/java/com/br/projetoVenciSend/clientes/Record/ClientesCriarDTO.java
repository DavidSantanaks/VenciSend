package com.br.projetoVenciSend.clientes.Record;

import java.time.LocalDateTime;

public record ClientesCriarDTO( String nome, Boolean ativo, LocalDateTime dataCriacao) {
}
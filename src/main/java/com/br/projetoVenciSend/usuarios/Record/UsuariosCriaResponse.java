package com.br.projetoVenciSend.usuarios.Record;

import com.br.projetoVenciSend.clientes.Clientes;

public record UsuariosCriaResponse(
    String email,
    String senha,
    Clientes clientes
) {
    

}

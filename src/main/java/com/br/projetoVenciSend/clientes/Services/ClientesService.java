package com.br.projetoVenciSend.clientes.Services;

import java.util.List;

import com.br.projetoVenciSend.clientes.Record.ClientesCriarResponseDTO;
import com.br.projetoVenciSend.clientes.Record.ClientesCriarDTO;
import com.br.projetoVenciSend.clientes.Record.ClientesListagemDTO;

    public interface ClientesService {

    List<ClientesListagemDTO> list();

    ClientesCriarResponseDTO criar(ClientesCriarDTO dto);

    void deletar(Long id);

    List<ClientesListagemDTO> findByAtivoTrue();


}

package com.br.projetoVenciSend.clientes.Services;

import java.util.List;

import com.br.projetoVenciSend.clientes.Record.PessoaCriarResponseDTO;
import com.br.projetoVenciSend.clientes.Record.PessoasCriarDTO;
import com.br.projetoVenciSend.clientes.Record.PessoasListagemDTO;

    public interface PessoasService {

    List<PessoasListagemDTO> list();

    PessoaCriarResponseDTO criar(PessoasCriarDTO dto);

    void deletar(Long id);

    List<PessoasListagemDTO> findByAtivoTrue();


}

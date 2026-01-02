package com.br.projetoVenciSend.pessoa.Services;

import java.util.List;

import com.br.projetoVenciSend.pessoa.Record.PessoaCriarResponseDTO;
import com.br.projetoVenciSend.pessoa.Record.PessoasCriarDTO;
import com.br.projetoVenciSend.pessoa.Record.PessoasListagemDTO;

    public interface PessoasService {

    List<PessoasListagemDTO> list();

    PessoaCriarResponseDTO criar(PessoasCriarDTO dto);
}

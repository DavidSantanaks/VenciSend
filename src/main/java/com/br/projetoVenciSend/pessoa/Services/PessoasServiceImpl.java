package com.br.projetoVenciSend.pessoa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.projetoVenciSend.pessoa.PessoaRepository;
import com.br.projetoVenciSend.pessoa.Pessoas;
import com.br.projetoVenciSend.pessoa.Record.PessoaCriarResponseDTO;
import com.br.projetoVenciSend.pessoa.Record.PessoasCriarDTO;
import com.br.projetoVenciSend.pessoa.Record.PessoasListagemDTO;

@Service
public class PessoasServiceImpl implements PessoasService {
    

    private final PessoaRepository repository;

    public PessoasServiceImpl(PessoaRepository repository){
        this.repository = repository;
    }
   
    @Override
    public List<PessoasListagemDTO> list() {
        return repository.findAll().stream()
        .map(p -> new PessoasListagemDTO(p.getId(), p.getNome(), p.isAtivo())).toList();

    }

    @Override
    public PessoaCriarResponseDTO criar(PessoasCriarDTO dto) {
        
        Pessoas pessoa = new Pessoas(dto.nome(),dto.senha());
        Pessoas salva =  repository.save(pessoa);
        return new PessoaCriarResponseDTO(salva.getId(), salva.getNome());  
    }

    @Override
    public void deletar(Long id) {
        Optional<Pessoas> pessoaDeletar = repository.findById(id);
        Pessoas pessoa = pessoaDeletar.get();
        pessoa.setAtivo(false);
        repository.save(pessoa);
    }

  
}

package com.br.projetoVenciSend.clientes.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.projetoVenciSend.clientes.PessoaRepository;
import com.br.projetoVenciSend.clientes.Pessoas;
import com.br.projetoVenciSend.clientes.Record.PessoaCriarResponseDTO;
import com.br.projetoVenciSend.clientes.Record.PessoasCriarDTO;
import com.br.projetoVenciSend.clientes.Record.PessoasListagemDTO;

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

    @Override
    public List<PessoasListagemDTO> findByAtivoTrue() {
        List<PessoasListagemDTO> pessoa = list();
       pessoa = pessoa.stream().filter(p -> p.ativo() != false).toList();

        return pessoa;

    }


}

package com.br.projetoVenciSend.clientes.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.projetoVenciSend.clientes.ClientesRepository;
import com.br.projetoVenciSend.clientes.Clientes;
import com.br.projetoVenciSend.clientes.Record.ClientesCriarResponseDTO;
import com.br.projetoVenciSend.clientes.Record.ClientesCriarDTO;
import com.br.projetoVenciSend.clientes.Record.ClientesListagemDTO;

@Service
public class ClientesServiceImpl implements ClientesService {
    

    private final ClientesRepository repository;

    public ClientesServiceImpl(ClientesRepository repository){
        this.repository = repository;
    }
   
    @Override
    public List<ClientesListagemDTO> list() {
        return repository.findAll().stream()
        .map(p -> new ClientesListagemDTO(p.getId(), p.getNome(), p.isAtivo(), p.getDataCriacao())).toList();

    }

    @Override
    public ClientesCriarResponseDTO criar(ClientesCriarDTO dto) {
        
        Clientes clientes = new Clientes(dto.nome());
        Clientes salva =  repository.save(clientes);
        return new ClientesCriarResponseDTO(salva.getId(), salva.getNome(), salva.getDataCriacao());  
    }

    @Override
    public void deletar(Long id) {
        Optional<Clientes> pessoaDeletar = repository.findById(id);
        Clientes pessoa = pessoaDeletar.get();
        pessoa.setAtivo(false);
        repository.save(pessoa);
    }

    @Override
    public List<ClientesListagemDTO> findByAtivoTrue() {
        List<ClientesListagemDTO> pessoa = list();
       pessoa = pessoa.stream().filter(p -> p.ativo() != false).toList();

        return pessoa;

    }


}

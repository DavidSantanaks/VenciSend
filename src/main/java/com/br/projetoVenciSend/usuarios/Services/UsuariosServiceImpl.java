package com.br.projetoVenciSend.usuarios.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.projetoVenciSend.clientes.ClientesRepository;
import com.br.projetoVenciSend.clientes.Services.ClientesService;
import com.br.projetoVenciSend.usuarios.Usuarios;
import com.br.projetoVenciSend.usuarios.UsuariosRepository;
import com.br.projetoVenciSend.usuarios.Record.UsuariosCriaResponse;
import com.br.projetoVenciSend.usuarios.Record.UsuariosCriarDTO;
import com.br.projetoVenciSend.usuarios.Record.UsuariosListagemDTO;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    
    private final ClientesRepository clientesRepository;
    private final UsuariosRepository usuariosRepository;

    public UsuariosServiceImpl(ClientesRepository clientesRepository, UsuariosRepository usuariosRepository){
        this.clientesRepository = clientesRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public UsuariosCriaResponse criar(UsuariosCriarDTO dto) {
        Usuarios usuario = new Usuarios(dto.email(), dto.senha(),dto.clientes());
        Usuarios salvar = usuariosRepository.save(usuario);
        return new UsuariosCriaResponse(salvar.getEmail(), salvar.getSenha(), salvar.getClientes());
    }

    @Override
    public UsuariosListagemDTO listarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorId'");
    }

    @Override
    public void deletarUsuario(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarUsuario'");
    }

    @Override
    public List<UsuariosListagemDTO> findByAtivoTrue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByAtivoTrue'");
    }



}

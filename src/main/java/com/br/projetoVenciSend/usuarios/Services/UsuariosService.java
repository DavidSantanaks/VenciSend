package com.br.projetoVenciSend.usuarios.Services;

import java.util.List;

import com.br.projetoVenciSend.usuarios.Record.UsuariosCriaResponse;
import com.br.projetoVenciSend.usuarios.Record.UsuariosCriarDTO;
import com.br.projetoVenciSend.usuarios.Record.UsuariosListagemDTO;

public interface UsuariosService {

  
   UsuariosCriaResponse criar(UsuariosCriarDTO dto);
   UsuariosListagemDTO listarPorId(Long id);
   void deletarUsuario(Long id);
   List<UsuariosListagemDTO> findByAtivoTrue();
   
    
} 

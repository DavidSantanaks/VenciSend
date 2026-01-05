package com.br.projetoVenciSend.clientes;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoVenciSend.clientes.Record.ClientesCriarResponseDTO;
import com.br.projetoVenciSend.clientes.Record.ClientesCriarDTO;
import com.br.projetoVenciSend.clientes.Record.ClientesListagemDTO;
import com.br.projetoVenciSend.clientes.Services.ClientesService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController()
@RequestMapping("/clientes/")
public class ClientesController {


    private final ClientesService service;

    public ClientesController(ClientesService service) {
        this.service = service;
    }
    
    @GetMapping("listall")
    public ResponseEntity<List<ClientesListagemDTO>> listar() {
        List<ClientesListagemDTO> todasPessoas = service.list();
        return ResponseEntity.status(HttpStatus.OK).body(todasPessoas);
    }
    
    
    @PostMapping()
    public ResponseEntity<ClientesCriarResponseDTO>  postPessoa(@RequestBody ClientesCriarDTO entity) {

      ClientesCriarResponseDTO responseDTO = service.criar(entity);
      return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping()
    public ResponseEntity<List<ClientesListagemDTO>> listaAtivo() {
        List<ClientesListagemDTO> p = service.findByAtivoTrue();
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
    
    
    @GetMapping("home")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("index");
        String paragrafo = "Teste de paragrafo";
        mv.addObject("paragrafo", paragrafo);
        return mv;
    }
    
}

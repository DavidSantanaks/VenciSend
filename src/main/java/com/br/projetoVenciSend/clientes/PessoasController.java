package com.br.projetoVenciSend.clientes;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.br.projetoVenciSend.clientes.Record.PessoaCriarResponseDTO;
import com.br.projetoVenciSend.clientes.Record.PessoasCriarDTO;
import com.br.projetoVenciSend.clientes.Record.PessoasListagemDTO;
import com.br.projetoVenciSend.clientes.Services.PessoasService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController()
@RequestMapping("/usuarios")
public class PessoasController {


    private final PessoasService service;

    public PessoasController(PessoasService service) {
        this.service = service;
    }
    
    @GetMapping("/listall")
    public ResponseEntity<List<PessoasListagemDTO>> listar() {
        List<PessoasListagemDTO> todasPessoas = service.list();
        return ResponseEntity.status(HttpStatus.OK).body(todasPessoas);
    }
    
    
    @PostMapping()
    public ResponseEntity<PessoaCriarResponseDTO>  postPessoa(@RequestBody PessoasCriarDTO entity) {

      PessoaCriarResponseDTO responseDTO = service.criar(entity);
      return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deletar(id);
    }

    @GetMapping()
    public ResponseEntity<List<PessoasListagemDTO>> listaAtivo() {
        List<PessoasListagemDTO> p = service.findByAtivoTrue();
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }
    
    
    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView mv = new ModelAndView("index");
        String paragrafo = "Teste de paragrafo";
        mv.addObject("paragrafo", paragrafo);
        return mv;
    }
    
}

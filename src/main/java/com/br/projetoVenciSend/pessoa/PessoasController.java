package com.br.projetoVenciSend.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projetoVenciSend.pessoa.Record.PessoaCriarResponseDTO;
import com.br.projetoVenciSend.pessoa.Record.PessoasCriarDTO;
import com.br.projetoVenciSend.pessoa.Record.PessoasListagemDTO;
import com.br.projetoVenciSend.pessoa.Services.PessoasService;
import com.br.projetoVenciSend.pessoa.Services.PessoasServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController()
@RequestMapping("/pessoas")
public class PessoasController {


    private final PessoasService service;

    public PessoasController(PessoasService service) {
        this.service = service;
    }
    
    @GetMapping()
    public List<PessoasListagemDTO> listar() {
        return service.list();
    }
    
    @PostMapping()
    public ResponseEntity<PessoaCriarResponseDTO>  criar(@RequestBody PessoasCriarDTO entity) {

      PessoaCriarResponseDTO responseDTO = service.criar(entity);
      return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);


    }
    
    
}

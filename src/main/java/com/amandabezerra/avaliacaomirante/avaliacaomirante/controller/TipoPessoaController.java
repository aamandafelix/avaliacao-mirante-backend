package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.service.TipoPessoaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/tipo-pessoa")
public class TipoPessoaController {

//    @Autowired
//    private TipoPessoaService tipoPessoaService;

    private final TipoPessoaService tipoPessoaService;

    public TipoPessoaController(TipoPessoaService tipoPessoaService) {
        this.tipoPessoaService = tipoPessoaService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> index() {
        return ResponseEntity.ok(tipoPessoaService.index());
    }
}


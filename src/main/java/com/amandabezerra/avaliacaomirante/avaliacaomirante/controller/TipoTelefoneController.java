package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.service.TipoTelefoneService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/tipo-telefone")
public class TipoTelefoneController {


    private final TipoTelefoneService tipoTelefoneService;

    public TipoTelefoneController(TipoTelefoneService tipoTelefoneService) {
        this.tipoTelefoneService = tipoTelefoneService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> index() {
        return ResponseEntity.ok(tipoTelefoneService.index());
    }

}

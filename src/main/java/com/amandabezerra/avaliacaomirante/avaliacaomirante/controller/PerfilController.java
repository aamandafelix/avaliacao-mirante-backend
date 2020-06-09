package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.service.PerfilService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/perfil")
public class PerfilController {

//    @Autowired
//    private PerfilService perfilService;

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> index() {
        return ResponseEntity.ok(perfilService.index());
    }
}

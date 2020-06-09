package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.dto.TelefoneDTO;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.service.TelefoneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/telefone")
public class TelefoneController {

    private final TelefoneService telefoneService;

    public TelefoneController(TelefoneService telefoneService) {
        this.telefoneService = telefoneService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody TelefoneDTO telefoneDTO) throws Exception {
        return ResponseEntity.ok(telefoneService.create(telefoneDTO));
    }

    @DeleteMapping(value = "/{telefoneId}")
    public ResponseEntity<Object> delete(@PathVariable(value = "telefoneId") Long telefoneId) {
        telefoneService.delete(telefoneId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.amandabezerra.avaliacaomirante.avaliacaomirante.controller;

import com.amandabezerra.avaliacaomirante.avaliacaomirante.dto.OperadorDTO;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.model.Operador;
import com.amandabezerra.avaliacaomirante.avaliacaomirante.service.OperadorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/operador")
public class OperadorController {

    private final OperadorService operadorService;

    public OperadorController(OperadorService operadorService) {
        this.operadorService = operadorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> index() {
	    return ResponseEntity.ok(operadorService.index());
    }

    @GetMapping(value = "/{operadorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> show(@PathVariable(value = "operadorId") Long operadorId) {
        return ResponseEntity.ok(operadorService.show(operadorId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Operador> create(@RequestBody OperadorDTO operadorDTO) throws Exception {
        return ResponseEntity.ok(operadorService.create(operadorDTO));
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Object> edit(@RequestBody OperadorDTO operadorDTO) {
        return ResponseEntity.ok(operadorService.edit(operadorDTO));
    }

    @DeleteMapping(value = "/{operadorId}")
    public ResponseEntity<Object> delete(@PathVariable(value = "operadorId") Long operadorId) {
        operadorService.delete(operadorId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
